package daoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Entidad.Persona;
import dao.PersonaDao;

public class PersonaDaolmpl implements PersonaDao{

	private static final String insert = "INSERT INTO personas (dni, nombre, apellido) VALUES(?, ?, ?)";

	public PersonaDaolmpl() {}

    public boolean AgregarPersona(Persona persona)
    {
        PreparedStatement statement;
        Connection conexion = Conexion.getConexion().getSQLConexion();
        boolean insertExitoso = false;
        
        try
        {
            statement = conexion.prepareStatement(insert);
            statement.setInt(1, persona.getDni());
            statement.setString(2, persona.getNombre());
            statement.setString(3, persona.getApellido());
            
            if(statement.executeUpdate() > 0)
            {
                conexion.commit();
                insertExitoso = true;
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            try {
                conexion.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        return insertExitoso;
    }
	

    public boolean borrar(String dni) {
        boolean eliminado = false;
        PreparedStatement statement;
        Connection conexion = Conexion.getConexion().getSQLConexion();

        try {
            statement = conexion.prepareStatement("DELETE FROM personas WHERE dni = ?");
            statement.setString(1, dni);

            if (statement.executeUpdate() > 0) {
                conexion.commit();
                eliminado = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conexion.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        return eliminado;
    }
    
    
}

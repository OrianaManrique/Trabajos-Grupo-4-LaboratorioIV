package daoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Entidad.Persona;

public class PersonaDaolmpl {

	private static final String insert = "INSERT INTO personas (dni, nombre, apellido) VALUES(?, ?, ?)";

	public PersonaDaolmpl() {}

    static public boolean AgregarPersona(Persona persona)
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
	

}

package daoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Entidad.Persona;
import dao.PersonaDao;

public class PersonaDaolmpl implements PersonaDao{

	private static final String insert = "INSERT INTO personas (dni, nombre, apellido) VALUES(?, ?, ?)";
	private static final String delete = "DELETE FROM personas WHERE dni = ?";
	private static final String update = "UPDATE personas SET nombre = ?, apellido = ? WHERE dni = ?";
	private static final String readall = "SELECT * FROM personas";
	public PersonaDaolmpl() {}

    public boolean AgregarPersona(Persona persona)
    {
        PreparedStatement statement;
        Connection conexion = Conexion.getConexion().getSQLConexion();
        //boolean insertExitoso = false;
        
        try
        {
            statement = conexion.prepareStatement(insert);
            statement.setInt(1, persona.getDni());
            statement.setString(2, persona.getNombre());
            statement.setString(3, persona.getApellido());
            
            if(statement.executeUpdate() > 0)
            {
                conexion.commit();
                return true;
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

        return false;
    }
	

    public boolean EliminarPersona(Persona persona) {
        PreparedStatement statement;
        Connection conexion = Conexion.getConexion().getSQLConexion();

        try {
            statement = conexion.prepareStatement(delete);
            statement.setString(1, String.valueOf(persona.getDni()));

            if (statement.executeUpdate() > 0) {
                conexion.commit();
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conexion.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        return false;
    }
    
    @Override
    public boolean ModificarPersona(Persona persona) {
    	PreparedStatement statement;
        Connection conexion = Conexion.getConexion().getSQLConexion();

        try {
            statement = conexion.prepareStatement(update);
            statement.setString(1, persona.getNombre());
            statement.setString(2, persona.getApellido());
            statement.setString(3, String.valueOf(persona.getDni()));

            if (statement.executeUpdate() > 0) {
                conexion.commit();
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conexion.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    	return false;
    }
    
    public List<Persona> ListarPersonas() {
    	PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Persona> personas = new ArrayList<Persona>();
		Conexion conexion = Conexion.getConexion();
		try
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				Persona per = new Persona();
				per.setDni(resultSet.getInt("Dni"));
				per.setNombre(resultSet.getString("Nombre"));
				per.setApellido(resultSet.getString("Apellido"));
				personas.add(per);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return personas;
	}

    public static ArrayList<Persona> ObtenerListaPersonas()
    {
        PreparedStatement statement;
        ResultSet resultSet;
        ArrayList<Persona> Listapersonas = new ArrayList<Persona>();
        Conexion conexion = Conexion.getConexion();
        try 
        {
            statement = conexion.getSQLConexion().prepareStatement(readall);
            resultSet = statement.executeQuery();
            while(resultSet.next())
            {
                Listapersonas.add(getPersona(resultSet));
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return Listapersonas;
    }

    public boolean ComprobarExistenciaPersona(String dni) {
        PreparedStatement statement;
        ResultSet resultset = null;
        Connection conexion = Conexion.getConexion().getSQLConexion();

        try {
            statement = conexion.prepareStatement("SELECT COUNT(*) FROM personas WHERE dni = ?");
            statement.setString(1, dni);
            
            resultset = statement.executeQuery();
            
            if (resultset.next()) {
                int count = resultset.getInt(1); 
                if (count > 0) {
                    return true; 
                }           
            }
            
        } catch (SQLException e) {
            System.err.println("Error al verificar DNI: " + e.getMessage());
        }
        
        return false;

    }
    
    private static Persona getPersona(ResultSet resultSet) throws SQLException
    {
        int dni = resultSet.getInt("Dni");
        String nombre = resultSet.getString("Nombre");
        String apellido = resultSet.getString("Apellido");
        return new Persona(dni, nombre, apellido);
    }
    
}

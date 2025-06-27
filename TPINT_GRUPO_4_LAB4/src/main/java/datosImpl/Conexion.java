package datosImpl;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

	private static final String host = "jdbc:mysql://localhost:3306/";
	private static final String user = "root";
	private static final String pass = "root";
	private static final String dbName = "bd_banco??profileSQL=true&useSSL=false";

	protected Connection conexion = null;
	
	public Connection open()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			this.conexion = DriverManager.getConnection(host+dbName, user, pass);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return this.conexion;
	}
	
	public ResultSet query(String query)
	{
		Statement statement;
		ResultSet resultset=null;
		try
		{
			statement= conexion.createStatement();
			resultset= statement.executeQuery(query);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return resultset;
	}
	
	public boolean execute(String query)
	{
		Statement statement;
		boolean guardar = true;
		try {
			statement = conexion.createStatement();
			statement.executeUpdate(query);
		}
		catch(SQLException e)
		{
			guardar = false;
			e.printStackTrace();
		}
		return guardar;
	}
	
	public boolean close()
	{
		boolean estado=true;
		try {
			conexion.close();
		}
		catch(Exception e)
		{
			estado= false;
			e.printStackTrace();
		}
		return estado;
	}
	

    public int executeUpdate(String query) throws SQLException {
        Statement statement = null;
        try {
        	statement = conexion.createStatement();
            return statement.executeUpdate(query);
        } finally {
            if (statement != null) statement.close();
        }
    }
	
}
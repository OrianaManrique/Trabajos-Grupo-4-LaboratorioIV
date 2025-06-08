package dominio;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TipoSeguroDao {
		
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "segurosgroup";
	
	
	public ArrayList<TipoSeguro> obtenerTipoSeguros() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<TipoSeguro> ListaTipoSeguros = new ArrayList<TipoSeguro>();
		Connection cn = null;
		try{
			cn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("Select idTipo,descripcion FROM tiposeguros");
			
			while(rs.next()){			
				TipoSeguro tiposeguroRS = new TipoSeguro();
				tiposeguroRS.setIdTipo((rs.getInt("idTipo"))); 
				tiposeguroRS.setDescripcion((rs.getString("descripcion")));
				
				ListaTipoSeguros.add(tiposeguroRS);
			}
			cn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		
		}
		
		return ListaTipoSeguros;
	}
	
	
	public String obtenerTipoSeguroporID(int id) {
        
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		TipoSeguro tiposeguro = new TipoSeguro();
		Connection cn = null;
		try{
			cn = DriverManager.getConnection(host + dbName, user, pass);
			PreparedStatement ps = cn.prepareStatement("SELECT * FROM tiposeguros where idTipo = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			tiposeguro.setIdTipo(rs.getInt(1));
			tiposeguro.setDescripcion(rs.getString(2));
		    
		    cn.close();
		}
		catch(Exception e)
		{
			System.out.println("Conexion fallida");
		}
		finally
		{
		}
		
		return tiposeguro.getDescripcion();
	}

}

package dominio;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;


public class SegurosDao {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "segurosgroup";

	public int ObtenerProxId() {
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection cn = null;
		int id = 0;		

		try {
			cn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = cn.createStatement();

			ResultSet rs = st.executeQuery("select max(idSeguro) 'idSeguro' from seguros");

			while (rs.next()) {
				id = rs.getInt("idSeguro");
				cn.close();
			}

			return id + 1;
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			 try {
		            if (cn != null) cn.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		}
		
		return id + 1;
	}
	
	
	public int AgregarSeguro(Seguro seguro) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int filas = 0;
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host + dbName, user, pass); 
			Statement st = cn.createStatement();
			String qry = "Insert into seguros(descripcion,idTipo,costoContratacion,costoAsegurado) values ('"
					+ seguro.getDescripcion() + "','" + seguro.getIdTipo() + "','"
					+ seguro.getCostoContratacion() + "','" + seguro.getCostoAsegurado() + "')";
			filas = st.executeUpdate(qry); 
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
		return filas;		
	}
	
	public ArrayList<Seguro> obtenerSeguros() {
   	
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<Seguro> ListaSeguros = new ArrayList<Seguro>();
		Connection cn = null;
		try{
			cn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT idSeguro , descripcion , idTipo , costoContratacion , costoAsegurado FROM seguros");
			
			while(rs.next()){
												
				Seguro seguroRs = new Seguro();
				seguroRs.setId(rs.getInt("idSeguro"));
				seguroRs.setDescripcion(rs.getString("descripcion"));
				seguroRs.setIdTipo(rs.getInt("idTipo"));
				seguroRs.setCostoContratacion(rs.getInt("costoContratacion"));
				seguroRs.setCostoAsegurado(rs.getInt("costoAsegurado"));

				ListaSeguros.add(seguroRs);
			}
			
			cn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		
		}
		
		return ListaSeguros;
	}
	
	
	public ArrayList<Seguro> obtenerSegurosFiltrados(int tipoid) {
	   	
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<Seguro> ListaSegurosFiltrados = new ArrayList<Seguro>();
		Connection cn = null;
		try{
			
			cn = DriverManager.getConnection(host + dbName, user, pass);
			PreparedStatement ps = cn.prepareStatement("SELECT idSeguro , descripcion , idTipo , costoContratacion , costoAsegurado\r\n"
					+ "FROM seguros\r\n"
					+ "WHERE idTipo = ?;");
			ps.setInt(1, tipoid);
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			while(rs.next()){
												
				Seguro seguroRs = new Seguro();
				seguroRs.setId(rs.getInt("idSeguro"));
				seguroRs.setDescripcion(rs.getString("descripcion"));
				seguroRs.setIdTipo(rs.getInt("idTipo"));
				seguroRs.setCostoContratacion(rs.getInt("costoContratacion"));
				seguroRs.setCostoAsegurado(rs.getInt("costoAsegurado"));

				ListaSegurosFiltrados.add(seguroRs);
			}
			
			cn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		
		}
		
		return ListaSegurosFiltrados;
	}
	
}

package dominio;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
	
	
	
}

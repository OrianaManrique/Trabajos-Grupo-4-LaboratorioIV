package entidad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuariosDao {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bd_banco";
	
	public Usuario obtenerUsuario(String dni, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Usuario usu = new Usuario();
		Connection cn = null;
		
		try {
			cn = DriverManager.getConnection(host+dbName, user, pass);
			PreparedStatement ps = cn.prepareStatement("SELECT Dni_Usuario, Contraseña_Usuario, tipo_Usuario , Estado_Usuario "
														+ "FROM usuarios WHERE Dni_Usuario = ? AND Contraseña_Usuario = ?;");
			ps.setString(1, dni);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				usu.setDniUsuario(rs.getString("Dni_Usuario"));
				usu.setPasswordUsuario(rs.getString("Contraseña_Usuario"));
				usu.setTipoUsuario(rs.getString("tipo_Usuario"));
				usu.setEstadoUsuario(rs.getInt("Estado_Usuario"));
			}
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {}
		
		return usu;
	}
}

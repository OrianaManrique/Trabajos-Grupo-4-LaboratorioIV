package datosImpl;

import java.sql.ResultSet;

import entidad.Cuenta;
import entidad.TipoCuenta;
import entidad.Usuario;

public class UsuarioDaoImpl {

	private Conexion conexion;
	
	//terminar 17/07 17:27
	public Usuario obtenerUsuario(String usuario_log, String clave_log) {
		
		Usuario usuario = null;
		
		try {
		conexion = new Conexion();
		conexion.open();

		String consulta = "SELECT usuario_US AS Usuario, contrasena_US AS Clave, tipo_US AS TipoUsuario, dnicliente_US AS DniCliente,\r\n"
				+ "dniadmin_US AS DniAdministrador, nombre_US AS Nombre, apellido_US AS Apellido\r\n"
				+ "FROM usuarios WHERE estado_US = 1 AND usuario_US = '"+usuario_log+"' AND contrasena_US = "+clave_log+";";

		
			ResultSet rs = conexion.query(consulta);

			if (rs.next()) {
				
				usuario= new Usuario();

				usuario.setUsuario_us(rs.getString("Usuario"));
				usuario.setContraseña_us(rs.getString("Clave"));
				usuario.setTipo_us(rs.getString("TipoUsuario"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.close();
		}
		
		return usuario;
	}
}

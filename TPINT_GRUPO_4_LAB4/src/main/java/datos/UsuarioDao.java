package datos;

import entidad.Usuario;

public interface UsuarioDao {

	public Usuario obtenerUsuario(String usuario, String clave);
	
}

package negocioImpl;

import entidad.Usuario;
import negocio.UsuarioNeg;
import datos.UsuarioDao;
import datosImpl.UsuarioDaoImpl;

public class UsuarioNegImpl implements UsuarioNeg{

	UsuarioDao usuarioDao = new UsuarioDaoImpl();
	
	public UsuarioNegImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Usuario obtenerUsuario(String usuario, String clave) {
		return usuarioDao.obtenerUsuario(usuario, clave);
	}
	
	
}

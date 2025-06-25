package negocioImpl;
import datos.ClienteDao;
import datosImpl.ClienteDaoImpl;
import entidad.Cliente;
import negocio.ClienteNeg;

public class ClienteNegImpl implements ClienteNeg {

	private ClienteDao cliDao = new ClienteDaoImpl();
	
	public ClienteNegImpl() {
		// TODO Auto-generated constructor stub
	}

	public boolean insertar(Cliente cliente) {
		return cliDao.insertar(cliente);
	}
}

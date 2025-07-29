package negocioImpl;
import exceptions.arrobaException;
import exceptions.cuentaCliente;
import exceptions.mailCliente;
import exceptions.maximoCuentas;

import java.util.ArrayList;

import datos.ClienteDao;
import datosImpl.ClienteDaoImpl;
import entidad.Cliente;
import negocio.ClienteNeg;

public class ClienteNegImpl implements ClienteNeg {

	private ClienteDao cliDao = new ClienteDaoImpl();

	public ClienteNegImpl() {
		// TODO Auto-generated constructor stub
	}

	public boolean insertar (Cliente cliente) {
		
		try
		{
			mailCliente.validarMail(cliente.getCorreo_electronico_cliente());
			return cliDao.insertar(cliente);
		}
		catch(arrobaException e)
		{
			e.printStackTrace();
			return false;
		}
		
		
	}

	public Cliente obtenerCliente(int dni) {
		return cliDao.obtenerCliente(dni);
	}

	public boolean borrar(int dni) {

		return cliDao.borrar(dni);
	}

	@Override
	public ArrayList<Cliente> obtenerClientes() {
		return cliDao.obtenerClientes();
	}

	@Override
	public boolean editar(Cliente cliente) {
		return cliDao.editar(cliente);
	}
	
	public Boolean verificarClienteExiste(int dni) {
		return cliDao.verificarClienteExiste(dni);
	}
}

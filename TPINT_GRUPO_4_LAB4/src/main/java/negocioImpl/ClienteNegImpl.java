package negocioImpl;
import exceptions.mailCliente;

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
		
		mailCliente.validarMail(cliente.getCorreo_electronico_cliente()); 
		
		return cliDao.insertar(cliente);
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
}

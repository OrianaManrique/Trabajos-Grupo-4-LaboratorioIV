package negocio;
import entidad.Cliente;

public interface ClienteNeg {


	public boolean insertar(Cliente cliente);
	public Cliente obtenerCliente(int dni);
	
}

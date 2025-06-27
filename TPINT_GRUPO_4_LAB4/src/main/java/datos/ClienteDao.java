package datos;
import entidad.Cliente;

public interface ClienteDao {
   
	public boolean insertar(Cliente cliente);
	public Cliente obtenerCliente(int dni);
	public boolean borrar(int dni);
	
}

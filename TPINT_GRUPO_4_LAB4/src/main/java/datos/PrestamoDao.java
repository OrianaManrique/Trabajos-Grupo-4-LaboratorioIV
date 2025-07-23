package datos;
import java.util.ArrayList;
import entidad.Prestamo;

public interface PrestamoDao {
   
	public boolean SolicitarPrestamo(Prestamo prestamo);
	public ArrayList<Prestamo> obtenerPrestamos();
	public boolean AutorizarRechazarPrestamo(Prestamo prestamo);
}

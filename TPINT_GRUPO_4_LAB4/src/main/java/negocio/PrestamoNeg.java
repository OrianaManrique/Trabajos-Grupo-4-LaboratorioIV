package negocio;

import java.util.ArrayList;
import entidad.Prestamo;

public interface PrestamoNeg {
	
	public boolean SolicitarPrestamo(Prestamo prestamo);
	public ArrayList<Prestamo> obtenerPrestamos();
	public boolean AutorizarRechazarPrestamo(Prestamo prestamo, String CambioCondicion);

}

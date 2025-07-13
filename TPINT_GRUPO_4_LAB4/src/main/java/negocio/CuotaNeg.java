package negocio;
import java.util.ArrayList;
import entidad.Cuota;

public interface CuotaNeg {
	
	public ArrayList<Cuota> obtenerCuotasporIdPrestamo(int idPrestamo);
	
}

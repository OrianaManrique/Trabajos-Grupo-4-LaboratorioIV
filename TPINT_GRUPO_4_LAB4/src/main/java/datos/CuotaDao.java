package datos;
import java.util.ArrayList;
import entidad.Cuota;

public interface CuotaDao {
  
	public ArrayList<Cuota> obtenerCuotasporIdPrestamo(int idPrestamo);
	
}

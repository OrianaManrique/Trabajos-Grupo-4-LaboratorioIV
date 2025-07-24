package datos;
import java.util.ArrayList;
import entidad.Cuota;

public interface CuotaDao {
  
	public ArrayList<Cuota> obtenerCuotasporIdPrestamo(int idPrestamo);
	public int obtenerCantidadCuotasPagadas(int idPrestamo);
	public boolean PagarCuota(int idPrestamo , int NumeroCuenta);
	
}

package negocioImpl;
import java.util.ArrayList;
import entidad.Cuota;
import negocio.CuotaNeg;
import datos.CuotaDao;
import datosImpl.CuotaDaoImpl;

public class CuotaNegImpl implements CuotaNeg{
     
	CuotaDao Cudao = new CuotaDaoImpl();
	
	@Override
	public ArrayList <Cuota> obtenerCuotasporIdPrestamo(int idPrestamo) {
		return Cudao.obtenerCuotasporIdPrestamo(idPrestamo);
	}

	@Override
	public int obtenerCantidadCuotasPagadas(int idPrestamo) {
		return Cudao.obtenerCantidadCuotasPagadas(idPrestamo);
	}

}

package negocioImpl;
import java.util.ArrayList;
import entidad.Prestamo;
import negocio.PrestamoNeg;
import datos.PrestamoDao;
import datosImpl.PrestamoDaoImpl;

public class PrestamoNegImpl implements PrestamoNeg {
	
	private PrestamoDao presDao = new PrestamoDaoImpl();

	@Override
	public boolean SolicitarPrestamo(Prestamo prestamo) {
		return presDao.SolicitarPrestamo(prestamo);
	}

	@Override
	public ArrayList<Prestamo> obtenerPrestamos() {
		return presDao.obtenerPrestamos();
	}

}

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

	@Override
	public boolean AutorizarRechazarPrestamo(Prestamo prestamo, String CambioCondicion) {
		return presDao.AutorizarRechazarPrestamo(prestamo, CambioCondicion);
	}

	@Override
	public ArrayList<Prestamo> obtenerPrestamosPorDni(int dni) {
		return presDao.obtenerPrestamosPorDni(dni);
	}

	@Override
	public Prestamo obtenerPrestamoPorid(int id) {
		return presDao.obtenerPrestamoPorid(id);
	}

	public int ContarPrestamosPorMes(int mes, String condicion) {
		return presDao.ContarPrestamosPorMes(mes, condicion);
	}
}

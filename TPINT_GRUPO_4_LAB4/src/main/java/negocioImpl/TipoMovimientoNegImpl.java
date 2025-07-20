package negocioImpl;

import java.util.ArrayList;
import datos.TipoMovimientoDao;
import datosImpl.TipoMovimientoDaoImpl;
import entidad.TipoMovimiento;
import negocio.TipoMovimientoNeg;

public class TipoMovimientoNegImpl implements TipoMovimientoNeg {
	
	private TipoMovimientoDao tipoMovDao = new TipoMovimientoDaoImpl();

	public TipoMovimientoNegImpl() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<TipoMovimiento> obtenerTiposMovimientos(){
		return tipoMovDao.obtenerTiposMovimientos();
	}
	public String obtenerDescripcionPorId(int id) {
		return tipoMovDao.obtenerDescripcionPorId(id);
	};
}

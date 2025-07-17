package negocioImpl;

import java.util.ArrayList;
import datos.TipoCuentaDao;
import datosImpl.TipoCuentaDaoImpl;
import entidad.TipoCuenta;
import negocio.TipoCuentaNeg;

public class TipoCuentaNegImpl implements TipoCuentaNeg{
	
	private TipoCuentaDao tipoDao = new TipoCuentaDaoImpl();

	public TipoCuentaNegImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<TipoCuenta> obtenerTiposCuentas() {
		return  tipoDao.obtenerTiposCuentas();
	}
	
	public String obtenerDescripcionPorId(int id) {
		return  tipoDao.obtenerDescripcionPorId(id);
	}
}

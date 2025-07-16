package negocioImpl;

import java.util.ArrayList;

import datos.Tipo_CuentaDao;
import datosImpl.Tipo_CuentaDaoImpl;
import entidad.TipoCuenta;
import negocio.Tipo_CuentaNeg;

public class Tipo_CuentaNegImpl implements Tipo_CuentaNeg{
	
	Tipo_CuentaDao tipoDao = new Tipo_CuentaDaoImpl();

	public Tipo_CuentaNegImpl() {
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

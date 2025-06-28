package negocioImpl;

import java.util.ArrayList;

import datos.Tipo_CuentaDao;
import datosImpl.Tipo_CuentaDaoImpl;
import entidad.Tipo_Cuenta;
import negocio.Tipo_CuentaNeg;

public class Tipo_CuentaNegImpl implements Tipo_CuentaNeg{
	
	Tipo_CuentaDao tipoDao = new Tipo_CuentaDaoImpl();

	public Tipo_CuentaNegImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Tipo_Cuenta> obtenerTiposCuentas() {
		return  tipoDao.obtenerTiposCuentas();
	}

}

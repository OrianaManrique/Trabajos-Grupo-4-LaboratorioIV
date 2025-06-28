package negocioImpl;
import java.util.ArrayList;
import entidad.Cuenta;
import datos.CuentaDao;
import datosImpl.CuentaDaoImpl;
import negocio.CuentaNeg;

public class CuentaNegImpl implements CuentaNeg{
	
	CuentaDao cuentaDao = new CuentaDaoImpl();

	public CuentaNegImpl() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Cuenta> obtenerCuentas(){
		return cuentaDao.obtenerCuentas();
	}

	@Override
	public boolean borrar(String NroCuenta_Cuenta) {
		return cuentaDao.borrar(NroCuenta_Cuenta);
	}

	@Override
	public boolean editar(Cuenta cuenta) {
		return cuentaDao.editar(cuenta);
	}
}

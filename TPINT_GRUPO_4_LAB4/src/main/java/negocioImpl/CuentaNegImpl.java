package negocioImpl;
import java.util.ArrayList;
import entidad.Cuenta;
import datos.CuentaDao;
import datosImpl.CuentaDaoImpl;
import negocio.CuentaNeg;
import exceptions.cuentaCliente;
import exceptions.maximoCuentas;

public class CuentaNegImpl implements CuentaNeg{
	
	CuentaDao cuentaDao = new CuentaDaoImpl();

	public CuentaNegImpl() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Cuenta> obtenerCuentas(){
		return cuentaDao.obtenerCuentas();
	}

	@Override
	public boolean borrar(int NroCuenta_Cuenta) {
		return cuentaDao.borrar(NroCuenta_Cuenta);
	}

	@Override
	public boolean modificarCuenta(Cuenta cuenta) {
		return cuentaDao.modificarCuenta(cuenta);
	}
	
	public Boolean agregarCuenta(Cuenta cuenta) {
		
		try
		{
			cuentaCliente.validarCantidadCuentas(cuenta.getDni_Cliente());
			
			return cuentaDao.agregarCuenta(cuenta);
					
		}
		catch(maximoCuentas e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<Cuenta> obtenerCuentasxDni(int dni_cliente) {
		return cuentaDao.obtenerCuentasxDni(dni_cliente);
	}

	@Override
	public Cuenta Obtenercuenta(int NroCuenta_Cuenta) {
		return cuentaDao.Obtenercuenta(NroCuenta_Cuenta);
	}
	
	public int proximoNroCuenta() {
		return cuentaDao.proximoNroCuenta();
	}
	
	public String ObtenerCBU() {
		return cuentaDao.ObtenerCBU();
	}

	@Override
	public int ContarCuentas(int dni_cliente) {
		return cuentaDao.ContarCuentas(dni_cliente);
	}
}

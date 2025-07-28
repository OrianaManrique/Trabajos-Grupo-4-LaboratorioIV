package exceptions;
import datos.CuentaDao;
import datosImpl.CuentaDaoImpl;

public class cuentaCliente {
	

	public static boolean validarCantidadCuentas (int dni) throws maximoCuentas
	{
		Boolean aprobacionCuentas = true;
		int cuentas = 0;
		
			CuentaDao cuentaDao = new CuentaDaoImpl();
			cuentas = cuentaDao.ContarCuentas(dni);

	        if (cuentas > 3) {
	        	aprobacionCuentas = false;
	        }
	        
	        if(aprobacionCuentas==false)
			   {
	        	throw new maximoCuentas();
			   }else {
				   aprobacionCuentas = true;
			   }

	        return aprobacionCuentas;
	}

}

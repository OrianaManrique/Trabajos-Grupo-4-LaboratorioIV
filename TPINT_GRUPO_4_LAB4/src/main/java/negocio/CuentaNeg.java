package negocio;
import java.util.ArrayList;
import entidad.Cuenta;

public interface CuentaNeg {

	public ArrayList<Cuenta> obtenerCuentas();
	public boolean borrar(String NroCuenta_Cuenta);
	
}

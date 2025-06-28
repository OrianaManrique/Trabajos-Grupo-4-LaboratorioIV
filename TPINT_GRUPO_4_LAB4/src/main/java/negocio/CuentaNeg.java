package negocio;
import java.util.ArrayList;
import entidad.Cuenta;

public interface CuentaNeg {

	public ArrayList<Cuenta> obtenerCuentas();
	public boolean editar(Cuenta cuenta);
	public boolean borrar(String NroCuenta_Cuenta);
	public Boolean agregarCuenta(Cuenta cuenta);
	
}

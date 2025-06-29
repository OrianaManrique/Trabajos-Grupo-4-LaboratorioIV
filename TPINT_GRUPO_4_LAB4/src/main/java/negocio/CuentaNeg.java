package negocio;
import java.util.ArrayList;
import entidad.Cuenta;

public interface CuentaNeg {

	public ArrayList<Cuenta> obtenerCuentas();
	public boolean modificarCuenta(Cuenta cuenta);
	public boolean borrar(String NroCuenta_Cuenta);
	public Cuenta Obtenercuenta(String NroCuenta_Cuenta);
	public Boolean agregarCuenta(Cuenta cuenta);
	public ArrayList<Cuenta> obtenerCuentasxDni(int dni_cliente);	
}

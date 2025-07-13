package negocio;
import java.util.ArrayList;
import entidad.Cuenta;

public interface CuentaNeg {

	public ArrayList<Cuenta> obtenerCuentas();
	public boolean modificarCuenta(Cuenta cuenta);
	public boolean borrar(int NroCuenta_Cuenta);
	public Cuenta Obtenercuenta(int NroCuenta_Cuenta);
	public Boolean agregarCuenta(Cuenta cuenta);
	public ArrayList<Cuenta> obtenerCuentasxDni(int dni_cliente);	
}

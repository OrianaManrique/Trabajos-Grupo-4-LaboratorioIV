package datos;
import java.util.ArrayList;
import entidad.Cuenta;

public interface CuentaDao {
	
	public ArrayList<Cuenta> obtenerCuentas();
	public boolean modificarCuenta(Cuenta cuenta);
	public Cuenta Obtenercuenta(int NroCuenta_Cuenta);
	public ArrayList<Cuenta> obtenerCuentasxDni(int dni_cliente);
	public boolean borrar(int NroCuenta_Cuenta);
	public Boolean agregarCuenta(Cuenta cuenta);
	public int proximoNroCuenta();
	public String ObtenerCBU();

}

package datos;
import java.util.ArrayList;
import entidad.Cuenta;

public interface CuentaDao {
	
	public ArrayList<Cuenta> obtenerCuentas();
	public boolean editar(Cuenta cuenta);
	public Cuenta obtenerCuenta(String NroCuenta_Cuenta);
	public boolean borrar(String NroCuenta_Cuenta);
	public Boolean agregarCuenta(Cuenta cuenta);

}

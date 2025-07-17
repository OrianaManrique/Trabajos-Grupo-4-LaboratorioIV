package negocio;

import java.util.ArrayList;
import entidad.TipoCuenta;

public interface TipoCuentaNeg {

	public ArrayList<TipoCuenta> obtenerTiposCuentas();
	public String obtenerDescripcionPorId(int id);
}

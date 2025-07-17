package datos;

import java.util.ArrayList;

import entidad.TipoCuenta;

public interface TipoCuentaDao {
	
	public ArrayList<TipoCuenta> obtenerTiposCuentas();
	public String obtenerDescripcionPorId(int id);
}

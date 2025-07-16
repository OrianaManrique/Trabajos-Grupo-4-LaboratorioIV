package negocio;

import java.util.ArrayList;

import entidad.TipoCuenta;

public interface Tipo_CuentaNeg {

	public ArrayList<TipoCuenta> obtenerTiposCuentas();
	public String obtenerDescripcionPorId(int id);
}

package negocio;

import java.util.ArrayList;

import entidad.TipoMovimiento;

public interface TipoMovimientoNeg {

	public ArrayList<TipoMovimiento> obtenerTiposMovimientos();
	public String obtenerDescripcionPorId(int id);
}

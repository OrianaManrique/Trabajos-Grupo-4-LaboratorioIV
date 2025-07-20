package datos;

import java.util.ArrayList;

import entidad.TipoMovimiento;

public interface TipoMovimientoDao {

	public ArrayList<TipoMovimiento> obtenerTiposMovimientos();
	public String obtenerDescripcionPorId(int id);
	
}

package datos;

import java.util.ArrayList;

import entidad.Movimiento;

public interface MovimientoDao {

	public ArrayList<Movimiento> obtenerMovimientosCuenta(int NCuenta);
	public ArrayList<Movimiento> obtenerMovimientosPorCliente(int dni);
}

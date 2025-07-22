package negocio;

import java.util.ArrayList;

import entidad.Movimiento;

public interface MovimientoNeg {

	public ArrayList<Movimiento> obtenerMovimientosCuenta(int NCuenta);
	public ArrayList<Movimiento> obtenerMovimientosPorCliente(int dni);
}

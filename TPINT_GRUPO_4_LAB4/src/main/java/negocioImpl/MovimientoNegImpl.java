package negocioImpl;

import java.util.ArrayList;

import entidad.Movimiento;
import datos.MovimientoDao;
import datosImpl.MovimientoDaoImpl;
import negocio.MovimientoNeg;

public class MovimientoNegImpl implements MovimientoNeg{
	
	private MovimientoDao movDao = new MovimientoDaoImpl();

	public MovimientoNegImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Movimiento> obtenerMovimientosCuenta(int NCuenta) {
		
		return movDao.obtenerMovimientosCuenta(NCuenta);
	}

	public ArrayList<Movimiento> obtenerMovimientosPorCliente(int dni){
		return movDao.obtenerMovimientosPorCliente(dni);
	}
}

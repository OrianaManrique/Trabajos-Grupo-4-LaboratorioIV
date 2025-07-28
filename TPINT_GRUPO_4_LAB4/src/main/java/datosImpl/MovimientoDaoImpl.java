package datosImpl;

import java.sql.ResultSet;
import java.util.ArrayList;

import datos.MovimientoDao;
import entidad.Cuenta;
import entidad.Movimiento;
import entidad.TipoMovimiento;

public class MovimientoDaoImpl implements MovimientoDao{
	
	Conexion conexion;

	public MovimientoDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Movimiento> obtenerMovimientosCuenta(int NCuenta){
		conexion = new Conexion();
		conexion.open();
		
		String consulta = ("SELECT nroCuenta_movimiento AS NroCuenta, fecha_movimiento AS Fecha, detalle_movimiento AS Detalle, \r\n"
				+ "importe_movimiento AS Importe, Mov.id_tipoMovimiento AS TipoMovimiento, TipoMov.descripcion_tipoMovimiento AS DescripcionTipoMovimiento\r\n"
				+ "FROM movimientos Mov INNER JOIN tipomovimientos TipoMov ON Mov.id_tipoMovimiento = TipoMov.id_tipoMovimiento WHERE nroCuenta_movimiento = "+NCuenta+";");

		ArrayList<Movimiento> lista = new ArrayList<Movimiento>();

		try {
			ResultSet rs = conexion.query(consulta);

			while (rs.next()) {
				
				Movimiento movimiento = new Movimiento();
				Cuenta cuenta = new Cuenta();
				TipoMovimiento tipoMov = new TipoMovimiento();
				
				cuenta.setNroCuenta_cuenta(rs.getInt("NroCuenta"));
				tipoMov.setId_tipomovimiento(rs.getInt("TipoMovimiento"));
				tipoMov.setDescripcion_tipomovimiento(rs.getString("DescripcionTipoMovimiento"));
				
				movimiento.setNroCuenta_movimiento(cuenta);
				movimiento.setFecha_movimiento(rs.getDate("Fecha"));
				movimiento.setDetalle_movimiento(rs.getString("Detalle"));
				movimiento.setImporte_movimiento(rs.getFloat("Importe"));
				movimiento.setId_tipoMovimiento(tipoMov);
				
				lista.add(movimiento);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.close();
		}
		return lista;
	}
	
	public ArrayList<Movimiento> obtenerMovimientosPorCliente(int dni){
		
		conexion = new Conexion();
		conexion.open();
		
		String consulta = ("SELECT \r\n"
				+ "    Mov.nroCuenta_movimiento AS NroCuenta,\r\n"
				+ "    Mov.fecha_movimiento AS Fecha,\r\n"
				+ "    Mov.detalle_movimiento AS Detalle,\r\n"
				+ "    Mov.importe_movimiento AS Importe,\r\n"
				+ "    Mov.id_tipoMovimiento AS TipoMovimiento,\r\n"
				+ "    TipoMov.descripcion_tipoMovimiento AS DescripcionTipoMovimiento\r\n"
				+ "FROM movimientos Mov\r\n"
				+ "INNER JOIN tipomovimientos TipoMov ON Mov.id_tipoMovimiento = TipoMov.id_tipoMovimiento\r\n"
				+ "INNER JOIN cuentas Cue ON Mov.nroCuenta_movimiento = Cue.nroCuenta_cuenta\r\n"
				+ "WHERE Cue.estado_cuenta = 1 AND Cue.dnicliente_cuenta = "+dni+";");

		ArrayList<Movimiento> lista = new ArrayList<Movimiento>();

		try {
			ResultSet rs = conexion.query(consulta);

			while (rs.next()) {
				
				Movimiento movimiento = new Movimiento();
				Cuenta cuenta = new Cuenta();
				TipoMovimiento tipoMov = new TipoMovimiento();
				
				cuenta.setNroCuenta_cuenta(rs.getInt("NroCuenta"));
				tipoMov.setId_tipomovimiento(rs.getInt("TipoMovimiento"));
				tipoMov.setDescripcion_tipomovimiento(rs.getString("DescripcionTipoMovimiento"));
				
				movimiento.setNroCuenta_movimiento(cuenta);
				movimiento.setFecha_movimiento(rs.getDate("Fecha"));
				movimiento.setDetalle_movimiento(rs.getString("Detalle"));
				movimiento.setImporte_movimiento(rs.getFloat("Importe"));
				movimiento.setId_tipoMovimiento(tipoMov);
				
				lista.add(movimiento);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.close();
		}
		return lista;
	}
}


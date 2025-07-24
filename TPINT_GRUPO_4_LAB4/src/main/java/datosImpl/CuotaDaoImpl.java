package datosImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import datos.CuotaDao;
import entidad.Cliente;
import entidad.Cuota;
import entidad.Prestamo;

public class CuotaDaoImpl implements CuotaDao {
	
	private Conexion conexion;

	@Override
	public ArrayList<Cuota> obtenerCuotasporIdPrestamo(int idPrestamo) {
		conexion = new Conexion();
		conexion.open();

		String consulta = "SELECT cp.id_cuota AS IdCuota, cp.id_prestamo_cuota AS IdPrestamo, cp.monto_cuota AS Monto, cp.fechaPago_cuota AS Fecha " +
                "FROM cuotasprestamo cp " +
                "INNER JOIN prestamos p ON cp.id_prestamo_cuota = p.id_prestamo " +
                "WHERE cp.id_prestamo_cuota = " + idPrestamo + " " +
                "AND p.estado_prestamo = 1 " +
                "AND p.condicion_prestamo = 'A'";

		ArrayList<Cuota> lista = new ArrayList<Cuota>();

		try {
			ResultSet rs = conexion.query(consulta);

			while (rs.next()) {
				Cuota cuota = new Cuota();
				Prestamo prestamo = new Prestamo();
				
				cuota.setId_Cuota(rs.getInt("IdCuota"));
				prestamo.setId_prestamo(rs.getInt("IdPrestamo"));
				cuota.setIdprestamo_cuota(prestamo);
				cuota.setMonto_cuota((rs.getFloat("Monto")));
				cuota.setFechaPago_cuota(rs.getDate(("Fecha")));;

				lista.add(cuota);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.close();
		}
		return lista;
	}

	@Override
	public int obtenerCantidadCuotasPagadas(int idPrestamo) {
		
		conexion = new Conexion();
		conexion.open();
		
		int CantidadCuotas=-1;

		String consulta = ("SELECT COUNT(*) AS total FROM cuotasprestamo WHERE id_prestamo_cuota ="+ idPrestamo);
 

		try {
			ResultSet rs = conexion.query(consulta);

			if(rs.next()) {

				CantidadCuotas = rs.getInt("total");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.close();
		}
		return CantidadCuotas;
	}

	@Override
	public boolean PagarCuota(int idPrestamo, int NumeroCuenta) {
		
		boolean estado = false;
		
		conexion = new Conexion();
		conexion.open();
		
				
		String consulta = "CALL PagarCuota(" + idPrestamo +","+ NumeroCuenta +")";
		
		try {
			estado = conexion.execute(consulta);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.close();
		}
		
		return estado;
	}

}
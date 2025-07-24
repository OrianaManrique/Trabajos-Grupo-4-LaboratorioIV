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

		String consulta = ("Select id_cuota, id_prestamo_cuota, monto_cuota, fechaPago_cuota \r\n"
				+ "from cuotasprestamo inner join prestamos\r\n"
				+ "on id_prestamo_cuota = "+ idPrestamo+"\r\n"
				+ "where id_prestamo_cuota = 1\r\n"
				+ "and estado_prestamo = 1\r\n"
				+ "and condicion_prestamo = 'A';\r\n"
				+ "");

		ArrayList<Cuota> lista = new ArrayList<Cuota>();

		try {
			ResultSet rs = conexion.query(consulta);

			while (rs.next()) {
				Cuota cuota = new Cuota();
				Prestamo prestamo = new Prestamo();
				
				cuota.setId_Cuota(rs.getInt("id_cuota"));
				prestamo.setId_prestamo(rs.getInt("id_prestamo_cuota"));
				cuota.setIdprestamo_cuota(prestamo);
				cuota.setMonto_cuota((rs.getFloat("monto_cuota")));
				cuota.setFechaPago_cuota(rs.getDate(("fechaPago_cuota")));;

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

}
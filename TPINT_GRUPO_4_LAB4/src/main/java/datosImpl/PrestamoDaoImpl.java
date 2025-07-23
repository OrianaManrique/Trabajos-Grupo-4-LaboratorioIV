package datosImpl;
import java.sql.ResultSet;
import java.util.ArrayList;
import datos.PrestamoDao;
import entidad.Cliente;
import entidad.Cuenta;
import entidad.Prestamo;

public class PrestamoDaoImpl implements PrestamoDao {
    
	private Conexion conexion;
	@Override
	public boolean SolicitarPrestamo(Prestamo prestamo) {
		
		boolean estado = false;

		conexion = new Conexion();
		conexion.open();

		String query = "CALL SolicitudPrestamo("
			    + prestamo.getDniCliente_prestamo().getDni_cliente() + ", "
			    + prestamo.getNroCuenta_prestamo().getNroCuenta_cuenta() + ", "
			    + prestamo.getImporteSolicitado_prestamo() + ", "
			    + prestamo.getImporteApagar_prestamo() + ", "
			    + prestamo.getPlazoDePago_prestamo() + ", "
			    + prestamo.getCuotas_prestamo() + ", "
			    + prestamo.getMontoMensual_prestamo()
			    + ");";

		try {
			estado = conexion.execute(query);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.close();
		}
		return estado;
	}

	@Override
	public ArrayList<Prestamo> obtenerPrestamos() {
		
		conexion = new Conexion();
		conexion.open();
		
		String consulta = ("Select id_prestamo AS Id , dnicliente_prestamo AS Dni , nroCuenta_prestamo AS NroCuenta , importe_a_pagar_prestamo AS ImportePagar , importe_solicitado_prestamo AS ImporteSolicitado,  "
				          + "plazo_de_pago_prestamo AS Plazo, cuotas_prestamo AS Cuotas, fecha_creacion_prestamo AS Fecha, montoMensual_prestamo AS Monto, "
				          + "condicion_prestamo AS Condicion FROM prestamos WHERE estado_prestamo=1");

		ArrayList<Prestamo> lista = new ArrayList<Prestamo>();

		try {
			ResultSet rs = conexion.query(consulta);

			while (rs.next()) {
				
				Prestamo prestamo = new Prestamo();
				prestamo.setId_prestamo(rs.getInt("Id"));
				
				Cliente cliente = new Cliente();
				cliente.setDni_cliente(rs.getInt("Dni"));
				prestamo.setDniCliente_prestamo(cliente);
				
				Cuenta cuenta = new Cuenta();
				cuenta.setNroCuenta_cuenta(rs.getInt("NroCuenta"));
				prestamo.setNroCuenta_prestamo(cuenta);
				
				prestamo.setImporteApagar_prestamo(rs.getFloat("ImportePagar"));
				prestamo.setImporteSolicitado_prestamo(rs.getFloat("ImporteSolicitado"));
				prestamo.setPlazoDePago_prestamo(rs.getInt("Plazo"));
				prestamo.setCuotas_prestamo(rs.getInt("Cuotas"));
				prestamo.setFechaCreacion_prestamo(rs.getDate("Fecha"));
				prestamo.setMontoMensual_prestamo(rs.getFloat("Monto"));
				prestamo.setCondicion_prestamo(rs.getString("Condicion"));
				
				lista.add(prestamo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.close();
		}
		return lista;
	}
	
	public boolean AutorizarRechazarPrestamo(Prestamo prestamo, String CambioCondicion){
		
		boolean estado = false;

		conexion = new Conexion();
		conexion.open();

		String query = "CALL AutorizarRechazarPrestamo("
			    + prestamo.getId_prestamo() + ", "
			    + prestamo.getNroCuenta_prestamo().getNroCuenta_cuenta() + ", "
			    + prestamo.getImporteSolicitado_prestamo() + ", '"
			    + CambioCondicion + "');";

		try {
			estado = conexion.execute(query);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.close();
		}
		return estado;
	}

}

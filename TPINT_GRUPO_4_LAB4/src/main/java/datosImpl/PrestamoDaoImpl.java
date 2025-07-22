package datosImpl;
import java.util.ArrayList;
import datos.PrestamoDao;
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
		// TODO Auto-generated method stub
		return null;
	}

}

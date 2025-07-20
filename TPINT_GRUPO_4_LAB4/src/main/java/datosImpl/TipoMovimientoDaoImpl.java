package datosImpl;

import java.sql.ResultSet;
import java.util.ArrayList;

import datos.TipoMovimientoDao;
import entidad.TipoMovimiento;

public class TipoMovimientoDaoImpl  implements TipoMovimientoDao{

	Conexion conexion;
	
	public TipoMovimientoDaoImpl() {
		// TODO Auto-generated constructor stub
	}

public ArrayList<TipoMovimiento> obtenerTiposMovimientos() {
		
		conexion = new Conexion();
		conexion.open();

		String consulta = ("SELECT id_tipoMovimiento AS TipoMovimiento, descripcion_tipoMovimiento AS Descripcion FROM tipomovimientos;");
		
		ArrayList<TipoMovimiento> lista = new ArrayList<TipoMovimiento>();

		try {
			ResultSet rs = conexion.query(consulta);

			while (rs.next()) {
				
				TipoMovimiento tipoMov = new TipoMovimiento();
				
				tipoMov.setId_tipomovimiento(rs.getInt("TipoMovimiento"));
				tipoMov.setDescripcion_tipomovimiento(rs.getString("Descripcion"));

				lista.add(tipoMov);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.close();
		}
		return lista;
	}
	
	public String obtenerDescripcionPorId(int id) {
	
		conexion = new Conexion();
		conexion.open();
		TipoMovimiento tipoMov = new TipoMovimiento();

		String consulta = ("SELECT descripcion_tipoMovimiento AS Descripcion from tipomovimientos WHERE id_tipoMovimiento = "+id+";");

		try {
			ResultSet rs = conexion.query(consulta);

			if (rs.next()) {
				tipoMov.setDescripcion_tipomovimiento(consulta);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.close();
		}
		
		return tipoMov.getDescripcion_tipomovimiento();
	}
}

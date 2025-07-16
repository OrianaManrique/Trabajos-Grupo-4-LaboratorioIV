package datosImpl;
import java.sql.ResultSet;
import java.util.ArrayList;
import datos.Tipo_CuentaDao;
import entidad.TipoCuenta;

public class Tipo_CuentaDaoImpl implements Tipo_CuentaDao{
	
	Conexion conexion;

	public Tipo_CuentaDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<TipoCuenta> obtenerTiposCuentas() {
		
		conexion = new Conexion();
		conexion.open();

		String consulta = ("SELECT id_tipoCuenta, descripcion_tipoCuenta FROM tipocuentas;");

		ArrayList<TipoCuenta> lista = new ArrayList<TipoCuenta>();

		try {
			ResultSet rs = conexion.query(consulta);

			while (rs.next()) {
				
				TipoCuenta tipo = new TipoCuenta();
				
				tipo.setId_tipoCuenta(rs.getInt("id_tipoCuenta"));
				tipo.setDescripcion_tipoCuenta(rs.getString("descripcion_tipoCuenta"));

				lista.add(tipo);
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
		TipoCuenta tipo = new TipoCuenta();

		String consulta = ("select descripcion_tipoCuenta AS Descripcion from tipocuentas where id_tipoCuenta = "+id+";");

		try {
			ResultSet rs = conexion.query(consulta);

			if (rs.next()) {
				tipo.setDescripcion_tipoCuenta(rs.getString("Descripcion"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.close();
		}
		
		return tipo.getDescripcion_tipoCuenta();
	}
	

}

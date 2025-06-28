package datosImpl;
import java.sql.ResultSet;
import java.util.ArrayList;
import datos.Tipo_CuentaDao;
import entidad.Tipo_Cuenta;

public class Tipo_CuentaDaoImpl implements Tipo_CuentaDao{
	
	Conexion conexion;

	public Tipo_CuentaDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Tipo_Cuenta> obtenerTiposCuentas() {
		
		conexion = new Conexion();
		conexion.open();

		String consulta = ("SELECT id_TipoCuenta, Descripcion_tipoCuenta FROM tipo_cuentas;");

		ArrayList<Tipo_Cuenta> lista = new ArrayList<Tipo_Cuenta>();

		try {
			ResultSet rs = conexion.query(consulta);

			while (rs.next()) {
				
				Tipo_Cuenta tipo = new Tipo_Cuenta();
				
				tipo.setId_tipoCuenta(rs.getInt("id_TipoCuenta"));
				tipo.setDescripcion_tipoCuenta(rs.getString("Descripcion_tipoCuenta"));

				lista.add(tipo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.close();
		}
		return lista;
	}

}

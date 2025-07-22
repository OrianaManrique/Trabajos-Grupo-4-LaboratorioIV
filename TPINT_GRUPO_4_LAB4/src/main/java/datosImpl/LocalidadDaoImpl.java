package datosImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import datos.LocalidadDao;
import entidad.Localidad;
import entidad.Provincia;

public class LocalidadDaoImpl implements LocalidadDao {

	public ArrayList<Localidad> listaLocalidad() {
		Conexion conexion = new Conexion();
		conexion.open();

		ArrayList<Localidad> list = new ArrayList<Localidad>();
		try {

			ResultSet rs = conexion
					.query("SELECT l.id_localidad, l.descripcion_localidad, p.id_provincia, p.descripcion_provincia " +
						    "FROM localidades l " +
						    "INNER JOIN provincias p ON l.id_provincia_localidad = p.id_provincia");
			while (rs.next()) {
				
				Localidad localidad = new Localidad();

				localidad.setId_localidad(rs.getInt("l.id_localidad"));
				localidad.setDescripcion_localidad(rs.getString("l.Descripcion_localidad"));

				Provincia provincia = new Provincia();
				provincia.setId_provincia(rs.getInt("p.id_provincia"));
				provincia.setDescripcion_provincia(rs.getString("p.Descripcion_Provincia"));
				localidad.setId_provincia(provincia);

				list.add(localidad);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.close();
		}
		return list;
	}

	@Override
	public String obtenerDescripcionPorId(int id) {
		
		 Conexion conexion= new Conexion();
		 conexion.open();
		 
		Localidad localidad = new Localidad();

		String consulta = ("SELECT descripcion_localidad AS Descripcion from localidades WHERE id_localidad = "+id+";");

		try {
			ResultSet rs = conexion.query(consulta);

			if (rs.next()) {
				localidad.setDescripcion_localidad(rs.getString("Descripcion"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.close();
		}
		
		return localidad.getDescripcion_localidad();
	}

}

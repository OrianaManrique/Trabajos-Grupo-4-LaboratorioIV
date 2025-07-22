package datosImpl;
import java.sql.ResultSet;
import java.util.ArrayList;
import datos.ProvinciaDao;
import entidad.Provincia;
import entidad.TipoMovimiento;

public class ProvinciaDaoImpl implements ProvinciaDao {
	
	
	public ArrayList<Provincia> listarProvincias() {
		 Conexion conexion= new Conexion();
		 conexion.open();
		 ArrayList<Provincia> list = new ArrayList<Provincia>();
		 try
		 {
			 ResultSet rs= conexion.query("SELECT id_provincia, descripcion_provincia FROM provincias");
			 while(rs.next())
			 {
				 Provincia prov = new Provincia();
				 prov.setId_provincia(rs.getInt("id_provincia"));
				 prov.setDescripcion_provincia(rs.getString("descripcion_provincia"));
				 
				 list.add(prov);
			 }
			 
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 conexion.close();
		 }
		 return list;
	}
	
	public String obtenerDescripcionPorId(int id) {
		
		 Conexion conexion= new Conexion();
		 conexion.open();
		 
		Provincia provincia = new Provincia();

		String consulta = ("SELECT descripcion_provincia AS Descripcion from provincias WHERE id_provincia = "+id+";");

		try {
			ResultSet rs = conexion.query(consulta);

			if (rs.next()) {
			
				provincia.setDescripcion_provincia(rs.getString("Descripcion"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.close();
		}
		
		return provincia.getDescripcion_provincia();
	}

}

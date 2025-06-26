package datosImpl;
import java.sql.ResultSet;
import java.util.ArrayList;
import datos.ProvinciaDao;
import entidad.Provincia;

public class ProvinciaDaoImpl implements ProvinciaDao {
	
	
	public ArrayList<Provincia> listarProvincias() {
		 Conexion conexion= new Conexion();
		 conexion.open();
		 ArrayList<Provincia> list = new ArrayList<Provincia>();
		 try
		 {
			 ResultSet rs= conexion.query("SELECT id_provincia ,Descripcion_provincia FROM provincias");
			 while(rs.next())
			 {
				 Provincia prov = new Provincia();
				 prov.setId_provincia(rs.getInt("id_provincia"));
				 prov.setDescripcion_provincia(rs.getString("Descripcion_provincia"));
				 
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

}

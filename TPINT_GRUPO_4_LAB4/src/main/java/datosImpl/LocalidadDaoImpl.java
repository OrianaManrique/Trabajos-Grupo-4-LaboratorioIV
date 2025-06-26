package datosImpl;
import java.sql.ResultSet;
import java.util.ArrayList;
import datos.LocalidadDao;
import entidad.Localidad;

public class LocalidadDaoImpl implements LocalidadDao {
	
	
	public ArrayList<Localidad> listaLocalidad(int idProvincia) {
		 Conexion conexion= new Conexion();
		 conexion.open();
		 ArrayList<Localidad> list = new ArrayList<Localidad>();
		 try
		 {   
			 
			 ResultSet rs= conexion.query("SELECT id_localidad , Descripcion_localidad FROM localidades WHERE localidades.id_provincia =" + idProvincia);
			 while(rs.next())
			 {
				 Localidad localidad = new Localidad();
				 localidad.setId_localidad(rs.getInt("id_localidad"));
				 localidad.setDescripcion_localidad(rs.getString("Descripcion_localidad"));
				 
				 list.add(localidad);
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

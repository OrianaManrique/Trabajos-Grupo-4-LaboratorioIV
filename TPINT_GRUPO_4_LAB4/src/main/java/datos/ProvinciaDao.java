package datos;
import java.util.ArrayList;
import entidad.Provincia;

public interface ProvinciaDao {
   
	public ArrayList<Provincia> listarProvincias();
	public String obtenerDescripcionPorId(int id);
	
}

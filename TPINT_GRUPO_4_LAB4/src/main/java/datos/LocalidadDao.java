package datos;
import java.util.ArrayList;
import entidad.Localidad;

public interface LocalidadDao{
   
	public ArrayList<Localidad> listaLocalidad();
	public String obtenerDescripcionPorId(int id);
	
}

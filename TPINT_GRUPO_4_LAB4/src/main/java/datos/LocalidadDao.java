package datos;
import java.util.ArrayList;
import entidad.Localidad;

public interface LocalidadDao{
   
	public ArrayList<Localidad> listaLocalidad(int idProvincia);
	
}

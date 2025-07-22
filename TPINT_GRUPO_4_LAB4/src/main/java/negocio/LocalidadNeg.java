package negocio;
import java.util.ArrayList;
import entidad.Localidad;

public interface LocalidadNeg {
  
	public ArrayList<Localidad> listarLocalidades();
	public String obtenerDescripcionPorId(int id);
	
}

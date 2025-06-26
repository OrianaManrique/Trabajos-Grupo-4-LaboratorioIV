package negocioImpl;
import java.util.List;
import datos.ProvinciaDao;
import datosImpl.ProvinciaDaoImpl;
import entidad.Provincia;

public class ProvinciaNegImpl {
    
	private ProvinciaDao provDao = new ProvinciaDaoImpl();
	
	public List<Provincia> obtenerTodos() {
		return provDao.listarProvincias();
	}
	
}

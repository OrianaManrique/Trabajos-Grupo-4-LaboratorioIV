package negocioImpl;
import java.util.ArrayList;
import datos.ProvinciaDao;
import datosImpl.ProvinciaDaoImpl;
import entidad.Provincia;
import negocio.ProvinciaNeg;

public class ProvinciaNegImpl implements ProvinciaNeg {
    
	private ProvinciaDao provDao = new ProvinciaDaoImpl();

	@Override
	public ArrayList<Provincia> listarProvincias() {
		return provDao.listarProvincias();
	}
	
}

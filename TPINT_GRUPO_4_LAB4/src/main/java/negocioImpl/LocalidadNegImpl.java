package negocioImpl;
import java.util.ArrayList;
import datos.LocalidadDao;
import datosImpl.LocalidadDaoImpl;
import entidad.Localidad;
import negocio.LocalidadNeg;

public class LocalidadNegImpl implements LocalidadNeg{
    
	private LocalidadDao LocDao = new LocalidadDaoImpl();
	
	@Override
	public ArrayList<Localidad> listarLocalidades() {
		return LocDao.listaLocalidad();
	}

	@Override
	public String obtenerDescripcionPorId(int id) {
		return LocDao.obtenerDescripcionPorId(id);
	}

}

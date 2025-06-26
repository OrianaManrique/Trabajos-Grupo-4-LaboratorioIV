package negocioImpl;
import java.util.ArrayList;
import datos.LocalidadDao;
import datosImpl.LocalidadDaoImpl;
import entidad.Localidad;
import negocio.LocalidadNeg;

public class LocalidadNegImpl implements LocalidadNeg{
    
	private LocalidadDao provDao = new LocalidadDaoImpl();
	
	@Override
	public ArrayList<Localidad> listarLocalidades(int IdProvincia) {
		return provDao.listaLocalidad(IdProvincia);
	}

}

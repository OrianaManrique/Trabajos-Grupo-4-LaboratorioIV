package negocioImpl;

import java.util.List;

import com.sun.tools.javac.util.Convert;

import dao.PersonaDao;
import daoImpl.PersonaDaolmpl;
import Entidad.Persona;
import negocio.PersonaNegocio;

public class PersonaNegocioImpl implements PersonaNegocio{

	PersonaDao pdao = new PersonaDaolmpl();
	
	@Override
	public boolean insert(Persona persona) {
		
		boolean estado=false;
		if(persona.getNombre().trim().length()>0)
		{
			estado=pdao.AgregarPersona(persona);
		}
		return estado;
	}

	@Override
	public boolean delete(Persona personaEliminar) {
		boolean estado=false;
		if(personaEliminar.getDni()>0)
		{
			estado=pdao.EliminarPersona(personaEliminar);
		}
		return estado;
	}
	
	@Override
	public boolean update(Persona personaModificar) {
		boolean estado=false;
		if(personaModificar.getDni()>0)
		{
			estado=pdao.ModificarPersona(personaModificar);
		}
		return estado;
	}

	@Override
	public List<Persona> readAll() {
		return pdao.ListarPersonas();
	}

}

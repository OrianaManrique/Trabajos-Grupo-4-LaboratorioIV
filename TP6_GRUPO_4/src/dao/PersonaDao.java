package dao;

import java.util.List;

import Entidad.Persona;


public interface PersonaDao 
{
	public boolean AgregarPersona(Persona persona);
	public boolean ModificarPersona(Persona persona);
	public boolean EliminarPersona(Persona Persona);
	public List<Persona> ListarPersonas();
}

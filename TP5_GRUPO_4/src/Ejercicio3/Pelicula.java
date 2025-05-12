package Ejercicio3;

public class Pelicula {
  
	private int ID;
	private String nombre;
	Genero genero;
	private static int Contador = 0;
	
	public Pelicula() {
		Contador++;
		this.ID = Contador;
	}
	
	public Pelicula(String Nombre , Genero genero) {
		
		Contador++;
		
		this.ID = Contador;
		this.nombre = Nombre;
		this.genero = genero;
	}
	
	public int getID() {
		return ID;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public int siguienteID() {
		return Contador + 1;
	}
	
	@Override
	public String toString() {
		return "ID:" + ID + " | nombre : " + nombre + " | genero : " + genero;
	}
	
}

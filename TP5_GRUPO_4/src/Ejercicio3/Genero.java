package Ejercicio3;

public class Genero {

	
	private int id;
    private String nombre;
    	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Genero() {
		
	}

	public Genero(int id, String nombre ) {
		this.id = id;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
}

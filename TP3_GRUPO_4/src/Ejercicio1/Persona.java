package Ejercicio1;

public class Persona implements Comparable<Persona>{
    private String nombre;
    private String apellido;
    private String dni;

    // Constructor
    public Persona(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    // Getter para nombre 
    public String getNombre() {
        return nombre;
    }

    // Setter para nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para apellido
    public String getApellido() {
        return apellido;
    }

    // Setter para apellido
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    // Getter para dni
    public String getDni() {
        return dni;
    }


	// Setter para dni
    public void setDni(String dni) {
        this.dni = dni;
    }
    
	@Override
	public int compareTo(Persona otraPersona) {
		return this.apellido.compareTo(otraPersona.getApellido());
	}
	
	@Override
	public String toString() {
		return nombre + " " + apellido + " " + dni;
	}
}
package Ejercicio1;

import java.util.Iterator;
import java.util.TreeSet;

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
	
	public int compareTo(Persona otra) {
	    return this.apellido.compareToIgnoreCase(otra.getApellido());
	}
	
	@Override
	public String toString() {
		return nombre + " " + apellido + " " + dni + "\n";
	}
	
    public static boolean  verificarDniInvalido(String Dniaux) throws DniInvalido {   	
    	if(Dniaux.matches("[0-9]+")) {    		
    		return true; 	
    	}else {	
    		throw new DniInvalido(); 
    	}
     }
    
    public static void Mostrar(TreeSet<Persona> lista){

		System.out.println("LISTADO DE PERSONAS\n");
			Iterator<Persona> it = lista.iterator();
			while (it.hasNext()) {
				Persona persona = it.next();
				System.out.println(persona.toString());

			}
    }
    
} 
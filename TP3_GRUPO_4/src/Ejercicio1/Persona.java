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
	public int compareTo(Persona o) {
		return this.dni.compareTo(o.dni);   			
	}
	
	@Override
	public String toString() {
		return nombre + " " + apellido + " " + dni;
	}
	
    public static boolean  verificarDniInvalido(String Dniaux) throws DniInvalido {   	
    	if(ValidarNumeros(Dniaux)==false){    		
    		throw new DniInvalido();   		
    	}else {				
    		return true;  		
    	}
     }
     
    public static boolean ValidarNumeros(String Numeros) {   	
    	if(Numeros.matches("[0-9]*")){
    	  return true;
    	}else {
    	   return false;
    	}	   	
    }
}
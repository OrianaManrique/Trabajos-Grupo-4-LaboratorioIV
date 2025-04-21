package Ejercicio1;
import java.util.Iterator;
import java.util.TreeSet;


public class Principal {

	public static void main(String[] args) throws DniInvalido  {
		
		Archivo archivoPersonas = new Archivo();
		archivoPersonas.setRuta("Personas.txt");
		
		Archivo archivoResultado = new Archivo();
		archivoResultado.setRuta("Resultado.txt");
				
		if(archivoPersonas.existe())
		{		
			TreeSet<Persona> listaPersonas = new TreeSet<Persona>();
		
	    try {
		    listaPersonas = Archivo.GuardarArchivoenTreeSet(listaPersonas , "Personas.txt");		   	    	

                        System.out.println("LISTADO DE PERSONAS\n");		    	
					    Iterator<Persona> it = listaPersonas.iterator();
					    while (it.hasNext()) {
						   Persona persona = it.next();			   
						   System.out.println(persona.toString());								   			   
					        }			    	    		    	        	    	   	    				  
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR - NO SE PUDO GUARDAR EL ARRAYLIST");
		}
				
		}
		else
		{
			System.out.println("No existe el archivo");
			archivoPersonas.creaArchivo();
		}	
		 
	}

}
package Ejercicio1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class mainEjercicio1_b {

	public static void main(String[] args) {
		TreeSet<Profesor> profesores = new TreeSet<>();

        profesores.add(new Profesor("Samira", 40, "Titular", 15));
        profesores.add(new Profesor("Lucas", 35, "Adjunto", 10));
        profesores.add(new Profesor("Dante", 50, "Jefe de Cátedra", 25));
        profesores.add(new Profesor("Lady", 29, "Ayudante", 3));
        profesores.add(new Profesor("Juan", 45, "Adjunto", 18));

        Iterator<Profesor> it = profesores.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        
        
        Profesor Profe1 = new Profesor("Carla", 40, "Titular", 10);
        Profesor Profe2 = new Profesor("Carla", 40, "Titular", 10);

        if (Profe1.equals(Profe2)) 
        	{
        	
        	/*System.out.println(Profe1.toString());
        	System.out.println(Profe2.toString());*/
        	System.out.println("Es el mismo profesor.");
        	}/*else 
        	{
        		System.out.println(Profe1.toString());
            	System.out.println(Profe2.toString());
        		System.out.println("No son el mismo profesor.");
        	}*/
        
	}
	
}

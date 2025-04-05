package Ejercicio1;

import java.util.ArrayList;
import java.util.Iterator;

public class mainEjercicio1_a {
    public static void main(String[] args) {
        ArrayList<Profesor> profesores = new ArrayList<>();

        profesores.add(new Profesor("Ana", 40, "Titular", 15));
        profesores.add(new Profesor("Luis", 35, "Adjunto", 10));
        profesores.add(new Profesor("Marta", 50, "Jefe de Cátedra", 25));
        profesores.add(new Profesor("Pedro", 29, "Ayudante", 3));
        profesores.add(new Profesor("Sofía", 45, "Adjunto", 18));

        Iterator<Profesor> it = profesores.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
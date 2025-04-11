package Ejercicio3;

import java.util.ArrayList;
import java.util.Iterator;

public class mainEjercicio3 {
    public static void main(String[] args) {
    	
        ArrayList<Edificio> listaEdificios = new ArrayList<>();
        
        listaEdificios.add(new Polideportivo("Poli Norte", 1200.5, 1));
        listaEdificios.add(new Polideportivo("Poli Sur", 950.0, 2));
        listaEdificios.add(new Polideportivo("Poli Centro", 1100.25, 1));

        listaEdificios.add(new EdificioOficinas("Norte", 300.75, 10));
        listaEdificios.add(new EdificioOficinas("Centro", 500.0, 15));

        Iterator<Edificio> it = listaEdificios.iterator();

        	while (it.hasNext()) {
            Edificio obj = it.next();
            System.out.println(obj);
        	}
        
        }
    }


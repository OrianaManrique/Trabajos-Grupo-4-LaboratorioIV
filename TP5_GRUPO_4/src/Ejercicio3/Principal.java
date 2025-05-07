package Ejercicio3;

import java.awt.EventQueue;
//codigo para programar mas facil
public class Principal {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Programa frame = new Programa();
					
					Genero G1 = new Genero(1,"Terror");
					Genero G2 = new Genero(2,"Acción");
					Pelicula p1 = new Pelicula("Alien",G1);
					Pelicula p2 = new Pelicula("Terminator",G2);
					
					System.out.println(p1.toString());
					System.out.println(p2.toString());
										
					frame.setTitle("Programa");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}		
}

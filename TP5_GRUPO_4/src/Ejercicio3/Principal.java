package Ejercicio3;

import java.awt.EventQueue;
//codigo para programar mas facil

import javax.swing.DefaultListModel;
public class Principal {
	
	private static DefaultListModel<Pelicula> listModel;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Programa frame = new Programa();
					listModel = new DefaultListModel<Pelicula>();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}		
}

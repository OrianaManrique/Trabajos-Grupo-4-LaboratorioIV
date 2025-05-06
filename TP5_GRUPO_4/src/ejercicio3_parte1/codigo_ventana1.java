package ejercicio3_parte1;

import java.awt.EventQueue;
//codigo para programar mas facil
public class codigo_ventana1 {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana_1 frame = new ventana_1();
					
					frame.setTitle("PROGRAMA");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	
	
	
	
	
}

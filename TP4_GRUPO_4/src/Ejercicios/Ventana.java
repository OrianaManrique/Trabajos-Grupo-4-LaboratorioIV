package Ejercicios;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ventana extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private JButton botonEjercicio1;
	private JButton botonEjercicio2;
	private JButton botonEjercicio3;
	
	private JLabel titulo;
	
	public Ventana() {
		
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setTitle("VENTANA");
		setBounds(500,500,500,500);
		setLayout(null);
		
		titulo = new JLabel();
		titulo.setSize(500,500);
	    Font nuevaFuente = new Font("Arial", Font.BOLD, 20);
	    titulo.setFont(nuevaFuente);
	    titulo.setText("GRUPO NRO: 4");
	    titulo.setBounds(180,50, 300,100);    
	    getContentPane().add(titulo);
	    
	    botonEjercicio1 = new JButton();
		botonEjercicio1.setText("Ejercicio 1");
		botonEjercicio1.setBounds(180,150, 140,30);
		getContentPane().add(botonEjercicio1);
		
		botonEjercicio2 = new JButton();
		botonEjercicio2.setText("Ejercicio 2");
		botonEjercicio2.setBounds(180,200, 140,30);
		getContentPane().add(botonEjercicio2);
		
		botonEjercicio3 = new JButton();
		botonEjercicio3.setText("Ejercicio 3");
		botonEjercicio3.setBounds(180,250, 140,30);
		getContentPane().add(botonEjercicio3);	
		
	}
	
	public void cambiarVisibilidad(boolean estado) {	
		setVisible(estado);
	}
}

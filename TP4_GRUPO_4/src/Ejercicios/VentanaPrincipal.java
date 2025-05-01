package Ejercicios;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public VentanaPrincipal() {
		setDefaultCloseOperation(VentanaPrincipal.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(213, 224, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("VENTANA");
		getContentPane().setLayout(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("GRUPO NRO: 4");
		lblNombre.setFont(new Font("Calibri", Font.BOLD, 30));
		lblNombre.setBounds(22, 109, 194, 38);
		contentPane.add(lblNombre);
		
		JButton btnEjercicio1 = new JButton("Ejercicio 1");
		btnEjercicio1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				VentanaEjercicio1 ejer1 = new VentanaEjercicio1();
				ejer1.setVisible(true);
		                
			}
		});
		btnEjercicio1.setBounds(234, 61, 144, 36);
		contentPane.add(btnEjercicio1);
		
		JButton btnEjercicio2 = new JButton("Ejercicio 2");
		btnEjercicio2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VentanaEjercicio2 ejer2 = new VentanaEjercicio2();
				ejer2.setVisible(true);
				JOptionPane.showMessageDialog(null, "Utilizar '.' para números decimales, no utilizar ','", "Aclaración", JOptionPane.INFORMATION_MESSAGE);
        		
				
			}
		});
		btnEjercicio2.setBounds(234, 110, 144, 36);
		contentPane.add(btnEjercicio2);
		
		JButton btnEjercicio3 = new JButton("Ejercicio 3");
		btnEjercicio3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VentanaEjercicio3 ejer3 = new VentanaEjercicio3();
				ejer3.setVisible(true);
				JOptionPane.showMessageDialog(null, "Utilizar '.' para números decimales, no utilizar ','", "Aclaración", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		btnEjercicio3.setBounds(234, 157, 144, 36);
		contentPane.add(btnEjercicio3);
	}
}

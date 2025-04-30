package Ejercicios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaEjercicio2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtnota3;
	private JTextField txtnota2;
	private JTextField txtnota1;
	private JTextField txtPromedio;
	private JTextField txtCondicion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEjercicio2 frame = new VentanaEjercicio2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaEjercicio2() {
		setDefaultCloseOperation(VentanaEjercicio2.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 531, 469);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(213, 224, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Promedio");

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel JPanelNotas1 = new JPanel();
		JPanelNotas1.setBounds(33, 38, 326, 212);
		JPanelNotas1.setBackground(new Color(213, 224, 255));
		contentPane.add(JPanelNotas1);
		TitledBorder bordeNotas1 = BorderFactory.createTitledBorder("Notas del estudiante");
		JPanelNotas1.setBorder(bordeNotas1);
		JPanelNotas1.setLayout(null);
		
		txtnota1 = new JTextField();
		txtnota1.setBounds(112, 31, 161, 20);
		JPanelNotas1.add(txtnota1);
		txtnota1.setColumns(10);
		
		JLabel lblNota1 = new JLabel("Nota 1:");
		lblNota1.setBounds(39, 36, 46, 14);
		JPanelNotas1.add(lblNota1);
		lblNota1.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JLabel lblNota2 = new JLabel("Nota 2:");
		lblNota2.setBounds(39, 77, 46, 14);
		JPanelNotas1.add(lblNota2);
		lblNota2.setFont(new Font("Calibri", Font.BOLD, 14));
		
		txtnota2 = new JTextField();
		txtnota2.setBounds(112, 72, 161, 20);
		JPanelNotas1.add(txtnota2);
		txtnota2.setColumns(10);
		
		txtnota3 = new JTextField();
		txtnota3.setBounds(112, 114, 161, 20);
		JPanelNotas1.add(txtnota3);
		txtnota3.setColumns(10);
		
		JLabel lblNota3 = new JLabel("Nota 3:");
		lblNota3.setBounds(39, 119, 46, 14);
		JPanelNotas1.add(lblNota3);
		lblNota3.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JComboBox cbCondicion = new JComboBox();
		cbCondicion.setBounds(112, 159, 161, 22);
		JPanelNotas1.add(cbCondicion);
		cbCondicion.setModel(new DefaultComboBoxModel(new String[] {"Aprobado", "Desaprobado"}));
		cbCondicion.setFont(cbCondicion.getFont().deriveFont(14f));
		
		JLabel lblTPS = new JLabel("TPS");
		lblTPS.setBounds(39, 163, 46, 14);
		JPanelNotas1.add(lblTPS);
		lblTPS.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JPanel JPanelNotas2 = new JPanel();
		JPanelNotas2.setBackground(new Color(213, 224, 255));
		TitledBorder bordeNotas2 = BorderFactory.createTitledBorder("Notas del estudiante");
		JPanelNotas2.setBorder(bordeNotas2);
		JPanelNotas2.setBounds(33, 273, 326, 130);
		contentPane.add(JPanelNotas2);
		JPanelNotas2.setLayout(null);
		
		JLabel lblPromedio = new JLabel("Promedio:");
		lblPromedio.setFont(new Font("Calibri", Font.BOLD, 14));
		lblPromedio.setBounds(26, 40, 74, 14);
		JPanelNotas2.add(lblPromedio);
		
		JLabel lblCondicion = new JLabel("Condición");
		lblCondicion.setFont(new Font("Calibri", Font.BOLD, 14));
		lblCondicion.setBounds(26, 82, 74, 14);
		JPanelNotas2.add(lblCondicion);
		
		txtPromedio = new JTextField();
		txtPromedio.setColumns(10);
		txtPromedio.setBounds(110, 35, 165, 20);
		JPanelNotas2.add(txtPromedio);
		
		txtCondicion = new JTextField();
		txtCondicion.setColumns(10);
		txtCondicion.setBounds(110, 77, 165, 20);
		JPanelNotas2.add(txtCondicion);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
	
		btnSalir.setFont(new Font("Calibri", Font.BOLD, 11));
		btnSalir.setBounds(369, 308, 122, 44);
		contentPane.add(btnSalir);
		
		JButton btnNuevo = new JButton("NUEVO");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtnota1.setText("");
				txtnota2.setText("");
				txtnota3.setText("");
				txtPromedio.setText("");
				txtCondicion.setText("");
				
			}
		});
		btnNuevo.setFont(new Font("Calibri", Font.BOLD, 11));
		btnNuevo.setBounds(369, 131, 122, 44);
		contentPane.add(btnNuevo);
		
		JButton btnCalcular = new JButton("CALCULAR");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				float nota1 = Integer.parseInt(txtnota1.getText());
				float nota2 = Integer.parseInt(txtnota2.getText());
				float nota3 = Integer.parseInt(txtnota3.getText());
				
				float promedio = (nota1+nota2+nota3)/3;
				
				txtPromedio.setText(String.valueOf(promedio));
				if(cbCondicion.getSelectedIndex() == 1) {
					txtCondicion.setText("Libre");
					return;
				}
				if(nota1 < 6 || nota2 < 6 || nota3 < 6) {
					txtCondicion.setText("Libre");
					return;
				}
				if(promedio >= 8 && cbCondicion.getSelectedIndex() == 0) {
					txtCondicion.setText("Promociona");
					return;
				}
				if(promedio <= 8 && cbCondicion.getSelectedIndex() == 0) {
					txtCondicion.setText("Regular");
					return;
				}
			}
		});
		btnCalcular.setFont(new Font("Calibri", Font.BOLD, 11));
		btnCalcular.setBounds(369, 59, 122, 44);
		contentPane.add(btnCalcular);
	}
}

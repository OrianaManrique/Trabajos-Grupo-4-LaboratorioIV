package Ejercicios;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class VentanaEjercicio3 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEjercicio3 frame = new VentanaEjercicio3();
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
	public VentanaEjercicio3() {
		setDefaultCloseOperation(VentanaEjercicio3.EXIT_ON_CLOSE);
		setBounds(250, 250, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(213, 224, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Selección múltiple");

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(27, 23, 381, 38);
		LineBorder bordeParte1 = new LineBorder(Color.BLACK);
        panel1.setBorder(bordeParte1);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		JLabel lblElegir = new JLabel("Elige un sistema operativo");
		lblElegir.setBounds(10, 11, 163, 14);
		panel1.add(lblElegir);
		lblElegir.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JRadioButton rdbtnWindows = new JRadioButton("Windows");
		rdbtnWindows.setBounds(194, 7, 71, 23);
		panel1.add(rdbtnWindows);
		rdbtnWindows.setFont(new Font("Calibri", Font.BOLD, 12));
		
		JRadioButton rdbtnMac = new JRadioButton("Mac");
		rdbtnMac.setBounds(267, 7, 48, 23);
		panel1.add(rdbtnMac);
		rdbtnMac.setFont(new Font("Calibri", Font.BOLD, 12));
		
		JRadioButton rdbtnLinux = new JRadioButton("Linux");
		rdbtnLinux.setBounds(317, 7, 58, 23);
		panel1.add(rdbtnLinux);
		rdbtnLinux.setFont(new Font("Calibri", Font.BOLD, 12));
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(27, 85, 381, 93);
		LineBorder bordeParte2 = new LineBorder(Color.BLACK);
		panel2.setBorder(bordeParte2);
		contentPane.add(panel2);
		panel2.setLayout(null);
		
		JLabel lblEspecialidad = new JLabel("Elige una especialidad");
		lblEspecialidad.setBounds(25, 37, 137, 18);
		panel2.add(lblEspecialidad);
		lblEspecialidad.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JCheckBox chckbxProgramacion = new JCheckBox("Programación");
		chckbxProgramacion.setFont(new Font("Calibri", Font.BOLD, 12));
		chckbxProgramacion.setBounds(218, 7, 108, 23);
		panel2.add(chckbxProgramacion);
		
		JCheckBox chckbxAdministracion = new JCheckBox("Administración");
		chckbxAdministracion.setFont(new Font("Calibri", Font.BOLD, 12));
		chckbxAdministracion.setBounds(218, 35, 108, 23);
		panel2.add(chckbxAdministracion);
		
		JCheckBox chckbxDiseñoGrafico = new JCheckBox("Diseño Gráfico");
		chckbxDiseñoGrafico.setFont(new Font("Calibri", Font.BOLD, 12));
		chckbxDiseñoGrafico.setBounds(218, 61, 108, 23);
		panel2.add(chckbxDiseñoGrafico);
	}
}

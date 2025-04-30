package Ejercicios;


import java.awt.Color;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;


public class VentanaEjercicio3 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField txtElijaUnSistema;

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

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtElijaUnSistema = new JTextField();
		txtElijaUnSistema.setText("Elija un sistema operativo");
		txtElijaUnSistema.setBounds(50, 39, 297, 46);
		panel.add(txtElijaUnSistema);
		txtElijaUnSistema.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Elija Un sistema Operativo");
		lblNewLabel.setBounds(68, 55, 45, 13);
		panel.add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("windows");
		rdbtnNewRadioButton.setBounds(177, 51, 65, 21);
		panel.add(rdbtnNewRadioButton);
		setTitle("Ejercicio 3");
		JRadioButton rbWindows = new JRadioButton("Windows");
		rbWindows.setBounds(30, 50, 100, 20);
		contentPane.add(rbWindows);

		JRadioButton rbLinux = new JRadioButton("Linux");
		rbLinux.setBounds(140, 50, 100, 20);
		contentPane.add(rbLinux);

		JRadioButton rbMac = new JRadioButton("Mac");
		rbMac.setBounds(250, 50, 100, 20);
		contentPane.add(rbMac);

		// aca se agrupa para que se pueden elejir uno
		ButtonGroup grupoSO = new ButtonGroup();
		grupoSO.add(rbWindows);
		grupoSO.add(rbLinux);
		grupoSO.add(rbMac);
		
		JCheckBox cbProgramacion = new JCheckBox("Programación");
		cbProgramacion.setBounds(30, 90, 120, 20);
		contentPane.add(cbProgramacion);

		JCheckBox cbDiseno = new JCheckBox("Diseño Gráfico");
		cbDiseno.setBounds(150, 90, 130, 20);
		contentPane.add(cbDiseno);

		JCheckBox cbAdministracion = new JCheckBox("Administración");
		cbAdministracion.setBounds(280, 90, 130, 20);
		contentPane.add(cbAdministracion);
		JLabel lblHoras = new JLabel("¿Cuántas horas usás la computadora?");
		lblHoras.setBounds(20, 130, 300, 20);
		contentPane.add(lblHoras);

		JTextField txtHoras = new JTextField();
		txtHoras.setBounds(30, 160, 100, 25);
		contentPane.add(txtHoras);
		JButton btnMostrar = new JButton("Mostrar datos");
		btnMostrar.setBounds(30, 200, 150, 30);
		contentPane.add(btnMostrar);
		btnMostrar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String so = "";//Cuando haces clic, se muestra todo
		        if (rbWindows.isSelected()) so = "Windows";
		        else if (rbLinux.isSelected()) so = "Linux";
		        else if (rbMac.isSelected()) so = "Mac";

		        String especialidades = "";
		        if (cbProgramacion.isSelected()) especialidades += "Programación ";
		        if (cbDiseno.isSelected()) especialidades += "Diseño Gráfico ";
		        if (cbAdministracion.isSelected()) especialidades += "Administración ";

		        String horas = txtHoras.getText();

		        String mensaje = "Sistema Operativo: " + so +
		                "\nEspecialidades: " + especialidades +
		                "\nHoras frente a la computadora: " + horas;

		        JOptionPane.showMessageDialog(null, mensaje);
		    }
		});
		

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

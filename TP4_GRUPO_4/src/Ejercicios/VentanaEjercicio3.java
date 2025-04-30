package Ejercicios;

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
		
	}
}

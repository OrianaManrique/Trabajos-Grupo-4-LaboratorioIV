package Ejercicios;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaEjercicio3 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtHoras;
	private String SOSeleccionado;

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
		setTitle("Selección multiple");

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
		rdbtnWindows.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
		 
				 if (rdbtnWindows.isSelected()) {
	                    SOSeleccionado = "Windows";
	                }
			}
		});
		rdbtnWindows.setBounds(194, 7, 71, 23);
		panel1.add(rdbtnWindows);
		rdbtnWindows.setFont(new Font("Calibri", Font.BOLD, 12));
		
		JRadioButton rdbtnMac = new JRadioButton("Mac");
		rdbtnMac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (rdbtnMac.isSelected()) {
					SOSeleccionado = "Mac";
                }
			}
		});
		rdbtnMac.setBounds(267, 7, 48, 23);
		panel1.add(rdbtnMac);
		rdbtnMac.setFont(new Font("Calibri", Font.BOLD, 12));
		
		JRadioButton rdbtnLinux = new JRadioButton("Linux");
		rdbtnLinux.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (rdbtnLinux.isSelected()) {
					SOSeleccionado = "Linux";
                }
				
			}
		});
		
		rdbtnLinux.setBounds(317, 7, 58, 23);
		panel1.add(rdbtnLinux);
		rdbtnLinux.setFont(new Font("Calibri", Font.BOLD, 12));
		
		ButtonGroup grupoSistemaOperativo = new ButtonGroup(); 
		grupoSistemaOperativo.add(rdbtnWindows);
		grupoSistemaOperativo.add(rdbtnMac);
		grupoSistemaOperativo.add(rdbtnLinux);
		
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
		
		JCheckBox chckbxDisenioGrafico = new JCheckBox("Diseño Grafico");
		chckbxDisenioGrafico.setFont(new Font("Calibri", Font.BOLD, 12));
		chckbxDisenioGrafico.setBounds(218, 61, 108, 23);
		panel2.add(chckbxDisenioGrafico);
		
		JLabel lblMensaje = new JLabel("Cantidad de horas en el computador:");
		lblMensaje.setFont(new Font("Calibri", Font.BOLD, 14));
		lblMensaje.setBounds(27, 202, 224, 18);
		contentPane.add(lblMensaje);
		
		txtHoras = new JTextField();
		txtHoras.setBounds(261, 199, 86, 20);
		contentPane.add(txtHoras);
		txtHoras.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			try {
				
				float horas = Float.parseFloat(txtHoras.getText());	
				
				if(grupoSistemaOperativo.getSelection() == null) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar una opcion de 'Sistema Operativo'", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(!chckbxProgramacion.isSelected() && !chckbxAdministracion.isSelected() && !chckbxDisenioGrafico.isSelected()) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar al menos una opcion de 'Especialidad'", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(txtHoras.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe completar el campo 'Cantidad de Horas'", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				
				if (horas <= 0) {
					
					JOptionPane.showMessageDialog(null, "Las horas deben ser mayores a 0", "Error", JOptionPane.ERROR_MESSAGE);
					txtHoras.setText("");
					return;
				}
				
				
				
				String especialidades = "";
				
				if(chckbxProgramacion.isSelected())especialidades += " - " + chckbxProgramacion.getText();
				if(chckbxAdministracion.isSelected())especialidades += " - " + chckbxAdministracion.getText();
				if(chckbxDisenioGrafico.isSelected())especialidades += " - " + chckbxDisenioGrafico.getText();
				
				String Mensaje = SOSeleccionado + especialidades + " - " + txtHoras.getText() + " Hs";
				
				JOptionPane.showMessageDialog(null, Mensaje, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
				txtHoras.setText("");
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Los datos son incorrectos", "ERROR", JOptionPane.ERROR_MESSAGE);	
				
				
			}
				
				
			}
		});
		btnAceptar.setBounds(315, 230, 89, 23);
		contentPane.add(btnAceptar);
	}
	
}

package Ejercicios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class VentanaEjercicio1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtFechaNac;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEjercicio1 frame = new VentanaEjercicio1();
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
	public VentanaEjercicio1() {
		setDefaultCloseOperation(VentanaEjercicio1.DISPOSE_ON_CLOSE);
		setBounds(150, 150, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(213, 224, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Contactos");

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Calibri", Font.BOLD, 11));
		lblNombre.setBounds(36, 59, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Calibri", Font.BOLD, 11));
		lblApellido.setBounds(36, 84, 46, 14);
		contentPane.add(lblApellido);
		
		JLabel lblTelefono = new JLabel("Teléfono");
		lblTelefono.setFont(new Font("Calibri", Font.BOLD, 11));
		lblTelefono.setBounds(36, 109, 46, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblFechaNac = new JLabel("Fecha Nac.");
		lblFechaNac.setFont(new Font("Calibri", Font.BOLD, 11));
		lblFechaNac.setBounds(36, 134, 60, 14);
		contentPane.add(lblFechaNac);
		
		JLabel lblDatosIngresados = new JLabel("Los datos ingresados fueron: ");
		lblDatosIngresados.setFont(new Font("Calibri", Font.BOLD, 11));
		lblDatosIngresados.setBounds(10, 236, 350, 14);
		lblDatosIngresados.setVisible(false);
		contentPane.add(lblDatosIngresados);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(163, 54, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(163, 79, 86, 20);
		contentPane.add(txtApellido);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(163, 104, 86, 20);
		contentPane.add(txtTelefono);
		
		txtFechaNac = new JTextField();
		txtFechaNac.setColumns(10);
		txtFechaNac.setBounds(163, 129, 86, 20);
		contentPane.add(txtFechaNac);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.setBounds(300, 88, 102, 24);
		contentPane.add(btnMostrar);
		
		btnMostrar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    		    
		    	Boolean vacio = false;

		        if(txtNombre.getText().isEmpty()) {
		        	txtNombre.setBackground(Color.RED);
		        	vacio = true;
		        }else {	        	
		        	if(!txtNombre.getText().matches("^[a-zA-Z0-9]*$")) { 
			        	
		        		txtNombre.setBackground(Color.RED);
		        		JOptionPane.showMessageDialog(null, "El nombre no puede contener símbolos", "Error", 
								JOptionPane.ERROR_MESSAGE);
		        		txtNombre.setBackground(Color.WHITE);
		        		return;
		        		
		        	}else {
		        		txtNombre.setBackground(Color.WHITE);
			        	vacio = false;
		        	}		        
		        }
		        
		        if(txtApellido.getText().isEmpty()) {
		        	txtApellido.setBackground(Color.RED);
		        	vacio = true;
		        }else {
		        	
		        	if(!txtApellido.getText().matches("^[a-zA-Z0-9]*$")) { 
			        	
		        		txtApellido.setBackground(Color.RED);
		        		JOptionPane.showMessageDialog(null, "El apellido no puede contener símbolos", "Error", 
								JOptionPane.ERROR_MESSAGE);
		        		txtApellido.setBackground(Color.WHITE);
		        		return;
		        		
		        	}else {
		        		txtApellido.setBackground(Color.WHITE);
			        	vacio = false;
		        	}	        		        
		        }
		        
		        if(txtTelefono.getText().isEmpty()) {
		        	txtTelefono.setBackground(Color.RED);
		        	vacio = true;
		        }else {
		        	if(!txtTelefono.getText().matches("[0-9]+")) {
		        	    
		        		txtTelefono.setBackground(Color.RED);
		        		JOptionPane.showMessageDialog(null, "El teléfono debe contener sólo números", "Error", 
								JOptionPane.ERROR_MESSAGE);
		        		txtTelefono.setBackground(Color.WHITE);
		        		return;
		        		
		        	}else {
		        		txtTelefono.setBackground(Color.WHITE);
			        	vacio = false;
		        	}
		        }
		        if(txtFechaNac.getText().isEmpty()) {
		        	txtFechaNac.setBackground(Color.RED);
		        	vacio = true;
		        }else {
		        
		        	txtFechaNac.setBackground(Color.WHITE);
		        	vacio = false;
		        }
		        
		        if(!vacio) {
		        	
		        	if(txtNombre.getText().matches(".*\\d.*") || txtApellido.getText().matches(".*\\d.*")) {
		        		txtNombre.setBackground(Color.RED);
		        		txtApellido.setBackground(Color.RED);
		        		JOptionPane.showMessageDialog(null, "Los campos 'Nombre' y 'Apellido' no deben contener numeros", "Error", 
		        										JOptionPane.ERROR_MESSAGE);
		        		txtNombre.setBackground(Color.WHITE);
			        	txtApellido.setBackground(Color.WHITE);
			        	return;
		        	}
		   	        
		        	lblDatosIngresados.setText("Los datos ingresados fueron: ");
		        	lblDatosIngresados.setText(lblDatosIngresados.getText() + txtNombre.getText() + ", " + txtApellido.getText()
		        								+ ", " + txtTelefono.getText() + ", " + txtFechaNac.getText());
		        	txtNombre.setText("");
		        	txtApellido.setText("");
		        	txtTelefono.setText("");
		        	txtFechaNac.setText("");
		        	lblDatosIngresados.setVisible(true);
		        	
		        	// vuelvo a poner el texbox en blanco 
		        	txtNombre.setBackground(Color.white);
		        	txtApellido.setBackground(Color.white);
		        	txtTelefono.setBackground(Color.white);
		        	txtFechaNac.setBackground(Color.white);	
		        }else {
		        	JOptionPane.showMessageDialog(null, "Debe completar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
		        	txtNombre.setBackground(Color.white);
		        	txtApellido.setBackground(Color.white);
		        	txtTelefono.setBackground(Color.white);
		        	txtFechaNac.setBackground(Color.white);	
		        }		        
		    }
		});
		
	}
}

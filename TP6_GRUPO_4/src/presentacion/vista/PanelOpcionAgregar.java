package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Entidad.Persona;
import daoImpl.PersonaDaolmpl;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelOpcionAgregar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private PersonaDaolmpl PersonaDao = new PersonaDaolmpl();

	public PanelOpcionAgregar() {
		setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNombre.setBounds(112, 62, 88, 20);
		add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblApellido.setBounds(112, 115, 88, 20);
		add(lblApellido);
		
		JLabel lblDni = new JLabel("Dni");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDni.setBounds(112, 167, 88, 20);
		add(lblDni);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
			    char ingreso = e.getKeyChar();
				
				if (!((ingreso >= 'a' && ingreso <= 'z') || (ingreso >= 'A' && ingreso <= 'Z') ||
	                    (ingreso == KeyEvent.VK_BACK_SPACE) || (ingreso == KeyEvent.VK_DELETE))) {
	                    e.consume();
	                }
				
			}
		});
		txtNombre.setBounds(250, 65, 101, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				 char ingreso = e.getKeyChar();
					
					if (!((ingreso >= 'a' && ingreso <= 'z') || (ingreso >= 'A' && ingreso <= 'Z') ||
		                    (ingreso == KeyEvent.VK_BACK_SPACE) || (ingreso == KeyEvent.VK_DELETE))) {
		                    e.consume();
		                }
			}
		});
		txtApellido.setColumns(10);
		txtApellido.setBounds(250, 118, 101, 20);
		add(txtApellido);
		txtDni = new JTextField();
		txtDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				char ingreso = e.getKeyChar();
				
				if (!Character.isDigit(ingreso)) {
					e.consume();
				}
				
			}
		});
		txtDni.setColumns(10);
		txtDni.setBounds(250, 170, 101, 20);
		add(txtDni);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			     
                if(!txtNombre.getText().matches("^[a-zA-Z0-9]*$")) { 
                
                txtNombre.setBackground(Color.RED);
                JOptionPane.showMessageDialog(null, "El nombre no puede contener s�mbolos", "Error", 
        JOptionPane.ERROR_MESSAGE);
                txtNombre.setBackground(Color.WHITE);
                return;
                
                }else {
                txtNombre.setBackground(Color.WHITE);
               
                }
                
                if(!txtApellido.getText().matches("^[a-zA-Z0-9]*$")) { 
                
                txtApellido.setBackground(Color.RED);
                JOptionPane.showMessageDialog(null, "El apellido no puede contener s�mbolos", "Error", 
        JOptionPane.ERROR_MESSAGE);
                txtApellido.setBackground(Color.WHITE);
                return;
                
                }else {
                txtApellido.setBackground(Color.WHITE);    
                }
                
                if(!txtDni.getText().matches("[0-9]+")) {
                    
                txtDni.setBackground(Color.RED);
                JOptionPane.showMessageDialog(null, "El tel�fono debe contener s�lo n�meros", "Error", 
        JOptionPane.ERROR_MESSAGE);
                txtDni.setBackground(Color.WHITE);
                return;
                
                }else {
                txtDni.setBackground(Color.WHITE);
                
                }
                
                
                if(txtNombre.getText().matches(".*\\d.*") || txtApellido.getText().matches(".*\\d.*")) {
                txtNombre.setBackground(Color.RED);
                txtApellido.setBackground(Color.RED);
                JOptionPane.showMessageDialog(null, "Los campos 'Nombre' y 'Apellido' no deben contener numeros", "Error", 
                JOptionPane.ERROR_MESSAGE);
                txtNombre.setBackground(Color.WHITE);
                txtApellido.setBackground(Color.WHITE);
                
                
                
                return;
                }
                else {
                	Persona Persona = new Persona(Integer.parseInt(txtDni.getText()), txtNombre.getText(), txtApellido.getText());
                    PersonaDao.AgregarPersona(Persona);
                }
                txtNombre.setText("");
                txtApellido.setText("");
                txtDni.setText("");
                
                // vuelvo a poner el texbox en blanco 
                txtNombre.setBackground(Color.white);
                txtApellido.setBackground(Color.white);
                txtDni.setBackground(Color.white);
               
            }
		});
		btnAceptar.setBounds(112, 232, 239, 41);
		add(btnAceptar);

	}
	
	public void setDefaultListModel(DefaultListModel<Persona> listModelRecibido)
	{
	}
}

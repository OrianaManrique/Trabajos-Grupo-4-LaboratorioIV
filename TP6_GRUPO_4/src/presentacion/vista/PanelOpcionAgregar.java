package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Entidad.Personas;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;

public class PanelOpcionAgregar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private DefaultListModel<Personas> listModel;

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
		txtNombre.setBounds(250, 65, 101, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(250, 118, 101, 20);
		add(txtApellido);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(250, 170, 101, 20);
		add(txtDni);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(112, 232, 239, 41);
		add(btnAceptar);

	}
	
	public void setDefaultListModel(DefaultListModel<Personas> listModelRecibido)
	{
		this.listModel = listModelRecibido;
	}
}

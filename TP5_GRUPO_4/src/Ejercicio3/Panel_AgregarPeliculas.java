package Ejercicio3;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;

public class Panel_AgregarPeliculas extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JLabel lblNombre;
	private JLabel lblID;
	private JLabel lblIDAutomatico;
	private JLabel lblGenero;
	private JButton btnAceptar;
	private JLabel lblTitulo;
	Pelicula pelicula;
	JComboBox<Object> cbxGenero;
	private DefaultListModel<Pelicula> listModel;
	private static int IDGLOBAL=1;
	
	
	public Panel_AgregarPeliculas() {
		setBackground(new Color(221, 255, 221));
		
		setLayout(null);
		
		lblID = new JLabel("ID");
		lblID.setBounds(94, 66, 18, 28);
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblID);
		
		lblIDAutomatico = new JLabel(Integer.toString(IDGLOBAL));
		lblIDAutomatico.setBounds(267, 67, 11, 25);
		lblIDAutomatico.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblIDAutomatico);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(94, 105, 58, 28);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(197, 112, 160, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		lblGenero = new JLabel("Genero");
		lblGenero.setBounds(94, 144, 58, 28);
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblGenero);
		
		cbxGenero = new JComboBox<Object>();
		cbxGenero.setBounds(197, 150, 160, 22);
		add(cbxGenero);
		cbxGenero.addItem("Seleccione un genero");
		cbxGenero.addItem(new Genero(1, "Terror"));
		cbxGenero.addItem(new Genero(2, "Accion"));
		cbxGenero.addItem(new Genero(3, "Suspenso"));
		cbxGenero.addItem(new Genero(4, "Romantica"));
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(94, 220, 263, 39);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtNombre.getText().isEmpty() && cbxGenero.getSelectedIndex() > 0) {
					
					pelicula = new Pelicula();
					pelicula.setNombre(txtNombre.getText());
					pelicula.setGenero((Genero) cbxGenero.getSelectedItem());
					listModel.addElement(pelicula);
					
					txtNombre.setText("");
					cbxGenero.setSelectedIndex(0);
					lblIDAutomatico.setText(Integer.toString(pelicula.siguienteID()));
					IDGLOBAL = pelicula.getID()+1;
				}
				else {
					JOptionPane.showMessageDialog(null, "Asegurese de que los campos esten completos.");
				}
			}
		});
		add(btnAceptar);		
		
		lblTitulo = new JLabel("          Agregar Películas");
		lblTitulo.setFont(lblTitulo.getFont().deriveFont(18f));
		lblTitulo.setBounds(94, 11, 263, 25);
		add(lblTitulo);
	
		
	}
	
	public void setDefaultListModel(DefaultListModel<Pelicula> listModelRecibido)
	{
		this.listModel = listModelRecibido;
	}
}

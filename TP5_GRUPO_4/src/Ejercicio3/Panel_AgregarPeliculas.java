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

public class Panel_AgregarPeliculas extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	private DefaultListModel<Pelicula> listModel;
	
	
	public Panel_AgregarPeliculas() {
		
		setLayout(null);
		
		JLabel lblID = new JLabel("ID");
		lblID.setBounds(137, 66, 18, 28);
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblID);
		
		JLabel lblNewLabel = new JLabel("1");
		lblNewLabel.setBounds(338, 67, 11, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(137, 105, 58, 28);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(288, 112, 112, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setBounds(137, 144, 58, 28);
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblGenero);
		
		JComboBox cbxGenero = new JComboBox();
		cbxGenero.setBounds(288, 150, 112, 22);
		add(cbxGenero);
		cbxGenero.addItem("Seleccione un genero");
		cbxGenero.addItem(new Genero(1, "Terror"));
		cbxGenero.addItem(new Genero(2, "Accion"));
		cbxGenero.addItem(new Genero(3, "Suspenso"));
		cbxGenero.addItem(new Genero(4, "Romantica"));
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(137, 220, 263, 39);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField.getText().isEmpty() && cbxGenero.getSelectedIndex() > 0) {
					
					Pelicula pelicula = new Pelicula();
					pelicula.setNombre(textField.getText());
					pelicula.setGenero((Genero) cbxGenero.getSelectedItem());
					listModel.addElement(pelicula);
					
					textField.setText("");
					cbxGenero.setSelectedIndex(0);
					lblNewLabel.setText(Integer.toString(pelicula.siguienteID()));
				}
				else {
					JOptionPane.showMessageDialog(null, "Asegurese de que los campos esten completos.");
				}
			}
		});
		add(btnNewButton);		
		
		JLabel lblTitulo = new JLabel("          Agregar Películas");
		lblTitulo.setFont(lblTitulo.getFont().deriveFont(18f));
		lblTitulo.setBounds(137, 11, 263, 25);
		add(lblTitulo);
	
		
	}
	
	public void setDefaultListModel(DefaultListModel<Pelicula> listModelRecibido)
	{
		this.listModel = listModelRecibido;
	}
}

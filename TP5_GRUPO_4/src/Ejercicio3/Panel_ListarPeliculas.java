package Ejercicio3;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridBagLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class Panel_ListarPeliculas extends JPanel {

	private static final long serialVersionUID = 1L;

	private JScrollPane scrollPane;
	private JList<Pelicula> jList;
	private DefaultListModel<Pelicula> listModel;
	
	
	public Panel_ListarPeliculas() {
		setLayout(null);
		
		JLabel lblListado = new JLabel("Peliculas");
		lblListado.setBounds(34, 135, 83, 29);
		lblListado.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		add(lblListado);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(127, 21, 315, 275);
		add(scrollPane);
		
		jList = new JList<Pelicula>();
		scrollPane.setViewportView(jList);
		jList.setFont(new Font("Trebuchet MS", Font.BOLD, 13));


    }
	
	public void setDefaultListModel(DefaultListModel<Pelicula> listModelRecibido)
	{
		this.listModel = listModelRecibido;
		jList.setModel(this.listModel);

	}

}

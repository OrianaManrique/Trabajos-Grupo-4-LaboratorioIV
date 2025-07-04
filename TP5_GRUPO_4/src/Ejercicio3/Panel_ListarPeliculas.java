package Ejercicio3;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.util.*;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import java.util.Collections;
import java.awt.Font;
import javax.swing.JList;
import java.awt.Color;

public class Panel_ListarPeliculas extends JPanel {

	private static final long serialVersionUID = 1L;

	private JScrollPane scrollPane;
	private JList<Pelicula> jList;
	private DefaultListModel<Pelicula> listModel;
	private JLabel lblListado;
	
	
	public Panel_ListarPeliculas() {
		setBackground(new Color(221, 255, 221));
		setLayout(null);
		
		lblListado = new JLabel("Peliculas");
		lblListado.setBounds(34, 135, 83, 29);
		lblListado.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		add(lblListado);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(127, 21, 315, 275);
		add(scrollPane);
		
		jList = new JList<Pelicula>();
		jList.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(jList);
		jList.setFont(new Font("Trebuchet MS", Font.BOLD, 13));


    }
	
	public void setDefaultListModel(DefaultListModel<Pelicula> listModelRecibido)
	{
		this.listModel = listModelRecibido;
		jList.setModel(this.listModel);
		ordenAlfabetico(listModelRecibido);

	}

	
	public void ordenAlfabetico(DefaultListModel<Pelicula> modelo) {		
		List<Pelicula> lst = Collections.list(modelo.elements());
		lst.sort(Comparator.comparing(p -> p.getNombre().toLowerCase()));
		modelo.clear();
		lst.forEach(modelo::addElement);		
	}
}

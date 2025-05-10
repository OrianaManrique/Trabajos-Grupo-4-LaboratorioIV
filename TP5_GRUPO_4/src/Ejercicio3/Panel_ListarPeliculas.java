package Ejercicio3;

import javax.swing.JPanel;
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

	
	private DefaultListModel<Pelicula> listModel;
	
	
	public Panel_ListarPeliculas() {
                setLayout(null);
        
                JLabel lblPeliculas = new JLabel("Peliculas: ");
                lblPeliculas.setBounds(63, 51, 73, 24);
                lblPeliculas.setFont(new Font("Tahoma", Font.BOLD, 14));
                add(lblPeliculas);

        JList listPeliculas = new JList();
        listPeliculas.setBounds(210, 53, 241, 227);
        listPeliculas.setModel(new AbstractListModel() {
        	String[] values = new String[] {"- Items"};
        	public int getSize() {
        		return values.length;
        	}
        	public Object getElementAt(int index) {
        		return values[index];
        	}
        });
        add(listPeliculas);


    }
	
	public void setDefaultListModel(DefaultListModel<Pelicula> listModelRecibido)
	{
		this.listModel = listModelRecibido;
	}

}

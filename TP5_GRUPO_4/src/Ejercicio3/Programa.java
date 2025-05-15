package Ejercicio3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Programa extends JFrame {//CODIGO VENTANA SOLO LO QUE CREAMOS EN VENTANA

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static DefaultListModel<Pelicula> listModel;
	private JMenu mnNewMenu;
	private JMenuBar menuBar;
	private JMenuItem mntmNewMenuItemListar;
	private JMenuItem mntmNewMenuItemAgregar;
	
	
	public Programa() {
		setTitle("Programa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 397);
 	
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.setBounds(0, 0, 434, 22);
		
		mnNewMenu = new JMenu("Peliculas");
		menuBar.add(mnNewMenu);
		
		
		mntmNewMenuItemAgregar = new JMenuItem("Agregar");
		mntmNewMenuItemAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane.removeAll();
				Panel_AgregarPeliculas Panel = new Panel_AgregarPeliculas();
				Panel.setDefaultListModel(listModel);
				contentPane.add(Panel);
				contentPane.repaint();
				contentPane.revalidate();
				
			}
		});
		mnNewMenu.add(mntmNewMenuItemAgregar);
		
		mntmNewMenuItemListar= new JMenuItem("Listar");
		mntmNewMenuItemListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane.removeAll();
				Panel_ListarPeliculas Panel = new Panel_ListarPeliculas();
				Panel.setDefaultListModel(listModel);
				contentPane.add(Panel);
				contentPane.repaint();
				contentPane.revalidate();
				
			}
		});
		
		mnNewMenu.add(mntmNewMenuItemListar);
		
	}
}

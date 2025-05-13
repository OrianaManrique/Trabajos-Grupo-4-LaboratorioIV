package Ejercicio3;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Programa extends JFrame {//CODIGO VENTANA SOLO LO QUE CREAMOS EN VENTANA

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static DefaultListModel<Pelicula> listModel;
	
	
	
	public Programa() {
		setTitle("Programa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 397);
 	
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.setBounds(0, 0, 434, 22);
		
		JMenu mnNewMenu = new JMenu("Peliculas");
		menuBar.add(mnNewMenu);
		
		
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Agregar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane.removeAll();
				Panel_AgregarPeliculas Panel = new Panel_AgregarPeliculas();
				Panel.setDefaultListModel(listModel);
				contentPane.add(Panel);
				contentPane.repaint();
				contentPane.revalidate();
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Listar");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane.removeAll();
				Panel_ListarPeliculas Panel = new Panel_ListarPeliculas();
				Panel.setDefaultListModel(listModel);
				contentPane.add(Panel);
				contentPane.repaint();
				contentPane.revalidate();
				
			}
		});
		
		mnNewMenu.add(mntmNewMenuItem_1);
		
	}
}

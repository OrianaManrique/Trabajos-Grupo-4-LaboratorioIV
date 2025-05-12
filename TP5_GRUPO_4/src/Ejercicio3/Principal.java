package Ejercicio3;

import java.awt.BorderLayout;
import java.awt.EventQueue;
//codigo para programar mas facil
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Principal extends JFrame {

	private JPanel contentPane;
	private static DefaultListModel<Pelicula> listModel;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					listModel = new DefaultListModel<Pelicula>();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Principal() {

		setTitle("Programa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 397);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.setBounds(0, 0, 434, 22);
		
		JMenu mnNewMenu = new JMenu("Peliculas");
		mnNewMenu.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItemAgregarPeliculas = new JMenuItem("Agregar");
		menuItemAgregarPeliculas.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		
		menuItemAgregarPeliculas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane.removeAll();
				Panel_AgregarPeliculas panel = new Panel_AgregarPeliculas();
				panel.setDefaultListModel(listModel);
				contentPane.add(panel);
				contentPane.repaint();
				contentPane.revalidate();
				
			}
		});
		mnNewMenu.add(menuItemAgregarPeliculas);
		
		JMenuItem menuItemListadoPeliculas = new JMenuItem("Listado");
		menuItemListadoPeliculas.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		
		menuItemListadoPeliculas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane.removeAll();
				Panel_ListarPeliculas panel = new Panel_ListarPeliculas();
				panel.setDefaultListModel(listModel);
				contentPane.add(panel);
				contentPane.repaint();
				contentPane.revalidate();
				
			}
		});
		mnNewMenu.add(menuItemListadoPeliculas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}

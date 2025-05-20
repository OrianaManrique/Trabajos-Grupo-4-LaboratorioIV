package main;
import java.awt.BorderLayout;
import java.awt.EventQueue;
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

import Entidad.Personas;
import presentacion.vista.PanelOpcionAgregar;
import presentacion.vista.PanelOpcionModificar;


public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static DefaultListModel<Personas> listModel;

	
	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Principal frame = new Principal();
                    listModel = new DefaultListModel<Personas>();
                    frame.setVisible(true);
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
		
		JMenu mnNewMenu = new JMenu("Persona");
		mnNewMenu.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		menuBar.add(mnNewMenu);
		
		//Boton Agregar
		JMenuItem menuItemAgregar = new JMenuItem("Agregar");
		menuItemAgregar.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		
		menuItemAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane.removeAll();
				PanelOpcionAgregar panel = new PanelOpcionAgregar();
				panel.setDefaultListModel(listModel);
				contentPane.add(panel);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		mnNewMenu.add(menuItemAgregar);
		
		//Boton Modificar
		JMenuItem menuItemModificar = new JMenuItem("Modificar");
		menuItemModificar.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		
		menuItemModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
                PanelOpcionModificar panel = new PanelOpcionModificar();
                panel.setDefaultListModel(listModel);
                contentPane.add(panel);
                contentPane.repaint();
                contentPane.revalidate();
			}
		});
		mnNewMenu.add(menuItemModificar);
		
		//Boton Eliminar
		JMenuItem menuItemEliminar = new JMenuItem("Eliminar");
		menuItemEliminar.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		
		menuItemEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnNewMenu.add(menuItemEliminar);
		
		//Boton Listar
		JMenuItem menuItemListar = new JMenuItem("Listar");
		menuItemListar.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		
		menuItemListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnNewMenu.add(menuItemListar);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}

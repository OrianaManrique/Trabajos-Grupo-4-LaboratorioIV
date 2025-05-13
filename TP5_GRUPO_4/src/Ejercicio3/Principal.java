package Ejercicio3;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		contentPane.setBackground(new Color(221, 255, 221));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("               GRUPO 4");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
        contentPane.add(lblNewLabel, BorderLayout.NORTH);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(221, 255, 221));
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);
        
        JLabel lblIntegrantes = new JLabel("Integrantes del grupo:");
        lblIntegrantes.setFont(new Font("Calibri", Font.BOLD, 16));
        lblIntegrantes.setBounds(149, 88, 160, 26);
        panel.add(lblIntegrantes);
        
        JLabel lblTP = new JLabel("TP 5 - Aplicaciones de Escritorio");
        lblTP.setFont(new Font("Calibri", Font.BOLD, 18));
        lblTP.setBounds(108, 38, 246, 26);
        panel.add(lblTP);
        
        JLabel lblIntegrante1 = new JLabel("Arellano Nahuel Ivan");
        lblIntegrante1.setBounds(173, 135, 170, 14);
        panel.add(lblIntegrante1);
        
        JLabel lblIntegrante2 = new JLabel("Cejas Leonel");
        lblIntegrante2.setBounds(193, 160, 126, 14);
        panel.add(lblIntegrante2);
        
        JLabel lblIntegrante3 = new JLabel("Franco Braian Exequiel");
        lblIntegrante3.setBounds(173, 185, 181, 14);
        panel.add(lblIntegrante3);
        
        JLabel lblIntegrante4 = new JLabel("Manrique Oriana Belen");
        lblIntegrante4.setBounds(173, 210, 195, 14);
        panel.add(lblIntegrante4);
        
        JLabel lblIntegrante5 = new JLabel("De Rui Sartor Fabrizio Alejandro");
        lblIntegrante5.setBounds(149, 235, 205, 14);
        panel.add(lblIntegrante5);
        
       
		
		
	}
}

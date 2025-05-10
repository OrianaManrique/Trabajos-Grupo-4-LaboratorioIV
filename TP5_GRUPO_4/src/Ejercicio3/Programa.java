package Ejercicio3;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

public class Programa extends JFrame {//CODIGO VENTANA SOLO LO QUE CREAMOS EN VENTANA

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static DefaultListModel<Pelicula> listModel;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	
	public Programa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 396);
		contentPane = new JPanel();
		//contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
 	
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

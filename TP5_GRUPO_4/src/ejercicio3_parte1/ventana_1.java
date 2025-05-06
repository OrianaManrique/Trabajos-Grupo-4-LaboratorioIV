package ejercicio3_parte1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JComboBox;

public class ventana_1 extends JFrame {//CODIGO VENTANA SOLO LO QUE CREAMOS EN VENTANA

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * @wbp.nonvisual location=24,24
	 */
	private final JComboBox comboBox = new JComboBox();

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ventana_1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
       
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}

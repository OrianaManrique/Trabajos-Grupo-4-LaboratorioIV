package Ejercicios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class VentanaEjercicio2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEjercicio2 frame = new VentanaEjercicio2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaEjercicio2() {
		setDefaultCloseOperation(VentanaEjercicio2.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Promedio");

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNotas = new JLabel("Notas del estudiante");
		lblNotas.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNotas.setBounds(35, 26, 123, 14);
		contentPane.add(lblNotas);
		
		JLabel lblNota1 = new JLabel("Nota 1:");
		lblNota1.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNota1.setBounds(35, 51, 46, 14);
		contentPane.add(lblNota1);
		
		JLabel lblNota2 = new JLabel("Nota 2:");
		lblNota2.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNota2.setBounds(35, 76, 46, 14);
		contentPane.add(lblNota2);
		
		JLabel lblNota3 = new JLabel("Nota 3:");
		lblNota3.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNota3.setBounds(35, 101, 46, 14);
		contentPane.add(lblNota3);
		
		JLabel lblTPS = new JLabel("TPS");
		lblTPS.setFont(new Font("Calibri", Font.BOLD, 14));
		lblTPS.setBounds(35, 126, 46, 14);
		contentPane.add(lblTPS);
		
		JComboBox cbCondicion = new JComboBox();
		cbCondicion.setModel(new DefaultComboBoxModel(new String[] {"Libre", "Promociona", "Regular"}));
		cbCondicion.setFont(new Font("Calibri", Font.BOLD, 14));
		cbCondicion.setBounds(137, 122, 115, 22);
		contentPane.add(cbCondicion);
		
		textField = new JTextField();
		textField.setBounds(137, 96, 115, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(137, 71, 115, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(137, 46, 115, 20);
		contentPane.add(textField_2);
	}
}

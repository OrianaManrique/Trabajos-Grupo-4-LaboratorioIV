package Ejercicio3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class agregarpelis extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					agregarpelis frame = new agregarpelis();
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
	public agregarpelis() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 503);
		contentPane = new JPanel();
         
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("id");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNewLabel.setBounds(55, 65, 95, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNombre.setBounds(55, 128, 95, 33);
		contentPane.add(lblNombre);
		
		JLabel lblGenero = new JLabel("GENERO");
		lblGenero.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblGenero.setBounds(55, 185, 95, 33);
		contentPane.add(lblGenero);
		
		textField = new JTextField();
		textField.setBounds(195, 130, 166, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("1");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNewLabel_1.setBounds(304, 65, 95, 33);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("ACEPTAR");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(217, 276, 130, 33);
		contentPane.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(194, 193, 167, 21);
		contentPane.add(comboBox);
	   
	}
}

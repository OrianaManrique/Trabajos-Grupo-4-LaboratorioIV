package presentacion.vista;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Entidad.Personas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

public class PanelOpcionEliminar extends JPanel {
	private JScrollPane scrollPanelPersonas;
	private JList<Personas> jListPersonas;
	
	public PanelOpcionEliminar() {
		setLayout(null);
        
        
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(137, 256, 102, 33);
        add(btnEliminar);
        
        JLabel lblEliminar = new JLabel("Eliminar usuarios");
        lblEliminar.setBounds(149, 20, 79, 14);
        add(lblEliminar);
        
        scrollPanelPersonas = new JScrollPane();
        scrollPanelPersonas.setBounds(59, 45, 260, 200);
        add(scrollPanelPersonas);
        
        jListPersonas = new JList<Personas>();
        jListPersonas.setBackground(new Color(255, 255, 255));
        scrollPanelPersonas.setViewportView(jListPersonas);
        jListPersonas.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
	}
}

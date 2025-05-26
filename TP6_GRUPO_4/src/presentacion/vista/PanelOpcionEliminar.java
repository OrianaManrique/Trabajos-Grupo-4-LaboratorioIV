package presentacion.vista;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import Entidad.Persona;

public class PanelOpcionEliminar extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultListModel<Persona> listModel;
    private JList<Persona> jListPersonas;
    private JScrollPane scrollPanelPersonas;
    private JButton btnEliminar;

    public PanelOpcionEliminar() {
        setLayout(null);
        
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(177, 251, 102, 33);
        add(btnEliminar);

        // configuracion de scrol y la lista
        scrollPanelPersonas = new JScrollPane();
        scrollPanelPersonas.setBounds(30, 60, 391, 180);
        add(scrollPanelPersonas);
        
        jListPersonas = new JList<>();
        scrollPanelPersonas.setViewportView(jListPersonas);
        jListPersonas.setBackground(Color.WHITE);
        jListPersonas.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
        
        daoImpl.PersonaDaolmpl dao = new daoImpl.PersonaDaolmpl();
        List<Persona> lPersonas = dao.ListarPersonas();
        listModel = new DefaultListModel<>();
        jListPersonas.setModel(listModel);
        
        for(Persona persona : lPersonas) {
        	listModel.addElement(persona);
        }

        //aregada lista opcion de ver personas 
        jListPersonas.addListSelectionListener(e -> {
            //accion fuera de persona
        });
        
        btnEliminar.addActionListener(e -> {
        	Persona personaSeleccionada = jListPersonas.getSelectedValue();
        	if (personaSeleccionada == null) {
        		JOptionPane.showMessageDialog(null, "Seleccione una persona para eliminar.");
        		return;
        	}
        	
        	int confirmacion = JOptionPane.showConfirmDialog(null, "�Esta seguro de eliminar?", "Confirmar", JOptionPane.YES_NO_OPTION);
        	
        	if (confirmacion == JOptionPane.YES_OPTION) {
        		//negocioImpl.PersonaNegocioImpl neg = new negocioImpl.PersonaNegocioImpl();
        		if (dao.EliminarPersona(personaSeleccionada)) {
        			listModel.removeElement(personaSeleccionada);
        			JOptionPane.showMessageDialog(null, "Persona eliminada correctamente.");
        		} else {
        			JOptionPane.showMessageDialog(null, "Error al eliminar.");
        		}
        	}
        });
    }

    // Fuera del constructor, al mismo nivel
    public void setDefaultListModel(DefaultListModel<Persona> modelo) {
        this.listModel = modelo;
        jListPersonas.setModel(this.listModel);
    }
}
package presentacion.vista;

import javax.swing.*;
import java.awt.*;
import Entidad.Persona;
import javax.swing.event.*;

public class PanelOpcionEliminar extends JPanel {
    private DefaultListModel<Persona> listModel;
    private JList<Persona> jListPersonas;
    private JScrollPane scrollPanelPersonas;
    private JButton btnEliminar;

    public PanelOpcionEliminar() {
        setLayout(null);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(137, 256, 102, 33);
        add(btnEliminar);

        btnEliminar.addActionListener(e -> {
            Persona personaSeleccionada = jListPersonas.getSelectedValue();
            if (personaSeleccionada == null) {
                JOptionPane.showMessageDialog(null, "Seleccione una persona para eliminar.");
                return;
            }

            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar?", "Confirmar", JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                daoImpl.PersonaDaolmpl dao = new daoImpl.PersonaDaolmpl();
                if (dao.borrar(String.valueOf(personaSeleccionada.getDni()))) {
                    listModel.removeElement(personaSeleccionada);
                    JOptionPane.showMessageDialog(null, "Persona eliminada correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar.");
                }
            }
        });

        // configuracion de scrol y la lista
        scrollPanelPersonas = new JScrollPane();
        scrollPanelPersonas.setBounds(30, 60, 420, 180);
        add(scrollPanelPersonas);

        jListPersonas = new JList<>();
        jListPersonas.setBackground(Color.WHITE);
        scrollPanelPersonas.setViewportView(jListPersonas);
        jListPersonas.setFont(new Font("Trebuchet MS", Font.BOLD, 13));

        //aregada lista opcion de ver personas 
        jListPersonas.addListSelectionListener(e -> {
            //accion fuera de persona
        });
    }

    // Fuera del constructor, al mismo nivel
    public void setDefaultListModel(DefaultListModel<Persona> modelo) {
        this.listModel = modelo;
        jListPersonas.setModel(this.listModel);
    }
}
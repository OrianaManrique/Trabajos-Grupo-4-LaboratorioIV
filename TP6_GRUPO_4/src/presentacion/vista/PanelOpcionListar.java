package presentacion.vista;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Entidad.Persona;
import daoImpl.PersonaDaolmpl;

public class PanelOpcionListar extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTable tablaPersonas;
    private JScrollPane scrollPane;


    public PanelOpcionListar() {

        tablaPersonas = new JTable();
        tablaPersonas.setBounds(10, 11, 430, 278);
        add(tablaPersonas);
        scrollPane = new JScrollPane(tablaPersonas);
        add(scrollPane , BorderLayout.CENTER);


        String[] Columnas = {"Dni", "Nombre", "Apellido"};

        DefaultTableModel modelo = new DefaultTableModel(null, Columnas);

        tablaPersonas.setEnabled(false);
        tablaPersonas.setModel(modelo);
        tablaPersonas.getTableHeader().setReorderingAllowed(false);

        ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
        listaPersonas = PersonaDaolmpl.ObtenerListaPersonas();

         for (Persona persona : listaPersonas) {
                Object[] fila = new Object[3];
                fila[0] = persona.getDni();
                fila[1] = persona.getNombre();
                fila[2] = persona.getApellido();
                modelo.addRow(fila);
            }
    }

    public void setDefaultListModel(DefaultListModel<Persona> listModelRecibido)
    {
    }
}
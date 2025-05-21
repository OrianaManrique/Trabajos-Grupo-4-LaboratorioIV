package presentacion.vista;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import Entidad.Persona;
import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class PanelOpcionModificar extends JPanel {

	private static final long serialVersionUID = 1L;

		private DefaultListModel<Persona> listModel;
	    private JList<Persona> jListPersonas;
	    private JTextField txtNombre;
	    private JTextField txtApellido;
	    private JTextField txtDni;
	    private JScrollPane scrollPanelPersonas;
	    private JList list;

	    public PanelOpcionModificar() {
	        setLayout(null);

	        txtNombre = new JTextField();
	        txtNombre.setBounds(31, 288, 86, 20);
	        add(txtNombre);
	        txtNombre.setColumns(10);

	        txtApellido = new JTextField();
	        txtApellido.setBounds(140, 288, 86, 20);
	        txtApellido.setColumns(10);
	        add(txtApellido);

	        txtDni = new JTextField();
	        txtDni.setBounds(254, 288, 86, 20);
	        txtDni.setColumns(10);
	        add(txtDni);

	        JButton btnModificar = new JButton("Modificar");
	        btnModificar.setBounds(360, 287, 89, 23);
	        add(btnModificar);

	        JLabel lblSeleccione = new JLabel("Seleccione a la persona que desea modificar");
	        lblSeleccione.setBounds(31, 21, 482, 14);
	        add(lblSeleccione);

	        scrollPanelPersonas = new JScrollPane();
	        scrollPanelPersonas.setBounds(30, 60, 420, 200);
	        add(scrollPanelPersonas);

	        jListPersonas = new JList<Persona>();
	        jListPersonas.setBackground(new Color(255, 255, 255));
	        scrollPanelPersonas.setViewportView(jListPersonas);
	        jListPersonas.setFont(new Font("Trebuchet MS", Font.BOLD, 13));

	    }

	    public void setDefaultListModel(DefaultListModel<Persona> listModelRecibido)
	    {
	        this.listModel = listModelRecibido;
	        jListPersonas.setModel(this.listModel);
	    }
	}

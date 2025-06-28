package presentacion.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Cliente;
import entidad.Localidad;
import entidad.Provincia;
import negocio.ClienteNeg;
import negocio.LocalidadNeg;
import negocioImpl.ClienteNegImpl;
import negocioImpl.LocalidadNegImpl;
import negocio.ProvinciaNeg;
import negocioImpl.ProvinciaNegImpl;

@WebServlet("/ServletModificarClientes")
public class ServletModificarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Boolean estado;
	ClienteNeg negCli = new ClienteNegImpl();
	ProvinciaNeg negprov = new ProvinciaNegImpl();
	LocalidadNeg negloc = new LocalidadNegImpl();
	Cliente cliente = new Cliente();

	public ServletModificarCliente() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("Param2") != null && request.getParameter("Param") != null) {

			String operacion = request.getParameter("Param").toString();

			switch (operacion) {
			case "CargarModificarCliente": {
               
				int dniCliente = Integer.parseInt(request.getParameter("Param2"));
				request.setAttribute("DniClienteEditar", dniCliente);
				request.setAttribute("Cliente", negCli.obtenerCliente(dniCliente));
				request.setAttribute("listaLocalidades", negloc.listarLocalidades());
				request.setAttribute("listaProvincias", negprov.listarProvincias());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ModificarCliente.jsp");
				dispatcher.forward(request, response);
				break;
			}
			default:
				break;
			}

			return;

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        
		if (request.getParameter("btnModificar") != null) {
			
			
			Cliente cliente = new Cliente();
			Localidad localidad = new Localidad();
			Provincia provincia = new Provincia();

			cliente.setDni_cliente(Integer.parseInt(request.getParameter("txtDniCliente")));
			cliente.setNombre_cliente(request.getParameter("txtNombre"));
			cliente.setApellido_cliente(request.getParameter("txtApellido"));
			cliente.setCuil_cliente(Integer.parseInt(request.getParameter("txtCuil")));
			cliente.setSexo_cliente(request.getParameter("tiposexo"));
			provincia.setId_provincia(Integer.parseInt(request.getParameter("txtProvincia")));
			localidad.setId_localidad(Integer.parseInt(request.getParameter("txtLocalidad")));
			String fecha = request.getParameter("txtFechaNacimiento");
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			formato.setLenient(false);
			Date fechanacimiento = null;

			try {
				fechanacimiento = new Date(formato.parse(fecha).getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}

			cliente.setFecha_nacimiento_cliente(fechanacimiento);
			cliente.setProvincia(provincia);
			cliente.setLocalidad(localidad);
			cliente.setNacionalidad_cliente(request.getParameter("txtNacionalidad"));
			cliente.setFecha_nacimiento_cliente(fechanacimiento);
			cliente.setCorreo_electronico_cliente(request.getParameter("txtCorreo"));
			cliente.setDireccion_cliente(request.getParameter("txtDireccion"));
			cliente.setTelefono_cliente(request.getParameter("txtTelefono"));

			request.setAttribute("Exito", negCli.editar(cliente));
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("/InicioAdministrador.jsp");
			requestdispatcher.forward(request, response);
			return;

		}
				
		
	}

}

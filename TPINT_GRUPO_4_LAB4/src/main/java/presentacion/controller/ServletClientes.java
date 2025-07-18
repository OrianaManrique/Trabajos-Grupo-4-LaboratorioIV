package presentacion.controller;

import javax.servlet.http.HttpSession;
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
import entidad.Cuenta;
import entidad.Localidad;
import entidad.Provincia;
import entidad.TipoCuenta;
import negocio.ClienteNeg;
import negocio.LocalidadNeg;
import negocioImpl.ClienteNegImpl;
import negocioImpl.LocalidadNegImpl;
import negocio.ProvinciaNeg;
import negocioImpl.ProvinciaNegImpl;

@WebServlet("/ServletClientes")
public class ServletClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Boolean estado;
	ClienteNeg negCli = new ClienteNegImpl();
	ProvinciaNeg negprov = new ProvinciaNegImpl();
	LocalidadNeg negloc = new LocalidadNegImpl();

	public ServletClientes() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("Param") != null && request.getParameter("Param2") == null) {

			String operacion = request.getParameter("Param").toString();

			switch (operacion) {
			case "CargarAgregarCliente": {

				request.setAttribute("listaLocalidades", negloc.listarLocalidades());
				request.setAttribute("listaProvincias", negprov.listarProvincias());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/AgregarCliente.jsp");
				dispatcher.forward(request, response);
				break;
			}
			case "ListarClientes": {
				// Cargo el form
				request.setAttribute("Lista", negCli.obtenerClientes());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarCliente.jsp");
				dispatcher.forward(request, response);
				break;
			}
			case "ListarEliminarCliente": {
				// Cargo el form
				request.setAttribute("Lista", negCli.obtenerClientes());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/EliminarCliente.jsp");
				dispatcher.forward(request, response);
				break;
			}
			default:
				break;
			}

			return;

		}

		if (request.getParameter("Param") != null && request.getParameter("Param2") != null) {

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
			case "EliminarCliente": {

				boolean estado = negCli.borrar(Integer.parseInt(request.getParameter("Param2")));

				request.setAttribute("Exito", estado);
				request.setAttribute("Lista", negCli.obtenerClientes());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/EliminarCliente.jsp");
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

		if (request.getParameter("Param") != null) {

			String operacion = request.getParameter("Param").toString();

			switch (operacion) {
			case "CargarUsuario": {

				Cliente cliente = new Cliente();
				Localidad localidad = new Localidad();
				Provincia provincia = new Provincia();

				cliente.setDni_cliente(Integer.parseInt(request.getParameter("txtDniCliente")));
				cliente.setNombre_cliente(request.getParameter("txtNombre"));
				cliente.setApellido_cliente(request.getParameter("txtApellido"));
				cliente.setCuil_cliente((request.getParameter("txtCuil")));
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

				HttpSession session = request.getSession();
				session.setAttribute("ClienteparaAgregar", cliente);

				request.setAttribute("Dni", request.getParameter("txtDniCliente"));
				RequestDispatcher requestdispatcher = request.getRequestDispatcher("/ConfirmarUsuario.jsp");
				requestdispatcher.forward(request, response);
				break;
			}
			case "BuscarClienteModificar":{
				
				request.setAttribute("Cliente", negCli.obtenerCliente(Integer.parseInt(request.getParameter("txtBusquedaModificarCliente"))));
				request.setAttribute("DniBusquedaModificarCliente", (Integer.parseInt(request.getParameter("txtBusquedaModificarCliente"))));
				request.setAttribute("listaProvincias", negprov.listarProvincias());
				request.setAttribute("listaLocalidades", negloc.listarLocalidades());
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ModificarCliente.jsp");
				dispatcher.forward(request, response);
				break;
				
			}
			case "GuardarModificacionCliente": {

				Cliente cliente = new Cliente();
				Localidad localidad = new Localidad();
				Provincia provincia = new Provincia();
				
				
				System.out.println(request.getParameter("DniBusquedaModificarCliente"));            
				System.out.println(request.getParameter("txtNombre"));
				System.out.println(request.getParameter("txtApellido"));
				System.out.println(request.getParameter("ddlSexo"));
				System.out.println(request.getParameter("ddlProvincia"));
				System.out.println(request.getParameter("ddlLocalidad"));
				System.out.println(request.getParameter("txtNacimiento"));
				System.out.println(request.getParameter("txtNacionalidad"));
				System.out.println(request.getParameter("txtCorreo"));
				System.out.println(request.getParameter("txtDireccion"));
				System.out.println(request.getParameter("txtTelefono"));
				System.out.println(request.getParameter("txtcontra"));

				cliente.setNombre_cliente(request.getParameter("txtNombre"));
				cliente.setApellido_cliente(request.getParameter("txtApellido"));
				cliente.setSexo_cliente(request.getParameter("ddlSexo"));
				provincia.setId_provincia(Integer.parseInt(request.getParameter("ddlProvincia")));
				localidad.setId_localidad(Integer.parseInt(request.getParameter("ddlLocalidad")));
				cliente.setProvincia(provincia);
				cliente.setLocalidad(localidad);
				String fecha = request.getParameter("txtNacimiento");
				SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
				formato.setLenient(false);
				Date fechanacimiento = null;

				try {
					fechanacimiento = new Date(formato.parse(fecha).getTime());
				} catch (ParseException e) {
					e.printStackTrace();
				}
                
				cliente.setFecha_nacimiento_cliente(fechanacimiento);
				cliente.setNacionalidad_cliente(request.getParameter("txtNacionalidad"));
				cliente.setCorreo_electronico_cliente(request.getParameter("txtCorreo"));
				cliente.setDireccion_cliente(request.getParameter("txtDireccion"));
				cliente.setTelefono_cliente(request.getParameter("txtTelefono"));
				cliente.setContraseña_cliente(request.getParameter("txtContra"));		
				
				System.out.println(cliente.toString());

				request.setAttribute("Exito", negCli.editar(cliente));
				request.setAttribute("Cliente", negCli.obtenerCliente(Integer.parseInt(request.getParameter("DniBusquedaModificarCliente"))));
				request.setAttribute("DniBusquedaModificarCliente", (Integer.parseInt(request.getParameter("DniBusquedaModificarCliente"))));
				request.setAttribute("listaProvincias", negprov.listarProvincias());
				request.setAttribute("listaLocalidades", negloc.listarLocalidades());
				
				RequestDispatcher requestdispatcher = request.getRequestDispatcher("/ModificarCliente.jsp");
				requestdispatcher.forward(request, response);
				break;
			}
			case "ConfirmarClienteyUsuario": {

				boolean estado = false;
				HttpSession session = request.getSession(false);
				Cliente cliente = (Cliente) session.getAttribute("ClienteparaAgregar");
				cliente.setUsuario_cliente(request.getParameter("txtUsuarioCliente"));
				cliente.setContraseña_cliente(request.getParameter("txtContra"));
				estado = negCli.insertar(cliente);

				request.setAttribute("Exito", estado);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ConfirmarUsuario.jsp");
				dispatcher.forward(request, response);
				break;
			}

			default:
				break;
			}

		}

		if (request.getParameter("btnEliminar") != null) {

			request.setAttribute("Exito", negCli.borrar((Integer.parseInt(request.getParameter("dni")))));
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("/EliminarCliente.jsp");
			requestdispatcher.forward(request, response);
			return;

		}

		if (request.getParameter("btnModificar") != null) {



		}

	}

}
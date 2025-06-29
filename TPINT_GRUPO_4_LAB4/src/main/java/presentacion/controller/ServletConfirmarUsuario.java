package presentacion.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidad.Cliente;
import negocio.ClienteNeg;
import negocio.LocalidadNeg;
import negocio.ProvinciaNeg;
import negocioImpl.ClienteNegImpl;
import negocioImpl.LocalidadNegImpl;
import negocioImpl.ProvinciaNegImpl;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletConfirmarUsuario
 */
@WebServlet("/ServletConfirmarUsuario")
public class ServletConfirmarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Boolean estado;
	ClienteNeg negCli = new ClienteNegImpl();
	ProvinciaNeg negprov = new ProvinciaNegImpl();
	LocalidadNeg negloc = new LocalidadNegImpl();

	public ServletConfirmarUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (request.getParameter("Param") != null) {

			String operacion = request.getParameter("Param").toString();

			switch (operacion) {
			case "ConfirmarCliente": {			
				
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

			return;

		}
		
		
	}

}

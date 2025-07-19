package presentacion.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import entidad.Usuario;
import negocio.UsuarioNeg;
import negocioImpl.UsuarioNegImpl;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (request.getParameter("Param") != null) {
			
			UsuarioNeg usuarioNeg = new UsuarioNegImpl();
			Usuario usuario_logueado;
			
			String usuario = request.getParameter("usuario");
			String clave = request.getParameter("clave");
			
			usuario_logueado = usuarioNeg.obtenerUsuario(usuario, clave);

			request.getSession().setAttribute("usuarioLogueado", usuario_logueado);
			
			if (usuario_logueado.getTipo_us().equals("A")){
			RequestDispatcher rd = request.getRequestDispatcher("/InicioAdministrador.jsp");
			rd.forward(request, response);
			} else {
			RequestDispatcher rd = request.getRequestDispatcher("/CuentaCliente.jsp");
			rd.forward(request, response);
			}
		}
	}
}
package presentacion.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String ADMIN_DNI = "12345678";
	private static final String ADMIN_CLAVE = "admin123";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		if (request.getParameter("Param") != null) {
			String dni = request.getParameter("usuario");
			String clave = request.getParameter("clave");

			if (dni != null && clave != null && dni.equals(ADMIN_DNI) && clave.equals(ADMIN_CLAVE)) {
				HttpSession session = request.getSession();
				session.setAttribute("usuarioLogueado", dni);
				RequestDispatcher rd = request.getRequestDispatcher("/InicioAdministrador.jsp");
				rd.forward(request, response);
			
			} else {
				request.setAttribute("error", "DNI o contraseña incorrectos");
				RequestDispatcher rd = request.getRequestDispatcher("/InicioLogin.jsp");
				rd.forward(request, response);
			}
		}
		
		return;

	

	}
}
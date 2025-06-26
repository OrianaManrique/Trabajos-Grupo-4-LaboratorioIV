package presentacion.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/InicioLogin.jsp")
public class ServletLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

   
    private static final String ADMIN_DNI = "12345678";
    private static final String ADMIN_CLAVE = "admin123";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        procesarLogin(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
    	if (request.getParameter("Param") != null) {

			String operacion = request.getParameter("Param").toString();

			switch (operacion) {
			case "CargarUsuario": {
				// Cargo el formulario
				
				

				RequestDispatcher requestdispatcher = request.getRequestDispatcher("ConfirmarUsuario.jsp");
				requestdispatcher.forward(request, response);
				break;
			}
			case "ListarClientes": {
				
				break;
			}
			default:
				break;
			}

			RequestDispatcher rdrequestdispatcher = request.getRequestDispatcher("AgregarCliente.jsp");
			rdrequestdispatcher.forward(request, response);

		}

    }

    private void procesarLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dni = request.getParameter("dni");
        String clave = request.getParameter("password");

        if (dni != null && clave != null && dni.equals(ADMIN_DNI) && clave.equals(ADMIN_CLAVE)) {
            HttpSession session = request.getSession();
            session.setAttribute("usuarioLogueado", dni); 
            response.sendRedirect("InicioAdministrador.jsp"); 
        } else {
            request.setAttribute("error", "DNI o contraseña incorrectos");
            RequestDispatcher rd = request.getRequestDispatcher("InicioLogin.jsp");
            rd.forward(request, response);
        }
    }
}
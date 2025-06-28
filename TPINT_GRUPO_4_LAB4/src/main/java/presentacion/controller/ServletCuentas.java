package presentacion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.CuentaNeg;
import negocioImpl.CuentaNegImpl;

@WebServlet("/ServletCuentas")
public class ServletCuentas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CuentaNeg negCuenta = new CuentaNegImpl();
    
    public ServletCuentas() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("Param") != null) {

			String operacion = request.getParameter("Param").toString();

			switch (operacion) {
			case "Listar": {
				// Cargo el form

				request.setAttribute("Lista", negCuenta.obtenerCuentas());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarCuenta.jsp");
				dispatcher.forward(request, response);
				break;
			}
			
			default:
				break;
			}

			RequestDispatcher rd = request.getRequestDispatcher("/ListarCuenta.jsp");
			rd.forward(request, response);
			return;
		}
	}
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("btnEliminarCuenta") != null) {

			request.setAttribute("Exito", negCuenta.borrar(request.getParameter("NumeroDeCuenta")));
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("/EliminarCuenta.jsp");
			requestdispatcher.forward(request, response);
			return;

		}
	}

}

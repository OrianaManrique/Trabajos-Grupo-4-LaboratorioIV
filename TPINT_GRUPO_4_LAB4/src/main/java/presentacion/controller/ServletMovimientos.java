package presentacion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletMovimientos")
public class ServletMovimientos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("Param") != null) {

			String operacion = request.getParameter("Param").toString();

			switch (operacion) {
			case "CalcularPrestamo": {		
				
				float interes = 0;
				float total = 0;
				float ValorCuotas = 0;
				float Total=0;
				float Cuota1=0;
				float Cuota3=0;
				float Cuota6=0;
				float Cuota9=0;
				float Cuota12=0;
				
				float Recibis = Float.parseFloat(request.getParameter("txtMonto"));
				
				System.out.println(Recibis);
				System.out.println(total);
				System.out.println(ValorCuotas);
			
				request.setAttribute("VisibilidadDatos", "display: inline;");
				request.setAttribute("Recibis", Recibis);
				request.setAttribute("ValorCuotas", ValorCuotas);
				request.setAttribute("Total", total);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/PedirPrestamo.jsp");
				dispatcher.forward(request, response);
				break;

			}
			default:
				break;
			}

		}
	}

}

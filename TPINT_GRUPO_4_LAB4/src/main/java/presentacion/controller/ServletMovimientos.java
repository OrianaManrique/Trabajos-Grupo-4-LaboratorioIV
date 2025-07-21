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
				float Recibis = Float.parseFloat(request.getParameter("txtMonto"));
				int cuotas = Integer.parseInt(request.getParameter("cuotas"));
				
				switch (cuotas) {
				case 1: {
                    interes = 1.0f;
					break;
				}
				case 3: {
					interes = 1.1f;
					break;
				}
				case 6: {
					interes = 1.2f;
					break;
				}
				case 9: {
					interes = 1.3f;
					break;
				}
				case 12: {
					interes = 1.4f;
					break;
				}
			   }

				
				total = Recibis*interes;
				ValorCuotas = total/cuotas;
					
				System.out.println(Recibis);
				System.out.println(cuotas);
				System.out.println(total);
				System.out.println(ValorCuotas);
			
				request.setAttribute("VisibilidadDatos", "display: inline;");
				request.setAttribute("Recibis", Recibis);
				request.setAttribute("Cuotas", cuotas);
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

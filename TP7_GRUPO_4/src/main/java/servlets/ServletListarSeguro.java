package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dominio.Seguro;
import dominio.SegurosDao;

@WebServlet("/ServletListarSeguro")
public class ServletListarSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletListarSeguro() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("Param") != null) {

			SegurosDao seguroDao = new SegurosDao();
			ArrayList<Seguro> ListaSeguros = seguroDao.obtenerSeguros();

			request.setAttribute("listaSeguros", ListaSeguros);

			RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguro.jsp");
			rd.forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        
		String visibilidadErrorFiltro = "hidden";
		String visibilidadTabla = "visible";
		
		if (request.getParameter("btnFiltrar") != null) {
			if (request.getParameter("tipoSeguro") != null && !request.getParameter("tipoSeguro").isEmpty()) {
				ArrayList<Seguro> listafiltrada;
				SegurosDao sDao = new SegurosDao();

				int idtipo = Integer.parseInt(request.getParameter("tipoSeguro"));				

				listafiltrada = sDao.obtenerSegurosFiltrados(idtipo);

				request.setAttribute("listaSeguros", listafiltrada);
				request.setAttribute("VisibilidadErrorFiltro", visibilidadErrorFiltro);

				RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguro.jsp");
				rd.forward(request, response);
			}else {
				
				visibilidadErrorFiltro = "visible";
				visibilidadTabla = "visible";
				
				request.setAttribute("VisibilidadErrorFiltro", visibilidadErrorFiltro);
				request.setAttribute("VisibilidadTabla", visibilidadTabla);
				RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguro.jsp");
				rd.forward(request, response);

				
			}

		}

	}

}

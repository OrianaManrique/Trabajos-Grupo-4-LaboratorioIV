package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Seguro;
import dominio.SegurosDao;

@WebServlet("/ServletAgregarSeguro")
public class ServletAgregarSeguro extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ServletAgregarSeguro() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int filas = 0;
		if (request.getParameter("btnAceptar") != null) {
			SegurosDao sDao = new SegurosDao();
			Seguro seguro = new Seguro();

			if (!request.getParameter("descripcion").isEmpty() && !request.getParameter("tipoSeguro").isEmpty()
					&& !request.getParameter("tipoSeguro").isEmpty()
					&& !request.getParameter("costoContratacion").isEmpty()
					&& !request.getParameter("costoMaximoAsegurado").isEmpty() ) {

				seguro.setDescripcion(request.getParameter("descripcion"));
				seguro.setIdTipo(Integer.parseInt(request.getParameter("tipoSeguro")));
				seguro.setCostoContratacion(Float.parseFloat(request.getParameter("costoContratacion")));
				seguro.setCostoAsegurado(Float.parseFloat(request.getParameter("costoMaximoAsegurado")));

				filas = sDao.AgregarSeguro(seguro);

			}

			request.setAttribute("CantFilas", filas);
			RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguro.jsp");
			rd.forward(request, response);

		}

	}

}

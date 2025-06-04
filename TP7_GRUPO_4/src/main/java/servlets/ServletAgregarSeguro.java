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

/**
 * Servlet implementation class ServletAgregarSeguro
 */
@WebServlet("/ServletAgregarSeguro")
public class ServletAgregarSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAgregarSeguro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int filas = 0;
		if(request.getParameter("btnAceptar")!= null)
		{
			SegurosDao sDao = new SegurosDao();
			Seguro seguro = new Seguro();
			
			
			seguro.setDescripcion( request.getParameter("descripcion") );
			seguro.setIdTipo( Integer.parseInt(request.getParameter("tipoSeguro")));
			seguro.setCostoContractacion( Float.parseFloat(request.getParameter("costoContratacion")));
			seguro.setCostoAsegurado(Float.parseFloat(request.getParameter("costoMaximoAsegurado")));			
			
			filas = sDao.AgregarSeguro(seguro);
			
			request.setAttribute("CantFilas", filas);
			RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguro.jsp");
			rd.forward(request, response);			
			
		}		
		
		doGet(request, response);
	}

}

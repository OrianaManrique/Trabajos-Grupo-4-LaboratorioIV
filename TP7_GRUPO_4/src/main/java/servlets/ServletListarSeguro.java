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


/**
 * Servlet implementation class ServletListarSeguro
 */
@WebServlet("/ServletListarSeguro")
public class ServletListarSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarSeguro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("Param")!=null)
		{
			
			SegurosDao seguroDao = new SegurosDao();
			ArrayList<Seguro> ListaSeguros= seguroDao.obtenerSeguros();
			
			request.setAttribute("listaSeguros", ListaSeguros);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguro.jsp");   
	        rd.forward(request, response);
	        
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getParameter("btnFiltrar")!= null)
		{
			ArrayList<Seguro> listafiltrada;
			SegurosDao sDao = new SegurosDao();
			int idtipo= Integer.parseInt(request.getParameter("tipoSeguro"));
			
			listafiltrada = sDao.obtenerSegurosFiltrados(idtipo);
			
			request.setAttribute("listaFilt", listafiltrada);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguro.jsp");   
	        rd.forward(request, response);
			
		}
		
	}

}

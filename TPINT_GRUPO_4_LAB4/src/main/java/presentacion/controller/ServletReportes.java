package presentacion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.PrestamoNeg;
import negocioImpl.PrestamoNegImpl;

@WebServlet("/ServletReportes")
public class ServletReportes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrestamoNeg PresNeg = new PrestamoNegImpl();
     
    public ServletReportes() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mes = 0;
		int aprobados = 0;
		int rechazados = 0;
		
		if (request.getParameter("ddlMes") != null) {
			
			mes = Integer.parseInt(request.getParameter("ddlMes"));
			aprobados = PresNeg.ContarPrestamosPorMes(mes, "A");
			rechazados = PresNeg.ContarPrestamosPorMes(mes, "R");
			
			
			request.setAttribute("aprobados", aprobados);
			request.setAttribute("rechazados", rechazados);
			request.setAttribute("total", (rechazados+aprobados));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ReporteCondicion.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
      if (request.getParameter("ddlMes1") != null && request.getParameter("ddlMes2") !=null) {
			
			request.setAttribute("importe1", PresNeg.TotalImportePrestamosPorMes(Integer.parseInt(request.getParameter("ddlMes1"))));
			request.setAttribute("importe2", PresNeg.TotalImportePrestamosPorMes(Integer.parseInt(request.getParameter("ddlMes2"))));
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ReporteImporte.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

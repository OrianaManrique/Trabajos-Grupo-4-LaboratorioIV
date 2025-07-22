package presentacion.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidad.Cuenta;
import entidad.Transferencia;
import entidad.Usuario;
import negocio.CuentaNeg;
import negocio.TransferenciaNeg;
import negocioImpl.CuentaNegImpl;
import negocioImpl.TransferenciaNegImpl;

@WebServlet("/ServletMovimientos")
public class ServletMovimientos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CuentaNeg negCuenta = new CuentaNegImpl();
	TransferenciaNeg trNeg = new TransferenciaNegImpl();
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("Param") != null) {

			String operacion = request.getParameter("Param").toString();

			switch (operacion) {
			case "CargarCuentasTransferencias": {

				Usuario UsuarioLogeado = (Usuario) request.getSession().getAttribute("usuarioLogueado");
				request.setAttribute("ListaCuentas", negCuenta.obtenerCuentasxDni(UsuarioLogeado.getDni_us()));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/RealizarTransferencia.jsp");
				dispatcher.forward(request, response);
				break;
			}
			default:
				break;
			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("Param") != null) {

			String operacion = request.getParameter("Param").toString();

			switch (operacion) {
			case "CalcularPrestamo": {

				float Recibis = Float.parseFloat(request.getParameter("txtMonto"));

				request.setAttribute("VisibilidadDatos", "display: inline;");
				request.setAttribute("Recibis", Recibis);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/SolicitarPrestamo.jsp");
				dispatcher.forward(request, response);
				break;

			}
			case "ConfirmarTransferencia": {

				Transferencia transferencia = new Transferencia();
				Cuenta cuentaEmisor = new Cuenta();
				Cuenta cuentaReceptor = new Cuenta();

				cuentaEmisor.setCbu_cuenta(request.getParameter("ddlCuentas"));
				cuentaReceptor.setCbu_cuenta(request.getParameter("txtCBUdestino"));

				transferencia.setCbuEmisor_transferencia(cuentaEmisor);
				transferencia.setCbuReceptor_transferencia(cuentaReceptor);
				transferencia.setMonto_transferencia(Integer.parseInt(request.getParameter("txtMonto")));
				transferencia.setMotivo(request.getParameter("ddlMotivo"));

				Usuario UsuarioLogeado = (Usuario) request.getSession().getAttribute("usuarioLogueado");
				request.setAttribute("Exito", trNeg.AgregarTransferencia(transferencia));
				request.setAttribute("ListaCuentas", negCuenta.obtenerCuentasxDni(UsuarioLogeado.getDni_us()));

				RequestDispatcher dispatcher = request.getRequestDispatcher("/RealizarTransferencia.jsp");
				dispatcher.forward(request, response);
				break;
			}
			case "SolicitarPrestamo": {
                
				
                 
				

				RequestDispatcher dispatcher = request.getRequestDispatcher("/SolicitarPrestamo.jsp");
				dispatcher.forward(request, response);
				break;
			}
			default:
				break;
			}

		}
	}

}

package presentacion.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidad.Cliente;
import entidad.Cuenta;
import entidad.Prestamo;
import entidad.Transferencia;
import entidad.Usuario;
import negocio.CuentaNeg;
import negocio.TransferenciaNeg;
import negocioImpl.CuentaNegImpl;
import negocioImpl.TransferenciaNegImpl;
import negocio.PrestamoNeg;
import negocioImpl.PrestamoNegImpl;
import negocio.MovimientoNeg;
import negocioImpl.MovimientoNegImpl;
import negocioImpl.ClienteNegImpl;
import negocio.ClienteNeg;

@WebServlet("/ServletMovimientos")
public class ServletMovimientos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CuentaNeg negCuenta = new CuentaNegImpl();
	TransferenciaNeg trNeg = new TransferenciaNegImpl();
	PrestamoNeg PresNeg = new PrestamoNegImpl();
	MovimientoNeg movNeg = new MovimientoNegImpl();
	ClienteNeg negCliente = new ClienteNegImpl();

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
			case "CargarJSPSolicitudPrestamo": {

				Usuario UsuarioLogueado = (Usuario) request.getSession().getAttribute("usuarioLogueado");
				request.setAttribute("ListaCuentas", negCuenta.obtenerCuentasxDni(UsuarioLogueado.getDni_us()));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/SolicitarPrestamo.jsp");
				dispatcher.forward(request, response);
				break;
			}

			case "CargarCuentasMovimientos": {

				Usuario UsuarioLogueado = (Usuario) request.getSession().getAttribute("usuarioLogueado");
				request.setAttribute("ListaCuentas", negCuenta.obtenerCuentasxDni(UsuarioLogueado.getDni_us()));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Movimientos.jsp");
				dispatcher.forward(request, response);
				break;
			}		
			case "CargarAutorizarPrestamos": {

				request.setAttribute("ListaPrestamos", PresNeg.obtenerPrestamos());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/AutorizarPrestamo.jsp");
				dispatcher.forward(request, response);
				break;
			}

			default:
				break;
			}

		}
		if (request.getParameter("ddlCuentasMovimientos") != null) {
		
			
			Usuario UsuarioLogueado = (Usuario) request.getSession().getAttribute("usuarioLogueado");

			if (request.getParameter("ddlCuentasMovimientos").equals("TodasCuentas")) {
				
				request.setAttribute("ListaMovimientos",
						movNeg.obtenerMovimientosPorCliente(UsuarioLogueado.getDni_us()));
			} else {
				request.setAttribute("ListaMovimientos",
						movNeg.obtenerMovimientosCuenta(Integer.parseInt(request.getParameter("ddlCuentasMovimientos"))));
			}
			
			request.setAttribute("ListaCuentas", negCuenta.obtenerCuentasxDni(UsuarioLogueado.getDni_us()));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Movimientos.jsp");
			dispatcher.forward(request, response);
			
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("Param") != null) {

			String operacion = request.getParameter("Param").toString();

			switch (operacion) {
			case "CalcularPrestamo": {

				float Recibis = Float.parseFloat(request.getParameter("txtMonto"));

				Usuario UsuarioLogueado = (Usuario) request.getSession().getAttribute("usuarioLogueado");
				request.setAttribute("ListaCuentas", negCuenta.obtenerCuentasxDni(UsuarioLogueado.getDni_us()));
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

				Usuario UsuarioLogueado = (Usuario) request.getSession().getAttribute("usuarioLogueado");
				request.setAttribute("Exito", trNeg.AgregarTransferencia(transferencia));
				request.setAttribute("ListaCuentas", negCuenta.obtenerCuentasxDni(UsuarioLogueado.getDni_us()));

				RequestDispatcher dispatcher = request.getRequestDispatcher("/RealizarTransferencia.jsp");
				dispatcher.forward(request, response);
				break;
			}
			case "SolicitarPrestamo": {
				Prestamo prestamo = new Prestamo();
				Cliente cliente = new Cliente();
				Cuenta cuenta = new Cuenta();

				Usuario UsuarioLogueado = (Usuario) request.getSession().getAttribute("usuarioLogueado");
				cliente = negCliente.obtenerCliente(UsuarioLogueado.getDni_us());
				cuenta = negCuenta.Obtenercuenta(Integer.parseInt(request.getParameter("ddlCuentas")));			
				
				prestamo.setDniCliente_prestamo(cliente);
				prestamo.setNroCuenta_prestamo(cuenta);
				               
				prestamo.setImporteSolicitado_prestamo(Float.parseFloat(request.getParameter("recibis")));
				prestamo.setImporteApagar_prestamo(Float.parseFloat(request.getParameter("total")));	
				prestamo.setPlazoDePago_prestamo(Integer.parseInt(request.getParameter("cuotas")));
				prestamo.setCuotas_prestamo(Integer.parseInt(request.getParameter("cuotas")));
				prestamo.setMontoMensual_prestamo(Float.parseFloat(request.getParameter("ValorCuotas")));	

				request.setAttribute("Exito", PresNeg.SolicitarPrestamo(prestamo));
				request.setAttribute("ListaCuentas", negCuenta.obtenerCuentasxDni(UsuarioLogueado.getDni_us()));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/SolicitarPrestamo.jsp");
				dispatcher.forward(request, response);
				break;
			}
			case "Autorizar-RechazarPrestamo": {
	             
				Prestamo prestamo = new Prestamo();
				Cuenta cuenta = new Cuenta();
				
				cuenta.setNroCuenta_cuenta(Integer.parseInt(request.getParameter("NumeroCuenta_Prestamo")));
				
				prestamo.setId_prestamo(Integer.parseInt(request.getParameter("Id_Prestamo")));
				prestamo.setNroCuenta_prestamo(cuenta);
				prestamo.setImporteSolicitado_prestamo(Float.parseFloat(request.getParameter("ImporteSolicitado_Prestamo")));
					
				PresNeg.AutorizarRechazarPrestamo(prestamo, request.getParameter("Condicion"));
				request.setAttribute("ListaPrestamos", PresNeg.obtenerPrestamos());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/AutorizarPrestamo.jsp");
				dispatcher.forward(request, response);
				break;
			}

			default:
				break;
			}

		}
	}

}

package presentacion.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidad.Cuenta;
import entidad.TipoCuenta;
import negocio.CuentaNeg;
import negocioImpl.CuentaNegImpl;
import negocioImpl.TipoCuentaNegImpl;
import negocio.TipoCuentaNeg;
import negocio.ClienteNeg;
import negocioImpl.ClienteNegImpl;

@WebServlet("/ServletCuentas")
public class ServletCuentas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CuentaNeg negCuenta = new CuentaNegImpl();
	TipoCuentaNeg tipoCuentaNeg = new TipoCuentaNegImpl();
	ClienteNeg clienteNeg = new ClienteNegImpl();

	public ServletCuentas() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("Param") != null && request.getParameter("Param2") == null) {

			String operacion = request.getParameter("Param").toString();

			switch (operacion) {
			case "ListarCuentas": {

				request.setAttribute("Lista", negCuenta.obtenerCuentas());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarCuenta.jsp");
				dispatcher.forward(request, response);
				break;
			}
			case "SeleccionModificar": {
				
				request.setAttribute("Cuenta", negCuenta.Obtenercuenta(Integer.parseInt(request.getParameter("NumeroCuenta"))));
				request.setAttribute("ListaCuentas", negCuenta.obtenerCuentasxDni(Integer.parseInt(request.getParameter("dnibusqueda"))));
				request.setAttribute("Cliente", clienteNeg.obtenerCliente(Integer.parseInt(request.getParameter("dnibusqueda"))));
				request.setAttribute("DniBusqueda", (Integer.parseInt(request.getParameter("dnibusqueda"))));
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ModificarCuenta.jsp");
				dispatcher.forward(request, response);
				break;
			}
			case "ListarEliminar": {

				request.setAttribute("Lista", negCuenta.obtenerCuentas());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/EliminarCuenta.jsp");
				dispatcher.forward(request, response);
				break;
			}
			case "CargarAgregarCuenta": {

				request.setAttribute("NroCuenta", negCuenta.proximoNroCuenta());
				request.setAttribute("CBU", negCuenta.ObtenerCBU());
				request.setAttribute("Tipos", tipoCuentaNeg.obtenerTiposCuentas());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/AgregarCuenta.jsp");
				dispatcher.forward(request, response);
				break;
			}

			default:
				break;
			}

		}

		if (request.getParameter("Param2") != null && request.getParameter("Param") != null) {

			String operacion = request.getParameter("Param").toString();

			switch (operacion) {
			case "EliminarCuenta": {

				boolean estado = negCuenta.borrar(Integer.parseInt(request.getParameter("Param2")));

				request.setAttribute("Exito", estado);
				request.setAttribute("Lista", negCuenta.obtenerCuentas());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/EliminarCuenta.jsp");
				dispatcher.forward(request, response);
				break;
			}
			default:
				break;
			}

			return;

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (request.getParameter("Param") != null) {

			String operacion = request.getParameter("Param").toString();

			switch (operacion) {
			case "Asignar": {

				Cuenta cuenta = new Cuenta();

				cuenta.setCbu_cuenta(request.getParameter("txtCBU"));
				cuenta.setDni_Cliente(Integer.parseInt(request.getParameter("txtDniCliente")));

				TipoCuenta tipo = new TipoCuenta();

				tipo.setId_tipoCuenta(Integer.parseInt(request.getParameter("ddlTipoCuenta")));

				cuenta.setTipo_cuenta(tipo);

				request.setAttribute("Exito", negCuenta.agregarCuenta(cuenta));
				RequestDispatcher requestdispatcher = request.getRequestDispatcher("/AgregarCuenta.jsp");
				requestdispatcher.forward(request, response);
				break;
			}
			case "GuardarModificacionCuenta": {

				Cuenta cuenta = new Cuenta();
				TipoCuenta tipo = new TipoCuenta();
				
				cuenta.setNroCuenta_cuenta(Integer.parseInt(request.getParameter("nroCuenta")));
				cuenta.setCbu_cuenta(request.getParameter("txtCBU"));
				cuenta.setSaldo_cuenta(Float.parseFloat(request.getParameter("txtSaldo")));			
				tipo.setId_tipoCuenta(Integer.parseInt(request.getParameter("ddlTipoCuenta")));
				cuenta.setTipo_cuenta(tipo);

				request.setAttribute("Exito", negCuenta.modificarCuenta(cuenta));
				request.setAttribute("ListaCuentas", negCuenta.obtenerCuentasxDni(Integer.parseInt(request.getParameter("dnibusqueda"))));
				request.setAttribute("Cliente", clienteNeg.obtenerCliente(Integer.parseInt(request.getParameter("dnibusqueda"))));
				request.setAttribute("DniBusqueda", (Integer.parseInt(request.getParameter("dnibusqueda"))));
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ModificarCuenta.jsp");
				dispatcher.forward(request, response);
				break;
			}
			
			case "BuscarCuentasModificar":{
							
				request.setAttribute("ListaCuentas", negCuenta.obtenerCuentasxDni(Integer.parseInt(request.getParameter("txtBusqueda"))));			
				request.setAttribute("Cliente", clienteNeg.obtenerCliente(Integer.parseInt(request.getParameter("txtBusqueda"))));
				request.setAttribute("DniBusqueda", (Integer.parseInt(request.getParameter("txtBusqueda"))));
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ModificarCuenta.jsp");
				dispatcher.forward(request, response);
				
			}
			
			default:
				break;
			}
		}
		
		
	}
}

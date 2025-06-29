package presentacion.controller;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidad.Cuenta;
import entidad.Tipo_Cuenta;
import negocio.CuentaNeg;
import negocioImpl.CuentaNegImpl;
import negocio.Tipo_CuentaNeg;
import negocioImpl.Tipo_CuentaNegImpl;

@WebServlet("/ServletCuentas")
public class ServletCuentas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CuentaNeg negCuenta = new CuentaNegImpl();
	Tipo_CuentaNeg tipoCuentaNeg = new Tipo_CuentaNegImpl();

	public ServletCuentas() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("Param") != null && request.getParameter("Param2")==null) {

			String operacion = request.getParameter("Param").toString();

			switch (operacion) {
			case "Listar": {
				// Cargo el form

				request.setAttribute("Lista", negCuenta.obtenerCuentas());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarCuenta.jsp");
				dispatcher.forward(request, response);
				break;
			}
			case "CargarAgregar": {			

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
			case "CargarModificarCuenta":{		
								
          		Cuenta cuentaEditar = negCuenta.Obtenercuenta(request.getParameter("Param2"));
          		int TipoSeleccionado = cuentaEditar.getTipo_cuenta().getId_tipoCuenta();
          		
          		System.out.println(TipoSeleccionado);
          		
				request.setAttribute("CuentaEditar", cuentaEditar);
				request.setAttribute("TipoSeleccionado", TipoSeleccionado);
				request.setAttribute("Tipos", tipoCuentaNeg.obtenerTiposCuentas());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ModificarCuenta.jsp");
				dispatcher.forward(request, response);
				break;
			}
			case "CargarEliminarCuenta":{			
					
				request.setAttribute("ListaCuentasFiltradas", negCuenta.obtenerCuentasxDni(Integer.parseInt(request.getParameter("Param2"))));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/EliminarCuenta.jsp");
				dispatcher.forward(request, response);			
				break;
			}
			case "EliminarCuenta":{	
						
				boolean estado = negCuenta.borrar(request.getParameter("Param2"));
				
				request.setAttribute("Exito", estado);				
				request.setAttribute("ListaCuentasFiltradas", negCuenta.obtenerCuentasxDni(Integer.parseInt(request.getParameter("dniCliente"))));
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

				cuenta.setNroCuenta_cuenta(request.getParameter("txtNumeroCuenta"));
				cuenta.setCbu_cuenta(request.getParameter("txtCBU"));
				cuenta.setDni_Cliente(Integer.parseInt(request.getParameter("txtDniCliente")));
				cuenta.setSaldo_cuenta(Double.parseDouble(request.getParameter("txtSaldo")));
				
				String fecha = request.getParameter("txtFechaActual");
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                formato.setLenient(false);
                Date fechacreacion = null;

                try {
                	fechacreacion = new Date(formato.parse(fecha).getTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
				
				cuenta.setFecha_creacion_cuenta(fechacreacion);
				
				Tipo_Cuenta tipo = new Tipo_Cuenta();
				
				tipo.setId_tipoCuenta(Integer.parseInt(request.getParameter("ddlTipoCuenta")));
				
				cuenta.setTipo_cuenta(tipo);
				
				request.setAttribute("Exito", negCuenta.agregarCuenta(cuenta));
				RequestDispatcher requestdispatcher = request.getRequestDispatcher("/AgregarCuenta.jsp");
				requestdispatcher.forward(request, response);
				break;
			}
			case "Modificar":{
						
				Cuenta cuenta = new Cuenta();
				
				cuenta.setNroCuenta_cuenta(request.getParameter("txtNumeroCuenta"));
				cuenta.setCbu_cuenta(request.getParameter("txtCBU"));
				cuenta.setDni_Cliente(Integer.parseInt(request.getParameter("txtDniCliente")));
				cuenta.setSaldo_cuenta(Double.parseDouble(request.getParameter("txtSaldo")));
				
				String fecha = request.getParameter("txtFechaActual");
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                formato.setLenient(false);
                Date fechacreacion = null;

                try {
                	fechacreacion = new Date(formato.parse(fecha).getTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
				
				cuenta.setFecha_creacion_cuenta(fechacreacion);
				
				Tipo_Cuenta tipo = new Tipo_Cuenta();
				
				tipo.setId_tipoCuenta(Integer.parseInt(request.getParameter("ddlTipoCuenta")));		
				cuenta.setTipo_cuenta(tipo);			
				
				request.setAttribute("Exito", negCuenta.modificarCuenta(cuenta));;
				RequestDispatcher dispatcher = request.getRequestDispatcher("/InicioAdministrador.jsp");
				dispatcher.forward(request, response);			
				break;
			}				
			    default:
				break;
			}
		}
	}
}

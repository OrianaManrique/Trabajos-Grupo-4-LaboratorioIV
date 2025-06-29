package datosImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import datos.CuentaDao;
import entidad.Cuenta;
import entidad.Tipo_Cuenta;

public class CuentaDaoImpl implements CuentaDao {

	private Conexion conexion;

	public CuentaDaoImpl() {
	}

	public ArrayList<Cuenta> obtenerCuentas() {

		conexion = new Conexion();
		conexion.open();

		String consulta = ("SELECT c.NroCuenta_Cuenta, c.dni_cliente, c.fecha_creacion_cuenta, "
				+ "c.cbu_cuenta, c.id_TipoCuenta, tc.Descripcion_tipoCuenta, " + "c.saldo_cuenta FROM Cuentas c "
				+ "LEFT JOIN Tipo_Cuentas tc ON c.id_TipoCuenta = tc.id_TipoCuenta WHERE c.estado_cuenta = 1;");

		ArrayList<Cuenta> lista = new ArrayList<Cuenta>();

		try {
			ResultSet rs = conexion.query(consulta);

			while (rs.next()) {
				Cuenta cuenta = new Cuenta();
				cuenta.setNroCuenta_cuenta(rs.getString("NroCuenta_Cuenta"));
				cuenta.setDni_Cliente(rs.getInt("dni_cliente"));
				cuenta.setFecha_creacion_cuenta(rs.getDate("fecha_creacion_cuenta"));
				cuenta.setCbu_cuenta(rs.getString("cbu_cuenta"));

				Tipo_Cuenta tipo = new Tipo_Cuenta();

				tipo.setId_tipoCuenta(rs.getInt("id_TipoCuenta"));
				tipo.setDescripcion_tipoCuenta(rs.getString("Descripcion_tipoCuenta"));
				cuenta.setTipo_cuenta(tipo);
				cuenta.setSaldo_cuenta(rs.getDouble("saldo_cuenta"));

				lista.add(cuenta);
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.close();
		}
		return lista;
	}

	@Override
	public boolean borrar(String NroCuenta_Cuenta) {

		boolean estado = false;

		try {
			conexion = new Conexion();
			conexion.open();
			String query = "UPDATE cuentas SET estado_cuenta = 0 WHERE NroCuenta_Cuenta = " + NroCuenta_Cuenta
					+ " AND estado_cuenta = 1";

			int filasAfectadas = conexion.executeUpdate(query);

			if (filasAfectadas > 0) {
				estado = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.close();
		}
		return estado;
	}

	@Override
	public boolean editar(Cuenta cuenta) {

		boolean estado = true;

		conexion = new Conexion();
		conexion.open();

		String query = "UPDATE cuentas SET " + "NroCuenta_Cuenta=" + cuenta.getNroCuenta_cuenta() + ", "
				+ "dni_cliente='" + cuenta.getDni_Cliente() + "', " + "fecha_creacion_cuenta='"
				+ cuenta.getFecha_creacion_cuenta() + "', " + "cbu_cuenta='" + cuenta.getCbu_cuenta() + "', "
				+ "id_TipoCuenta=" + cuenta.getTipo_cuenta() + ", " + "saldo_cuenta=" + cuenta.getSaldo_cuenta() + " "
				+ "WHERE NroCuenta_Cuenta=" + cuenta.getNroCuenta_cuenta();

		try {
			estado = conexion.execute(query);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.close();
		}
		return estado;
	}

	@Override
	public Cuenta obtenerCuenta(String NroCuenta_Cuenta) {
		conexion = new Conexion();
		conexion.open();
		
		Cuenta cuenta = new Cuenta();
		Tipo_Cuenta tipocuenta= new Tipo_Cuenta();

		String consulta = "select * \r\n" + " from cuentas\r\n"
				+ "		where NroCuenta_Cuenta = " + NroCuenta_Cuenta;

		try {
			ResultSet rs = conexion.query(consulta);
			if (rs.next()) {
				
				cuenta.setNroCuenta_cuenta(rs.getString("NroCuenta_Cuenta"));
				cuenta.setDni_Cliente(rs.getInt("dni_cliente"));
				cuenta.setFecha_creacion_cuenta((rs.getDate("fecha_creacion_cuenta")));		
				cuenta.setCbu_cuenta(rs.getString("cbu_cuenta"));
				tipocuenta.setId_tipoCuenta(rs.getInt("id_TipoCuenta"));
				cuenta.setTipo_cuenta(tipocuenta);
				cuenta.setSaldo_cuenta(rs.getDouble("id_TipoCuenta"));			
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.close();
		}

		return cuenta;
	}
	
	public Boolean agregarCuenta(Cuenta cuenta){
		
		boolean estado = true;
		
		conexion = new Conexion();
		conexion.open();
		
		cuenta.setEstado_cuenta(1);

		String consulta = "INSERT INTO cuentas (NroCuenta_Cuenta, dni_cliente, fecha_creacion_cuenta, cbu_cuenta, id_TipoCuenta, saldo_cuenta, estado_cuenta) "
	               + "VALUES ('" + cuenta.getNroCuenta_cuenta() + "', "
	               + cuenta.getDni_Cliente() + ", "
	               + "'" + cuenta.getFecha_creacion_cuenta().toString() + "', "
	               + "'" + cuenta.getCbu_cuenta() + "', "
	               + cuenta.getTipo_cuenta().getId_tipoCuenta() + ", "
	               + cuenta.getSaldo_cuenta() + ", "
	               + cuenta.getEstado_cuenta() + ");";

		try {
			estado = conexion.execute(consulta);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.close();
		}
		return estado;
	}

}

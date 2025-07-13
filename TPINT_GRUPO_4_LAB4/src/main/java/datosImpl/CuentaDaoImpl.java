package datosImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import datos.CuentaDao;
import entidad.Cuenta;
import entidad.TipoCuenta;

public class CuentaDaoImpl implements CuentaDao {

	private Conexion conexion;

	public CuentaDaoImpl() {
	}

	public ArrayList<Cuenta> obtenerCuentas() {

		conexion = new Conexion();
		conexion.open();

		String consulta = ("SELECT c.nroCuenta_cuenta, c.dnicliente_cuenta, c.fecha_creacion_cuenta, "
				+ "c.cbu_cuenta, c.idtipo_cuenta, tc.descripcion_tipoCuenta, " + "c.saldo_cuenta FROM Cuentas c "
				+ "LEFT JOIN tipocuentas tc ON c.idtipo_cuenta = tc.id_tipoCuenta WHERE c.estado_cuenta = 1;");

		ArrayList<Cuenta> lista = new ArrayList<Cuenta>();

		try {
			ResultSet rs = conexion.query(consulta);

			while (rs.next()) {
				Cuenta cuenta = new Cuenta();
				cuenta.setNroCuenta_cuenta(rs.getString("nroCuenta_Cuenta"));
				cuenta.setDni_Cliente(rs.getInt("dnicliente_cuenta"));
				cuenta.setFechaCreacion_cuenta(rs.getDate("fecha_creacion_cuenta"));
				cuenta.setCbu_cuenta(rs.getString("cbu_cuenta"));

				TipoCuenta tipo = new TipoCuenta();

				tipo.setId_tipoCuenta(rs.getInt("idtipo_cuenta"));
				tipo.setDescripcion_tipoCuenta(rs.getString("descripcion_tipoCuenta"));
				cuenta.setTipo_cuenta(tipo);
				cuenta.setSaldo_cuenta(rs.getFloat("saldo_cuenta"));

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
			String consulta = "UPDATE cuentas SET estado_cuenta = 0 WHERE nroCuenta_cuenta = '" + NroCuenta_Cuenta
					+ " ' AND estado_cuenta = 1";

			int filasAfectadas = conexion.executeUpdate(consulta);

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
	public boolean modificarCuenta(Cuenta cuenta) {

		boolean estado = true;

		
		conexion = new Conexion();
		conexion.open();

		String consulta = "UPDATE cuentas SET " + "nroCuenta_cuenta = '" + cuenta.getNroCuenta_cuenta() + "', "
				+ "dnicliente_cuenta = '" + cuenta.getDni_Cliente() + "', " + "fecha_creacion_cuenta = '"
				+ cuenta.getFechaCreacion_cuenta() + "', " + "cbu_cuenta = '" + cuenta.getCbu_cuenta() + "', "
				+ "id_tipoCuenta = " + cuenta.getTipo_cuenta().getId_tipoCuenta() + ", " + "saldo_cuenta = "
				+ cuenta.getSaldo_cuenta() + " " + "WHERE nroCuenta_cuenta = '" + cuenta.getNroCuenta_cuenta() + "'";

		try {
			estado = conexion.execute(consulta);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.close();
		}
		return estado;
	}

	@Override
	public ArrayList<Cuenta> obtenerCuentasxDni(int dni_cliente) {

		conexion = new Conexion();
		conexion.open();

		String consulta = ("SELECT c.nroCuenta_cuenta, c.dnicliente_cuenta, c.fecha_creacion_cuenta, "
				+ "c.cbu_cuenta, c.id_tipoCuenta, tc.descripcion_tipoCuenta, " + "c.saldo_cuenta FROM Cuentas c "
				+ "LEFT JOIN tipocuentas tc ON c.id_tipoCuenta = tc.id_tipoCuenta WHERE c.estado_cuenta = 1 AND c.dnicliente_cuenta="
				+ dni_cliente);

		ArrayList<Cuenta> lista = new ArrayList<Cuenta>();

		try {
			ResultSet rs = conexion.query(consulta);

			while (rs.next()) {
				Cuenta cuenta = new Cuenta();
				cuenta.setNroCuenta_cuenta(rs.getString("nroCuenta_cuenta"));
				cuenta.setDni_Cliente(rs.getInt("dnicliente_cuenta"));
				cuenta.setFechaCreacion_cuenta(rs.getDate("fecha_creacion_cuenta"));
				cuenta.setCbu_cuenta(rs.getString("cbu_cuenta"));

				TipoCuenta tipo = new TipoCuenta();

				tipo.setId_tipoCuenta(rs.getInt("id_tipoCuenta"));
				tipo.setDescripcion_tipoCuenta(rs.getString("descripcion_tipoCuenta"));
				cuenta.setTipo_cuenta(tipo);
				cuenta.setSaldo_cuenta(rs.getFloat("saldo_cuenta"));

				lista.add(cuenta);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.close();
		}
		return lista;
	}

	public Boolean agregarCuenta(Cuenta cuenta) {

		boolean estado = true;

		conexion = new Conexion();
		conexion.open();

		cuenta.setEstado_cuenta(1);

		String consulta = "INSERT INTO cuentas (nroCuenta_cuenta, dnicliente_cuenta, fecha_creacion_cuenta, cbu_cuenta, id_tipoCuenta, saldo_cuenta, estado_cuenta) "
				+ "VALUES ('" + cuenta.getNroCuenta_cuenta() + "', " + cuenta.getDni_Cliente() + ", " + "'"
				+ cuenta.getFechaCreacion_cuenta().toString() + "', " + "'" + cuenta.getCbu_cuenta() + "', "
				+ cuenta.getTipo_cuenta().getId_tipoCuenta() + ", " + cuenta.getSaldo_cuenta() + ", "
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

	@Override
	public Cuenta Obtenercuenta(String NroCuenta_Cuenta) {
		Cuenta cuenta = null;
		TipoCuenta tipo = null;

		try {
			conexion = new Conexion();
			conexion.open();

			String consulta = "SELECT c.nroCuenta_cuenta, c.dnicliente_cuenta, c.fecha_creacion_cuenta, "
					+ "c.cbu_cuenta, c.id_tipoCuenta, tc.descripcion_tipoCuenta, c.saldo_cuenta " + "FROM Cuentas c "
					+ "LEFT JOIN tipocuentas tc ON c.id_tipoCuenta = tc.id_tipoCuenta "
					+ "WHERE c.estado_cuenta = 1 AND c.nroCuenta_cuenta = '" + NroCuenta_Cuenta + "'";

			ResultSet rs = conexion.query(consulta);

			if (rs.next()) {
				cuenta = new Cuenta();

				cuenta.setNroCuenta_cuenta(rs.getString("nroCuenta_cuenta"));
				cuenta.setDni_Cliente(rs.getInt("dnicliente_cuenta"));
				cuenta.setFechaCreacion_cuenta(rs.getDate("fecha_creacion_cuenta"));
				cuenta.setCbu_cuenta(rs.getString("cbu_cuenta"));

				tipo = new TipoCuenta();

				tipo.setId_tipoCuenta(rs.getInt("id_tipoCuenta"));
				tipo.setDescripcion_tipoCuenta(rs.getString("descripcion_tipoCuenta"));
				cuenta.setTipo_cuenta(tipo);

				cuenta.setSaldo_cuenta(rs.getFloat("saldo_cuenta"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.close();
		}

		return cuenta;
	}

}

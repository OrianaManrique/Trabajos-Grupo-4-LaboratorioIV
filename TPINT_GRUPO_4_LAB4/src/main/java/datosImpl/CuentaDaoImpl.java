package datosImpl;
import java.sql.ResultSet;

import java.util.ArrayList;
import datos.CuentaDao;
import entidad.Cuenta;
import entidad.TipoCuenta;
import java.util.Random;

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
				cuenta.setNroCuenta_cuenta(rs.getInt("nroCuenta_Cuenta"));
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
	public boolean borrar(int NroCuenta_Cuenta) {

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

		boolean estado = false;

		conexion = new Conexion();
		conexion.open();

		String consulta = "UPDATE cuentas SET " + "cbu_cuenta = '" + cuenta.getCbu_cuenta() + "', "
				+ "idtipo_cuenta = " + cuenta.getTipo_cuenta().getId_tipoCuenta() + ", " + "saldo_cuenta = "
				+ cuenta.getSaldo_cuenta() + " " + "WHERE nroCuenta_cuenta = " + cuenta.getNroCuenta_cuenta() + ";";

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
				+ "c.cbu_cuenta, c.idtipo_cuenta, tc.descripcion_tipoCuenta, " + "c.saldo_cuenta FROM Cuentas c "
				+ "LEFT JOIN tipocuentas tc ON c.idtipo_cuenta = tc.id_tipoCuenta WHERE c.estado_cuenta = 1 AND c.dnicliente_cuenta="
				+ dni_cliente);

		ArrayList<Cuenta> lista = new ArrayList<Cuenta>();

		try {
			ResultSet rs = conexion.query(consulta);

			while (rs.next()) {
				Cuenta cuenta = new Cuenta();
				cuenta.setNroCuenta_cuenta(rs.getInt("nroCuenta_cuenta"));
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

	public Boolean agregarCuenta(Cuenta cuenta) {

		boolean estado = false;

		conexion = new Conexion();
		conexion.open();

		String consulta = "CALL AgregarCuenta(" + cuenta.getDni_Cliente() + ", '" + cuenta.getCbu_cuenta() + "', "
				+ cuenta.getTipo_cuenta().getId_tipoCuenta() + ");";

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
	public Cuenta Obtenercuenta(int NroCuenta_Cuenta) {
		Cuenta cuenta = null;
		TipoCuenta tipo = null;

		try {
			conexion = new Conexion();
			conexion.open();

			String consulta = "SELECT c.nroCuenta_cuenta, c.dnicliente_cuenta, c.fecha_creacion_cuenta, "
					+ "c.cbu_cuenta, c.idtipo_cuenta, tc.descripcion_tipoCuenta, c.saldo_cuenta " + "FROM Cuentas c "
					+ "LEFT JOIN tipocuentas tc ON c.idtipo_cuenta = tc.id_tipoCuenta "
					+ "WHERE c.estado_cuenta = 1 AND c.nroCuenta_cuenta = " + NroCuenta_Cuenta + ";";

			ResultSet rs = conexion.query(consulta);

			if (rs.next()) {
				cuenta = new Cuenta();

				cuenta.setNroCuenta_cuenta(rs.getInt("nroCuenta_cuenta"));
				cuenta.setDni_Cliente(rs.getInt("dnicliente_cuenta"));
				cuenta.setFechaCreacion_cuenta(rs.getDate("fecha_creacion_cuenta"));
				cuenta.setCbu_cuenta(rs.getString("cbu_cuenta"));

				tipo = new TipoCuenta();

				tipo.setId_tipoCuenta(rs.getInt("idtipo_cuenta"));
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

	public int proximoNroCuenta() {

		int proxNum = 11000;

		try {
			conexion = new Conexion();
			conexion.open();

			String consulta = "SELECT COUNT(*) AS 'total cuentas' FROM cuentas;";

			ResultSet rs = conexion.query(consulta);

			if (rs.next()) {

				proxNum += rs.getInt("total cuentas");

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.close();
		}

		return proxNum;
	}

	public String ObtenerCBU() {
		
		String cbu= "";
		int largo = 22;
		String grupo1 = "";
		String grupo2 = "";
		String grupo3 = "";
		Random random = new Random();

        int minimo = 10000000;
        int maximo = 99999999;

        grupo1 = Integer.toString(random.nextInt(maximo - minimo + 1) + minimo);
        grupo2 = Integer.toString(random.nextInt(maximo - minimo + 1) + minimo);
        grupo3 = Integer.toString(random.nextInt(999999 - 100000 + 1) + 100000);
        
        cbu += grupo1 += grupo2 += grupo3;
        
        if (cbu.length()== largo) {
        	
        	return cbu;
        }
        else {
        	
        	return cbu;
        }
        
	}

	@Override
	public int ContarCuentas(int dni_cliente) {
		int cantidad = 0;

		try {
			conexion = new Conexion();
			conexion.open();

			String consulta = "SELECT dnicliente_cuenta AS Cliente, COUNT(*) AS Cantidad  FROM cuentas WHERE dnicliente_cuenta = 12345678 AND estado_cuenta = 1 GROUP BY dnicliente_cuenta;";

			ResultSet rs = conexion.query(consulta);

			if (rs.next()) {

				cantidad = rs.getInt("Cantidad");

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.close();
		}

		return cantidad;
	}

}

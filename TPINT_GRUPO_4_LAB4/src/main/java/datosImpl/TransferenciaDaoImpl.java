package datosImpl;

import java.util.ArrayList;
import java.sql.ResultSet;
import datos.TransferenciaDao;
import entidad.Cuenta;
import entidad.Transferencia;

public class TransferenciaDaoImpl implements TransferenciaDao{
	
	private Conexion conexion;

	@Override
	public boolean AgregarTransferencia(Transferencia transferencia) {
		
		boolean estado = true;

		conexion.open();

		String query = "CALL AltaCompletaCliente('" +transferencia.getCbu_emisor_transferencia()+"', '"+transferencia.getCbu_receptor_transferencia()+"', "+transferencia.getMonto_transferencia()+");";

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
	public Transferencia obtenerTransferenciaporid(int id) {

		Transferencia transferencia = new Transferencia();
		Cuenta cuentaEmisor = new Cuenta();
		Cuenta cuentaReceptor = new Cuenta();

		conexion = new Conexion();
		conexion.open();

		String consulta = "select id_transferencia AS id, cbu_emisor_transferencia AS emisor, cbu_receptor_transferencia AS receptor, monto_transferencia AS monto, fecha_transferencia AS fecha "
				          +"from transferencias where id_transferencia ="+ id + ";";

		try {
			ResultSet rs = conexion.query(consulta);
			if (rs.next()) {
				
				transferencia.setId_transferencia(rs.getInt("id"));
				cuentaEmisor.setCbu_cuenta(rs.getString("emisor"));
				cuentaReceptor.setCbu_cuenta(rs.getString("receptor"));
				transferencia.setCbuEmisor_transferencia(cuentaEmisor);
				transferencia.setCbuReceptor_transferencia(cuentaReceptor);
				transferencia.setMonto_transferencia(rs.getFloat("monto"));
				transferencia.setFecha_transferencia(rs.getDate("fecha"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.close();
		}

		return transferencia;
	}

	@Override
	public ArrayList<Transferencia> obtenerTransferencias() {

		conexion.open();
		Transferencia transferencia = new Transferencia();
		Cuenta cuentaEmisor = new Cuenta();
		Cuenta cuentaReceptor = new Cuenta();

		String consulta = "select id_transferencia AS id, cbu_emisor_transferencia AS emisor, cbu_receptor_transferencia AS receptor, monto_transferencia AS monto, fecha_transferencia AS fecha "
		          +"from transferencias;";

		ArrayList<Transferencia> lista = new ArrayList<Transferencia>();

		try {
			ResultSet rs = conexion.query(consulta);

			while (rs.next()) {
				
				transferencia.setId_transferencia(rs.getInt("id"));
				cuentaEmisor.setCbu_cuenta(rs.getString("emisor"));
				cuentaReceptor.setCbu_cuenta(rs.getString("receptor"));
				transferencia.setCbuEmisor_transferencia(cuentaEmisor);
				transferencia.setCbuReceptor_transferencia(cuentaReceptor);
				transferencia.setMonto_transferencia(rs.getFloat("monto"));
				transferencia.setFecha_transferencia(rs.getDate("fecha"));

				lista.add(transferencia);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.close();
		}
		return lista;

	}

}

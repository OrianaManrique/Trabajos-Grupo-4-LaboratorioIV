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
		
		boolean estado = false;

		conexion = new Conexion();
		conexion.open();

		String query = "CALL AltaTransferencia('" +transferencia.getCbu_emisor_transferencia().getCbu_cuenta()+"', '"
		+transferencia.getCbu_receptor_transferencia().getCbu_cuenta()+"', "+transferencia.getMonto_transferencia()+" ,'"+ transferencia.getMotivo()+"')";

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

		String consulta = "select id_transferencia AS Id, cbu_emisor_transferencia AS Emisor, cbu_receptor_transferencia AS Receptor, monto_transferencia AS Monto, "
				          + "fecha_transferencia AS Fecha, motivo_transferencia AS Motivo "
				          +"from transferencias where id_transferencia ="+ id + ";";

		try {
			ResultSet rs = conexion.query(consulta);
			if (rs.next()) {
				
				transferencia.setId_transferencia(rs.getInt("Id"));
				cuentaEmisor.setCbu_cuenta(rs.getString("Emisor"));
				cuentaReceptor.setCbu_cuenta(rs.getString("Receptor"));
				transferencia.setCbuEmisor_transferencia(cuentaEmisor);
				transferencia.setCbuReceptor_transferencia(cuentaReceptor);
				transferencia.setMonto_transferencia(rs.getFloat("Monto"));
				transferencia.setMotivo(rs.getString("Motivo"));
				transferencia.setFecha_transferencia(rs.getDate("Fecha"));
				
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

		String consulta = "select id_transferencia AS Id, cbu_emisor_transferencia AS Emisor, cbu_receptor_transferencia AS Receptor, monto_transferencia AS Monto, "
				  + "fecha_transferencia AS Fecha, motivo_transferencia AS Motivo "
		          +"from transferencias;";

		ArrayList<Transferencia> lista = new ArrayList<Transferencia>();

		try {
			ResultSet rs = conexion.query(consulta);

			while (rs.next()) {
				
				transferencia.setId_transferencia(rs.getInt("Id"));
				cuentaEmisor.setCbu_cuenta(rs.getString("Emisor"));
				cuentaReceptor.setCbu_cuenta(rs.getString("Receptor"));
				transferencia.setCbuEmisor_transferencia(cuentaEmisor);
				transferencia.setCbuReceptor_transferencia(cuentaReceptor);
				transferencia.setMonto_transferencia(rs.getFloat("Monto"));
				transferencia.setMotivo(rs.getString("Motivo"));
				transferencia.setFecha_transferencia(rs.getDate("Fecha"));

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

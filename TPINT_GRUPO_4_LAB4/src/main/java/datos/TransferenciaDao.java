package datos;

import java.util.ArrayList;

import entidad.Transferencia;
public interface TransferenciaDao {
	
	public boolean AgregarTransferencia(Transferencia transferencia);
	public Transferencia obtenerTransferenciaporid(int id);
	public ArrayList<Transferencia> obtenerTransferencias();

}

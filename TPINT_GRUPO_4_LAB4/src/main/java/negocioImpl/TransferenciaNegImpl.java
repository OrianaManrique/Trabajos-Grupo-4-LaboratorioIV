package negocioImpl;
import java.util.ArrayList;
import entidad.Transferencia;
import negocio.TransferenciaNeg;
import datosImpl.TransferenciaDaoImpl;
import datos.TransferenciaDao;

public class TransferenciaNegImpl implements TransferenciaNeg{
	
	private TransferenciaDao trdao = new TransferenciaDaoImpl();

	@Override
	public boolean AgregarTransferencia(Transferencia transferencia) {
		return trdao.AgregarTransferencia(transferencia);
	}

	@Override
	public Transferencia obtenerTransferenciaporid(int id) {
		return trdao.obtenerTransferenciaporid(id);
	}

	@Override
	public ArrayList<Transferencia> obtenerTransferencias() {
		return trdao.obtenerTransferencias();
	}

}

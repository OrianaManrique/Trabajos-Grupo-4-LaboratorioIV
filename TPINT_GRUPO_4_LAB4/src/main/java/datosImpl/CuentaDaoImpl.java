package datosImpl;
import java.sql.ResultSet;
import java.util.ArrayList;

import datos.CuentaDao;
import entidad.Cuenta;
import entidad.Tipo_Cuenta;

public class CuentaDaoImpl implements CuentaDao {

	private Conexion conexion;
	
	public CuentaDaoImpl() {}

	
	public ArrayList<Cuenta> obtenerCuentas() {
		
		conexion = new Conexion();
		conexion.open();
		
		String consulta = ("SELECT c.NroCuenta_Cuenta, c.dni_cliente, c.fecha_creacion_cuenta, "
													+ "c.cbu_cuenta, c.id_TipoCuenta, tc.Descripcion_tipoCuenta, "
													+ "c.saldo_cuenta FROM Cuentas c "
													+ "LEFT JOIN Tipo_Cuentas tc ON c.id_TipoCuenta = tc.id_TipoCuenta");
		
		ArrayList<Cuenta> lista = new ArrayList<Cuenta>();
		
		 try
		 {
			 ResultSet rs= conexion.query(consulta);
			 
			 while(rs.next())
			 {
				Cuenta cuenta = new Cuenta();
				 cuenta.setNroCuenta_cuenta(rs.getString("NroCuenta_Cuenta"));
				 cuenta.setDni_Cliente(rs.getInt("dni_cliente"));
				 cuenta.setFecha_creacion_cuenta(rs.getDate("fecha_creación_cuenta"));
				 cuenta.setCbu_cuenta(rs.getString("cbu_cuenta"));
				 
				 Tipo_Cuenta tipo = new Tipo_Cuenta();
				 
				 tipo.setId_tipoCuenta(rs.getInt("id_TipoCuenta"));
				 tipo.setDescripcion_tipoCuenta(rs.getString("Descripcion_tipoCuenta"));
				 cuenta.setTipo_cuenta(tipo);
				 cuenta.setSaldo_cuenta(rs.getDouble("saldo_cuenta"));
				 
				 lista.add(cuenta);
			 }
			 
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 conexion.close();
		 }
		 return lista;
	}


	
	
}

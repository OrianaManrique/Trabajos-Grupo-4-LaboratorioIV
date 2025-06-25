package entidad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CuentasDao {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bd_banco";
	
	public Cuenta obtenerCuentas() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Cuenta cta = new Cuenta();
		Connection cn = null;
		
		try {
			cn = DriverManager.getConnection(host+dbName, user, pass);
			PreparedStatement ps = cn.prepareStatement("SELECT c.NroCuenta_Cuenta, c.dni_cliente, c.fecha_creación_cuenta, "
													+ "c.cbu_cuenta, c.id_TipoCuenta, tc.Descripcion_tipoCuenta, "
													+ "c.saldo_cuenta, c.estado_cuenta FROM Cuentas c "
													+ "JOIN Tipo_Cuentas tc ON c.id_TipoCuenta = tc.id_TipoCuenta");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				cta.setNroCuenta_cuenta(rs.getString("NroCuenta_Cuenta"));
				cta.setDni_Cliente(rs.getInt("dni_cliente"));
				cta.setFecha_creacion_cuenta(rs.getDate("fecha_creación_cuenta"));
			    cta.setCbu_cuenta(rs.getString("cbu_cuenta"));
			    
			    Tipo_Cuenta tipoCuenta = new Tipo_Cuenta();
			    tipoCuenta.setId_tipoCuenta(rs.getInt("id_TipoCuenta"));
			    tipoCuenta.setDescripcion_tipoCuenta(rs.getString("Descripcion_tipoCuenta"));
			    cta.setTipo_cuenta(tipoCuenta);
			    
			    cta.setSaldo_cuenta(rs.getDouble("saldo_cuenta"));
			    cta.setEstado_cuenta(rs.getBoolean("estado_cuenta"));

			}
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {}
		
		return cta;
	}
}

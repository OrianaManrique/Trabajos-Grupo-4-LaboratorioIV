package datosImpl;
import java.sql.ResultSet;

import datos.ClienteDao;
import entidad.Cliente;

public class ClienteDaoImpl implements ClienteDao{
    
	private Conexion conexion;
	
	@Override
	public boolean insertar(Cliente cliente) {
		
		boolean estado=true;

		conexion = new Conexion();
		conexion.open();	

		String query = "INSERT INTO Clientes (dni_cliente,cuil_cliente,nombre_cliente,apellido_cliente,sexo_cliente,"
				+ "nacionalidad_cliente,fecha_nacimiento_cliente,direccion_cliente,id_localidad_cliente,id_provincia_cliente,"
				+ "correo_electronico_cliente,telefono_cliente,usuario_cliente,contraseña_cliente,estado_cliente) "
				+ "VALUES ('"+cliente.getDni_cliente()+"','"+cliente.getCuil_cliente()+"','"+cliente.getNombre_cliente()+"', "
				+ cliente.getApellido_cliente()+ "','" + cliente.getSexo_cliente() + "','" + cliente.getNacionalidad_cliente() + "','" 
				+ cliente.getFecha_nacimiento_cliente() + cliente.getDireccion_cliente() + cliente.getId_localidad() 
				+ cliente.getId_provincia() + cliente.getCorreo_electronico_cliente() + cliente.getTelefono_cliente() 
				+ cliente.getUsuario_cliente() + cliente.getContraseña_cliente() + cliente.getEstado()+")";
		
		try
		 {
			estado=conexion.execute(query);
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			conexion.close();
		}
		return estado;
	}

public Cliente obtenerCliente(int dni) {
		
		Cliente cliente= new Cliente();

		conexion = new Conexion();
		conexion.open();	

		/*agregar filtro de estado=1*/
		String consulta = "select dni_cliente, nombre_cliente, apellido_cliente\r\n"
				+ "		from clientes\r\n"
				+ "		where dni_cliente = " +dni;
				
		try
		 {
			ResultSet rs =conexion.query(consulta);
			if (rs.next()) {
			cliente.setDni_cliente(rs.getInt("dni_cliente"));
			cliente.setNombre_cliente(rs.getString("nombre_cliente"));
			cliente.setApellido_cliente(rs.getString("apellido_cliente"));
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
		
		return cliente;
	}
}

package datosImpl;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import datos.ClienteDao;
import entidad.Cliente;
import entidad.Cuenta;
import entidad.Localidad;
import entidad.Provincia;
import entidad.Tipo_Cuenta;

public class ClienteDaoImpl implements ClienteDao {

	private Conexion conexion;

	@Override
	public boolean insertar(Cliente cliente) {

		boolean estado = true;

		Localidad localidad = new Localidad();
		Provincia provincia = new Provincia();

		localidad = cliente.getLocalidad();
		provincia = cliente.getProvincia();

		conexion = new Conexion();
		conexion.open();

		String query = "INSERT INTO Clientes (dni_cliente, cuil_cliente, nombre_cliente, apellido_cliente, sexo_cliente, "
				+ "nacionalidad_cliente, fecha_nacimiento_cliente, direccion_cliente, id_localidad_cliente, id_provincia_cliente, "
				+ "correo_electronico_cliente, telefono_cliente, usuario_cliente, contraseña_cliente, estado_cliente) "
				+ "VALUES ('" + cliente.getDni_cliente() + "', '" + cliente.getCuil_cliente() + "', '"
				+ cliente.getNombre_cliente() + "', '" + cliente.getApellido_cliente() + "', '"
				+ cliente.getSexo_cliente() + "', '" + cliente.getNacionalidad_cliente() + "', '"
				+ cliente.getFecha_nacimiento_cliente() + "', '" + cliente.getDireccion_cliente() + "', "
				+ localidad.getId_localidad() + ", " + provincia.getId_provincia() + ", '"
				+ cliente.getCorreo_electronico_cliente() + "', '" + cliente.getTelefono_cliente() + "', '"
				+ cliente.getUsuario_cliente() + "', '" + cliente.getContraseña_cliente() + "', '" + 1 + "')";

		try {
			estado = conexion.execute(query);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.close();
		}
		return estado;
	}

	public Cliente obtenerCliente(int dni) {
		
		Localidad localidad = new Localidad();
		Provincia provincia = new Provincia();


		Cliente cliente = new Cliente();

		conexion = new Conexion();
		conexion.open();

		/* agregar filtro de estado=1 */
		String consulta = "select * \r\n" + " from clientes\r\n"
				+ "		where dni_cliente = " + dni;

		try {
			ResultSet rs = conexion.query(consulta);
			if (rs.next()) {
				
				cliente.setDni_cliente(rs.getInt("dni_cliente"));
				cliente.setNombre_cliente(rs.getString("nombre_cliente"));
				cliente.setApellido_cliente(rs.getString("apellido_cliente"));			
				cliente.setCuil_cliente(rs.getInt("cuil_cliente"));
				cliente.setSexo_cliente(rs.getString("sexo_cliente"));
				provincia.setId_provincia(rs.getInt("id_provincia_cliente"));
				localidad.setId_localidad(rs.getInt("id_localidad_cliente"));
				cliente.setFecha_nacimiento_cliente(rs.getDate("fecha_nacimiento_cliente"));
				cliente.setProvincia(provincia);
				cliente.setLocalidad(localidad);
				cliente.setNacionalidad_cliente(rs.getString("nacionalidad_cliente"));
				cliente.setCorreo_electronico_cliente(rs.getString("correo_electronico_cliente"));
				cliente.setDireccion_cliente(rs.getString("direccion_cliente"));
				cliente.setTelefono_cliente(rs.getString("telefono_cliente"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.close();
		}

		return cliente;
	}

	@Override
	public boolean borrar(int dni) {

		boolean estado = false;

		try {
			conexion = new Conexion();
			conexion.open();
			String query = "UPDATE clientes SET estado_cliente=0 WHERE dni_cliente = " + dni;

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
	public ArrayList<Cliente> obtenerClientes() {
		conexion = new Conexion();
		conexion.open();

		String consulta = ("Select dni_cliente , nombre_cliente , apellido_cliente , cuil_cliente , correo_electronico_cliente  from clientes where estado_cliente=1");

		ArrayList<Cliente> lista = new ArrayList<Cliente>();

		try {
			ResultSet rs = conexion.query(consulta);

			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setDni_cliente(rs.getInt("dni_cliente"));
				cliente.setNombre_cliente(rs.getString("nombre_cliente"));
				cliente.setApellido_cliente(rs.getString("apellido_cliente"));
				cliente.setCuil_cliente(rs.getInt("cuil_cliente"));
				cliente.setCorreo_electronico_cliente(rs.getString("correo_electronico_cliente"));

				lista.add(cliente);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexion.close();
		}
		return lista;

	}

	@Override
	public boolean editar(Cliente cliente) {
	    boolean estado = true;

	    conexion = new Conexion();
	    conexion.open();

	    String query = "UPDATE clientes SET nombre_cliente='" + cliente.getNombre_cliente() + "', "
	    	    + "cuil_cliente='" + cliente.getCuil_cliente() + "', "
	    	    + "apellido_cliente='" + cliente.getApellido_cliente() + "', "
	    	    + "sexo_cliente='" + cliente.getSexo_cliente() + "', "
	    	    + "nacionalidad_cliente='" + cliente.getNacionalidad_cliente() + "', "
	    	    + "fecha_nacimiento_cliente='" + cliente.getFecha_nacimiento_cliente() + "', "
	    	    + "direccion_cliente='" + cliente.getDireccion_cliente() + "', "
	    	    + "id_localidad_cliente='" + cliente.getLocalidad().getId_localidad() + "', "
	    	    + "id_provincia_cliente='" + cliente.getProvincia().getId_provincia() + "', "
	    	    + "correo_electronico_cliente='" + cliente.getCorreo_electronico_cliente() + "', "
	    	    + "telefono_cliente='" + cliente.getTelefono_cliente() + "', "
	    	    + "usuario_cliente='" + cliente.getUsuario_cliente() + "', "
	    	    + "contraseña_cliente='" + cliente.getContraseña_cliente() + "' "
	    	    + "WHERE dni_cliente='" + cliente.getDni_cliente() + "'";

	    try {
	        estado = conexion.execute(query);
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        conexion.close();
	    }
	    return estado;
	}
}

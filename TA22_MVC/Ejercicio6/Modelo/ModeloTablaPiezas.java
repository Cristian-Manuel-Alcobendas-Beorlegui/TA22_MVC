package Modelo;

//Importar librerias
import java.sql.SQLException;
import java.sql.Statement;

public class ModeloTablaPiezas {
	// Atributos de la clase
	private ModeloConnBD conn = new ModeloConnBD();
	private String nombreTabla = "piezas", mensaje;
	
	// ---------------------------------------------------------------- //
	
	// Métodos y funciones
	
	// FUNCIÓN 1: Crear la tabla
	public String crearTabla() {
		// Variables
		String consulta;
		
		// Intentar ejecutar el código
		try {
			// Abrir la conexión
			conn.abrirConexion();
			
			// Indicar que base de datos utilizar.
			consulta = "USE " + conn.getNombreBD() + ";";
			Statement stbd = conn.conexion.createStatement();
			stbd.executeUpdate(consulta);
			
			// Crear y ejecutar la consulta que eliminará la tabla "proveedores" si es que existe.
			consulta = "DROP TABLE IF EXISTS " + nombreTabla + ";";
			Statement st = conn.conexion.createStatement();
			st.execute(consulta);
			
			
			// Crear y ejecutar la consulta que creará la tabla "proveedores"
			consulta = "CREATE TABLE " + nombreTabla + " ("
					+ "id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,"
					+ "nombre VARCHAR(100) NOT NULL"
					+ ");";
			Statement st2= conn.conexion.createStatement();
			st2.executeUpdate(consulta);
			mensaje = "Se ha creado la tabla (" + nombreTabla + ").";
			
			// Cerrar la conexión
			conn.cerrarConexion();
		}
		
		// Control de errores
		catch(SQLException ex) {
			mensaje = "Ha habido un error, es posible que alguna de las tablas no haya sido creada.";
		} // Fin CATCH
		
		// Devolver el valor de mensaje
		return mensaje;
	}
	
	
	// FUNCIÓN 2: Añadir datos a la tabla
	public String añadirDatos(String nombreProveedor) {
		// Variables
		String consulta;
		
		// Intentar ejecutar el código
		try {
			// Abrir la conexión
			conn.abrirConexion();
			
			// Indicar que base de datos usar
			consulta = "USE " + conn.getNombreBD() + ";";
			Statement stbd = conn.conexion.createStatement();
			stbd.executeUpdate(consulta);
			
			// Insertar los datos en la base de datos
			consulta = "INSERT INTO " + nombreTabla + "(nombre) VALUES('" + nombreProveedor + "')";
			Statement st = conn.conexion.createStatement();
			st.executeUpdate(consulta);
			
			// Mostrar un mensaje por pantalla que indique que los datos se han añadido
			mensaje = "Se han añadido datos en la tabla (" + nombreTabla + ").";
			
			// Cerrar la conexión
			conn.cerrarConexion();
		} // Fin TRY
		
		// Control de errores
		catch(SQLException ex) {
			mensaje = "No se ha podido añadir los datos en la tabla (" + nombreTabla + ").";
		}
		
		// Devolver el mensaje
		return mensaje;
	}
	
	
	// FUNCIÓN 3: Mostrar datos por pantalla
	public String mostrarDatos() {
		// Variables
		String consulta;

		// Intentar ejecutar código
		try {
			// Abrir conexión
			conn.abrirConexion();

			// Indicar que base de datos hay que usar
			consulta = "USE " + conn.getNombreBD() + ";";
			Statement stbd = conn.conexion.createStatement();
			stbd.executeUpdate(consulta);

			// Consulta para coneguir todos los resultados de la tabla
			consulta = "SELECT * FROM " + nombreTabla + ";";

			// Guardar los resultados
			Statement st = conn.conexion.createStatement();
			java.sql.ResultSet listaResultados;
			listaResultados = st.executeQuery(consulta);

			// Mostrar los datos de la consulta por pantalla
			System.out.println("ID Pieza | Nombre");
			while (listaResultados.next()) {
				System.out.println(listaResultados.getString("id") + " | " + listaResultados.getString("nombre"));
			}
			mensaje = "[OK]";
			
			// Cerrar conexión
			conn.cerrarConexion();
		} // Fin TRY

		// Control de errores
		catch (SQLException ex) {
			mensaje = "No se ha podido mostrar los datos de la tabla (" + nombreTabla + ").";
		} // Fin CATCH
		
		// Devolver el valor de mensaje
		return mensaje;
	}

	
	// FUNCIÓN 4: Eliminar datos
	public String eliminarDatos(int id) {
		// Variables
		String consulta;

		// Intentar ejecutar código
		try {
			// Abrir conexión
			conn.abrirConexion();

			// Indicar que base de datos hay que usar
			consulta = "USE " + conn.getNombreBD() + ";";
			Statement stbd = conn.conexion.createStatement();
			stbd.executeUpdate(consulta);

			// Consulta para eliminar un registro de la tabla
			consulta = "DELETE FROM " + nombreTabla + " WHERE id=" + id + ";";
			Statement st = conn.conexion.createStatement();
			st.executeUpdate(consulta);
			
			// Mostrar un mensaje por pantalla
			mensaje = "Se ha eliminado el registro con ID (" + id + ").";
			
			// Cerrar conexión
			conn.cerrarConexion();
		} // Fin TRY

		// Control de errores
		catch (SQLException ex) {
			mensaje = "No se ha podido eliminar el registro. Comprueba que el registro no forme parte de alguna clave foránea.";
		} // Fin CATCH
		
		// Devolver el valor de "mensaje"
		return mensaje;
	}
	
	
	// FUNCIÓN 5: Actualizar los datos de la tabla
	public String actualizarDatos(int id, String nombre) {
		// Variables
		String consulta;

		// Intentar ejecutar código
		try {
			// Abrir conexión
			conn.abrirConexion();

			// Indicar que base de datos hay que usar
			consulta = "USE " + conn.getNombreBD() + ";";
			Statement stbd = conn.conexion.createStatement();
			stbd.executeUpdate(consulta);

			// Consulta para actualizar los datos de la tabla
			consulta = "UPDATE " + nombreTabla + " SET nombre='"+ nombre + "' WHERE id=" + id + ";";
			Statement st = conn.conexion.createStatement();
			st.executeUpdate(consulta);
			
			// Mostrar un mensaje por pantalla
			mensaje = "Se ha actualizado el producto con ID (" + id + ").";
			
			// Cerrar conexión
			conn.cerrarConexion();
		} // Fin TRY

		// Control de errores
		catch (SQLException ex) {
			mensaje = "No se ha podido mostrar los datos de la tabla (" + nombreTabla + ").";
		} // Fin CATCH
		
		// Devolver el valor de mensaje
		return mensaje;
	}
	
	// ---------------------------------------------------------------- //
	// Fin de la clase
	
}

package Modelo;

// Importar librerias
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ModeloConnBD {
	// Atributos de la clase
	public Connection conexion;
	private String mensaje;
	private final String NOMBRE_BD = "ejercicio6";

	// -------------------------------------------------------------------------- // 
	
	// Métodos y funciones
	
	// MÉTODO 1: Abrir la conexión con la base de datos
	public String abrirConexion() {
		// Intentar ejecutar el código
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306", "Necrozma", "#~01UltraNecrozma04~#");
			// System.out.println("Conexión establecida.");
		} // Fin TRY

		// Control de errores
		catch (SQLException | ClassNotFoundException ex) {
			mensaje = "No se ha podido establecer conexión con la base de datos.";
			System.out.println(ex);
		} // Fin CATCH
		
		// Devolver el mensaje
		return mensaje;
	}
	
	// MÉTODO 2: Cerrar la conexión
	// Intentar ejecutar el código
	public String cerrarConexion() {
		// Intentar ejecutar el código
		try {
			conexion.close();
			// System.out.println("Se ha cerrado la conexión.");
		} // Fin TRY

		// Control de errores
		catch (SQLException ex) {
			mensaje = "Ha habido un error.";
		} // Fin CATCH
		
		// Devolver el mensaje
		return mensaje;
	}
	
	// -------------------------------------------------------------------------- // 
	
	// Getters y setters
	// Atributo 1: NombreBD
	public String getNombreBD() {
		return NOMBRE_BD;
	}
	
	// Atributo 2: Conexión
	public Connection getConexion() {
		return conexion;
	}
	
	// -------------------------------------------------------------------------- // 
	
	// Fin de la clase
}

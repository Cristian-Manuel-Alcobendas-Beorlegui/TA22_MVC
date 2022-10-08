package Vista;

// Importar librerias
import java.util.Scanner;

public class VistaTablaProveedores {
	// Atributos de la clase
	Scanner sc = new Scanner(System.in);
	
	// --------------------------------------------------------------------------- //
	
	// Métodos y funciones
	// FUNCIÓN 1: Preguntar al usuario el ID del registro que quiere eliminar
	public int eliminarRegistro() {
		// Variables
		int id;
		
		// Preguntar al usuario el registro
		System.out.println("Introduce el ID de proveedor del registro que quieres eliminar.");
		System.out.print("Opción: ");
		id = sc.nextInt();
		
		// Devolver el valor de la variable "ID"
		return id;
	}
	
	// FUNCIÓN 2: Preguntar al usuario el ID del regitro que quiere actualizar
	public int actualizarRegistro() {
		// Variables
		int id;
		
		// Preguntar al usuario por el ID
		System.out.println("Introduce el ID del proveedor que quieres actualizar.");
		System.out.print("Opción: ");
		id = sc.nextInt();
		
		// Devolver el valor de "id"
		return id;
	}
	
	// FUNCIÓN 3: Actualizar el nombre
	public String nuevoNombre() {
		// Variables
		String nombre;
		
		// Limpiar el buffer
		System.out.println("Si no se muestra mas información presiona [ENTER]");
		sc.nextLine();
		
		// Preguntar al usuario el nombre del nuevo producto
		System.out.println("Introduce el nuevo nombre del proveedor.");
		System.out.print("Nuevo nombre: ");
		nombre = sc.nextLine();
	
		// Devolver el valor de "nombre"
		return nombre;
	}

	// --------------------------------------------------------------------------- //
}

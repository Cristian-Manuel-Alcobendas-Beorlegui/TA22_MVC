package Vista;

// Importar librerias
import java.util.Scanner;

public class VistaTablaSuministra {
	// Atributos de la clase
	Scanner sc = new Scanner(System.in);
	
	// --------------------------------------------------------------------------- //
	
	// Métodos y funciones
	// FUNCIÓN 1: Nuevo precio
	public double nuevoPrecio() {
		// Variables
		double precio;
		
		// Preguntar al usuario el nuevo precio
		System.out.println("Introduce el nuevo precio del producto.");
		System.out.print("Nuevo precio: ");
		precio = sc.nextDouble();
		
		// Devolver el valor de la variable "precio"
		return precio;
	}
	
	// FUNCIÓN 2: ID Pieza
	public int nuevoIDPieza() {
		// Variables
		int idPieza;
		
		// Preguntar al usuario el nuevo ID
		System.out.print("Introduce el ID de la pieza: ");
		idPieza = sc.nextInt();
		
		// Devolver el valor de ID Pieza
		return idPieza;
	}
	
	// FUNCIÓN 2: ID Proveedor
	public int nuevoIDProveedor() {
		// Variables
		int idProveedor;
		
		// Preguntar al usuario el nuevo ID
		System.out.print("Introduce el ID del proveedor: ");
		idProveedor = sc.nextInt();
		
		// Devolver el valor de ID Pieza
		return idProveedor;
	}
	
	// --------------------------------------------------------------------------- //

}

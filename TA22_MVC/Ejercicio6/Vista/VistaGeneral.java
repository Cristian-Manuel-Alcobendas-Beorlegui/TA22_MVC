package Vista;

// Importar librerias
import java.util.Scanner;

public class VistaGeneral {
	// Atributos de la clase
	private String[] menu = {"Crear otra vez la tabla", "Mostrar los datos de la tabla", "Añadir datos", "Eliminar los datos de la tabla", "Actualizar los datos de la tabla", "Cambiar de tabla", "Salir"};
	private String[] tablas = {"piezas", "proveedores", "suministra"};
	private Scanner sc = new Scanner(System.in);
	
	// ------------------------------------------------------------------- //
	
	// Métodos y funciones
	// FUNCIÓN 1: Mostrar el menú y el usuario elige la opción
	public int opcionMenu() {
		// Variables
		int i, opcion;
		
		// Mostrar el menú por pantalla
		for(i = 0; i < menu.length; i++) {
			System.out.println("   " + (i+1) + ". " + menu[i]);
		}
		
		// Aplicar un salto de línea
		System.out.println();
		
		// Pedir al usuario la opción
		System.out.print("Opción: ");
		opcion = sc.nextInt();
		
		// Devolver el valor de "opción"
		return opcion;
	}
	
	
	// FUNCIÓN 2: Devolver la longitud del vecto
	public int longitudMenu() {
		// Variables
		int longitud;
		
		// Guardar la longitud
		longitud = menu.length;
		
		// Devolver el valor de "longitud"
		return longitud;
	}
	
	
	// MÉTODO 1: Mostrar un mensaje
	public void mostrarMensaje(String mensaje) {
		// Mostrar el mensaje por pantalla
		System.out.println(mensaje);
	}
	
	// FUNCIÓN 3: Mostrar las diferentes tablas
	public int opcionTabla() {
		// Variables
		int i, opcion;
		
		// Mostrar el menú por pantalla
		for(i = 0; i < tablas.length; i++) {
			System.out.println("   " + (i+1) + ". " + tablas[i]);
		}
		
		// Aplicar un salto de línea
		System.out.println();
		
		// Pedir al usuario la opción
		System.out.print("Opción: ");
		opcion = sc.nextInt();
		
		// Si la opción no es correcta, se establecerá el valor por defecto
		if(opcion <= 0 || opcion > tablas.length) {
			opcion = 1; // La opción por defecto
		}
		
		// Devolver el valor de "opción"
		return opcion;
	}
	
	// ------------------------------------------------------------------- //


	
}

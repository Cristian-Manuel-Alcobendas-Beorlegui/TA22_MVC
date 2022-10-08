package Controlador;

// Importar clases y librerias
import Modelo.*;
import Vista.*;

public class Controlador {

	public static void main(String[] args) {
		// 1. Variables y Objetos
		String nombre, mensaje;
		int opcion, opcionTabla = 1, idPieza, idProveedor;
		double precio;
		String[] tablas = {"piezas", "proveedores", "suministra"};
		
		// Objetos de MODELO
		ModeloTablaPiezas modTabPiezas = new ModeloTablaPiezas();
		ModeloTablaProveedores modTabProveedores = new ModeloTablaProveedores();
		ModeloTablaSuministra modTabSuministra = new ModeloTablaSuministra();
		
		// Objetos de VISTA
		VistaGeneral visGen = new VistaGeneral();
		VistaTablaPiezas visTabPiezas = new VistaTablaPiezas();
		VistaTablaProveedores visTabProveedores = new VistaTablaProveedores();
		VistaTablaSuministra visTabSuministra = new VistaTablaSuministra();
		
		
		// 2. Bucle DO-WHILE con la opciones y funcionalidades del menú
		do {
			// Mostrar y guardar la opción del usuario
			visGen.mostrarMensaje("TABLA ACTUAL: " + tablas[opcionTabla-1]);
			visGen.mostrarMensaje("Menú:");
			opcion = visGen.opcionMenu();
			visGen.mostrarMensaje("");
			switch(opcion) {
				case 1: // Crear la tabla otra vez
					visGen.mostrarMensaje("1. Volver a crear la tabla");
					
					// Sentencia SWITCH con las opciones de tablas
					switch(opcionTabla) {
						case 1: // TABLA: piezas
							mensaje = modTabPiezas.crearTabla();
							visGen.mostrarMensaje(mensaje);
							break;
						
						case 2: // Tabla: proveedores
							mensaje = modTabProveedores.crearTabla();
							visGen.mostrarMensaje(mensaje);
							break;
							
						case 3: // Tabla: suministra
							mensaje = modTabProveedores.crearTabla();
							visGen.mostrarMensaje(mensaje);
							break;
						
					} // Fin SWITCH
					break;
					
				case 2: // Mostrar los datos de la tabla
					visGen.mostrarMensaje("2. Mostrar los datos de la tabla");
					
					// Sentencia SWITCH con las opciones de las tablas
					switch(opcionTabla) {
						case 1: // TABLA: piezas
							mensaje = modTabPiezas.mostrarDatos();
							visGen.mostrarMensaje(mensaje);
							break;
						
						case 2: // Tabla: proveedores
							mensaje = modTabProveedores.mostrarDatos();
							visGen.mostrarMensaje(mensaje);
							break;
							
						case 3: // Tabla: suministra
							mensaje = modTabSuministra.mostrarDatos();
							visGen.mostrarMensaje(mensaje);
							break;
							
					} // Fin SWITCH
					break;
				
					
				case 3: // Añadir datos a la tabla
					visGen.mostrarMensaje("3. Insertar datos en la tabla");
					
					// Sentencia SWITCH con las opciones de las tablas
					switch(opcionTabla) {
						case 1: // TABLA: piezas
							// Pedir al usuario el nombre de la pieza
							nombre = visTabPiezas.nuevoNombre();
							
							// Añadir el registro
							mensaje = modTabPiezas.añadirDatos(nombre);
							
							// Mostrar un mensaje
							visGen.mostrarMensaje(mensaje);
							break;
						
						case 2: // Tabla: proveedores
							// Pedir al usuario el nombre del proveedor
							nombre = visTabProveedores.nuevoNombre();
							
							// Añadir el registro
							mensaje = modTabProveedores.añadirDatos(nombre);
							
							// Mostrar un mensaje
							visGen.mostrarMensaje(mensaje);
							break;
							
						case 3: // Tabla: suministra
							// Pedir al usuario datos
							idPieza = visTabSuministra.nuevoIDPieza();
							idProveedor = visTabSuministra.nuevoIDProveedor();
							precio = visTabSuministra.nuevoPrecio();
							
							// Añadir los datos
							mensaje = modTabSuministra.añadirDatos(idPieza, idProveedor, precio);
							
							// Mostrar un mensaje por pantalla
							visGen.mostrarMensaje(mensaje);
							break;
							
					} // Fin SWITCH
					break;
				
				case 4: // Eliminar los datos de la tabla
					visGen.mostrarMensaje("4. Eliminar datos de la tabla");
					
					// Sentencia SWITCH con las opciones de las tablas
					switch(opcionTabla) {
						case 1: // TABLA: piezas
							// Preguntar y guardar el ID del registro a eliminar.
							idPieza = visTabPiezas.eliminarRegistro();
							
							// Eliminar el registro
							mensaje = modTabPiezas.eliminarDatos(idPieza);
							
							// Mostrar el mensaje por pantalla
							visGen.mostrarMensaje(mensaje);
							break;
						
						case 2: // Tabla: proveedores
							// Preguntar y guardar el ID del registro a eliminar.
							idProveedor = visTabProveedores.eliminarRegistro();
							
							// Eliminar el registro de la base de datos
							mensaje = modTabProveedores.eliminarDatos(idProveedor);
							
							// Mostrar el "mensaje"
							visGen.mostrarMensaje(mensaje);
							break;
							
						case 3: // Tabla: suministra
							// Preguntar y guardar el ID de pieza y el ID de proveedor
							idPieza = visTabPiezas.eliminarRegistro();
							idProveedor = visTabProveedores.eliminarRegistro();
							
							// Eliminar el registro
							mensaje = modTabSuministra.eliminarDatos(idPieza, idProveedor);
							
							// Mostrar el mensaje
							visGen.mostrarMensaje(mensaje);
							break;
						
					} // Fin SWITCH
					break;
					
				case 5: // Actualizar los datos de la tabla
					visGen.mostrarMensaje("6. Actualizar los datos de la tabla");
					
					// Sentencia SWITCH con las diferentes tablas
					switch(opcionTabla) {
						case 1: // TABLA: piezas
							// Pedir al usuario el ID del registro que quiere actualizar y los nuevos datos
							idPieza = visTabPiezas.actualizarRegistro();
							nombre = visTabPiezas.nuevoNombre();
							
							// Actualizar el registro
							mensaje = modTabPiezas.actualizarDatos(idPieza, nombre);
							
							// Mostrar un mensaje por pantalla
							visGen.mostrarMensaje(mensaje);
							break;
						
						case 2: // Tabla: proveedores
							// Pedir al usuario el ID del registro que quiere actualizar y los nuevos datos
							idProveedor = visTabProveedores.actualizarRegistro();
							nombre = visTabProveedores.nuevoNombre();
							
							// Actualizar el registro
							mensaje = modTabProveedores.actualizarDatos(idProveedor, nombre);
							
							// Mostrar mensaje por pantalla
							visGen.mostrarMensaje(mensaje);
							break;
						
					case 3: // Tabla: suministra
						// Pedir al usuario el ID del registro que quiere actualizar y los nuevos datos
						idPieza = visTabPiezas.actualizarRegistro();
						idProveedor = visTabProveedores.actualizarRegistro();
						precio = visTabSuministra.nuevoPrecio();
						
						// Actualizar los datos
						mensaje = modTabSuministra.actualizarDatos(idPieza, idProveedor, precio);
						
						// Mostrar mensaje por pantalla
						visGen.mostrarMensaje(mensaje);
						break;
					} // Fin SWITCH
					break;
					
				case 6: // Cambiar de tabla
					visGen.mostrarMensaje("6. Cambiar la tabla");
					opcionTabla = visGen.opcionTabla();
					break;
					
				case 7: // Salir del programa
					visGen.mostrarMensaje("Fin del programa.");
					break;
					
				default: // Opción por defecto
					visGen.mostrarMensaje("ERROR: La opción introducida no es correcta.");
			} // Fin SWITCH
			visGen.mostrarMensaje("\n");
		} while(opcion != visGen.longitudMenu());
	}
}

/**
 * 
 */
package servicios;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import biblioteca.inicio;

/**
 * 
 */
public class menuImplementacion implements menuInterface {
	Scanner sc = new Scanner(System.in);

	private void escribirEnFicheroLog(String mensajeLog) throws IOException {
		try (PrintWriter printWriter = new PrintWriter(new FileWriter(inicio.ficheroLog, true))) {
			printWriter.println(mensajeLog);
		}
	}

	@Override
	public int MenuPrincipal() throws IOException {
		System.out.println("------------------------");
		System.out.println("0. Cerrar menu");
		System.out.println("1. Dar alta biblioteca");
		System.out.println("2. Dar alta cliente");
		System.out.println("3. Dar alta libro");
		System.out.println("4. Menu Prestamo");
		System.out.println("Seleccione una opcion");
		System.out.println("------------------------");
		int seleccionUsuario = sc.nextInt();
		return seleccionUsuario;
	}

	@Override
	public void MenuPrestamo() throws IOException {
		operativaInterface oi = new operativaImplementacion();

		int opcionSeleccionada;
		boolean esCerrado = false;

		do {

			opcionSeleccionada = MenuPrincipalPrestamo();
			String mensajeLog = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
					.concat(" - Opcion Menu Prestamo: ").concat(String.valueOf(opcionSeleccionada));
			switch (opcionSeleccionada) {
			case 0:
				System.out.println("Volver");
				mensajeLog += " - Volver";
				esCerrado = true;
				break;
			case 1:
				mensajeLog += " - Prestamo";
				oi.Prestamo();
				break;
			case 2:
				mensajeLog += " - Devolucion";
				oi.Devolucion();
				break;
			default:
				mensajeLog += " - Opcion no valida";
				System.out.println("La opcion seleccionada no es valida");
				break;
			}
			escribirEnFicheroLog(mensajeLog);

		} while (!esCerrado);

	}

	private int MenuPrincipalPrestamo() throws IOException {
		System.out.println("------------------------");
		System.out.println("Menu principal prestamo");
		System.out.println("0. volver");
		System.out.println("1. Prestamo");
		System.out.println("2. devolucion");
		System.out.println("Seleccione una opcion");
		System.out.println("------------------------");
		int seleccionUsuario = sc.nextInt();
		return seleccionUsuario;
	}

}

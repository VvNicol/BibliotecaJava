/**
 * 
 */
package utils;

import java.util.Scanner;

import biblioteca.inicio;
import dtos.bibliotecaDto;
import dtos.clienteDto;
import dtos.libroDto;

/**
 * 
 */
public class utils {
	static Scanner sc = new Scanner(System.in);

	public static long generarIdBiblioteca() {
		long nuevoId = 0;
		int tamanio = inicio.bibliotecaLista.size();

		if (tamanio > 0) {
			nuevoId = inicio.bibliotecaLista.get(tamanio - 1).getIdBiblioteca() + 1;
		} else {
			nuevoId = 1;
		}
		return nuevoId;
	}

	public static long generarIdCliente() {
		long nuevoId = 0;
		int tamanio = inicio.clienteLista.size();

		if (tamanio > 0) {
			nuevoId = inicio.clienteLista.get(tamanio - 1).getIdCliente() + 1;
		} else {
			nuevoId = 1;
		}
		return nuevoId;
	}

	public static long generarIdLibro() {
		long nuevoId = 0;
		int tamanio = inicio.libroLista.size();

		if (tamanio > 0) {
			nuevoId = inicio.libroLista.get(tamanio - 1).getIdLibro() + 1;
		} else {
			nuevoId = 1;
		}
		return nuevoId;
	}

	public static void MostrarBibliotecas() {
		if (inicio.bibliotecaLista.size() > 0) {
			for (bibliotecaDto bi : inicio.bibliotecaLista) {
				System.out.println(bi.toString());
			}
		} else {
			System.out.println("No hay bibliotecas habilitadas");
		}
	}

	public static void MostrarCliente() {
		if (inicio.clienteLista.size() > 0) {
			for (clienteDto cli : inicio.clienteLista) {
				System.out.println(cli.toString());
				System.out.println("-----------------");

			}
		} else {
			System.out.println("No hay bibliotecas habilitadas");
		}
	}
	
	public static void MostrarLibros() {
		if (inicio.libroLista.size() > 0) {
			for (libroDto lib : inicio.libroLista) {
				System.out.println(lib.toString());
			}
		} else {
			System.out.println("No hay bibliotecas habilitadas");
		}
	}

	public static String verificarDni() {
		String dniCliente = "";
		boolean esValidoDni = false;

		do {
			System.out.println("Ingrese su dni (8 digitos)");
			int dniDigitos = sc.nextInt();

			System.out.println("Ingrese la letra de su dni (ej: z)");
			char letraDni = Character.toUpperCase(sc.next().charAt(0));

			int[] resto = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22 };
			char[] letras = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V',
					'H', 'L', 'C', 'K', 'E' };

			int divisor = 23;
			int operacion = dniDigitos % divisor;

			int posicionResto = resto[operacion];

			if (letraDni == letras[posicionResto]) {

				System.out.println("DNI válido");
				esValidoDni = true;
				dniCliente = String.valueOf(dniDigitos).concat(String.valueOf(letraDni));
			} else {
				esValidoDni = false;
				System.out.println("No es valido Intentelo otravez");
			}

		} while (!esValidoDni);
		return dniCliente;
	}
}

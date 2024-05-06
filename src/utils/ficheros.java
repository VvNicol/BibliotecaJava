package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import biblioteca.inicio;
import dtos.bibliotecaDto;
import dtos.clienteDto;
import dtos.libroDto;
import dtos.prestamoDto;

public class ficheros {

	public static void crearFicheros() {
		try {
			File bibliotecaFichero = new File(inicio.bibliotecaFichero);
			File clienteFichero = new File(inicio.clienteFichero);
			File libroFichero = new File(inicio.libroFichero);
			File prestamoFichero = new File(inicio.prestamoFichero);

			if (!bibliotecaFichero.exists()) {
				System.out.println("Creando archivos");
				bibliotecaFichero.createNewFile();
			}
			if (!clienteFichero.exists()) {
				clienteFichero.createNewFile();
			}
			if (!libroFichero.exists()) {
				libroFichero.createNewFile();
			}
			if (!prestamoFichero.exists()) {
				prestamoFichero.createNewFile();
			}

		} catch (Exception e) {
			System.out.println("Ha ocurido un error: ".concat(e.getMessage()));
			e.printStackTrace();
		}
	}

	public static void guardarLineasBibliotecasFichero() {
		try {

			Set<String> entradasExistentes = new HashSet<>();
			try (BufferedReader reader = new BufferedReader(new FileReader(inicio.bibliotecaFichero))) {
				String linea;
				while ((linea = reader.readLine()) != null) {
					entradasExistentes.add(linea.trim());
				}
			}

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(inicio.bibliotecaFichero, true))) {
				for (bibliotecaDto bi : inicio.bibliotecaLista) {
					String nuevaEntrada = String.valueOf(bi.getIdBiblioteca()).concat(";")
							.concat(bi.getNombreBiblioteca()).concat(";").concat(bi.getDireccionBiblioteca());
					if (!entradasExistentes.contains(nuevaEntrada)) {
						bw.write(nuevaEntrada);
						bw.newLine();
						System.out.println("Datos agregados al archivo de bibliotecas.");
					}
				}
			}

		} catch (Exception e) {
			System.out.println("Ha ocurido un error: ".concat(e.getMessage()));
			e.printStackTrace();
		}
	}

	public static void guardarLineasClienteFichero() {
		try {

			Set<String> entradasExistentes = new HashSet<>();
			try (BufferedReader reader = new BufferedReader(new FileReader(inicio.clienteFichero))) {
				String linea;
				while ((linea = reader.readLine()) != null) {
					entradasExistentes.add(linea.trim());
				}
			}

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(inicio.clienteFichero, true))) {
				for (clienteDto cli : inicio.clienteLista) {
					String nuevaEntrada = String.valueOf(cli.getIdCliente()).concat(";")
							.concat(String.valueOf(cli.getIdBibliotecaCliente())).concat(";")
							.concat(cli.getNombreCliente()).concat(";").concat(cli.getApellido1Cliente()).concat(";")
							.concat(cli.getApellido2Cliente()).concat(";")
							.concat(cli.getFechaNac().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))).concat(";")
							.concat(cli.getDniCompleto()).concat(";").concat(cli.getEmailCliente()).concat(";")
							.concat(String.valueOf(cli.isEstadoSuspencion())).concat(";")
							.concat(cli.getInicioSuspencion()
									.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")))
							.concat(";")
							.concat(cli.getFinSuspencion().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
					if (!entradasExistentes.contains(nuevaEntrada)) {
						bw.write(nuevaEntrada);
						bw.newLine();
					}
				}
			}

		} catch (Exception e) {
			System.out.println("Ha ocurido un error: ".concat(e.getMessage()));
			e.printStackTrace();
		}
	}

	public static void guardarLineasLibroFichero() {
		try {

			Set<String> entradasExistentes = new HashSet<>();
			try (BufferedReader reader = new BufferedReader(new FileReader(inicio.libroFichero))) {
				String linea;
				while ((linea = reader.readLine()) != null) {
					entradasExistentes.add(linea.trim());
				}
			}

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(inicio.libroFichero, true))) {
				for (libroDto lib : inicio.libroLista) {
					String nuevaEntrada = String.valueOf(lib.getIdLibro()).concat(";")
										.concat(String.valueOf(lib.getIdBibliotecaLibro())).concat(";")
										.concat(String.valueOf(lib.getIdClienteLibro())).concat(";")
										.concat(lib.getTituloLibro()).concat(";")
										.concat(lib.getSubtituloLibro()).concat(";")
										.concat(lib.getAutorLibro()).concat(";")
										.concat(String.valueOf(lib.getCodigoISBN())).concat(";")
										.concat(String.valueOf(lib.getNumeroEdicion())).concat(";")
										.concat(String.valueOf(lib.getStockLibros())).concat(";")
										.concat(String.valueOf(lib.getStockPrestamo()));
							
					if (!entradasExistentes.contains(nuevaEntrada)) {
						bw.write(nuevaEntrada);
						bw.newLine();
					}
				}
			}

		} catch (Exception e) {
			System.out.println("Ha ocurido un error: ".concat(e.getMessage()));
			e.printStackTrace();
		}
	}
	
	public static void guardarLineasPrestamoFichero() {
		try {

			Set<String> entradasExistentes = new HashSet<>();
			try (BufferedReader reader = new BufferedReader(new FileReader(inicio.prestamoFichero))) {
				String linea;
				while ((linea = reader.readLine()) != null) {
					entradasExistentes.add(linea.trim());
				}
			}

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(inicio.prestamoFichero, true))) {
				for (prestamoDto pre : inicio.prestamoLista) {
					String nuevaEntrada = String.valueOf(pre.getIdLibro()).concat(";")
										.concat(String.valueOf(pre.getIdClientePrestamo())).concat(";")
										.concat(String.valueOf(pre.getIdLibro())).concat(";")
										.concat(String.valueOf(pre.getNumPrestado())).concat(";")
										.concat(pre.getEstadoPrestamo()).concat(";")
										.concat(pre.getFchaPrestamo().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))).concat(";")
										.concat(pre.getFchaEntrega().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))).concat(";")
										.concat(pre.getFchaEntregaEsperada().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
							
					if (!entradasExistentes.contains(nuevaEntrada)) {
						bw.write(nuevaEntrada);
						bw.newLine();
					}
				}
			}

		} catch (Exception e) {
			System.out.println("Ha ocurido un error: ".concat(e.getMessage()));
			e.printStackTrace();
		}
	}

	public static void leerLineas() {

		File bibliotecaFile = new File(inicio.bibliotecaFichero);
		File clienteFile = new File(inicio.clienteFichero);
		File libroFile = new File(inicio.libroFichero);
		File prestamoFile = new File(inicio.prestamoFichero);

		if (bibliotecaFile.exists()) {
			try (BufferedReader bibliotecaReader = new BufferedReader(new FileReader(inicio.bibliotecaFichero))) {
				String bibliotecaLine;

				System.out.println("Bibliotecas");

				while ((bibliotecaLine = bibliotecaReader.readLine()) != null) {
					String[] partes = bibliotecaLine.split(";");
					inicio.bibliotecaLista.add(new bibliotecaDto(Long.parseLong(partes[0]), partes[1], partes[2]));
					System.out.println(bibliotecaLine);
				}

			} catch (Exception e) {
				System.out.println("Ha ocurido un error: ".concat(e.getMessage()));
				e.printStackTrace();
			}
		} else {
			System.out.println("No hay bibliotecas habilitadas");
		}
		if (clienteFile.exists()) {
			try (BufferedReader clienteReader = new BufferedReader(new FileReader(inicio.clienteFichero))) {

				String clienteLine;
				System.out.println("Clientes");

				while ((clienteLine = clienteReader.readLine()) != null) {
					String[] partes = clienteLine.split(";");
					inicio.clienteLista.add(new clienteDto(
							Long.parseLong(partes[0]), 
							Long.parseLong(partes[1]),
							partes[2],
							partes[3], 
							partes[4],
							LocalDate.parse(partes[5], DateTimeFormatter.ofPattern("dd-MM-yyyy")), 
							partes[6],
							partes[7],
							Boolean.parseBoolean(partes[8]),
							LocalDateTime.parse(partes[9], DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")),
							LocalDateTime.parse(partes[10], DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))));
					System.out.println(clienteLine);
				}

			} catch (Exception e) {
				System.out.println("Ha ocurido un error: ".concat(e.getMessage()));
				e.printStackTrace();
			}
		} else {
			System.out.println("No hay clientes habilitados");
		}
		if (libroFile.exists()) {
			try (BufferedReader LibroReader = new BufferedReader(new FileReader(inicio.libroFichero))) {

				String libroLine;
				System.out.println("Libros");

				while ((libroLine = LibroReader.readLine()) != null) {
					String[] partes = libroLine.split(";");
					inicio.libroLista.add(new libroDto(
							Long.parseLong(partes[0]),
							Long.parseLong(partes[1]),
							Long.parseLong(partes[2]),
							partes[3],
							partes[4],
							partes[5],
							Integer.parseInt(partes[6]),
							Integer.parseInt(partes[7]),
							Integer.parseInt(partes[8]),
							Integer.parseInt(partes[9])));
							
					System.out.println(libroLine);
				}

			} catch (Exception e) {
				System.out.println("Ha ocurido un error: ".concat(e.getMessage()));
				e.printStackTrace();
			}
		} else {
			System.out.println("No hay Libros habilitados");
		}
		if (prestamoFile.exists()) {
			try (BufferedReader prestamoReader = new BufferedReader(new FileReader(inicio.prestamoFichero))) {

				String prestamoLine;
				System.out.println("Prestamo");

				while ((prestamoLine = prestamoReader.readLine()) != null) {
					String[] partes = prestamoLine.split(";");
					inicio.prestamoLista.add(new prestamoDto(
							Long.parseLong(partes[0]),
							Long.parseLong(partes[1]),
							Long.parseLong(partes[2]),
							Integer.parseInt(partes[3]),
							partes[4],
							LocalDate.parse(partes[5], DateTimeFormatter.ofPattern("dd-MM-yyyy")), 
							LocalDate.parse(partes[6], DateTimeFormatter.ofPattern("dd-MM-yyyy")),
							LocalDate.parse(partes[7], DateTimeFormatter.ofPattern("dd-MM-yyyy"))));	
					System.out.println(prestamoReader);
				}

			} catch (Exception e) {
				System.out.println("Ha ocurido un error: ".concat(e.getMessage()));
				e.printStackTrace();
			}
		} else {
			System.out.println("No hay Prestamos habilitados");
		}
		
	}
}

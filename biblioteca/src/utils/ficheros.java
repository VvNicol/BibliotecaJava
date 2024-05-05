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
					String nuevaEntrada = String.valueOf(bi.getId()).concat(";").concat(bi.getNombreBiblioteca())
							.concat(";").concat(bi.getDireccionBiblioteca());
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
							.concat(cli.getFechaNac().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")))
							.concat(";").concat(cli.getDniCompleto()).concat(";").concat(cli.getEmailCliente())
							.concat(";").concat(String.valueOf(cli.isEstadoSuspencion())).concat(";")
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
					inicio.clienteLista.add(new clienteDto(Long.parseLong(partes[0]), Long.parseLong(partes[1]),
							partes[2], partes[3], partes[4],
							LocalDate.parse(partes[5], DateTimeFormatter.ofPattern("yyyy-MM-dd")), partes[6], partes[7],
							Boolean.parseBoolean(partes[8]),
							LocalDateTime.parse(partes[9], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
							LocalDateTime.parse(partes[10], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
					System.out.println(clienteLine);
				}

			} catch (Exception e) {
				System.out.println("Ha ocurido un error: ".concat(e.getMessage()));
				e.printStackTrace();
			}
		} else {
			System.out.println("No hay clientes habilitados");
		}
	}
}

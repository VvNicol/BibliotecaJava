package servicios;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import biblioteca.inicio;
import dtos.bibliotecaDto;
import dtos.clienteDto;
import dtos.libroDto;
import dtos.prestamoDto;
import utils.utils;

public class operativaImplementacion implements operativaInterface {

	Scanner sc = new Scanner(System.in);

	@Override
	public void AltaBiblioteca() throws IOException {

		System.out.println("Crear nueva biblioteca");
		System.out.println("----------------------");
		long id = utils.generarIdBiblioteca();
		System.out.println("Ingrese el nombre de la biblioteca:");
		String nombreBibli = sc.nextLine();
		System.out.println("Ingrese la direccion:");
		String direccionBibli = sc.nextLine();

		bibliotecaDto nuevaBiblioteca = new bibliotecaDto(id, nombreBibli, direccionBibli);
		inicio.bibliotecaLista.add(nuevaBiblioteca);

		System.out.println("Creado con exito");
		System.out.println("-----------------");
	}

	@Override
	public void AltaCliente() throws IOException {

		utils.MostrarBibliotecas();
		System.out.println("Crear un usuario");
		System.out.println("-----------------");
		System.out.println("Ingrese el ID de la biblioteca:");
		Long idBiblioLong = sc.nextLong();
		sc.nextLine();
		boolean esBiblioteca = false;
		for (bibliotecaDto bi : inicio.bibliotecaLista) {
			if (idBiblioLong.equals(bi.getIdBiblioteca())) {
				esBiblioteca = true;
				Long idClienteLong = utils.generarIdCliente();
				System.out.println("Ingrese nombre:");
				String nombreCliente = sc.nextLine();
				System.out.println("Ingrese primer apellido:");
				String apellido1Cliente = sc.nextLine();
				System.out.println("Ingrese segundo apellido:");
				String apellido2Cliente = sc.nextLine();
				LocalDate fechaNaciCliente = solicitarFechaNaci();
				String dniCliente = utils.verificarDni();
				System.out.println("Ingrese correo:");
				String emailCliente = sc.nextLine();

				clienteDto nuevo = new clienteDto(idBiblioLong, idClienteLong, nombreCliente, apellido1Cliente,
						apellido2Cliente, fechaNaciCliente, dniCliente, emailCliente);
				inicio.clienteLista.add(nuevo);

				System.out.println("Creado con exito");
				System.out.println("-----------------");
			}
		}
		if (!esBiblioteca) {
			System.out.println("La biblioteca no existe");
		}

	}

	private LocalDate solicitarFechaNaci() throws IOException {
		LocalDate fechaDate = null;
		boolean esValido = false;
		do {
			try {
				System.out.println("Ingrese fecha nacimiento (dd-mm-yyyy):");
				String fechaNaciCliente = sc.nextLine();

				DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				fechaDate = LocalDate.parse(fechaNaciCliente, formato);
				esValido = true;
			} catch (DateTimeParseException e) {
				System.out.println("Formato de fecha inválido. Intente de nuevo.");
			}
		} while (!esValido);
		return fechaDate;
	}

	@Override
	public void AltaLibro() throws IOException {

		boolean esBiblioteca = false;

		Long idLibroLong = utils.generarIdLibro();
		utils.MostrarBibliotecas();
		System.out.println("Ingrese el ID de la biblioteca:");
		Long idBiblioLong = sc.nextLong();
		for (bibliotecaDto bi : inicio.bibliotecaLista) {
			if (idBiblioLong.equals(bi.getIdBiblioteca())) {
				esBiblioteca = true;
				utils.MostrarCliente();
				System.out.println("Ingrese el ID de usuario:");
				Long idClienteLong = sc.nextLong();
				sc.nextLine();
				System.out.println("Ingrese Titulo del libro:");
				String tituloLibro = sc.nextLine();
				System.out.println("Ingrese subtitulo del libro:");
				String subtituloLibro = sc.nextLine();
				System.out.println("Ingrese el nombre del autor:");
				String autorLibro = sc.nextLine();
				System.out.println("Ingrese codigo ISBN:");
				int codigoIsbnLibro = verificarDuplicado();
				System.out.println("Ingrese numero de edicion:");
				int edicionLibro = sc.nextInt();
				System.out.println("Ingrese numero de stock:");
				int stockLibro = sc.nextInt();

				libroDto nuevo = new libroDto(idLibroLong, idBiblioLong, idClienteLong, tituloLibro, subtituloLibro,
						autorLibro, codigoIsbnLibro, edicionLibro, stockLibro, stockLibro);
				inicio.libroLista.add(nuevo);
				System.out.println("Creado con exito");
				System.out.println("-----------------");
				break;
			}
		}
		if (!esBiblioteca) {
			System.out.println("La biblioteca no existe");
		}
	}

	private int verificarDuplicado() throws IOException {
		boolean esDuplicado;
		int codigo = 0;

		do {
			esDuplicado = false;
			System.out.println("Ingrese código ISBN:");
			int codigoIsbnLibro = sc.nextInt();
			sc.nextLine();

			for (libroDto libro : inicio.libroLista) {
				if (codigoIsbnLibro == libro.getCodigoISBN()) {
					System.out.println("Se han encontrado códigos ISBN duplicados, el libro ya existe.");
					esDuplicado = true;
					break;
				}
			}

			if (!esDuplicado) {
				System.out.println("Código ISBN válido.");
				codigo = codigoIsbnLibro;
			}
		} while (esDuplicado);

		return codigo;
	}

	@Override
	public void Prestamo() throws IOException {
		utils.MostrarBibliotecas();
		System.out.println("PRESTAMO");
		System.out.println("-----------------");
		System.out.println("Ingrese id de la biblioteca");
		long idBibliotecaRegistroPrestamo = sc.nextLong();
		sc.nextLine();

		utils.MostrarCliente();
		System.out.println("Ingrese el id del usuario para el prestamo");
		long idU = sc.nextLong();

		utils.generarIdLibro();
		System.out.println("Introduzca el id del libro");
		long idLib = sc.nextLong();

		System.out.println("Introduzca la cantidad de libros prestados");
		int cantLibros = sc.nextInt();

		boolean clienteEncontrado = false;
		boolean libroEncontrado = false;
		boolean stockDisponible = false;

		if (inicio.clienteLista.size() > 0) {
			for (clienteDto cliente : inicio.clienteLista) {

				if (cliente.getIdBibliotecaCliente() == (idBibliotecaRegistroPrestamo) && cliente.getIdCliente() == (idU)) 
				{
					clienteEncontrado = true;
					break;
				}
			}
			if (!clienteEncontrado) {
				System.out.println("El cliente no pertenece a la biblioteca");
			} else {
				for (libroDto lib : inicio.libroLista) {

					if (lib.getIdLibro() == (idLib) && lib.getIdBibliotecaLibro() == (idBibliotecaRegistroPrestamo)) 
					{
						libroEncontrado = true;

						if (lib.getStockPrestamo() >= cantLibros) {
							stockDisponible = true;

							lib.setStockPrestamo(lib.getStockPrestamo() - cantLibros);

							long idPres = utils.generarIdPrestamo();
							long idUsuario = idU;
							long idLibroPrestamo = idLib;
							int numPrestadoCliente = cantLibros;
							LocalDate fechaInstante = LocalDate.now();
							String estado = "en proceso";
							LocalDate fechaEntregaEsperada = fechaInstante.plusDays(8);

							prestamoDto prestamo = new prestamoDto(
									idPres,
									idUsuario,
									idLibroPrestamo,
									numPrestadoCliente,
									estado,
									fechaInstante,
									fechaEntregaEsperada);
							inicio.prestamoLista.add(prestamo);

							System.out.println("Prestamo con exito");
							break;
						} else {
							System.out.println("No hay libros disponibles");
						}

					}
				}
			}
			if (!libroEncontrado) {
				System.out.println("El libro no se encuentra en la biblioteca");
			}
			if (!stockDisponible) {
				System.out.println("No hay stock disponible de ese libro");
			}
		}

	}

	@Override
	public void Devolucion() throws IOException {
		utils.MostrarCliente();
        System.out.println("Ingrese su id");
        long idUs = sc.nextLong();

        System.out.println("Ingrese el id del libro devuelto:");
        long idLibroDevolucion = sc.nextLong();
        LocalDate fechaDevolucion = LocalDate.now();

        boolean prestamoEncontrado = false;

        for (prestamoDto prestamo : inicio.prestamoLista) {
            if (prestamo.getIdLibro() == idLibroDevolucion && prestamo.getEstadoPrestamo().equals("en proceso") && prestamo.getIdClientePrestamo() == idUs)
            {
                prestamoEncontrado = true;

                if (fechaDevolucion.isBefore(prestamo.getFchaEntregaEsperada()) || fechaDevolucion.isEqual(prestamo.getFchaEntregaEsperada())) {
                    prestamo.setEstadoPrestamo("entregado");
                } else {
                    prestamo.setEstadoPrestamo("entregado con retraso");
                    suspenderCliente(prestamo.getIdClientePrestamo());
                }

                System.out.println("Libro devuelto con éxito.");

                return;
            }
        }

        if (!prestamoEncontrado) {
            System.out.println("No se encontró ningún préstamo en proceso para el libro especificado.");
        }

	}

	private void suspenderCliente(long idClientePrestamo) throws IOException {
	    for (clienteDto cli : inicio.clienteLista) {
	        if (cli.getIdCliente() == idClientePrestamo) {
	            cli.setEstadoSuspencion(true);
	            cli.setInicioSuspencion(LocalDateTime.now());
	            cli.setFinSuspencion(cli.getInicioSuspencion().plusDays(7));
	            System.out.println("Cliente " + cli.getNombreCliente() + " suspendido por 7 días debido a la devolución con retraso.");
	            return;
	        }
	    }
	}


}

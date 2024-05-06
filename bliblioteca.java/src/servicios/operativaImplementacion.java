package servicios;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import biblioteca.inicio;
import dtos.bibliotecaDto;
import dtos.clienteDto;
import dtos.libroDto;
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
		Long idClienteLong = utils.generarIdCliente();
		sc.nextLine();
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
		
		Long idLibroLong = utils.generarIdLibro();
		utils.MostrarBibliotecas();
		System.out.println("Ingrese el ID de la biblioteca:");
		Long idBiblioLong = sc.nextLong();
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
		int codigoIsbnLibro = sc.nextInt();
		System.out.println("Ingrese numero de edicion:");
		int edicionLibro = sc.nextInt();
		System.out.println("Ingrese numero de stock:");
		int stockLibro = sc.nextInt();
		
		libroDto nuevo = new libroDto(idLibroLong,idBiblioLong,idClienteLong,tituloLibro,subtituloLibro,autorLibro, codigoIsbnLibro, edicionLibro, stockLibro, stockLibro);
		inicio.libroLista.add(nuevo);
		System.out.println("Creado con exito");
		System.out.println("-----------------");
	}

	@Override
	public void Prestamo() throws IOException {
		System.out.println("Cargando pag PRESTAMO:");
		
	}

	@Override
	public void Devolucion() throws IOException {
		System.out.println("Cargando pag Devolucion:");
		
	}

}

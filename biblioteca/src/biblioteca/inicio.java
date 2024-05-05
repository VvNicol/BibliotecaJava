/**
 * 
 */
package biblioteca;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import dtos.bibliotecaDto;
import dtos.clienteDto;
import dtos.libroDto;
import dtos.prestamoDto;
import servicios.menuImplementacion;
import servicios.menuInterface;
import servicios.operativaImplemnetacion;
import servicios.operativaInterface;

/**
 * 
 */
public class inicio {

	/**
	 * @param args
	 */
	public static List<bibliotecaDto> bibliotecaLista = new ArrayList<bibliotecaDto>();
	public static List<clienteDto> clienteLista = new ArrayList<clienteDto>();
	public static List<libroDto> libroLista = new ArrayList<libroDto>();
	public static List<prestamoDto> prestamoLista = new ArrayList<prestamoDto>();
	
	static LocalDate fechaActual = LocalDate.now();
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    static String fechaFormateada = fechaActual.format(formatter);

	public static String ficheroLog = fechaFormateada.concat(" ficheroLog.txt");
	public static String bibliotecaFichero = fechaFormateada.concat(" biblioteca.txt");
	public static String clienteFichero = fechaFormateada.concat(" cliente.txt");
	public static String libroFichero = fechaFormateada.concat(" libro.txt");
	public static String prestamoFichero = fechaFormateada.concat(" prestamo.txt");
	
	public static void main(String[] args) {

		menuInterface mi = new menuImplementacion();
		operativaInterface oi = new operativaImplemnetacion();

		int opcionSeleccionada;
		boolean esCerrado = false;
		try {
			
			FileWriter fw = new FileWriter(ficheroLog,true);
			PrintWriter pw = new PrintWriter(fw);
			
			do {
				utils.ficheros.crearFicheros();
				utils.ficheros.leerLineas();
				
				opcionSeleccionada = mi.MenuPrincipal();
				String mensajeLog = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).concat(" - Opcion Menu Principal: ").concat(String.valueOf(opcionSeleccionada));
				switch (opcionSeleccionada) {
				case 0:
					utils.ficheros.guardarLineasBibliotecasFichero();
					utils.ficheros.guardarLineasClienteFichero();
					mensajeLog += " - Menu cerrado"; 
					esCerrado = true;
					break;
				case 1 :
					mensajeLog += " - Alta Biblioteca";
					oi.AltaBiblioteca();
					break;
				case 2 :
					mensajeLog += " - Alta Cliente";
					oi.AltaCliente();
					break;
				case 3 :
					mensajeLog += " - Alta Libro";
					oi.AltaLibro();
					break;
				case 4:
					mensajeLog += " - Menu Prestamo";
					mi.MenuPrestamo();
					break;
				default:
					mensajeLog += " - Opcion no valida";
					System.out.println("La opcion seleccionada no es valida");
					break;
				}
				pw.println(mensajeLog);

			} while (!esCerrado);
			pw.close();
			fw.close();
			
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error en: ".concat(e.getMessage()));
		}
	}

}

/**
 * 
 */
package servicios;

import java.io.IOException;
import java.util.Scanner;

/**
 * 
 */
public class menuImplementacion implements menuInterface {
	Scanner sc = new Scanner(System.in);

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
	public void MenuPrestamo() throws IOException{
		// TODO Auto-generated method stub

	}

}

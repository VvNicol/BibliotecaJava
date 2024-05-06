package servicios;

import java.io.IOException;

public interface operativaInterface {

	void AltaBiblioteca() throws IOException;

	void AltaCliente() throws IOException;

	void AltaLibro() throws IOException ;

	void Prestamo() throws IOException ;

	void Devolucion() throws IOException;

}

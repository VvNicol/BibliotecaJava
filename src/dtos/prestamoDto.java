package dtos;

import java.time.LocalDate;

public class prestamoDto {
	
	long idPrestamo =  11111;
    long idClientePrestamo = 11111;
    long idLibro = 111111;
    int numPrestado = 11111;
    String estadoPrestamo = "aaaaa";

    LocalDate fchaPrestamo = LocalDate.now();
    LocalDate fchaEntrega = LocalDate.of(9999, 12, 31);
    LocalDate fchaEntregaEsperada = LocalDate.of(9999, 12, 31);
    
    

    
	@Override
	public String toString() {
		return "prestamoDto [idPrestamo= " + idPrestamo + ", idClientePrestamo= " + idClientePrestamo + ", idLibro= "
				+ idLibro + ", numPrestado= " + numPrestado + ", estadoPrestamo= " + estadoPrestamo + ", fchaPrestamo= "
				+ fchaPrestamo + ", fchaEntrega= " + fchaEntrega + ", fchaEntregaEsperada= " + fchaEntregaEsperada + "]";
	}


	/**
	 * @param idPrestamo
	 * @param idClientePrestamo
	 * @param idLibro
	 * @param numPrestado
	 * @param estadoPrestamo
	 * @param fchaPrestamo
	 * @param fchaEntregaEsperada
	 */
	public prestamoDto(long idPrestamo, long idClientePrestamo, long idLibro, int numPrestado, String estadoPrestamo,
			LocalDate fchaPrestamo, LocalDate fchaEntregaEsperada) {
		super();
		this.idPrestamo = idPrestamo;
		this.idClientePrestamo = idClientePrestamo;
		this.idLibro = idLibro;
		this.numPrestado = numPrestado;
		this.estadoPrestamo = estadoPrestamo;
		this.fchaPrestamo = fchaPrestamo;
		this.fchaEntregaEsperada = fchaEntregaEsperada;
	}







	/**
	 * @param idPrestamo
	 * @param idClientePrestamo
	 * @param idLibro
	 * @param numPrestado
	 * @param estadoPrestamo
	 * @param fchaPrestamo
	 * @param fchaEntrega
	 * @param fchaEntregaEsperada
	 */
	public prestamoDto(long idPrestamo, long idClientePrestamo, long idLibro, int numPrestado, String estadoPrestamo,
			LocalDate fchaPrestamo, LocalDate fchaEntrega, LocalDate fchaEntregaEsperada) {
		super();
		this.idPrestamo = idPrestamo;
		this.idClientePrestamo = idClientePrestamo;
		this.idLibro = idLibro;
		this.numPrestado = numPrestado;
		this.estadoPrestamo = estadoPrestamo;
		this.fchaPrestamo = fchaPrestamo;
		this.fchaEntrega = fchaEntrega;
		this.fchaEntregaEsperada = fchaEntregaEsperada;
	}
	/**
	 * @return the idPrestamo
	 */
	public long getIdPrestamo() {
		return idPrestamo;
	}
	/**
	 * @param idPrestamo the idPrestamo to set
	 */
	public void setIdPrestamo(long idPrestamo) {
		this.idPrestamo = idPrestamo;
	}
	/**
	 * @return the idClientePrestamo
	 */
	public long getIdClientePrestamo() {
		return idClientePrestamo;
	}
	/**
	 * @param idClientePrestamo the idClientePrestamo to set
	 */
	public void setIdClientePrestamo(long idClientePrestamo) {
		this.idClientePrestamo = idClientePrestamo;
	}
	/**
	 * @return the idLibro
	 */
	public long getIdLibro() {
		return idLibro;
	}
	/**
	 * @param idLibro the idLibro to set
	 */
	public void setIdLibro(long idLibro) {
		this.idLibro = idLibro;
	}
	/**
	 * @return the numPrestado
	 */
	public int getNumPrestado() {
		return numPrestado;
	}
	/**
	 * @param numPrestado the numPrestado to set
	 */
	public void setNumPrestado(int numPrestado) {
		this.numPrestado = numPrestado;
	}
	/**
	 * @return the estadoPrestamo
	 */
	public String getEstadoPrestamo() {
		return estadoPrestamo;
	}
	/**
	 * @param estadoPrestamo the estadoPrestamo to set
	 */
	public void setEstadoPrestamo(String estadoPrestamo) {
		this.estadoPrestamo = estadoPrestamo;
	}
	/**
	 * @return the fchaPrestamo
	 */
	public LocalDate getFchaPrestamo() {
		return fchaPrestamo;
	}
	/**
	 * @param fchaPrestamo the fchaPrestamo to set
	 */
	public void setFchaPrestamo(LocalDate fchaPrestamo) {
		this.fchaPrestamo = fchaPrestamo;
	}
	/**
	 * @return the fchaEntrega
	 */
	public LocalDate getFchaEntrega() {
		return fchaEntrega;
	}
	/**
	 * @param fchaEntrega the fchaEntrega to set
	 */
	public void setFchaEntrega(LocalDate fchaEntrega) {
		this.fchaEntrega = fchaEntrega;
	}
	/**
	 * @return the fchaEntregaEsperada
	 */
	public LocalDate getFchaEntregaEsperada() {
		return fchaEntregaEsperada;
	}
	/**
	 * @param fchaEntregaEsperada the fchaEntregaEsperada to set
	 */
	public void setFchaEntregaEsperada(LocalDate fchaEntregaEsperada) {
		this.fchaEntregaEsperada = fchaEntregaEsperada;
	}
}

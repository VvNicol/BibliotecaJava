package dtos;

public class libroDto {
	
	long idLibro;
    long idBibliotecaLibro;
    long idClienteLibro;
    String tituloLibro = "aaaaa";
    String subtituloLibro = "aaaaa";
    String autorLibro = "aaaaa";
    int codigoISBN = 11111;
    int numeroEdicion = 11111;
    int stockLibros= 11111;
    int stockPrestamo = 11111;
    
    
    
    
    
    
	/**
	 * @param idLibro
	 * @param idBibliotecaLibro
	 * @param idClienteLibro
	 * @param tituloLibro
	 * @param subtituloLibro
	 * @param autorLibro
	 * @param codigoISBN
	 * @param numeroEdicion
	 * @param stockLibros
	 */
	public libroDto(long idLibro, long idBibliotecaLibro, long idClienteLibro, String tituloLibro,
			String subtituloLibro, String autorLibro, int codigoISBN, int numeroEdicion, int stockLibros) {
		super();
		this.idLibro = idLibro;
		this.idBibliotecaLibro = idBibliotecaLibro;
		this.idClienteLibro = idClienteLibro;
		this.tituloLibro = tituloLibro;
		this.subtituloLibro = subtituloLibro;
		this.autorLibro = autorLibro;
		this.codigoISBN = codigoISBN;
		this.numeroEdicion = numeroEdicion;
		this.stockLibros = stockLibros;
	}
	/**
	 * @param idLibro
	 * @param idBibliotecaLibro
	 * @param idClienteLibro
	 * @param tituloLibro
	 * @param subtituloLibro
	 * @param autorLibro
	 * @param codigoISBN
	 * @param numeroEdicion
	 * @param stockLibros
	 * @param stockPrestamo
	 */
	public libroDto(long idLibro, long idBibliotecaLibro, long idClienteLibro, String tituloLibro,
			String subtituloLibro, String autorLibro, int codigoISBN, int numeroEdicion, int stockLibros,
			int stockPrestamo) {
		super();
		this.idLibro = idLibro;
		this.idBibliotecaLibro = idBibliotecaLibro;
		this.idClienteLibro = idClienteLibro;
		this.tituloLibro = tituloLibro;
		this.subtituloLibro = subtituloLibro;
		this.autorLibro = autorLibro;
		this.codigoISBN = codigoISBN;
		this.numeroEdicion = numeroEdicion;
		this.stockLibros = stockLibros;
		this.stockPrestamo = stockPrestamo;
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
	 * @return the idBibliotecaLibro
	 */
	public long getIdBibliotecaLibro() {
		return idBibliotecaLibro;
	}
	/**
	 * @param idBibliotecaLibro the idBibliotecaLibro to set
	 */
	public void setIdBibliotecaLibro(long idBibliotecaLibro) {
		this.idBibliotecaLibro = idBibliotecaLibro;
	}
	/**
	 * @return the idClienteLibro
	 */
	public long getIdClienteLibro() {
		return idClienteLibro;
	}
	/**
	 * @param idClienteLibro the idClienteLibro to set
	 */
	public void setIdClienteLibro(long idClienteLibro) {
		this.idClienteLibro = idClienteLibro;
	}
	/**
	 * @return the tituloLibro
	 */
	public String getTituloLibro() {
		return tituloLibro;
	}
	/**
	 * @param tituloLibro the tituloLibro to set
	 */
	public void setTituloLibro(String tituloLibro) {
		this.tituloLibro = tituloLibro;
	}
	/**
	 * @return the subtituloLibro
	 */
	public String getSubtituloLibro() {
		return subtituloLibro;
	}
	/**
	 * @param subtituloLibro the subtituloLibro to set
	 */
	public void setSubtituloLibro(String subtituloLibro) {
		this.subtituloLibro = subtituloLibro;
	}
	/**
	 * @return the autorLibro
	 */
	public String getAutorLibro() {
		return autorLibro;
	}
	/**
	 * @param autorLibro the autorLibro to set
	 */
	public void setAutorLibro(String autorLibro) {
		this.autorLibro = autorLibro;
	}
	/**
	 * @return the codigoISBN
	 */
	public int getCodigoISBN() {
		return codigoISBN;
	}
	/**
	 * @param codigoISBN the codigoISBN to set
	 */
	public void setCodigoISBN(int codigoISBN) {
		this.codigoISBN = codigoISBN;
	}
	/**
	 * @return the numeroEdicion
	 */
	public int getNumeroEdicion() {
		return numeroEdicion;
	}
	/**
	 * @param numeroEdicion the numeroEdicion to set
	 */
	public void setNumeroEdicion(int numeroEdicion) {
		this.numeroEdicion = numeroEdicion;
	}
	/**
	 * @return the stockLibros
	 */
	public int getStockLibros() {
		return stockLibros;
	}
	/**
	 * @param stockLibros the stockLibros to set
	 */
	public void setStockLibros(int stockLibros) {
		this.stockLibros = stockLibros;
	}
	/**
	 * @return the stockPrestamo
	 */
	public int getStockPrestamo() {
		return stockPrestamo;
	}
	/**
	 * @param stockPrestamo the stockPrestamo to set
	 */
	public void setStockPrestamo(int stockPrestamo) {
		this.stockPrestamo = stockPrestamo;
	}
    
    
}

package dtos;

public class bibliotecaDto {
	
	long idBiblioteca;
	String nombreBiblioteca = "aaaaa";
	String direccionBiblioteca = "aaaaa";
	
	@Override
	public String toString() {
		return "bibliotecaDto [id=" + idBiblioteca + ", nombreBiblioteca=" + nombreBiblioteca + "]";
	}
	/**
	 * @param id
	 * @param nombreBiblioteca
	 * @param direccionBiblioteca
	 */
	public bibliotecaDto(long idBiblioteca, String nombreBiblioteca, String direccionBiblioteca) {
		super();
		this.idBiblioteca = idBiblioteca;
		this.nombreBiblioteca = nombreBiblioteca;
		this.direccionBiblioteca = direccionBiblioteca;
	}
	
	/**
	 * @return the idBiblioteca
	 */
	public long getIdBiblioteca() {
		return idBiblioteca;
	}
	/**
	 * @param idBiblioteca the idBiblioteca to set
	 */
	public void setIdBiblioteca(long idBiblioteca) {
		this.idBiblioteca = idBiblioteca;
	}
	/**
	 * @return the nombreBiblioteca
	 */
	public String getNombreBiblioteca() {
		return nombreBiblioteca;
	}
	/**
	 * @param nombreBiblioteca the nombreBiblioteca to set
	 */
	public void setNombreBiblioteca(String nombreBiblioteca) {
		this.nombreBiblioteca = nombreBiblioteca;
	}
	/**
	 * @return the direccionBiblioteca
	 */
	public String getDireccionBiblioteca() {
		return direccionBiblioteca;
	}
	/**
	 * @param direccionBiblioteca the direccionBiblioteca to set
	 */
	public void setDireccionBiblioteca(String direccionBiblioteca) {
		this.direccionBiblioteca = direccionBiblioteca;
	}
}

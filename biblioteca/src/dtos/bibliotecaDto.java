package dtos;

public class bibliotecaDto {
	
	long id;
	String nombreBiblioteca = "aaaaa";
	String direccionBiblioteca = "aaaaa";
	
	@Override
	public String toString() {
		return "bibliotecaDto [id=" + id + ", nombreBiblioteca=" + nombreBiblioteca + "]";
	}
	/**
	 * @param id
	 * @param nombreBiblioteca
	 * @param direccionBiblioteca
	 */
	public bibliotecaDto(long id, String nombreBiblioteca, String direccionBiblioteca) {
		super();
		this.id = id;
		this.nombreBiblioteca = nombreBiblioteca;
		this.direccionBiblioteca = direccionBiblioteca;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
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

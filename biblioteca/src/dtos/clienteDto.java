package dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class clienteDto {

	long idBibliotecaCliente;
	long idCliente;
	String nombreCliente;
	String apellido1Cliente;
	String apellido2Cliente;
	LocalDate fechaNac = LocalDate.of(9999, 12, 31);
	String dniCompleto = "aaaaa";
	String emailCliente = "aaaaa";
	boolean estadoSuspencion = false;
	LocalDateTime inicioSuspencion = LocalDateTime.of(9999, 12, 31, 00, 00, 00);
	LocalDateTime finSuspencion = LocalDateTime.of(9999, 12,31,00,00,00);
	
	

	/**
	 * @param idBibliotecaCliente
	 * @param idCliente
	 * @param nombreCliente
	 * @param apellido1Cliente
	 * @param apellido2Cliente
	 * @param fechaNac
	 * @param dniCompleto
	 * @param emailCliente
	 * @param estadoSuspencion
	 * @param inicioSuspencion
	 * @param finSuspencion
	 */
	public clienteDto(long idBibliotecaCliente, long idCliente, String nombreCliente, String apellido1Cliente,
			String apellido2Cliente, LocalDate fechaNac, String dniCompleto, String emailCliente,
			boolean estadoSuspencion, LocalDateTime inicioSuspencion, LocalDateTime finSuspencion) {
		super();
		this.idBibliotecaCliente = idBibliotecaCliente;
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.apellido1Cliente = apellido1Cliente;
		this.apellido2Cliente = apellido2Cliente;
		this.fechaNac = fechaNac;
		this.dniCompleto = dniCompleto;
		this.emailCliente = emailCliente;
		this.estadoSuspencion = estadoSuspencion;
		this.inicioSuspencion = inicioSuspencion;
		this.finSuspencion = finSuspencion;
	}
	
	/**
	 * @return the idBibliotecaCliente
	 */
	public long getIdBibliotecaCliente() {
		return idBibliotecaCliente;
	}
	/**
	 * @param idBibliotecaCliente the idBibliotecaCliente to set
	 */
	public void setIdBibliotecaCliente(long idBibliotecaCliente) {
		this.idBibliotecaCliente = idBibliotecaCliente;
	}
	/**
	 * @return the idCliente
	 */
	public long getIdCliente() {
		return idCliente;
	}
	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	/**
	 * @return the nombreCliente
	 */
	public String getNombreCliente() {
		return nombreCliente;
	}
	/**
	 * @param nombreCliente the nombreCliente to set
	 */
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	/**
	 * @return the apellido1Cliente
	 */
	public String getApellido1Cliente() {
		return apellido1Cliente;
	}
	/**
	 * @param apellido1Cliente the apellido1Cliente to set
	 */
	public void setApellido1Cliente(String apellido1Cliente) {
		this.apellido1Cliente = apellido1Cliente;
	}
	/**
	 * @return the apellido2Cliente
	 */
	public String getApellido2Cliente() {
		return apellido2Cliente;
	}
	/**
	 * @param apellido2Cliente the apellido2Cliente to set
	 */
	public void setApellido2Cliente(String apellido2Cliente) {
		this.apellido2Cliente = apellido2Cliente;
	}
	/**
	 * @return the fechaNac
	 */
	public LocalDate getFechaNac() {
		return fechaNac;
	}
	/**
	 * @param fechaNac the fechaNac to set
	 */
	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}
	/**
	 * @return the dniCompleto
	 */
	public String getDniCompleto() {
		return dniCompleto;
	}
	/**
	 * @param dniCompleto the dniCompleto to set
	 */
	public void setDniCompleto(String dniCompleto) {
		this.dniCompleto = dniCompleto;
	}
	/**
	 * @return the emailCliente
	 */
	public String getEmailCliente() {
		return emailCliente;
	}
	/**
	 * @param emailCliente the emailCliente to set
	 */
	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}
	/**
	 * @return the estadoSuspencion
	 */
	public boolean isEstadoSuspencion() {
		return estadoSuspencion;
	}
	/**
	 * @param estadoSuspencion the estadoSuspencion to set
	 */
	public void setEstadoSuspencion(boolean estadoSuspencion) {
		this.estadoSuspencion = estadoSuspencion;
	}
	/**
	 * @return the inicioSuspencion
	 */
	public LocalDateTime getInicioSuspencion() {
		return inicioSuspencion;
	}
	/**
	 * @param inicioSuspencion the inicioSuspencion to set
	 */
	public void setInicioSuspencion(LocalDateTime inicioSuspencion) {
		this.inicioSuspencion = inicioSuspencion;
	}
	/**
	 * @return the finSuspencion
	 */
	public LocalDateTime getFinSuspencion() {
		return finSuspencion;
	}
	/**
	 * @param finSuspencion the finSuspencion to set
	 */
	public void setFinSuspencion(LocalDateTime finSuspencion) {
		this.finSuspencion = finSuspencion;
	}
	
}

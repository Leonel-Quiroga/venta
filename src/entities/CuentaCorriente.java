package entities;

import java.io.Serializable;

public class CuentaCorriente implements Serializable {

	private static final long serialVersionUID = 627334894356477665L;
	private Integer idCuentaCorriente;
	private Integer idCatIva;
	private Integer idLocalidad;
	private Integer documento;
	private Double saldoOperativo;
	private String calle;
	private String telefono;
	private String mail;
	private Boolean baja;
	private String apellido;
	private String nombre;

	public Integer getIdCuentaCorriente() {
		return idCuentaCorriente;
	}

	public void setIdCuentaCorriente(Integer idCuentaCorriente) {
		this.idCuentaCorriente = idCuentaCorriente;
	}

	public Integer getIdCatIva() {
		return idCatIva;
	}

	public void setIdCatIva(Integer idCatIva) {
		this.idCatIva = idCatIva;
	}

	public Integer getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(Integer idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public Integer getDocumento() {
		return documento;
	}

	public void setDocumento(Integer documento) {
		this.documento = documento;
	}

	public Double getSaldoOperativo() {
		return saldoOperativo;
	}

	public void setSaldoOperativo(Double saldoOperativo) {
		this.saldoOperativo = saldoOperativo;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Boolean getBaja() {
		return baja;
	}

	public void setBaja(Boolean baja) {
		this.baja = baja;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}

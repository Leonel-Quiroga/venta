package dto;

public class CuentaCorrienteDTO {
	private Integer idCuentaCorriente;
	private String apellido;
	private String nombre;
	private Integer cuil;
	private String calle;
	public Integer getIdCuentaCorriente() {
		return idCuentaCorriente;
	}
	public void setIdCuentaCorriente(Integer idCuentaCorriente) {
		this.idCuentaCorriente = idCuentaCorriente;
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
	public Integer getCuil() {
		return cuil;
	}
	public void setCuil(Integer cuil) {
		this.cuil = cuil;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	
}

package entities;

import java.io.Serializable;
import java.sql.Timestamp;

public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idProducto;
	private Integer codigo;
	private String nombre;
	private Integer cantidad;
	private Double precioUnitario;
	private boolean activo;
	private Timestamp alta;

	public Integer getIdProducto() {
		return idProducto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public Timestamp getAlta() {
		return alta;
	}

	public void setAlta(Timestamp alta) {
		this.alta = alta;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}

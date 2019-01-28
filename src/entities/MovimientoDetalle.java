package entities;

import java.io.Serializable;

public class MovimientoDetalle implements Serializable {

	private static final long serialVersionUID = 3556154562043250621L;
	private Integer idComprobanteDetalle;
	private Integer idComprobante;
	private Integer idProducto;
	private Integer cantidad;
	private Double totalPorUnidad;

	public Integer getIdComprobanteDetalle() {
		return idComprobanteDetalle;
	}

	public void setIdComprobanteDetalle(Integer idComprobanteDetalle) {
		this.idComprobanteDetalle = idComprobanteDetalle;
	}

	public Integer getIdComprobante() {
		return idComprobante;
	}

	public void setIdComprobante(Integer idComprobante) {
		this.idComprobante = idComprobante;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getTotalPorUnidad() {
		return totalPorUnidad;
	}

	public void setTotalPorUnidad(Double totalPorUnidad) {
		this.totalPorUnidad = totalPorUnidad;
	}
}

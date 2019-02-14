package dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class FacturaDTO {
	private Integer idCuentaCorriente;
	private List<DetalleFacturaDTO> listDetalleFactura = new ArrayList<DetalleFacturaDTO>();
	private String apellido;
	private String nombre;
	private Integer cuil;
	private String localidad;
	private String calle;
	private Integer codigoPostal;
	private static final int tipoComprobante = 1;
	private static final int puntoDeVenta = 1;
	private String codigoDeBarra;
	private Double debito;
	private Double subtotal;
	private Double iva;
	private Double total;

	public Integer getIdCuentaCorriente() {
		return idCuentaCorriente;
	}

	public void setIdCuentaCorriente(Integer idCuentaCorriente) {
		this.idCuentaCorriente = idCuentaCorriente;
	}

	public String getCodigoDeBarra() {
		return codigoDeBarra;
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

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public void setCodigoDeBarra(String codigoDeBarra) {
		this.codigoDeBarra = codigoDeBarra;
	}

	public Double getDebito() {
		return debito;
	}

	public void setDebito(Double debito) {
		this.debito = debito;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getIva() {
		return iva;
	}

	public void setIva(Double iva) {
		this.iva = iva;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Timestamp getEmision() {
		return emision;
	}

	public void setEmision(Timestamp emision) {
		this.emision = emision;
	}

	public Timestamp getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(Timestamp vencimiento) {
		this.vencimiento = vencimiento;
	}

	public static int getTipocomprobante() {
		return tipoComprobante;
	}

	public static int getPuntodeventa() {
		return puntoDeVenta;
	}

	private Timestamp emision;
	private Timestamp vencimiento;

	public List<DetalleFacturaDTO> getListDetalleFactura() {
		return listDetalleFactura;
	}

	public void setListDetalleFactura(List<DetalleFacturaDTO> listDetalleFactura) {
		this.listDetalleFactura = listDetalleFactura;
	}
}

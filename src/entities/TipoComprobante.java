package entities;

import java.io.Serializable;

public class TipoComprobante implements Serializable {

	private static final long serialVersionUID = 9097541633716400293L;

	private Integer idTipoComprobante;
	private String descripcion;
	private String codigo;
	private Boolean isActivo;

	public Integer getIdTipoComprobante() {
		return idTipoComprobante;
	}

	public void setIdTipoComprobante(Integer idTipoComprobante) {
		this.idTipoComprobante = idTipoComprobante;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Boolean getIsActivo() {
		return isActivo;
	}

	public void setIsActivo(Boolean isActivo) {
		this.isActivo = isActivo;
	}

}

package entities;

import java.io.Serializable;

public class CategoriaIva implements Serializable {

	private static final long serialVersionUID = -1164504466564423422L;

	private Integer idCategoriaIva;
	private String descripcion;
	private String codigo;
	private Boolean isActiva;

	public Integer getIdCategoriaIva() {
		return idCategoriaIva;
	}

	public void setIdCategoriaIva(Integer idCategoriaIva) {
		this.idCategoriaIva = idCategoriaIva;
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

	public Boolean getIsActiva() {
		return isActiva;
	}

	public void setIsActiva(Boolean isActiva) {
		this.isActiva = isActiva;
	}

}

package entities;

import java.io.Serializable;

public class FormaDePago implements Serializable {

	private static final long serialVersionUID = 2187606059368219741L;

	private Integer idFormaDePago;
	private String desccripcion;
	public Integer getIdFormaDePago() {
		return idFormaDePago;
	}

	public void setIdFormaDePago(Integer idFormaDePago) {
		this.idFormaDePago = idFormaDePago;
	}

	public String getDesccripcion() {
		return desccripcion;
	}

	public void setDesccripcion(String desccripcion) {
		this.desccripcion = desccripcion;
	}

}

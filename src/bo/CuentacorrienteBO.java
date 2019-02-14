package bo;

import java.util.List;

import entities.CuentaCorriente;

public interface CuentacorrienteBO {
	
	public List<CuentaCorriente> listarCuentasCorrientes();

	public CuentaCorriente getCuentaCorrienteByIdBO(Integer idCuentaCorriente);

	public void guardarCuentaCorriente(CuentaCorriente cuentaCorriente);

	public void borrarCuentaCorriente(Integer id);
}

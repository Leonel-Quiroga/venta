package dao;

import java.util.List;

import entities.CuentaCorriente;

public interface CuentaCorrienteDAO {
	
	public List<CuentaCorriente> listarCuentaCorrienteDAO();
	public String getCtaCteId(Integer idCuentaCorriente);
	public void guardarCuentaCorriente(CuentaCorriente cuentaCorriente);
	public void borrarCuentaCorriente(Integer id);
}

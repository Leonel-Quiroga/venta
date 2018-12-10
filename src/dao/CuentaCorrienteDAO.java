package dao;

import java.util.List;

import entities.CuentaCorriente;

public interface CuentaCorrienteDAO {
	
	public List<CuentaCorriente> listarCuentaCorrienteDAO();
	public String getCtaCteId(Integer idCuentaCorriente);
}

package bo.impl;

import java.util.List;

import dao.CuentaCorrienteDAO;
import dao.impl.CuentaCorrienteDAOImpl;
import entities.CuentaCorriente;


public class CuentaCorrienteBOImpl {
	
	private CuentaCorrienteDAO ctaCtesDAO = new CuentaCorrienteDAOImpl();

	public List<CuentaCorriente> listarCuentasCorrientes() {
		return ctaCtesDAO.listarCuentaCorrienteDAO();
	}
	public CuentaCorriente getCuentaCorrienteByIdBO(Integer idCuentaCorriente) {
		return ctaCtesDAO.getCtaCteById(idCuentaCorriente);
	}

	public void guardarCuentaCorriente(CuentaCorriente cuentaCorriente){
		this.ctaCtesDAO.guardarCuentaCorriente(cuentaCorriente);
	}

	public void borrarCuentaCorriente(Integer id){
		this.ctaCtesDAO.borrarCuentaCorriente(id);
	}
}

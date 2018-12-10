package bo.impl;

import java.util.ArrayList;
import java.util.List;

import dao.CuentaCorrienteDAO;
import dao.impl.CuentaCorrienteDAOImpl;
import entities.CuentaCorriente;


public class CuentaCorrienteBOImpl {
	
	private CuentaCorrienteDAO ctaCtesDAO = new CuentaCorrienteDAOImpl();
	private List<CuentaCorriente> ctasCtes = new ArrayList<CuentaCorriente>();;

	public List<CuentaCorriente> listarCuentasCorrientes() {
		return ctaCtesDAO.listarCuentaCorrienteDAO();
	}

}

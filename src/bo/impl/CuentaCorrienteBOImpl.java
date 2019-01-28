package bo.impl;

import java.util.List;

import bo.CuentacorrienteBO;
import dao.CuentaCorrienteDAO;
import dao.impl.CuentaCorrienteDAOImpl;
import entities.CuentaCorriente;

public class CuentaCorrienteBOImpl implements CuentacorrienteBO {
	private CuentaCorrienteDAO ctaCtesDAO = new CuentaCorrienteDAOImpl();

	@Override
	public List<CuentaCorriente> listarCuentasCorrientes() {
		return ctaCtesDAO.listarCuentaCorrienteDAO();
	}

	@Override
	public CuentaCorriente getCuentaCorrienteByIdBO(Integer idCuentaCorriente) {
		return ctaCtesDAO.getCtaCteById(idCuentaCorriente);
	}

	@Override
	public void guardarCuentaCorriente(CuentaCorriente cuentaCorriente) {
		this.ctaCtesDAO.guardarCuentaCorriente(cuentaCorriente);
	}

	@Override
	public void borrarCuentaCorriente(Integer id) {
		this.ctaCtesDAO.borrarCuentaCorriente(id);
	}
}

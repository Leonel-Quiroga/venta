package dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import dao.CuentaCorrienteDAO;
import dao.DAO;
import entities.CuentaCorriente;

public class CuentaCorrienteDAOImpl implements CuentaCorrienteDAO {
	public DAO<CuentaCorriente> dao = new DAO<CuentaCorriente>();
	private static Logger log = Logger.getLogger(CuentaCorrienteDAOImpl.class);

	public DAO<CuentaCorriente> getDao() {
		return dao;
	}

	public void setDao(DAO<CuentaCorriente> dao) {
		this.dao = dao;
	}

	public static Logger getLog() {
		return log;
	}

	@SuppressWarnings("unchecked")
	public List<CuentaCorriente> listarCuentaCorrienteDAO() {
		Session s = dao.getSession();
		List<CuentaCorriente> ctasCtes = new ArrayList<CuentaCorriente>();
		try {
			Criteria c = s.createCriteria(CuentaCorriente.class);
			c.addOrder(Order.asc("apellido"));
			ctasCtes = c.list();
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		} finally {
			dao.cerrarSession();
		}
		return ctasCtes;
	}

	public CuentaCorriente getCtaCteById(Integer idCuentaCorriente) {
		Session s = dao.getSession();
		Transaction tx = s.getTransaction();
		Criteria c = s.createCriteria(CuentaCorriente.class);
		CuentaCorriente ctaCte = null;
		try {
			c.add(Restrictions.eq("idCuentaCorriente", idCuentaCorriente));
			ctaCte = (CuentaCorriente) c.uniqueResult();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			dao.cerrarSession();
		}
		return ctaCte;
	}

	@Override
	public void guardarCuentaCorriente(CuentaCorriente cuentaCorriente) {
		dao.grabar(cuentaCorriente);
	}

	@Override
	public void borrarCuentaCorriente(Integer id) {
		this.dao.borrarPorId(CuentaCorriente.class, id);
	}

}
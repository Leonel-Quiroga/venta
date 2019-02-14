package dao.impl;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import dao.DAO;
import dao.LoginDAO;
import entities.Usuario;

public class LoginDAOImpl implements LoginDAO {
	private static Logger log = Logger.getLogger(LoginDAOImpl.class);

	public DAO<Usuario> dao = new DAO<Usuario>();

	@Override
	public Usuario auth(String usuario) throws SQLException {
		Transaction tx = null;
		Usuario respuesta;
		try {
			Session session = dao.getSession();
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Usuario.class, "usuario");
			criteria.add(Restrictions.eq("usuario", usuario));
			respuesta = (Usuario) criteria.uniqueResult();
			return respuesta;
		} catch (HibernateException e) {
			tx.rollback();
			log.error(e.toString());
			throw new SQLException(e.getMessage());
		} finally {
			dao.cerrarSession();
		}
	}
}

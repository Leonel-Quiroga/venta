package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtil;

public class DAO<T> {

	public DAO() {
	}

	// **************** Metodos comunes CRUD *********************

	// Graba el objeto
	public void grabar(T obj) {
		Transaction tx = null;
		try {
			Session session = getSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(obj);
			tx.commit();
		} catch (HibernateException e) {
			System.out.println("HibernateException: " + e.getMessage());
			tratarException(tx, e);
			throw e;
		} catch (Exception e) {
			System.out.println("Exception en DAO grabar: " + e.getMessage());
			throw e;
		} finally {
			cerrarSession();
		}
	}

	// Actualiza el objeto
	public void actualizar(T obj) {
		Transaction tx = null;

		try {
			Session session = getSession();
			tx = session.beginTransaction();
			session.merge(obj);
			tx.commit();
		} catch (HibernateException e) {
			tratarException(tx, e);
		} finally {
			cerrarSession();
		}
	}

	// Borrar pasandole el objeto a borrar
	public void borrar(T obj) {
		Transaction tx = null;
		try {
			Session session = getSession();
			tx = session.beginTransaction();
			session.delete(obj);
			tx.commit();
		} catch (HibernateException e) {
			System.out.println("Exception borrar: " + e.getMessage());
			tratarException(tx, e);
		} catch (Exception e) {
			System.out.println("Exception borrar: " + e.getMessage());
		} finally {
			cerrarSession();
		}
	}

	// Borrar por ID
	@SuppressWarnings("unchecked")
	public void borrarPorId(Class<T> clazz, int id) {
		T obj = null;
		Transaction tx = null;
		try {
			Session session = getSession();
			System.out.println("Session : " + session);
			tx = session.beginTransaction();
			obj = (T) session.get(clazz, id);
			session.delete(obj);
			tx.commit();
		} catch (HibernateException e) {
			tratarException(tx, e);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			cerrarSession();
		}

	}

	// Buscar por ID
	@SuppressWarnings("unchecked")
	public T buscar(Class<T> clazz, Long id) {
		T obj = null;
		Transaction tx = null;

		try {
			Session session = getSession();
			tx = session.beginTransaction();
			obj = (T) session.get(clazz, id);
			tx.commit();
		} catch (HibernateException e) {
			tratarException(tx, e);
		} finally {
			cerrarSession();
		}

		return obj;
	}

	// Buscar todos
	@SuppressWarnings("unchecked")
	public List<T> buscarTodos(Class<T> clazz) {
		List<T> objects = null;
		Transaction tx = null;
		try {
			Session session = getSession();
			tx = session.beginTransaction();
			objects = session.createQuery("from " + clazz.getName() + " c").list();
			tx.commit();
		} catch (HibernateException e) {
			System.out.println("Exception en buscarTodos: " + e.getMessage());
			tratarException(tx, e);
		} catch (Exception ex) {
			System.out.println("Exception en buscarTodos: " + ex.getMessage());
		} finally {
			cerrarSession();
		}
		return objects;
	}

	// Hibernate Util--------------------------------------------------------

	// Se obtiene una instancia de HibernateUtil
	public HibernateUtil getHibernateUtil() {
		return HibernateUtil.getInstancia();
	}

	// Trata la excepcion
	public void tratarException(Transaction tx, HibernateException e) {
		if (tx != null)
			getHibernateUtil().rollback(tx);
	}

	// Obtiene una sesion
	public Session getSession() {
		return getHibernateUtil().getSession();
	}

	// Cierra la sesion
	public void cerrarSession() {
		getHibernateUtil().cerrarSession();
	}

}

package utils;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static HibernateUtil instancia;
	private SessionFactory sessionFactory;
	private ThreadLocal<Session> session;
	private static Logger log = Logger.getLogger(HibernateUtil.class);

	// Constructor, inicializo variables
	private HibernateUtil() {
		try {
			Configuration c = new Configuration();
			sessionFactory = c.configure("hibernate.cfg.xml").buildSessionFactory();
			session = new ThreadLocal<Session>();
		} catch (HibernateException ex) {
			log.error("Creación del SessionFactory fallada." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	// Obtengo instancia
	public static synchronized HibernateUtil getInstancia() {
		if (instancia == null) {
			instancia = new HibernateUtil();
		}

		return instancia;
	}

	// Creo la session
	public Session getSession() {
		Session s = (Session) session.get();

		if (s == null) {
			s = sessionFactory.openSession();
			session.set(s);
		}

		return s;
	}

	// Cierro la session
	public void cerrarSession() {
		Session s = (Session) session.get();

		if (s != null)
			s.close();

		session.set(null);
	}

	// Cierro la Factory
	public void cerrarFactory() {
		if (sessionFactory != null) {
			try {
				sessionFactory.close();
				sessionFactory = null;
				session = null;
			} catch (HibernateException ignored) {
				log.error("No se pudo cerrar la sessionFactory. " + ignored);
			}
		}
	}

	// Rollback
	public void rollback(Transaction tx) {
		try {
			if (tx != null) {
				tx.rollback();
			}
		} catch (HibernateException ignored) {
			log.error("No se pudo hacer el rollback de la transaccion. " + ignored);
		}
	}

}

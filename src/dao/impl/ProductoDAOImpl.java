package dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import dao.DAO;
import dao.ProductoDAO;
import entities.CuentaCorriente;
import entities.Producto;

public class ProductoDAOImpl implements ProductoDAO {

	public DAO<Producto> dao = new DAO<Producto>();
	private static Logger log = Logger.getLogger(ProductoDAOImpl.class);

	public static Logger getLog() {
		return log;
	}

	public List<Producto> listarProductosDAO() {
		Session s = dao.getSession();
		Transaction tx = s.getTransaction();
		List<Producto> prouctos = new ArrayList<Producto>();
		try {
			Criteria c = s.createCriteria(Producto.class);
			c.addOrder(Order.asc("nombre"));
			prouctos = c.list();
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		} finally {
			dao.cerrarSession();
		}
		return prouctos;
	}

}

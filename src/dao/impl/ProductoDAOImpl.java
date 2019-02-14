package dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import dao.DAO;
import dao.ProductoDAO;
import entities.Producto;

public class ProductoDAOImpl implements ProductoDAO {

	public DAO<Producto> dao = new DAO<Producto>();
	private static Logger log = Logger.getLogger(ProductoDAOImpl.class);

	public static Logger getLog() {
		return log;
	}

	@SuppressWarnings("unchecked")
	public List<Producto> listarProductosDAO() {
		Session s = dao.getSession();
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

	@Override
	public Producto getProductoById(Integer id) {
		Session s = dao.getSession();
		Producto p = new Producto();
		try {
			Criteria c = s.createCriteria(Producto.class);
			c.add(Restrictions.eq("idProducto", id));
			p = (Producto) c.uniqueResult();
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		} finally {
			dao.cerrarSession();
		}
		return p;
	}

	@Override
	public void guardarProducto(Producto producto) {
		this.dao.grabar(producto);
	}

	@Override
	public void borrarProducto(Integer id) {
		this.dao.borrarPorId(Producto.class, id);
	}

}

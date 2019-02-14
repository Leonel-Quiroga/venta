package dao.impl;

import dao.DAO;
import dao.LocalidadDAO;
import entities.Localidad;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

public class LocalidadDAOImpl implements LocalidadDAO {
    public DAO<Localidad> dao = new DAO<>();
    private static Logger log = Logger.getLogger(LocalidadDAOImpl.class);

    public DAO<Localidad> getDao() {
        return dao;
    }

    public void setDao(DAO<Localidad> dao) {
        this.dao = dao;
    }

    public static Logger getLog() {
        return log;
    }
    
    @Override
    public List<Localidad> listarLocalidades() {
        Session s = dao.getSession();
        Transaction tx = s.getTransaction();
        List<Localidad> localidades = new ArrayList<Localidad>();
        try {
            Criteria c = s.createCriteria(Localidad.class);
            c.addOrder(Order.asc("denominacion"));
            localidades = c.list();
        } catch (Exception e) {
            log.error(e);
            e.printStackTrace();
        } finally {
            dao.cerrarSession();
        }
        return localidades;
    }
}

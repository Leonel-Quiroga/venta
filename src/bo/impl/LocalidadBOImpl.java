package bo.impl;

import dao.LocalidadDAO;
import dao.impl.LocalidadDAOImpl;
import entities.Localidad;

import java.util.List;


public class LocalidadBOImpl {

    private LocalidadDAO localidadDAO = new LocalidadDAOImpl();

    public List<Localidad> listarLocalidadeds(){
        return localidadDAO.listarLocalidades();
    }
}

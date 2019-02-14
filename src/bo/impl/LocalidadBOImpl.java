package bo.impl;

import dao.LocalidadDAO;
import dao.impl.LocalidadDAOImpl;
import entities.Localidad;

import java.util.List;

import bo.LocalidadBO;

public class LocalidadBOImpl implements LocalidadBO {

    private LocalidadDAO localidadDAO = new LocalidadDAOImpl();

    @Override
    public List<Localidad> listarLocalidadeds(){
        return localidadDAO.listarLocalidades();
    }
}

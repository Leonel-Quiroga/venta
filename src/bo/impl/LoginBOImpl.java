package bo.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

import bo.LoginBO;
import dao.LoginDAO;
import dao.impl.LoginDAOImpl;
import entities.Usuario;
import exceptions.LoginException;

public class LoginBOImpl implements LoginBO {

	private LoginDAO loginDAO = new LoginDAOImpl();
	private static Logger log = Logger.getLogger(LoginBOImpl.class);

	@Override
	public Usuario autenticar(String usuario, String contrasenia) throws Exception, LoginException {
		Usuario userEntitie = new Usuario();
		try {
			userEntitie = loginDAO.auth(usuario);
			if (null != userEntitie) {
				if (userEntitie.getUsuario().equals(usuario)) {
					if (userEntitie.getContrasenia().equals(contrasenia)) {
						return userEntitie;
					} else {
						log.warn(getTextProperty("USUARIO_INVALIDO"));
						throw new LoginException(getTextProperty("USUARIO_INVALIDO"));
					}
				} else {
					log.warn(getTextProperty("CLAVE_INVALIDA"));
					throw new LoginException(getTextProperty("CLAVE_INVALIDA"));
				}
			} else {
				log.warn(getTextProperty("DOC_INVALIDO"));
				throw new LoginException(getTextProperty("DOC_INVALIDO"));
			}
		} catch (SQLException e) {
			log.error(e.toString());
			throw new Exception(getTextProperty("ERROR"));
		}
	}

	private String getTextProperty(String key) {
		Properties prop = new Properties();
		try {
			prop.load(getClass().getResourceAsStream("../Utils/Constantes.properties"));
		} catch (IOException e) {
			log.error(e.toString());
		}
		return prop.getProperty(key.toUpperCase());
	}

}

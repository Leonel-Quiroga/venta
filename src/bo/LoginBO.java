package bo;

import entities.Usuario;
import exceptions.LoginException;

public interface LoginBO {

	public Usuario autenticar(String usuario,String contrasenia)throws LoginException, Exception;

}

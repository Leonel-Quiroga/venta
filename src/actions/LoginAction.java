package actions;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import bo.LoginBO;
import bo.impl.LoginBOImpl;
import entities.*;
import exceptions.LoginException;

public class LoginAction extends ActionSupport implements SessionAware, Action {

	private static final long serialVersionUID = 2630058019226882067L;
	private static final String VALIDATION_ERROR = "validationError";

	private static Logger log = Logger.getLogger(LoginAction.class);

	private Map<String, Object> sesion;
	private String usuario;
	private String contrasenia;
	private Usuario user;
	private String message;

	// banderas de errores.
	private boolean err;
	private int coderr;
	private boolean mail;
	private LoginBO loginBO = new LoginBOImpl();
	private boolean valido;

	public String execute() {

		return SUCCESS;
	}
	// -------------------------------- Login ----------------------------

	public String login() {
		if (StringUtils.isNotEmpty(getUsuario()) && StringUtils.isNotEmpty(getContrasenia())) {
			try {
				err = false;
				this.user = loginBO.autenticar(getUsuario(), getContrasenia());
				valido = true;
				sesion.put("usuario", this.user);
				return SUCCESS;
			} catch (LoginException e) {
				log.error(e.toString());
				setMessage(e.getMessage());
				err = true;
				return VALIDATION_ERROR;
			} catch (Exception e) {
				log.error(e.toString());
				setMessage(e.getMessage());
				err = true;
				return ERROR;
			}
		} else {
			err = true;
			setMessage("Ingrese contraseña");
			return VALIDATION_ERROR;
		}
	}

	public String logout() {
		sesion.clear();
		return SUCCESS;
	}

	// ------------------- Getters y setters ------------------------
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void setSession(Map<String, Object> map) {
		this.sesion = map;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public boolean isErr() {
		return err;
	}

	public void setErr(boolean err) {
		this.err = err;
	}

	public boolean isValido() {
		return valido;
	}

	public void setValido(boolean valido) {
		this.valido = valido;
	}

	public boolean isMail() {
		return mail;
	}

	public void setMail(boolean mail) {
		this.mail = mail;
	}

	public int getCoderr() {
		return coderr;
	}

	public void setCoderr(int coderr) {
		this.coderr = coderr;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

}

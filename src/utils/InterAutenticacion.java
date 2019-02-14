package utils;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import entities.Usuario;

import java.util.Map;

public class InterAutenticacion implements Interceptor {

	private static final long serialVersionUID = -8944193282347182872L;

	public void destroy() {
	}

	public void init() {
	}

	public String intercept(ActionInvocation actionInvocation) throws Exception {
		@SuppressWarnings("rawtypes")
		Map session = actionInvocation.getInvocationContext().getSession();
		Usuario usuario = (Usuario) session.get("usuario");
		if (usuario == null) {
			return Action.LOGIN;
		} else {
			Action action = (Action) actionInvocation.getAction();
			if (action instanceof UsuarioHabilitado) {
				((UsuarioHabilitado) action).setUsuario(usuario);
			}
			return actionInvocation.invoke();
		}
	}
}
package actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import bo.impl.CuentaCorrienteBOImpl;
import bo.impl.ProductoBOImpl;
import entities.CuentaCorriente;
import entities.Producto;
import entities.Usuario;

public class MovimientoAction extends ActionSupport implements SessionAware, Action {

	private static final long serialVersionUID = 2026769441835470521L;
	private Map<String, Object> sesion;
	private List<CuentaCorriente> listCtasCtes = new ArrayList<CuentaCorriente>();
	private List<Producto> listProductos = new ArrayList<Producto>();
	private ProductoBOImpl productoBO = new ProductoBOImpl();
	private CuentaCorrienteBOImpl ctasCtesBO = new CuentaCorrienteBOImpl();
	private Usuario usuario = new Usuario();

	public String execute() {
		cargarCtasCtes();
		cargarProductos();
		return SUCCESS;
	}

	private void cargarCtasCtes() {
		listCtasCtes = ctasCtesBO.listarCuentasCorrientes();
	}

	private void cargarProductos() {
		listProductos = productoBO.listarProductos();
	}

	public List<Producto> getListProductos() {
		return listProductos;
	}

	public void setListProductos(List<Producto> listProductos) {
		this.listProductos = listProductos;
	}

	public ProductoBOImpl getProductoBO() {
		return productoBO;
	}

	public void setProductoBO(ProductoBOImpl productoBO) {
		this.productoBO = productoBO;
	}

	public List<CuentaCorriente> getListCtasCtes() {
		return listCtasCtes;
	}

	public void setListCtasCtes(List<CuentaCorriente> listCtasCtes) {
		this.listCtasCtes = listCtasCtes;
	}

	public CuentaCorrienteBOImpl getCtasCtesBO() {
		return ctasCtesBO;
	}

	public void setCtasCtesBO(CuentaCorrienteBOImpl ctasCtesBO) {
		this.ctasCtesBO = ctasCtesBO;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public void setSession(Map<String, Object> map) {
		this.sesion = map;
	}

}

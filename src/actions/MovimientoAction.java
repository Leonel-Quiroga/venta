package actions;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import bo.impl.CuentaCorrienteBOImpl;
import bo.impl.MovimientoBOImpl;
import bo.impl.ProductoBOImpl;
import dto.DetalleFacturaDTO;
import dto.FacturaDTO;
import entities.CuentaCorriente;
import entities.Producto;
import entities.Usuario;

public class MovimientoAction extends ActionSupport implements SessionAware, Action {

	private static final long serialVersionUID = 2026769441835470521L;
	private Map<String, Object> sesion;

	//CAMPOS FORM
	private int idProducto, cantidad;
	private Integer idCuentaCorriente;
	private List<CuentaCorriente> listCtasCtes = new ArrayList<CuentaCorriente>();
	private Producto producto = new Producto();
	private Usuario usuario = new Usuario();


	private CuentaCorriente ctaCte = new CuentaCorriente();
	private String validaciones;


	private List<Producto> listProductos = new ArrayList<Producto>();
	private List<DetalleFacturaDTO> listDetalleFactura = new ArrayList<DetalleFacturaDTO>();
	private FacturaDTO totalAfacturar = new FacturaDTO();
	private DetalleFacturaDTO detalleFacturaDTO = new DetalleFacturaDTO();

	private ProductoBOImpl productoBO = new ProductoBOImpl();
	private CuentaCorrienteBOImpl ctasCtesBO = new CuentaCorrienteBOImpl();
	private MovimientoBOImpl movimientoBO = new MovimientoBOImpl();

	// e = erase;
	private boolean e;

	public String execute() {
		if (e) {
			sesion.clear();
			e = !e;
		}
		cargarCtasCtes();
		cargarProductos();
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String agregarProducto() {
		//Obtengo cta. cte.
		ctaCte = ctasCtesBO.getCuentaCorrienteByIdBO(idCuentaCorriente);

		//Obtengo producto
		producto = productoBO.getProductoByIdBO(idProducto);

		//Si hay poductos obtengo la lista
		if (sesion.containsKey("detalleVenta")) listDetalleFactura = (List<DetalleFacturaDTO>) sesion.get("detalleVenta");

		//Si se encuentra en la lista arroja un mensaje
//		 if (sesion.containsKey("detalleVenta")) {
//			 setValidaciones("El producto ya se encuentra en lista");
//			 return ERROR;
//		 }

		//Evaluo el stock del producto
		if (movimientoBO.validarStock(this.getCantidad(), producto.getCantidad())) return ERROR;

		//Cargo valores del detalle
		detalleFacturaDTO = movimientoBO.generarDetalle(producto.getIdProducto(), producto.getCodigo(), producto.getNombre(), cantidad, producto.getPrecioUnitario());

		//Cargo lista de productos
		listDetalleFactura.add(detalleFacturaDTO);

		//Calculo total a facturar
		totalAfacturar = movimientoBO.totalAfacturar(listDetalleFactura);

		sesion.put("idCuentaCorriente", ctaCte);
		sesion.put("totalesFactura", detalleFacturaDTO);
		sesion.put("detalleVenta", listDetalleFactura);
		sesion.put("totalAfacturar", totalAfacturar);


		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String facturar() throws SQLException {
		if (sesion.containsKey("detalleVenta"))
			listDetalleFactura = (List<DetalleFacturaDTO>) sesion.get("detalleVenta");

		if (sesion.containsKey("totalAfacturar"))
			totalAfacturar = (FacturaDTO) sesion.get("totalAfacturar");

		ctaCte = (CuentaCorriente) sesion.get("idCuentaCorriente");

		movimientoBO.generarFactura(ctaCte, listDetalleFactura, totalAfacturar);

		this.limpiarVariablesDeSesion();

		return SUCCESS;
	}

	private void limpiarVariablesDeSesion() {
		sesion.remove("idCuentaCorriente", ctaCte);
		sesion.remove("totalesFactura", detalleFacturaDTO);
		sesion.remove("detalleVenta", listDetalleFactura);
		sesion.remove("totalAfacturar", totalAfacturar);
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

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public DetalleFacturaDTO getPoductoDTO() {
		return detalleFacturaDTO;
	}

	public void setPoductoDTO(DetalleFacturaDTO detalleFacturaDTO) {
		this.detalleFacturaDTO = detalleFacturaDTO;
	}

	public Integer getIdCuentaCorriente() {
		return idCuentaCorriente;
	}

	public void setIdCuentaCorriente(Integer idCuentaCorriente) {
		this.idCuentaCorriente = idCuentaCorriente;
	}

	public List<DetalleFacturaDTO> getMovimientoDetalle() {
		return listDetalleFactura;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public DetalleFacturaDTO getProductoDTO() {
		return detalleFacturaDTO;
	}

	public void setProductoDTO(DetalleFacturaDTO detalleFacturaDTO) {
		this.detalleFacturaDTO = detalleFacturaDTO;
	}

	public boolean isE() {
		return e;
	}

	public void setE(boolean e) {
		this.e = e;
	}

	public String getValidaciones() {
		return validaciones;
	}

	public void setValidaciones(String validaciones) {
		this.validaciones = validaciones;
	}

}

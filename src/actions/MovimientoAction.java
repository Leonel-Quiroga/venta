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
import entities.CuentaCorriente;
import entities.Producto;
import entities.Usuario;

public class MovimientoAction extends ActionSupport implements SessionAware, Action {

	private static final long serialVersionUID = 2026769441835470521L;
	private Map<String, Object> sesion;

	private int idProducto, cantidad;
	private Integer idCuentaCorriente;
	private Usuario usuario = new Usuario();
	private Producto producto = new Producto();
	private CuentaCorriente ctaCte = new CuentaCorriente();
	private String validaciones;

	private List<CuentaCorriente> listCtasCtes = new ArrayList<CuentaCorriente>();
	private List<Producto> listProductos = new ArrayList<Producto>();
	private List<DetalleFacturaDTO> movimientoDetalle = new ArrayList<DetalleFacturaDTO>();

	private DetalleFacturaDTO productoDTO = new DetalleFacturaDTO();

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

		if (sesion.containsKey("detalleVenta"))
			movimientoDetalle = (List<DetalleFacturaDTO>) sesion.get("detalleVenta");

		producto = productoBO.getProductoByIdBO(idProducto);
		ctaCte = ctasCtesBO.getCuentaCorrienteByIdBO(idCuentaCorriente);

		if (getCantidad() > producto.getCantidad()) {
			return ERROR;
		}

		productoDTO.setIdProducto(producto.getIdProducto());
		productoDTO.setCodigo(producto.getCodigo());
		productoDTO.setNombre(producto.getNombre());
		productoDTO.setCantidad(cantidad);
		productoDTO.setPrecioUnitario(producto.getPrecioUnitario());
		productoDTO.setTotalPorUnidad(productoBO.calcularTotalPorUnidad(producto.getPrecioUnitario(), cantidad));
		productoDTO.setIva(productoBO.calcualarIVA(productoDTO.getTotalPorUnidad()));
		productoDTO.setTotal(productoBO.calcularTotal(productoDTO.getTotalPorUnidad(), productoDTO.getIva()));
		productoDTO.setTotalNetoFactura(productoBO.calcularNeto(movimientoDetalle, productoDTO.getTotalPorUnidad()));
		productoDTO.setTotalIVAFactura(productoBO.calcularTotalIVA(movimientoDetalle, productoDTO.getIva()));
		productoDTO.setTotalFactura(
				productoBO.calcularTotalFacturado(productoDTO.getTotalNetoFactura(), productoDTO.getTotalIVAFactura()));

		// HAY QUE MODIFICAR ESTO
		// if (sesion.containsKey("detalleVenta")) {
		// this.setValidaciones("El producto ya se encuentra en lista");
		// return ERROR;
		// }

		movimientoDetalle.add(productoDTO);

		sesion.put("idCuentaCorriente", ctaCte);
		sesion.put("detalleVenta", movimientoDetalle);
		sesion.put("totalesFactura", productoDTO);

		return SUCCESS;
	}

	public String facturar() throws SQLException {
		if (sesion.containsKey("detalleVenta"))
			movimientoDetalle = (List<DetalleFacturaDTO>) sesion.get("detalleVenta");
		ctaCte = (CuentaCorriente) sesion.get("idCuentaCorriente");

		movimientoBO.generarFactura(ctaCte, movimientoDetalle);
		sesion.remove("idCuentaCorriente");
		sesion.remove("detalleVenta");
		sesion.remove("totalesFactura");
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
		return productoDTO;
	}

	public void setPoductoDTO(DetalleFacturaDTO productoDTO) {
		this.productoDTO = productoDTO;
	}

	public Integer getIdCuentaCorriente() {
		return idCuentaCorriente;
	}

	public void setIdCuentaCorriente(Integer idCuentaCorriente) {
		this.idCuentaCorriente = idCuentaCorriente;
	}

	public List<DetalleFacturaDTO> getMovimientoDetalle() {
		return movimientoDetalle;
	}

	public void setMovimientoDetalle(List<DetalleFacturaDTO> movimientoDetalle) {
		this.movimientoDetalle = movimientoDetalle;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public DetalleFacturaDTO getProductoDTO() {
		return productoDTO;
	}

	public void setProductoDTO(DetalleFacturaDTO productoDTO) {
		this.productoDTO = productoDTO;
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

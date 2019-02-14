package actions;

import bo.impl.ProductoBOImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import entities.Producto;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class ProductosAction  extends ActionSupport implements SessionAware, Action {

	private static final long serialVersionUID = -6683435494173541127L;
	private Map<String, Object> sesion;
    private static Logger log = Logger.getLogger(ProductosAction.class);


    // ALTA PRODUCTO
    private Integer codigo;
    private String nombre;
    private  Integer cantidad;
    private Double precioUnitario;

    // LISTA PRODUCTOS
    private List<Producto> listaProductos;

    // ID DEL PRODUCTO A BORRAR
    private Integer idProducto;

    private ProductoBOImpl productoBO = new ProductoBOImpl();

    public String input(){
        return SUCCESS;
    }

    public String listaProductos(){
        this.listaProductos =productoBO.listarProductos();
        return SUCCESS;
    }

    public String guardarProducto(){
        Producto producto = new Producto();
        producto.setNombre(this.nombre);
        producto.setCantidad(this.cantidad);
        producto.setPrecioUnitario(this.precioUnitario);
        producto.setCodigo(this.codigo);
        producto.setActivo(true);
        producto.setAlta(new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()));

        try {
           productoBO.guardarProducto(producto);
           return SUCCESS;
        } catch (Exception e){
            log.error(e.getMessage());
            return ERROR;
        }
    }

    public String borrarProducto(){
        this.productoBO.borrarProducto(this.idProducto);
        return SUCCESS;
    }

    public Map<String, Object> getSesion() {
        return sesion;
    }

    public void setSesion(Map<String, Object> sesion) {
        this.sesion = sesion;
    }

    public static Logger getLog() {
        return log;
    }

    public static void setLog(Logger log) {
        ProductosAction.log = log;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public ProductoBOImpl getProductoBO() {
        return productoBO;
    }

    public void setProductoBO(ProductoBOImpl productoBO) {
        this.productoBO = productoBO;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.sesion = map;
    }
}

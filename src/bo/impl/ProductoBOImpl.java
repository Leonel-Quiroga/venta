package bo.impl;

import java.util.ArrayList;
import java.util.List;

import dao.ProductoDAO;
import dao.impl.ProductoDAOImpl;
import entities.Producto;

public class ProductoBOImpl {
	private ProductoDAO productoDAO = new ProductoDAOImpl();
	private List<Producto> productos =  new ArrayList<Producto>();
	
	public List<Producto> listarProductos() {
		return productoDAO.listarProductosDAO();
	}

	public void guardarProducto(Producto producto){
		productoDAO.guardarProducto(producto);
	}

	public void borrarProducto(Integer id){
		productoDAO.borrarProducto(id);
	}
	
}

package dao;

import java.util.List;

import entities.Producto;


public interface ProductoDAO {

	public List<Producto> listarProductosDAO();
	public Producto getProductoById(Integer id);
	public void guardarProducto( Producto producto );
	public void borrarProducto(Integer id);
}

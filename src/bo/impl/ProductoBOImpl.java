package bo.impl;


import java.util.List;

import dao.ProductoDAO;
import dao.impl.ProductoDAOImpl;
import dto.DetalleFacturaDTO;
import entities.Producto;

public class ProductoBOImpl {
	private ProductoDAO productoDAO = new ProductoDAOImpl();
	public static final Double IVA = 0.21;

	public List<Producto> listarProductos() {
		return productoDAO.listarProductosDAO();
	}

	public Producto getProductoByIdBO(Integer procutoId) {
		return productoDAO.getProductoById(procutoId);
	}

	public Double calcularTotalPorUnidad(Double t, Integer u) {
		return t * u;
	}

	public Double calcualarIVA(Double n) {
		return n * IVA;
	}

	public Double calcularTotal(Double n, Double i) {
		return n + i;
	}

	public Double calcularTotalIVA(List<DetalleFacturaDTO> p, Double iva) {
		Double i = iva;
		for (DetalleFacturaDTO productoDTO : p) {
			i += productoDTO.getIva();
		}
		return i;
	}

	public Double calcularNeto(List<DetalleFacturaDTO> p, Double neto) {
		Double n = neto;
		for (DetalleFacturaDTO productoDTO : p) {
			n += productoDTO.getTotalPorUnidad();
		}
		return n;
	}

	public Double calcularTotalFacturado(Double n, Double i) {
		return n + i;
	}
	
	public void guardarProducto(Producto producto){
		productoDAO.guardarProducto(producto);
	}

	public void borrarProducto(Integer id){
		productoDAO.borrarProducto(id);
	}

}

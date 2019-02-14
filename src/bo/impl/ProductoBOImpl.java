package bo.impl;

import java.util.List;

import bo.ProductoBO;
import dao.ProductoDAO;
import dao.impl.ProductoDAOImpl;
import dto.DetalleFacturaDTO;
import entities.Producto;

public class ProductoBOImpl implements ProductoBO {
	private ProductoDAO productoDAO = new ProductoDAOImpl();
	public static final Double IVA = 0.21;

	@Override
	public List<Producto> listarProductos() {
		return productoDAO.listarProductosDAO();
	}

	@Override
	public Producto getProductoByIdBO(Integer procutoId) {
		return productoDAO.getProductoById(procutoId);
	}

	@Override
	public Double calcularTotalPorUnidad(Double t, Integer u) {
		return t * u;
	}

	@Override
	public Double calcualarIVA(Double n) {
		return n * IVA;
	}

	@Override
	public Double calcularTotal(Double n, Double i) {
		return n + i;
	}

	@Override
	public Double calcularTotalIVA(List<DetalleFacturaDTO> p, Double iva) {
		Double i = iva;
		for (DetalleFacturaDTO productoDTO : p) {
			i += productoDTO.getIva();
		}
		return i;
	}

	@Override
	public Double calcularNeto(List<DetalleFacturaDTO> p, Double neto) {
		Double n = neto;
		for (DetalleFacturaDTO productoDTO : p) {
			n += productoDTO.getTotalPorUnidad();
		}
		return n;
	}

	@Override
	public Double calcularTotalFacturado(Double n, Double i) {
		return n + i;
	}

	@Override
	public void guardarProducto(Producto producto) {
		productoDAO.guardarProducto(producto);
	}

	public void borrarProducto(Integer id) {
		productoDAO.borrarProducto(id);
	}

	@Override
	public boolean isStockMinimo(Integer stockActual, Integer cantVenta) {
		// TODO Auto-generated method stub
		return (Boolean) null;
	}

}

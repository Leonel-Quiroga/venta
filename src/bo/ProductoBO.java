package bo;

import java.util.List;

import dto.DetalleFacturaDTO;
import entities.Producto;

public interface ProductoBO {
	
	public List<Producto> listarProductos();

	public Producto getProductoByIdBO(Integer procutoId);

	public Double calcularTotalPorUnidad(Double t, Integer u);

	public Double calcualarIVA(Double n);

	public Double calcularTotal(Double n, Double i);

	public Double calcularTotalIVA(List<DetalleFacturaDTO> p, Double iva);

	public Double calcularNeto(List<DetalleFacturaDTO> p, Double neto);

	public Double calcularTotalFacturado(Double n, Double i);

	public void guardarProducto(Producto producto);

	public void borrarProducto(Integer id);

	public boolean isStockMinimo(Integer stockActual, Integer cantVenta);

}

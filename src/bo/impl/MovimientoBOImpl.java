package bo.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import bo.MovimeintoBO;
import dao.MovimientoDAO;
import dao.impl.MovimientoDAOImpl;
import dto.DetalleFacturaDTO;
import dto.FacturaDTO;
import entities.CuentaCorriente;
import utils.MyUtil;
import bo.impl.ProductoBOImpl;

public class MovimientoBOImpl implements MovimeintoBO {
	private MovimientoDAO movimiento = new MovimientoDAOImpl();
	private ProductoBOImpl productoBO = new ProductoBOImpl();
	private Date date = new Date();
	private Timestamp t;

	@Override
	public void generarFactura(CuentaCorriente idCC, List<DetalleFacturaDTO> listDF, FacturaDTO f) throws SQLException {
		FacturaDTO factura = new FacturaDTO();
		factura.setIdCuentaCorriente(idCC.getIdCuentaCorriente());
		factura.setSubtotal(f.getSubtotal());
		factura.setIva(f.getIva());
		factura.setTotal(f.getTotal());
		factura.setDebito(f.getTotal());
		factura.setListDetalleFactura(listDF);
		factura.setEmision(new Timestamp(date.getTime()));
		t = new Timestamp(MyUtil.sumarRestarDiasFecha(date, 10).getTime());
		factura.setVencimiento(t);
		movimiento.insertarVenta(factura);
	}

	public FacturaDTO totalAfacturar(List<DetalleFacturaDTO> listDF) {
		FacturaDTO f = new FacturaDTO();
		Double s = 0.0;
		Double i = 0.0;
		Double t = 0.0;
		for (DetalleFacturaDTO df : listDF) {
			s += df.getTotalPorUnidad();
			i += df.getIva();
			t += df.getTotal();
		}
		f.setSubtotal(s);
		f.setIva(i);
		f.setTotal(t);
		f.setDebito(f.getTotal());
		return f;
	}

	public boolean validarStock(int cantCargada, int cantProducto) {
		return cantCargada > cantProducto ? true : false;
	}

	public DetalleFacturaDTO generarDetalle(Integer ip, Integer cod, String n, Integer can, Double pu) {
		DetalleFacturaDTO df = new DetalleFacturaDTO();
		df.setIdProducto(ip);
		df.setCodigo(cod);
		df.setNombre(n);
		df.setCantidad(can);
		df.setPrecioUnitario(pu);
		df.setTotalPorUnidad(productoBO.calcularTotalPorUnidad(pu, can));
		df.setIva(productoBO.calcualarIVA(df.getTotalPorUnidad()));
		df.setTotal(productoBO.calcularTotal(df.getTotalPorUnidad(), df.getIva()));
		return df;
	}

}

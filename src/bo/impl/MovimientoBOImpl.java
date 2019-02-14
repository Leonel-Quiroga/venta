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

public class MovimientoBOImpl implements MovimeintoBO {
	private FacturaDTO factura = new FacturaDTO();
	private DetalleFacturaDTO df = new DetalleFacturaDTO();
	private MovimientoDAO movimiento = new MovimientoDAOImpl();
	private Date date = new Date();
	private MyUtil mu = new MyUtil();
	private Timestamp t;

	@Override
	public void generarFactura(CuentaCorriente idCC, List<DetalleFacturaDTO> listDF) throws SQLException {

		factura.setIdCuentaCorriente(idCC.getIdCuentaCorriente());
		df = listDF.get(listDF.size() - 1);
		factura.setSubtotal(df.getTotalNetoFactura());
		factura.setIva(df.getTotalIVAFactura());
		factura.setDebito(df.getTotalFactura());
		factura.setTotal(df.getTotalFactura());
		factura.setListDetalleFactura(listDF);
		factura.setEmision(new Timestamp(date.getTime()));
		t = new Timestamp(mu.sumarRestarDiasFecha(date, 10).getTime());
		factura.setVencimiento(t);
		movimiento.insertarVenta(factura);

	}

}

package dao.impl;

import java.sql.SQLException;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.DAO;
import dao.MovimientoDAO;
import dto.DetalleFacturaDTO;
import dto.FacturaDTO;

public class MovimientoDAOImpl implements MovimientoDAO {
	private static Logger log = Logger.getLogger(MovimientoDAOImpl.class);
	public DAO<Object> dao = new DAO<Object>();

	public void insertarVenta(FacturaDTO f) throws SQLException {
		Transaction tx = null;
		Session session = dao.getSession();
		try {
			tx = session.beginTransaction();

			int maxIdMovimiento = (int) session
					.createSQLQuery("SELECT coalesce(max(idmovimiento),0) + 1 FROM movimientos;").uniqueResult();

			String str = "INSERT INTO movimientos(idmovimiento, idcuenta_corriente, idtipo_de_comprobante, idpunto_de_venta, debito, subtotal, iva, total, emision, vencimiento) "
					+ "VALUES( " + maxIdMovimiento + "," + f.getIdCuentaCorriente() + ", " + f.getTipocomprobante()
					+ ", " + f.getPuntodeventa() + ", " + f.getDebito() + ", " + f.getSubtotal() + ", " + f.getIva()
					+ "," + f.getTotal() + ", '" + f.getEmision() + "', '" + f.getVencimiento() + "');  ";

			int maxIdMovimietoDetalle = (int) session
					.createSQLQuery("SELECT coalesce(max(idmovimiento_detalle),0) + 1 FROM movimientos_detalles;")
					.uniqueResult();
			
			for (DetalleFacturaDTO v : f.getListDetalleFactura()) {

				str += "INSERT INTO movimientos_detalles (idmovimiento_detalle, idmovimiento, idproducto, cantidad, total_x_unidad)"
						+ "VALUES (" + maxIdMovimietoDetalle + "," + maxIdMovimiento + "," + v.getIdProducto() + ", "
						+ v.getCantidad() + "," + v.getTotalPorUnidad() + "); "
						+ "UPDATE productos SET cantidad = (cantidad - " + v.getCantidad() + ") WHERE idproducto = "
						+ v.getIdProducto() + ";";
				maxIdMovimietoDetalle += 1;
			}

			session.createSQLQuery(str).executeUpdate();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			JOptionPane.showMessageDialog(null, e);
			throw (SQLException) e;
		} finally {
			dao.cerrarSession();
		}
	}

	public static Logger getLog() {
		return log;
	}

	public static void setLog(Logger log) {
		MovimientoDAOImpl.log = log;
	}

}

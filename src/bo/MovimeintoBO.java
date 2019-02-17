package bo;

import java.sql.SQLException;
import java.util.List;

import dto.DetalleFacturaDTO;
import dto.FacturaDTO;
import entities.CuentaCorriente;

public interface MovimeintoBO {

	public void generarFactura(CuentaCorriente idCC, List<DetalleFacturaDTO> listDF, FacturaDTO f) throws SQLException;

}

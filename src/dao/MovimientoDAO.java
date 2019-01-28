package dao;

import java.sql.SQLException;

import dto.FacturaDTO;

public interface MovimientoDAO {

	public void insertarVenta(FacturaDTO f) throws SQLException;
}

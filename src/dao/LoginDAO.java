package dao;

import java.sql.SQLException;

import entities.*;

public interface LoginDAO {

	public Usuario auth(String usuario)throws SQLException;
	
}

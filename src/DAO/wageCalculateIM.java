package DAO;

import java.sql.SQLException;
import java.util.Vector;

public interface wageCalculateIM {
	public  void Calculate(String sql) throws SQLException;
	public void setBw(String sql5) throws SQLException  ;
	public void modyWg(String sql) throws SQLException;
}

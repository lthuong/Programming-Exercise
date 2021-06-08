package ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AirlineDAO {
		Connection conn = null;
		PreparedStatement preparedStmt;

		public boolean checkLogin(String email, String password) {
			conn = DBConnection.getConnection(); 
			boolean isAirline = false;
			try {
				preparedStmt = conn.prepareStatement("SELECT * FROM airlines WHERE airline_email = ? AND airline_password = ?");
				preparedStmt.setString(1, email);
				preparedStmt.setString(2, password);
				ResultSet rs = preparedStmt.executeQuery();
				if (rs.next()) {
					isAirline = true;
				}  
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return isAirline;
		}
}

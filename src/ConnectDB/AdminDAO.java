package ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDAO {
	Connection conn = null;
	PreparedStatement preparedStmt;

	public boolean checkLogin(String email, String password) {
		conn = DBConnection.getConnection(); 
		boolean isAdmin = false;
		try {
			preparedStmt = conn.prepareStatement("SELECT * FROM admins WHERE admin_email = ? AND admin_password = ?");
			preparedStmt.setString(1, email);
			preparedStmt.setString(2, password);
			ResultSet rs = preparedStmt.executeQuery();
			if (rs.next()) {
				isAdmin = true;
			}  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isAdmin;
	}
}

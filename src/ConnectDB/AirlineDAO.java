package ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 
 * @author Tuan Anh Nguyen
 *
 */
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
		
		public int updateNewFlightRequest(String airline_email, String dep, String arr, String start_date, String end_date,
				String dep_time, String arr_time, float basic_price, float premium_price, int flight_frequency) {
			int status = 0;
			try {
				conn = DBConnection.getConnection();
				preparedStmt = conn.prepareStatement("INSERT INTO new_flight_request (airline_email, dep, arr, start_date, end_date, dep_time, "
						+ "arr_time, basic_price, premium_price, flight_frequency) VALUES(?,?,?,?,?,?,?,?,?,?)");
				preparedStmt.setString(1, airline_email);
				preparedStmt.setString(2, dep);
				preparedStmt.setString(3, arr);
				preparedStmt.setString(4, start_date);
				preparedStmt.setString(5, end_date);
				preparedStmt.setString(6, dep_time);
				preparedStmt.setString(7, arr_time);
				preparedStmt.setFloat(8, basic_price);
				preparedStmt.setFloat(9, premium_price);
				preparedStmt.setInt(10, flight_frequency);
				status = preparedStmt.executeUpdate();
				conn.close();
			} catch (Exception e) {
				System.out.println(e);
			}
			return status;
			
		}
		
		public String getAirlineNameFromEmail(String airline_email) {
			conn = DBConnection.getConnection(); 
			String airline = "";
			try {
				preparedStmt = conn.prepareStatement("SELECT airline_name FROM airlines WHERE airline_email = ?");
				preparedStmt.setString(1, airline_email);
				ResultSet rs = preparedStmt.executeQuery();
				if (rs.next()) {
					airline = rs.getString(1);
				}  
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return airline;
		}
		
		public boolean checkFlightLineExisted(String dep, String arr) {
			boolean flightLineExiste = false;
			try {
				conn = DBConnection.getConnection();
				preparedStmt = conn.prepareStatement("SELECT * FROM flights_line WHERE city_dep = ? AND city_arr = ?");
				preparedStmt.setString(1, dep);
				preparedStmt.setString(2, arr);
				ResultSet rs = preparedStmt.executeQuery();
				if (rs.next()) {
					flightLineExiste = true;
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			return flightLineExiste;
		}
		
		public int getFlightLineID(String dep, String arr) {
			int flightLineID = 0;
			try {
				conn = DBConnection.getConnection();
				preparedStmt = conn.prepareStatement("SELECT id_line FROM flights_line WHERE city_dep = ? AND city_arr = ?");
				preparedStmt.setString(1, dep);
				preparedStmt.setString(2, arr);
				ResultSet rs = preparedStmt.executeQuery();
				if (rs.next()) {
					flightLineID = rs.getInt(1);
				}  
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return flightLineID;
		}
		
		
}

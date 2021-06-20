package ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import Models.User;

/**
 * 
 * @author Tuan Anh Nguyen
 *
 */
public class AdminDAO {
	static Connection conn = null;
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
	
	@SuppressWarnings("null")
	public void getRequestFromAirline(DefaultTableModel tb1Model, List<String[]> requests) {
		conn = DBConnection.getConnection(); 
		try {
			String sql = "SELECT * FROM new_flight_request;";
			
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				String idnew_flight_request = String.valueOf(rs.getInt("idnew_flight_request"));
				String airline_email = rs.getString("airline_email");
				String dep = rs.getString("dep");
				String arr = rs.getString("arr");
				String start_date = rs.getString("start_date");
				String end_date = rs.getString("end_date");
				String dep_time = rs.getString("dep_time");
				String arr_time = rs.getString("arr_time");
				String basic_price =	String.valueOf(rs.getFloat("basic_price"));
				String premium_price =	String.valueOf(rs.getFloat("premium_price"));
				String flight_frequency =	String.valueOf(rs.getInt("flight_frequency"));

				String tbData[] = {airline_email, dep, arr, dep_time, arr_time};
				String requestsFromDB[] = {idnew_flight_request, airline_email, dep, arr, start_date, end_date, dep_time, arr_time, basic_price, premium_price, flight_frequency};
				tb1Model.addRow(tbData);
				requests.add(requestsFromDB);
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int insertNewFlightLine(String dep, String arr) {
		int status = 0;
		try {
			conn = DBConnection.getConnection();
			preparedStmt = conn.prepareStatement("INSERT INTO flights_line (city_dep, city_arr) VALUES(?,?)");
			preparedStmt.setString(1, dep);
			preparedStmt.setString(2, arr);
			status = preparedStmt.executeUpdate();
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public void removeRequest(int idnew_flight_request)
	{
		try {
			conn = DBConnection.getConnection(); 
			String query = "DELETE from new_flight_request WHERE idnew_flight_request = ? ";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1,idnew_flight_request);
		    preparedStmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addNewFlights(int line_id, String start_date, String end_date, float dep_time_float, float arr_time_float, 
			int duration, String airline_name ,float basic_price, float premium_price, int flight_frequency) {
		conn = DBConnection.getConnection(); 
		try {
			String query = "CALL fill_flights(?,?,?,?,?,?,?,?,?,?)";
			 
			java.sql.CallableStatement stmt = conn.prepareCall(query);
			
			stmt.setInt(1, line_id);
			stmt.setString(2, start_date);
			stmt.setString(3, end_date);
			stmt.setFloat(4, dep_time_float);
			stmt.setFloat(5, arr_time_float);
			stmt.setInt(6, duration);
			stmt.setString(7, airline_name);
			stmt.setFloat(8, basic_price);
			stmt.setFloat(9, premium_price);
			stmt.setInt(10, flight_frequency);
			stmt.executeQuery();
		      
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

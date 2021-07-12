package ConnectDB;

/**
 * @author Thanh Tung Trinh 1320718
 * tung.tt133@gmail.com
 *
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

import Models.User;


/**
 * Class ConnectDB is responsible for all functions/methods that need to be connected to the database.
 */
public class UserDAO {

	Connection conn = null;
	PreparedStatement preparedStmt;

	public boolean checkLogin(String email, String password) {
		conn = DBConnection.getConnection(); 
		boolean isUser = false;
		try {
			preparedStmt = conn.prepareStatement("SELECT * FROM users WHERE user_email = ? AND user_password = md5(?)");
			preparedStmt.setString(1, email);
			preparedStmt.setString(2, password);
			ResultSet rs = preparedStmt.executeQuery();
			if (rs.next()) {
				isUser = true;
			}  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isUser;
	}
	
	public int getUserID(String email,String password) {
		conn = DBConnection.getConnection();
		try {
			preparedStmt = conn.prepareStatement("SELECT user_id FROM users WHERE user_email = ? AND user_password = md5(?)");
			preparedStmt.setString(1, email);
			preparedStmt.setString(2, password);
			ResultSet rs = preparedStmt.executeQuery();
			rs.next();
			return rs.getInt("user_id");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public User getUserById(int id) {
		conn = DBConnection.getConnection();
		User user = new User();
		try {
			preparedStmt = conn.prepareStatement("SELECT * FROM users WHERE user_id = ?");
			preparedStmt.setInt(1, id);
			ResultSet rs = preparedStmt.executeQuery();
			while(rs.next()) {
				user.setID(rs.getInt("user_id"));
				user.setFirstName(rs.getString("user_firstName"));
			    user.setLastName(rs.getString("user_lastName"));
				user.setEmail(rs.getString("user_email"));
				user.setPassword(rs.getString("user_password"));
				user.setType(rs.getString("user_type"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
	public boolean checkEmailExisted(String email) {
		boolean emailExisted = false;
		try {
			conn = DBConnection.getConnection();
			preparedStmt = conn.prepareStatement("SELECT * FROM users WHERE user_email = ?");
			preparedStmt.setString(1, email);
			ResultSet rs = preparedStmt.executeQuery();
			if (rs.next()) {
				emailExisted = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return emailExisted;
	}
	
	public double getCurrentBudget(int user_id) {
		try {
			conn = DBConnection.getConnection();
			preparedStmt = conn.prepareStatement("select current_budget from users where user_id = ? ");
			preparedStmt.setInt(1,user_id);
			ResultSet rs = preparedStmt.executeQuery();
			rs.next();
			return rs.getDouble(1);
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	public int insertUserRegistration(User user,double budget) {
		int status = 0;
		try {
			conn = DBConnection.getConnection();
			preparedStmt = conn.prepareStatement("INSERT INTO users (user_email, user_firstName, user_lastName, user_password,user_type,current_budget) VALUES(?,?,?,md5(?), ? , ? )");
			preparedStmt.setString(1, user.getEmail());
			preparedStmt.setString(2, user.getFirstName());
			preparedStmt.setString(3, user.getLastName());
			preparedStmt.setString(4, user.getPassword());
			preparedStmt.setString(5, user.getType());
			preparedStmt.setDouble(6, budget);
			status = preparedStmt.executeUpdate();
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	
	public void displayUserTickets(DefaultTableModel tb1Model, int user_id,List<String[]> tableData)
	{
		try {
			conn = DBConnection.getConnection(); 
			//TableUlti.RemoveAllRows(tb1Model);
			String sql = "SELECT seat_id,id_flights,seat_num,seat_price,seat_type,flight_day,flight_dep,flight_arr from flights natural join seats natural join users where user_id = ? ;";
			
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setInt(1,user_id);
			
			ResultSet rs = preparedStmt.executeQuery();
			

			
			while(rs.next())
			{
				String id_seat = String.valueOf(rs.getInt("seat_id"));
				String id_flight = String.valueOf(rs.getInt("id_flights"));
				String seat_num = rs.getString("seat_num");
				String date = String.valueOf(rs.getInt("flight_day"));
				float dep = rs.getFloat("flight_dep");
				float arr = rs.getFloat("flight_arr");
				String seat_price = String.valueOf(rs.getFloat("seat_price"));
				String seat_type = rs.getString("seat_type");
				
				// dd/mm/yyyy
				String dateFormat = date.charAt(6) + "" + date.charAt(7) + "/" + date.charAt(4) + date.charAt(5) + "/" + date.charAt(0) + date.charAt(1) + date.charAt(2) + date.charAt(3);
				
				// hh:mm
				// Departure
				float float_hour = dep; //time in float form
				int hour = (int)float_hour;
				float min_float = float_hour*10 - (float)hour*10;
				int min = (int) (min_float)*6;
				
				String h = "";
				String m = "";
				String depFormat = "";
				
				if(hour < 10) h = "0" + String.valueOf(hour);
				else h = String.valueOf(hour);
				
				if(min < 10) m = "0" + String.valueOf(min);
				else m = String.valueOf(min);
				
				depFormat = h+":"+m;
				
				// -----------------------------------------------------
				// Arrival
				float float_hour1 = arr; //time in float form
				int hour1 = (int)float_hour1;
				float min_float1 = float_hour1*10 - (float)hour1*10;
				int min1 = (int) (min_float1)*6;
				
				String h1 = "";
				String m1 = "";
				String arrFormat = "";
				
				if(hour1 < 10) h1 = "0" + String.valueOf(hour1);
				else h1 = String.valueOf(hour1);
				
				if(min1 < 10) m1 = "0" + String.valueOf(min1);
				else m1 = String.valueOf(min1);
				
				arrFormat = h1+":"+m1;
				
				// -----------------------------------------------------

				String tbData[] = {id_seat,id_flight,seat_num,dateFormat,depFormat,arrFormat};
				String data[] = {id_seat,id_flight,seat_num,seat_price,seat_type};
				tableData.add(data);
				tb1Model.addRow(tbData);		
			}			
     
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Used to identify the chosen seat type (in the booking ticket process)
	 * @param seat Id
	 * @return type of seat (Premium or Economy)
	 */
	
    public String getSeatType(int id) throws Exception {
    	String type = "none";
    	PreparedStatement preparedStatement = null;
    	ResultSet resultSet = null;
    	conn = DBConnection.getConnection();
    	
    	try {
    		String query = "SELECT seat_type FROM seats WHERE seat_id = ?";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
            	type = resultSet.getString("seat_type");
            }
            
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return type;
    }
    
    public ArrayList<String[]> getUserBills(int id) throws Exception{
    	ArrayList<String[]> bills = new ArrayList<String[]>();
    	PreparedStatement preparedStatement = null;
    	ResultSet resultSet = null;
    	conn = DBConnection.getConnection();
    	try {
	    	String query = "SELECT id_flights,bill,flight_day,carrier FROM airline.user_bills natural join flights where user_id = ? ";
	    	preparedStatement = conn.prepareStatement(query);
	        preparedStatement.setInt(1, id);
	        resultSet = preparedStatement.executeQuery();
	        while(resultSet.next()) {
	        	String id_f = String.valueOf(resultSet.getInt("id_flights"));
	        	String bill = String.valueOf(resultSet.getDouble("bill"));
	        	String flightday = String.valueOf(resultSet.getInt("flight_day"));
	        	String carrier = resultSet.getString("carrier");
	        	String[] data = {id_f,bill,flightday,carrier};
	        	bills.add(data);
	        }
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    	return bills;
    }
    
    public String getName(int id) {
    	String name = "";
    	PreparedStatement preparedStatement = null;
    	ResultSet resultSet = null;
    	conn = DBConnection.getConnection();
    	try {
	    	String query = "select user_firstName,user_lastName from users where user_id = ? ";
	    	preparedStatement = conn.prepareStatement(query);
	        preparedStatement.setInt(1, id);
	        resultSet = preparedStatement.executeQuery();
	        while(resultSet.next()) {
	        	name+= resultSet.getString("user_firstName");
	        	name+=" ";
	        	name+= resultSet.getString("user_lastName");
	        }
	        
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    	return name;
    }
    
    public void displayAllUsers(DefaultTableModel tb1Model) {
    	try {
			conn = DBConnection.getConnection(); 
			//TableUlti.RemoveAllRows(tb1Model);
			String sql = "SELECT user_id,user_firstName,user_lastName from users";
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			ResultSet rs = preparedStmt.executeQuery();
			
			while(rs.next())
			{
				String id = String.valueOf(rs.getInt("user_id"));
				String firstName = rs.getString("user_firstName");
				String lastName = rs.getString("user_lastName");
				// -----------------------------------------------------
				String data[] = {id,firstName,lastName};
				tb1Model.addRow(data);		
			}			
     
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void deleteUser(int id) {
    	System.out.println("haha");
    }
}

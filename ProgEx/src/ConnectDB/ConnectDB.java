package ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;



public class ConnectDB {
	public static void main(String[] args) throws Exception {

	}
	
	private static ConnectDB connectDB = null;

	private static Connection conn;
	private ConnectDB(){
		
	}

	/**
	 * @return Connection 
	 */
	public static ConnectDB getInstance(){
		if(connectDB == null){
			connectDB = new ConnectDB();
		}
		return connectDB;
	}

	/**get Connection if initialized. The function is used in Login Frame only. Program has to start from there!
	 * @throws Exception for SQL
	 */
	public void init() throws Exception {
		getConnection();
	}
	
	/**
	 * mySql Workbench connection established
	 * MySql Connection : test
	 * user : "root"
	 * password : ""
	 * @return Connection to Database
	 * @throws Exception for jdbc 
	 */
	public Connection getConnection() throws Exception{
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://127.0.0.1:3306/airline?useTimezone=true&serverTimezone=UTC";
			String username ="root";
			String password ="";
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url,username,password);
			return conn;
		}catch(Exception e) {
			
			System.out.println("error "+e.getMessage());
		}
		
		return null;
	}
	//Map<String, int[][]> mapDE = new HashMap<String, int[][]>();
	public static HashMap<String,Float> getSeatsMap()
	{
		HashMap<String,Float> seats = new HashMap<String,Float>();
		try {
			
			String sql = "select * from airline.seats";
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			ResultSet rs = preparedStmt.executeQuery();
			
			while(rs.next())
			{
					String seat_id= null;
					int res = rs.getInt("reserved");
					if(res != 0)
						seat_id = "Booked!";
					else
						seat_id = rs.getString("seat_id");
					float seat_preis = rs.getInt("seat_preis");
					seats.put(seat_id, (float) seat_preis);
					System.out.println(seat_id);
			}
			return seats;
		}catch(Exception e) {
			
			System.out.println("error "+e.getMessage());
		}
		return null;
		
	}
	
	public static void test()
	{
		HashMap<String,Float> seats = new HashMap<String,Float>();
		try {
			
			String sql = "select * from airline.seats";
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			ResultSet rs = preparedStmt.executeQuery();
			
			while(rs.next())
			{
					String seat_id= null;
					int res = rs.getInt("reserved");
					if(res != 0)
						seat_id = "Booked!";
					else
						seat_id = rs.getString("seat_id");
					float seat_preis = rs.getInt("seat_preis");
					seats.put(seat_id, (float) seat_preis);
					System.out.println(seat_id);
			}
		}catch(Exception e) {
			
			System.out.println("error "+e.getMessage());
		}
		
	}
	
}

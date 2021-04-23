package ConnectDB;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ConnectDB.getInstance().init();
			ConnectDB.test();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

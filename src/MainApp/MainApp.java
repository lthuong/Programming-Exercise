package MainApp;

import java.awt.EventQueue;

import Controllers.LoginController;
import Views.LoginView;

public class MainApp {

	/**
	 * @param args default value
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					new LoginController(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

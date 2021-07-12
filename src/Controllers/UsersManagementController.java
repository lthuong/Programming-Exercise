package Controllers;

import ConnectDB.UserDAO;
import Views.AdminInterface;
import Views.UsersManagement;

public class UsersManagementController {
	private UsersManagement uView;
	UserDAO userDao = new UserDAO();
	
	public UsersManagementController(UsersManagement uView) {
		this.uView = uView;
		initView();
		initController();
	}

	private void initController() {
		uView.getBtnBack().addActionListener(e->back());
	}

	private void back() {
		AdminInterface AdminFrame = new AdminInterface();
		new AdminInterfaceController(AdminFrame);
		AdminFrame.setVisible(true);
		uView.dispose(); 
	}

	private void initView() {
		displayListOfUsers();
	}

	private void displayListOfUsers() {
		userDao.displayAllUsers(uView.getTbModel());
	}
}

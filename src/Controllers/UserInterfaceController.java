package Controllers;

import ConnectDB.UserDAO;
import Models.User;
import Views.UserInterface;

public class UserInterfaceController {
	
	private User user;
	
	UserDAO userDAO = new UserDAO();
	private UserInterface userInterfaceView;
	
	public UserInterfaceController(UserInterface ui_view, User u) {
		userInterfaceView = ui_view;
		user = u;
		initView();
	}

	private void initView() {
		userInterfaceView.setVisible(true);
		userInterfaceView.getWelcomeLabel().setText("Hello " + user.getEmail());
	}
}

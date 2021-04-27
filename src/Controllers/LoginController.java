package Controllers;

import ConnectDB.UserDAO;
import Models.User;
import Views.LoginView;
import Views.RegisterView;
import Views.UserInterface;

public class LoginController {
	
	UserDAO userDAO = new UserDAO();
	private LoginView loginView;
	
	public LoginController(LoginView l_view) {
		loginView = l_view;
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		loginView.setVisible(true);
		loginView.getBtnLogin().addActionListener(e -> login());
		loginView.getBtnRegister().addActionListener(e -> redirectRegisterPage());
		loginView.getShowPasswordCheckbox().addActionListener(e -> handleShowPassword());
	}
	
	private void redirectRegisterPage() {
		RegisterView registerFrame = new RegisterView();
		new RegisterController(registerFrame);
		registerFrame.setVisible(true);
		loginView.dispose();
	}

	private void login()
	{
		boolean isFormBlank = false;
		if  (loginView.getEmail().equals("") || loginView.getPW().equals("")) {
			isFormBlank = true;
			loginView.getWarningMessage().setText("Fields can not be blank");
		} else {
			loginView.getWarningMessage().setText("");
		}
		
		if (!isFormBlank) {
			if (userDAO.checkLogin(loginView.getEmail(), loginView.getPW())) {
				userDAO.addToOnlineUsers(loginView.getEmail());
				User user = new User(loginView.getEmail());
				UserInterface UIFrame = new UserInterface();
				new UserInterfaceController(UIFrame, user);
				UIFrame.setVisible(true);
				loginView.dispose();   
			}
			 else {
				 loginView.getWarningMessage().setText("Account not existed! Please register");
			}
		}
	}
	
	private void handleShowPassword() {
		if(loginView.getShowPasswordCheckbox().isSelected())
			loginView.getPasswordField().setEchoChar((char)0);
		else
			loginView.getPasswordField().setEchoChar('*');
	}
	
}

package Controllers;

import ConnectDB.UserDAO;
import Models.User;
import Views.LoginView;
import Views.RegisterView;

public class RegisterController {
	
	UserDAO userDAO = new UserDAO();
	private RegisterView registerView;
	
	public RegisterController(RegisterView r_view) {
		registerView = r_view;
		initView();
	}
	
	private void initView() {
		registerView.setVisible(true);
		registerView.getBtnRegister().addActionListener(e -> register());
		registerView.getBtnLogin().addActionListener(e -> redirectLoginPage());
	}
	
	private void register() {
		boolean isEmailValid = true;
		boolean isPasswordValid = true;
		boolean isFormBlank = false;
		if (userDAO.checkEmailExisted(registerView.getEmail())) {
			registerView.getEmailMessage().setText("Invalid");
			isEmailValid = false;
		} else {
			registerView.getEmailMessage().setText("");
		}
		if (registerView.getFirstName().equals("") || registerView.getLastName().equals("") || registerView.getEmail().equals("") || registerView.getPW().equals("") || registerView.getRetypePW().equals("")) {
			isFormBlank = true;
			registerView.getWarningMessage().setText("Fields can not be blank");
		} else {
			registerView.getWarningMessage().setText("");
		}
		if (!registerView.getPW().equals(registerView.getRetypePW())) {
			registerView.getPasswordMessage().setText("Not match");
			isPasswordValid = false;
		} else {
			registerView.getPasswordMessage().setText("");
		}
		if (!isFormBlank && isEmailValid && isPasswordValid) {
			userDAO.insertUserRegistration(new User(registerView.getFirstName(), registerView.getLastName(), registerView.getEmail(), registerView.getPW()));
			LoginView loginFrame = new LoginView();
			new LoginController(loginFrame);
			loginFrame.setVisible(true);
			registerView.dispose();
		}
	}
	
	private void redirectLoginPage() {
		LoginView loginFrame = new LoginView();
		new LoginController(loginFrame);
		loginFrame.setVisible(true);
		registerView.dispose();
	}
}

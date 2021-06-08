package Controllers;

import ConnectDB.AdminDAO;
import ConnectDB.AirlineDAO;
import ConnectDB.UserDAO;
import Models.Admin;
import Models.Airline;
import Models.User;
import Ulti.Validator;
import Views.AdminInterface;
import Views.AirlineInterface;
import Views.LoginView;
import Views.RegisterView;
import Views.UserFindsFlightsView;
import Views.UserUI;

public class LoginController {
	
	UserDAO userDAO = new UserDAO();
	AirlineDAO airlineDAO = new AirlineDAO();
	AdminDAO adminDAO = new AdminDAO();
	private LoginView loginView;
	
	public LoginController(LoginView l_view) {
		loginView = l_view;
		initView();
	}

	private void initView() {
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
		boolean isEmailValid = false;
		boolean isPasswordValid = false;
		boolean isFormValid = false;
		
		Validator validator = new Validator();
		//handle email validation
		if (loginView.getEmail().equals("")) {
			loginView.getWarningEmail().setText("Fields can not be blank");
		} else if(!validator.emailValidate(loginView.getEmail().trim())) { 
			loginView.getWarningEmail().setText("Invalid email");
		} else {
			isEmailValid = true;
			loginView.getWarningEmail().setText("");
		}
		//handle password validation
		if (loginView.getPW().equals("")) {
			loginView.getWarningPassword().setText("Field can not be blank");
		} else if(!validator.passwordValidate(loginView.getPW())) { 
			loginView.getWarningPassword().setText("At least 8 characters required");
		} else {
			isPasswordValid = true;
			loginView.getWarningPassword().setText("");
		}
		
		isFormValid = isEmailValid & isPasswordValid;
		//handle login cases of user, airline and admin
		if (isFormValid) {
			if (userDAO.checkLogin(loginView.getEmail(), loginView.getPW())) {
				userDAO.addToOnlineUsers(loginView.getEmail());
				User user = new User(loginView.getEmail(),userDAO.getUserID(loginView.getEmail(), loginView.getPW()));
				UserUI UIFrame = new UserUI();
				new UserUIController(UIFrame, user);
				//UIFrame.setVisible(true);
				loginView.dispose();   
			} else if (airlineDAO.checkLogin(loginView.getEmail(), loginView.getPW())) {
				Airline airline = new Airline(loginView.getEmail());
				AirlineInterface AirlineFrame = new AirlineInterface();
				AirlineFrame.setVisible(true);
				loginView.dispose();    
			} else if (adminDAO.checkLogin(loginView.getEmail(), loginView.getPW())) {
				Admin admin = new Admin(loginView.getEmail());
				AdminInterface AdminFrame = new AdminInterface();
				AdminFrame.setVisible(true);
				loginView.dispose(); 
			} else {
				loginView.getWarningPassword().setText("Account not existed!");
			}
		}
	}
	
	private void handleShowPassword() {
		if(loginView.getShowPasswordCheckbox().isSelected()) loginView.getPasswordField().setEchoChar((char)0);
		else loginView.getPasswordField().setEchoChar('*');
	}
	
}

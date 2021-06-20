package Controllers;

import ConnectDB.UserDAO;
import Models.User;
import Ulti.Validator;
import Views.LoginView;
import Views.RegisterView;

/**
 * 
 * @author Tuan Anh Nguyen
 *
 */
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
		boolean isEmailValid = false;
		boolean isFirstNameValid = false;
		boolean isLastNameValid = false;
		boolean isPasswordValid = false;
		boolean isRetypePasswordValid = false;
		boolean isFormValid = false;
		
		Validator validator = new Validator();
		
		//handle email validation
		if (registerView.getEmail().equals("")) {
			registerView.getEmailMessage().setText("Field can not be blank");
		} else if (userDAO.checkEmailExisted(registerView.getEmail())) {
			registerView.getEmailMessage().setText("Email existed");
		} else if (!validator.emailValidate(registerView.getEmail().trim())) {
			registerView.getEmailMessage().setText("Invalid email");
		} else {
			isEmailValid = true;
			registerView.getEmailMessage().setText("");
		}
		
		//handle first name validation
		if (registerView.getFirstName().equals("")) {
			registerView.getFirstNameTextWarningMsg().setText("Field can not be blank");
		} else if (!validator.textValidate(registerView.getFirstName())) {
			registerView.getFirstNameTextWarningMsg().setText("Must be text");
		} else {
			isFirstNameValid = true;
			registerView.getFirstNameTextWarningMsg().setText("");
		}
		
		//handle last name validation
		if (registerView.getLastName().equals("")) {
			registerView.getLastNameTextWarningMsg().setText("Field can not be blank");
		} else if (!validator.textValidate(registerView.getLastName())) {
			registerView.getLastNameTextWarningMsg().setText("Must be text");
		} else {
			isLastNameValid = true;
			registerView.getLastNameTextWarningMsg().setText("");
		}
		
		//handle password validation
		if (registerView.getPW().equals("")) {
			registerView.getPasswordMessage().setText("Field can not be blank");
		} else if(!validator.passwordValidate(registerView.getPW())) { 
			registerView.getPasswordMessage().setText("At least 8 characters required");
		} else {
			isPasswordValid = true;
			registerView.getPasswordMessage().setText("");
		}
		
		//handle retype password validation
		if (registerView.getRetypePW().equals("")) {
			registerView.getReTypePasswordMessage().setText("Field can not be blank");
		} else if (!registerView.getPW().equals(registerView.getRetypePW())) {
			registerView.getReTypePasswordMessage().setText("Not match");
		} else {
			isRetypePasswordValid = true;
			registerView.getReTypePasswordMessage().setText("");
		}
		String type = registerView.getComboBox().getSelectedItem().toString();
		isFormValid = isEmailValid & isFirstNameValid & isLastNameValid & isPasswordValid & isRetypePasswordValid;
		
		if (isFormValid) {
			userDAO.insertUserRegistration(new User(registerView.getFirstName(), registerView.getLastName(), 
					registerView.getEmail(), registerView.getPW(),type),getBudget(type));
			LoginView loginFrame = new LoginView();
			new LoginController(loginFrame);
			loginFrame.setVisible(true);
			registerView.dispose();
		}
	}
	
	private double getBudget(String type) {
		if(type.equals("Classic"))
			return 1000;
		else if(type.equals("Gold"))
			return 2000;
		else
			return 3000;
	}
	
	private void redirectLoginPage() {
		LoginView loginFrame = new LoginView();
		new LoginController(loginFrame);
		loginFrame.setVisible(true);
		registerView.dispose();
	}
}

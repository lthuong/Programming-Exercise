package Controllers;

import Views.LoginView;
import Views.Registration;
import Views.UserInterface;

public class LoginController {
	private LoginView l;
	
	public LoginController(LoginView l_view)
	{
		l = l_view;
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		l.setVisible(true);
		l.getBtnLogin().addActionListener(e -> login());
		l.getBtnRegister().addActionListener(e -> register());
	}
	
	// view changed
	private void register() {
		Registration registerFrame = new Registration();
		registerFrame.setVisible(true);
		l.dispose();
	}

	private void login()
	{
		boolean isFormBlank = false;
		if  (l.getEmail().equals("") || l.getPW().equals("")) {
			isFormBlank = true;
			l.getWarningMessage().setText("Fields can not be blank");
		} else {
			l.getWarningMessage().setText("");
		}
		
		if (!isFormBlank) {
			if (l.getUserDAO().checkLogin(l.getEmail(), l.getPW())) {
				UserInterface UIFrame = new UserInterface();
				UIFrame.setVisible(true);
				l.dispose();   
			}
			 else {
				l.getWarningMessage().setText("Account not existed! Please register");
			}
		}
	}
}

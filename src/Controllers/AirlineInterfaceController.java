package Controllers;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ConnectDB.AirlineDAO;

import Models.Airline;
import Ulti.Validator;
import Views.AirlineInterface;
import Views.LoginView;
/**
 * 
 * @author Tuanh Anh Nguyen
 *
 */

public class AirlineInterfaceController {

	AirlineDAO airlineDAO = new AirlineDAO();
	private AirlineInterface airlineInterfaceView;
	private Airline airline;
	
	public AirlineInterfaceController(AirlineInterface ai_view, Airline _airline) {
		airlineInterfaceView = ai_view;
		airline = _airline;
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		airlineInterfaceView.setVisible(true);
		airlineInterfaceView.getBtnSubmit().addActionListener(e -> sendNewFlightRequest());
		airlineInterfaceView.getBtnLogout().addActionListener(e -> logout());
	}
	private void sendNewFlightRequest() {
		
		Validator validator = new Validator();
		boolean isFromValid = false;
		boolean isToValid = false;
		
		if (airlineInterfaceView.getTextFieldFrom().equals("")) {
			airlineInterfaceView.getWarningMsgFrom().setText("Fields can not be blank");
		} else if(!validator.textValidate(airlineInterfaceView.getTextFieldFrom())) { 
			airlineInterfaceView.getWarningMsgFrom().setText("Invalid departure");
		} else {
			isFromValid = true;
			airlineInterfaceView.getWarningMsgFrom().setText("");
		}
		
		if (airlineInterfaceView.getTextFieldTo().equals("")) {
			airlineInterfaceView.getWarningMsgTo().setText("Fields can not be blank");
		} else if(!validator.textValidate(airlineInterfaceView.getTextFieldTo())) { 
			airlineInterfaceView.getWarningMsgTo().setText("Invalid arrival");
		} else {
			isToValid = true;
			airlineInterfaceView.getWarningMsgTo().setText("");
		}
		
		if (isFromValid & isToValid) {
			airlineDAO.updateNewFlightRequest(airline.getEmail(), airlineInterfaceView.getTextFieldFrom(), airlineInterfaceView.getTextFieldTo(), 
					airlineInterfaceView.getDateChooserStartDate(), airlineInterfaceView.getDateChooserEndDate(), airlineInterfaceView.getSpinnerDepTime(), 
					airlineInterfaceView.getSpinnerArrTime(), airlineInterfaceView.getSpinnerBasicPrice(), 
					airlineInterfaceView.getSpinnerPremiumPrice(), airlineInterfaceView.getSpinnerFlightFreq());
            String message = "Successfully add new flight request";
            JOptionPane.showMessageDialog(new JFrame(), message, "Confirm", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	private void logout() {
		LoginView loginFrame = new LoginView();
		new LoginController(loginFrame);
		loginFrame.setVisible(true);
		airlineInterfaceView.dispose();
	}
}

package Controllers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import ConnectDB.AdminDAO;

import ConnectDB.AirlineDAO;
import Ulti.Converter;
import Views.AdminInterface;
import Views.LoginView;
import Views.UsersManagement;

/**
 * 
 * @author Tuanh Anh Nguyen
 *
 */
public class AdminInterfaceController {
	AdminDAO adminDAO = new AdminDAO();
	AirlineDAO airlineDAO = new AirlineDAO();
	private AdminInterface adminInterfaceView;
	private int selectedIndex = 0;
	Converter converter = new Converter();
	
	int idnew_flight_request;
	String airline_email;
	String dep;
	String arr;
	String start_date; 
	String end_date; 
	String dep_time;  
	String arr_time;  
	float basic_price;
	float premium_price;
	int flight_frequency;
	String airlineName;
	int duration;
	
	
	public AdminInterfaceController(AdminInterface admin_view) {
		adminInterfaceView = admin_view;
		initView();
		handleClickOnRow();
	}

	private void manageUsers() {
		UsersManagement uFrame = new UsersManagement();
		new UsersManagementController(uFrame);
		uFrame.setVisible(true);
		adminInterfaceView.dispose();
	}

	private void initView() {
		// TODO Auto-generated method stub
		adminInterfaceView.setVisible(true);
		adminInterfaceView.getBtnConfirmRequest().addActionListener(e -> approveNewFlightRequest());
		adminInterfaceView.getBtnDeleteRequest().addActionListener(e -> refuseNewFlightRequest());
		adminInterfaceView.getBtnLogout().addActionListener(e -> logout());
		adminInterfaceView.getBtnUsersManagement().addActionListener(e -> manageUsers());
	}
	
	private void approveNewFlightRequest() {
		String[] selectedRequestData = adminInterfaceView.getRequests().get(selectedIndex);
		idnew_flight_request = Integer.parseInt(selectedRequestData[0]);
		airline_email = selectedRequestData[1];
		dep = selectedRequestData[2];
		arr = selectedRequestData[3];
		start_date = selectedRequestData[4]; 
		end_date = selectedRequestData[5]; 
		dep_time = selectedRequestData[6];  
		arr_time = selectedRequestData[7];  
		basic_price = Float.parseFloat(selectedRequestData[8]);
		premium_price = Float.parseFloat(selectedRequestData[9]);
		flight_frequency = Integer.parseInt(selectedRequestData[10]);
		airlineName = airlineDAO.getAirlineNameFromEmail(airline_email);
		duration = (int) (60*(converter.convertTimeToFloatTime(arr_time) - converter.convertTimeToFloatTime(dep_time)));
		
		
		if (!airlineDAO.checkFlightLineExisted(dep, arr)) {
			adminDAO.insertNewFlightLine(dep, arr);
			adminDAO.removeRequest(idnew_flight_request);
			adminDAO.addNewFlights(airlineDAO.getFlightLineID(dep, arr), start_date, end_date, 
					converter.convertTimeToFloatTime(dep_time), converter.convertTimeToFloatTime(arr_time), 
					duration, airlineName, basic_price, premium_price, flight_frequency);		
				JOptionPane optionPane = new JOptionPane(
					    "Do you want to Seat " + "?",
					    JOptionPane.QUESTION_MESSAGE,
					    JOptionPane.YES_NO_OPTION);
				final JDialog dialog = new JDialog(adminInterfaceView, 
						"Confirm Selection",
						true);
				dialog.setContentPane(optionPane);
				dialog.setBounds(600,400,50,50);
				dialog.setLocationRelativeTo(null);
				optionPane.addPropertyChangeListener(
					    new PropertyChangeListener() {
					        public void propertyChange(PropertyChangeEvent e) {
					            String prop = e.getPropertyName();

					            if (dialog.isVisible() 
					             && (e.getSource() == optionPane)
					             && (prop.equals(JOptionPane.VALUE_PROPERTY))) {
					                dialog.setVisible(false);
					            }
					        }
					    });
				dialog.pack();
				dialog.setVisible(true);
				int value = ((Integer)optionPane.getValue()).intValue();
				if (value == JOptionPane.YES_OPTION) {
					adminInterfaceView.dispose();
					AdminInterface view = new AdminInterface();
					new AdminInterfaceController(view);

				} else if (value == JOptionPane.NO_OPTION) {
					dialog.setVisible(false);
				}
			}
		
		
	}
	
	private void refuseNewFlightRequest() {
		String[] selectedRequestData = adminInterfaceView.getRequests().get(selectedIndex);
		idnew_flight_request = Integer.parseInt(selectedRequestData[0]);
		airline_email = selectedRequestData[1];
		dep = selectedRequestData[2];
		arr = selectedRequestData[3];
		start_date = selectedRequestData[4]; 
		end_date = selectedRequestData[5]; 
		dep_time = selectedRequestData[6];  
		arr_time = selectedRequestData[7];  
		basic_price = Float.parseFloat(selectedRequestData[8]);
		premium_price = Float.parseFloat(selectedRequestData[9]);
		flight_frequency = Integer.parseInt(selectedRequestData[10]);
		airlineName = airlineDAO.getAirlineNameFromEmail(airline_email);
		duration = (int) (60*(converter.convertTimeToFloatTime(arr_time) - converter.convertTimeToFloatTime(dep_time)));
		
		
		adminDAO.removeRequest(idnew_flight_request);
		JOptionPane optionPane = new JOptionPane(
			    "Do you want to Seat " + "?",
			    JOptionPane.QUESTION_MESSAGE,
			    JOptionPane.YES_NO_OPTION);
		final JDialog dialog = new JDialog(adminInterfaceView, 
				"Confirm Selection",
				true);
		dialog.setContentPane(optionPane);
		dialog.setBounds(600,400,50,50);
		dialog.setLocationRelativeTo(null);
		optionPane.addPropertyChangeListener(
			    new PropertyChangeListener() {
			        public void propertyChange(PropertyChangeEvent e) {
			            String prop = e.getPropertyName();

			            if (dialog.isVisible() 
			             && (e.getSource() == optionPane)
			             && (prop.equals(JOptionPane.VALUE_PROPERTY))) {
			                dialog.setVisible(false);
			            }
			        }
			    });
		dialog.pack();
		dialog.setVisible(true);
		int value = ((Integer)optionPane.getValue()).intValue();
		if (value == JOptionPane.YES_OPTION) {
			adminInterfaceView.dispose();
			AdminInterface view = new AdminInterface();
			new AdminInterfaceController(view);

		} else if (value == JOptionPane.NO_OPTION) {
			dialog.setVisible(false);
		}
        
	}
	
	private void handleClickOnRow() {
		adminInterfaceView.getTable().addMouseListener(new java.awt.event.MouseAdapter() {  
			@Override
			 public void mouseClicked(java.awt.event.MouseEvent evt) {  
				int[] row = adminInterfaceView.getTable().getSelectedRows();  
				int[] columns = adminInterfaceView.getTable().getSelectedColumns();  
				for (int i = 0; i < row.length; i++) {  
					for (int j = 0; j < columns.length; j++) {  
						selectedIndex = row[i];
					} 
				}  
				String airlineName = airlineDAO.getAirlineNameFromEmail(adminInterfaceView.getRequests().get(selectedIndex)[1]);
				adminInterfaceView.getTextFieldAirline().setText(airlineName);
				adminInterfaceView.getTextFieldFlightLine().setText(adminInterfaceView.getRequests().get(selectedIndex)[2]+ " - "+adminInterfaceView.getRequests().get(selectedIndex)[3]);
				adminInterfaceView.getTextFieldFlightFreq().setText(adminInterfaceView.getRequests().get(selectedIndex)[10]);
				adminInterfaceView.getTextFieldBasicPrice().setText(adminInterfaceView.getRequests().get(selectedIndex)[8] + " Euro");
				adminInterfaceView.getTextFieldStartDate().setText(adminInterfaceView.getRequests().get(selectedIndex)[4]);
				adminInterfaceView.getTextFieldEndDate().setText(adminInterfaceView.getRequests().get(selectedIndex)[5]);
				adminInterfaceView.getTextFieldDepTime().setText(adminInterfaceView.getRequests().get(selectedIndex)[6]);
				adminInterfaceView.getTextFieldArrTime().setText(adminInterfaceView.getRequests().get(selectedIndex)[7]);
				adminInterfaceView.getTextFieldPremiumPrice().setText(adminInterfaceView.getRequests().get(selectedIndex)[9] + " Euro");
			 }       
			}); 
	}
	private void logout() {
		LoginView loginFrame = new LoginView();
		new LoginController(loginFrame);
		loginFrame.setVisible(true);
		adminInterfaceView.dispose();
}
}

package Controllers;

import javax.swing.JOptionPane;

import ConnectDB.UserDAO;
import Models.Flight;
import Models.Seat;
import Models.User;
import Views.BookingSeatView;
import Views.UserFindsFlightsView;
import Views.UserUI;

/**
 * 
 * @author Thanh Tung Trinh
 * @author Thien Huong Le
 *
 */
public class UserUIController {

	UserDAO userDAO = new UserDAO();
	private UserUI view;
	private User model;
	
	public UserUIController(UserUI v, User m) {
		this.view = v;
		this.model = m;
		initView();
		initController();
		initTableController();
	}
	
	private void initTableController() {
		view.getTable().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int index = 0;
				int[] row = view.getTable().getSelectedRows();  
				int[] columns = view.getTable().getSelectedColumns();  
				for (int i = 0; i < row.length; i++) {  
					for (int j = 0; j < columns.length; j++) {  
						index = row[i];
						int id_f = Integer.parseInt(view.getTableData().get(index)[1]);
						int id_s = Integer.parseInt(view.getTableData().get(index)[0]);
						String seatId = view.getTableData().get(index)[2];
						// if a seat was already booked, the BookingSeatView won't open
						if(seatId.equals("")) {
							Flight f = new Flight(id_f);
							Seat s = new Seat(id_s);
							BookingSeatView frame = new BookingSeatView();
							new BookingSeatController(frame,f,s,model);
							view.dispose();
						} else {
							// System.out.println("Seat is already booked!!!");
						}

						
			     } } 
			}
		}); 
		
	}

	private void initController() {
		view.getBtnFind().addActionListener(e->findFlights());
		
	}

	private void findFlights() {
		UserFindsFlightsView userInterface = new UserFindsFlightsView();
		new UserFindsFlightsController(userInterface,model);
		//view.dispose();
	}

	private void initView() {
		view.setVisible(true);
		view.getTextField_wallet().setText(String.valueOf(userDAO.getCurrentBudget(model.getID())) + "$");
		userDAO.displayUserTickets(view.getTb1Model(),model.getID(),view.getTableData());
	}

}

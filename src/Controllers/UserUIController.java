package Controllers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


import ConnectDB.UserDAO;
import Models.Flight;
import Models.Seat;
import Models.User;
import Ulti.Converter;
import Ulti.DateUlti;
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
	Converter converter = new Converter();
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
						if (seatId.equals("")) {
							Flight f = new Flight(id_f);
							Seat s = new Seat(id_s);
							BookingSeatView frame = new BookingSeatView();
							new BookingSeatController(frame, f, s, model);
							view.dispose();
						} else {
							// System.out.println("Seat is already booked!!!");
						}

					}
				}
			}
		});

	}

	private void initController() {
		view.getBtnFind().addActionListener(e -> findFlights());
		view.getBillBtn().addActionListener(e -> printBills());
	}

	private void printBills() {
		try {
	    	int counter = 1;
	    	double total = 0;
		      File myObj = new File("bills.txt");
		      ArrayList<String[]> bills = new ArrayList<String[]>();
		      bills = userDAO.getUserBills(model.getID());
		     
		        System.out.println("File created: " + myObj.getName());
		        FileWriter myWriter = new FileWriter("bills.txt");
		        myWriter.write("File generated : "+ DateUlti.today()+"\n");
		        myWriter.write("User : "+ userDAO.getName(model.getID())+"\n");
		        for(String[] data : bills) {
		        	myWriter.write("----------------------------------\n");
		        	myWriter.write("Bill number : "+counter+"\n");
		        	myWriter.write("id flights : "+data[0]+"\n");
		        	myWriter.write("flight day "+ converter.convertDateToString(data[2])+"\n");
		        	myWriter.write("Paid : "+data[1]+"\n");
		        	double price = Double.parseDouble(data[1]);
		        	total += price;
		        	counter++;
		        }
		        myWriter.write("----------------------------------\n");
		        myWriter.write("Total : "+total);
		        myWriter.close();

		    
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	private void findFlights() {
		UserFindsFlightsView userInterface = new UserFindsFlightsView();
		new UserFindsFlightsController(userInterface, model);
		view.dispose();
	}

	private void initView() {
		view.setVisible(true);
		view.getTextField_wallet().setText(String.valueOf(userDAO.getCurrentBudget(model.getID())) + "$");
		userDAO.displayUserTickets(view.getTb1Model(), model.getID(), view.getTableData());
	}

}

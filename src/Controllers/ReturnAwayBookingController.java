package Controllers;

import Views.OneWayBooking;
import Views.ReturnBookingAway;
import Views.ReturnBookingBack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import ConnectDB.BookingDAO;
import ConnectDB.UserDAO;
import Models.UserFindsFlightsModel;
import Ulti.DateUlti;

/**
 * 
 * @author Thanh Tung Trinh
 *
 */
public class ReturnAwayBookingController {
	BookingDAO bookingDAO = new BookingDAO();
	UserDAO userDAO = new UserDAO();
	private ReturnBookingAway view;
	private UserFindsFlightsModel userModel;
	private int innerIndex = 0;
	
	public ReturnAwayBookingController(ReturnBookingAway v,UserFindsFlightsModel model)
	{
		this.view = v;
		this.userModel = model;

		initController();
		initViewDirect();
		initViewTransit();
		initTableDirectController();
		initTableDirectTransitController();
		confirm();
	}
	private void initViewTransit() {
		view.setDirectTransitTableModel((DefaultTableModel)view.getTable_transit().getModel());

		bookingDAO.displayFlightTransit(view.getTransitTableModel(),view.getTableDataDirectTransit(),
				userModel.getOWDate(),userModel.getDep(),userModel.getArr());
		
	}
	private void confirm()
	{
		view.getBtn_book_direct().addActionListener(e->directConfirm());
		view.getBtn_book_transit().addActionListener(e->transConfirm());
	}
	private void directConfirm()
	{
		if (userDAO.getCurrentBudget(userModel.getUser_id()) 
                < Float.parseFloat(view.getTextField_price_direct().getText())) {
            String message = "Your budget ist not enough\n"
                    + "to book a ticket!!";
            JOptionPane.showMessageDialog(new JFrame(), message, "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
		bookingDAO.bookDirectFlight(Integer.parseInt(view.getTextField_flight_direct().getText()), userModel.getUser_id(),
				Float.parseFloat(view.getTextField_price_direct().getText()), view.getComboBox().getSelectedItem().toString());
		ReturnBookingBack reFrame = new ReturnBookingBack();
		UserFindsFlightsModel userModel1 = new UserFindsFlightsModel(userModel.getReDate(), 
				userModel.getArr(), 
				userModel.getDep(),userModel.getUser_id()); 
		new ReturnBackBookingController(reFrame,userModel1);
		view.dispose();
	}
	private void transConfirm()
	{
		if (userDAO.getCurrentBudget(userModel.getUser_id()) 
                < Float.parseFloat(view.getTextField_price1().getText())) {
            String message = "Your budget ist not enough\n"
                    + "to book a ticket!!";
            JOptionPane.showMessageDialog(new JFrame(), message, "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
		bookingDAO.bookDirectFlight(Integer.parseInt(view.getTextField_flight_transit().getText()), userModel.getUser_id(),
				Float.parseFloat(view.getTextField_price1().getText()), view.getComboBox().getSelectedItem().toString());
		bookingDAO.bookDirectFlight(Integer.parseInt(view.getTextField_flight_transit2().getText()), userModel.getUser_id(),
				Float.parseFloat(view.getTextField_price2().getText()), view.getComboBox().getSelectedItem().toString());
		
		ReturnBookingBack reFrame= new ReturnBookingBack();
		UserFindsFlightsModel userModel1 = new UserFindsFlightsModel(userModel.getReDate(), 
				userModel.getArr(), 
				userModel.getDep(),userModel.getUser_id()); 
		new ReturnBackBookingController(reFrame,userModel1);
		view.dispose();
	}
	private void initViewDirect() {
		
		view.setVisible(true);
		view.start();

		bookingDAO.displayFlightsOneWay(view.getDirectTableModel(),view.getTableDataDirect(),
				userModel.getOWDate(),userModel.getDep(),userModel.getArr());
		
	}
	private void initController() {
		 //data from database will be stored here
		view.setTableDataDirect(new ArrayList<String[]>());
		view.setTableDataTransit(new ArrayList<String[]>());
		view.setDirectTableModel((DefaultTableModel)view.getTable_direct().getModel());
		view.setDirectTransitTableModel((DefaultTableModel)view.getTable_transit().getModel());
	}

	private void initTableDirectController() {
		
		// view.getTable_direct().setCellSelectionEnabled(true);
		view.getTable_direct().addMouseListener(new java.awt.event.MouseAdapter() { 
		@Override
		 public void mouseClicked(java.awt.event.MouseEvent evt) {  
			int index = 0;
			int[] row = view.getTable_direct().getSelectedRows();  
			int[] columns = view.getTable_direct().getSelectedColumns();  
			for (int i = 0; i < row.length; i++) {  
				for (int j = 0; j < columns.length; j++) {  
					index = row[i];
					innerIndex = index;
		     } }  
			view.getTextField_flight_direct().setText(view.getTableDataDirect().get(index)[0]);
			view.getTextField_fromto_direct().setText(view.getTableDataDirect().get(index)[1]+ " - "+view.getTableDataDirect().get(index)[2]);
			view.getTextField_duration_direct().setText(view.getTableDataDirect().get(index)[3]+" min ");
			view.getTextField_carrier_direct().setText(view.getTableDataDirect().get(index)[4]);
			view.getTextField_time_direct().setText(view.getTableDataDirect().get(index)[5]+ " - "+view.getTableDataDirect().get(index)[6]);
			view.getTextField_date_direct().setText(view.getTableDataDirect().get(index)[7]);
			view.getTextField_price_direct().setText(view.getTableDataDirect().get(index)[8]);
			
			view.getComboBox().setSelectedItem("Economy");
			view.getComboBox().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(view.getComboBox().getSelectedItem().toString().equals("Premium")) 
						view.getTextField_price_direct().setText(view.getTableDataDirect().get(innerIndex)[9]);
					else
						view.getTextField_price_direct().setText(view.getTableDataDirect().get(innerIndex)[8]);
				}
			});
			
		 }       
		}); 
	}

	private void initTableDirectTransitController()
	{
		// view.getTable_transit().setCellSelectionEnabled(true);
		view.getTable_transit().addMouseListener(new java.awt.event.MouseAdapter() {  
			@Override
			 public void mouseClicked(java.awt.event.MouseEvent evt) {  
				int index = 0;
				int[] row = view.getTable_transit().getSelectedRows();  
				int[] columns = view.getTable_transit().getSelectedColumns();  
				for (int i = 0; i < row.length; i++) {  
					for (int j = 0; j < columns.length; j++) {  
						index = row[i];
						innerIndex = index;
			     } }  
				view.getTextField_flight_transit().setText(view.getTableDataDirectTransit().get(index)[0]);
				view.getTextField_flight_transit2().setText(view.getTableDataDirectTransit().get(index)[1]);
				view.getTextField_fromto_transit1().setText(view.getTableDataDirectTransit().get(index)[2]+ " - "+view.getTableDataDirectTransit().get(index)[3]);
				view.getTextField_fromto_transit2().setText(view.getTableDataDirectTransit().get(index)[3]+ " - "+view.getTableDataDirectTransit().get(index)[4]);
				view.getTextField_duration_transit().setText(view.getTableDataDirectTransit().get(index)[5]+" min ");
				view.getTextField_carrier_transit().setText(view.getTableDataDirectTransit().get(index)[6]);
				view.getTextField_time_transit1().setText(view.getTableDataDirectTransit().get(index)[7]+ " - "+view.getTableDataDirectTransit().get(index)[8]);
				view.getTextField_time_transit2().setText(view.getTableDataDirectTransit().get(index)[9]+ " - "+view.getTableDataDirectTransit().get(index)[10]);
				view.getTextField_date_transit().setText(view.getTableDataDirectTransit().get(index)[11]);
				view.getTextField_price1().setText(view.getTableDataDirectTransit().get(index)[14]);
				view.getTextField_price2().setText(view.getTableDataDirectTransit().get(index)[15]);
				
				view.getComboBox_transit().setSelectedItem("Economy");
				view.getComboBox_transit().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(view.getComboBox_transit().getSelectedItem().toString().equals("Premium")) {
							view.getTextField_price1().setText(view.getTableDataDirectTransit().get(innerIndex)[16]);
							view.getTextField_price2().setText(view.getTableDataDirectTransit().get(innerIndex)[17]);
						}
						else {
							view.getTextField_price1().setText(view.getTableDataDirectTransit().get(innerIndex)[14]);
							view.getTextField_price2().setText(view.getTableDataDirectTransit().get(innerIndex)[15]);
						}
					}
				});
			 }       
			}); 
	}
}

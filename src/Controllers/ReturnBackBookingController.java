package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import ConnectDB.BookingDAO;
import Models.User;
import Models.UserFindsFlightsModel;
import Ulti.DateUlti;
import Views.OneWayBooking;
import Views.ReturnBookingBack;
import Views.UserFindsFlightsView;

/**
 * 
 * @author Thanh Tung Trinh
 *
 */
public class ReturnBackBookingController {
	BookingDAO bookingDAO = new BookingDAO();
	private ReturnBookingBack view;
	private UserFindsFlightsModel userModel;
	private boolean check = false;
	private int innerIndex = 0;
	
	public ReturnBackBookingController(ReturnBookingBack v,UserFindsFlightsModel model) {
		this.view = v;
		this.userModel = model;
		
		initController();
		initViewDirect();
		initViewTransit();
		initTableDirectController();
		initTableDirectTransitController();
	}
	
	private void initViewTransit() {
		view.setDirectTransitTableModel((DefaultTableModel)view.getTable_transit().getModel());

		bookingDAO.displayFlightTransit(view.getTransitTableModel(),view.getTableDataDirectTransit(),
				userModel.getOWDate(),userModel.getDep(),userModel.getArr());
	}

	private void initViewDirect() {
		
		view.setVisible(true);
		view.start();
		view.setDirectTableModel((DefaultTableModel)view.getTable_direct().getModel());

		
		bookingDAO.displayFlightsOneWay(view.getDirectTableModel(),view.getTableDataDirect(),
				userModel.getOWDate(),userModel.getDep(),userModel.getArr());
		
	}

	private void initController() {
		view.setTableDataDirect(new ArrayList<String[]>());
		view.setTableDataTransit(new ArrayList<String[]>());
		view.setDirectTableModel((DefaultTableModel)view.getTable_direct().getModel());
		view.setDirectTransitTableModel((DefaultTableModel)view.getTable_transit().getModel());
		view.getBtn_book_direct().addActionListener(e->bookDirectFlight());
		view.getBtn_book_transit().addActionListener(e->bookTransitFlight());
		
	}
	

	private void bookTransitFlight() {
		bookingDAO.bookDirectFlight(Integer.parseInt(view.getTextField_flight_transit().getText()), userModel.getUser_id(),
				Float.parseFloat(view.getTextField_price1().getText()), view.getComboBox().getSelectedItem().toString());
		bookingDAO.bookDirectFlight(Integer.parseInt(view.getTextField_flight_transit2().getText()), userModel.getUser_id(),
				Float.parseFloat(view.getTextField_price2().getText()), view.getComboBox().getSelectedItem().toString());
		view.dispose();
	}

	private void bookDirectFlight() {
		bookingDAO.bookDirectFlight(Integer.parseInt(view.getTextField_flight_direct().getText()), userModel.getUser_id(),
				Float.parseFloat(view.getTextField_price_direct().getText()), view.getComboBox().getSelectedItem().toString());
		view.dispose();
	}


	private void initTableDirectController() {
		
		view.getTable_direct().setCellSelectionEnabled(true);
		
		
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
		view.getTable_transit().setCellSelectionEnabled(true);
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
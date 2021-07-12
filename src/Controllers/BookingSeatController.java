package Controllers;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import ConnectDB.BookingDAO;
import ConnectDB.UserDAO;
import ConnectDB.flightSeats;
import Models.Flight;
import Models.Seat;
import Models.User;
import Views.BookingSeatView;
import Views.UserUI;

/*
 * @author: Thien Huong Le
 */
public class BookingSeatController {
	private BookingSeatView view;
	private Flight flight;
	private Seat seat;
	private User user;
	flightSeats seatsDB = new flightSeats();
	UserDAO userDAO = new UserDAO();
	BookingDAO bookingDAO = new BookingDAO();
	
	public BookingSeatController(BookingSeatView view, Flight fl,Seat s, User user) {
		this.view = view;
		this.flight = fl;
		this.seat = s;
		this.user = user;
		initView();
		initTableListener();
		initBookingBtnListener();
		initBackBtnListener();
	}
	


	private void initView() {
		initFlightLabel();
		initTable();
		
	}
	
	private void initFlightLabel() {
		int flightId = flight.getId_flight();
		String cityDep = bookingDAO.getCityDep(flightId);
		String cityArr = bookingDAO.getCityArr(flightId);
		
		view.setFlightLabel(cityDep + " - " + cityArr);
		
	}


	@SuppressWarnings("serial")
	private void initTable() {
		// Table model
		String column1[]={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y"};
		String data[][] = new String[4][25];
		int flightId = flight.getId_flight();
		
		JTable table;
		JScrollPane scrollPane = view.getScrollPane();
		
		
		table = new JTable(data, column1) {
			/* Custom table renderer (create a table of seats according to the state of them)
			 * Column A - C: Premium (BLUE)
			 * Column D - Y: Economy (WHITE)
			 * Booked "Seat" (PINK)
			*/
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component comp = super.prepareRenderer(renderer, row, column);
                int modelRow = convertRowIndexToModel(row);
                int modelColumn = convertColumnIndexToModel(column);
                String chosenSeat = column1[modelColumn] + Integer.toString(modelRow + 1);
                char chosenColumn = column1[modelColumn].charAt(0);
                try {
					if( chosenColumn >= 'A' && chosenColumn <= 'C' && !seatsDB.isBooked(chosenSeat, flightId)) {
						comp.setBackground(SystemColor.textHighlight);
					} else if (chosenColumn >= 'D' && chosenColumn <= 'Y' && !seatsDB.isBooked(chosenSeat, flightId)) {
						comp.setBackground(Color.WHITE);
					} else {
						comp.setBackground(Color.PINK);
					    comp.setEnabled(false);
					}
				} catch (Exception e) {
					System.out.println("Error");
				}


                return comp;
            }
            
            // user can not edit the cell of the table
            @Override
            public boolean isCellEditable(int row, int column){  
                return false;  
            }
   
        };
        
	    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	    centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.setForeground(Color.WHITE);
	    table.setCellSelectionEnabled(true);
	    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    scrollPane.setViewportView(table);
	    table.setRowHeight(40);
	    JTableHeader header = table.getTableHeader();
	    header.setPreferredSize(new Dimension(100, 0));

	    scrollPane.setColumnHeader(new JViewport() {
	        @Override 
	        public Dimension getPreferredSize() {
	            Dimension d = super.getPreferredSize();
	            d.height = 0;
	            return d;
	          }
	    });
	    
	    view.setTable(table);
        
        
		
	}
	
	private void initTableListener() {
		JTable table = view.getTable();
		String column1[]={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y"};
	    JButton bookingBtn = view.getBookingBtn();
	    int flightId = flight.getId_flight();
		int seatId = seat.getSeatId();
		
		table.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(final MouseEvent e) {
	            if (e.getClickCount() == 1) {
	                final JTable jTable= (JTable)e.getSource();
	                final int row = jTable.getSelectedRow();
	                final int column = jTable.getSelectedColumn();
	                String chosenSeat = column1[column] + Integer.toString(row + 1);
	                char chosenColumn = column1[column].charAt(0);
	                try {
	                	String type = userDAO.getSeatType(seatId);
						if(!seatsDB.isBooked(chosenSeat, flightId)) {
							bookingBtn.setEnabled(true);
							view.setSeatState("AVAILABLE");
						} else {
							bookingBtn.setEnabled(false);
							view.setSeatState("BOOKED");
						}
						
						if( chosenColumn >= 'A' && chosenColumn <= 'C' && type.equals("Premium")) {
							bookingBtn.setEnabled(true);
						} else if (chosenColumn >= 'D' && chosenColumn <= 'Y' && type.equals("Economy")) {
							bookingBtn.setEnabled(true);
						} else {
							bookingBtn.setEnabled(false);
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	                view.setSelectedSeat(column1[column] + Integer.toString(row + 1));
	            }
	        }
	        });
	    
	}
	
	private void initBookingBtnListener() {

		JButton bookingBtn = view.getBookingBtn();
		String column1[]={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y"};
		JTable table = view.getTable();
		JFrame frame = view.getFrame();
	    bookingBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String chosenSeat = column1[table.getSelectedColumn()] + Integer.toString(table.getSelectedRow() + 1);			
				JOptionPane optionPane = new JOptionPane(
					    "Do you want to book Seat " + chosenSeat + "?",
					    JOptionPane.QUESTION_MESSAGE,
					    JOptionPane.YES_NO_OPTION);
				final JDialog dialog = new JDialog(frame, 
						"Confirm Selection",
						true);
				dialog.setBounds(400,600,50,50);
				dialog.setLocationRelativeTo(null);
				dialog.setContentPane(optionPane);
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
					try {
						int seatId = seat.getSeatId();
						String type = userDAO.getSeatType(seatId);
						seatsDB.putSeat(seatId,chosenSeat,type);
					    UserUI userView = new UserUI();
					    new UserUIController(userView, user);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				    dialog.setVisible(false);
				    frame.setVisible(false);
				} else if (value == JOptionPane.NO_OPTION) {
					dialog.setVisible(false);
				}
			}
	    	
	    });
	}
    
	private void initBackBtnListener() {
		JButton backBtn = view.getBackBtn();
		JFrame frame = view.getFrame();
		
		backBtn.addActionListener(new ActionListener() {

			@Override
			// close the BookingSeatView if the user clicks on the Back button
			// open the main user interface
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				UserUI UIFrame = new UserUI();
				new UserUIController(UIFrame, user);
			}
	    	
	    });
			
	}
}

package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import ConnectDB.flightSeats;
import Models.Seat;
/**
 * 
 * @author Thien Huong Le
 *
 */

public class BookingSeatView extends JFrame {

	private JTable table;
	private JPanel seatTable1 = new JPanel();
	private JScrollPane scrollPane = new JScrollPane();
	private JFrame frame  = new JFrame("Booking Seat");
	private JButton bookingBtn = new JButton("CONFIRM");
	private JButton backBtn = new JButton("BACK");
	
	private JTextField textField_1;
	private JTextField txtUnavailable;
	private JTextField textField_2;
	private JTextField seatPrice;
	private JTextField textField;
	private JTextField txtPremium;
	private JTextField txtEconomy;
	private JTextField seatState;
	private JTextField selectedSeat; 
	private JLabel flightLabel;

	
	/*
	public static void main(String[] args) {
		BookingSeatView frame = new BookingSeatView();
	}
	*/

	public BookingSeatView() {
		frame.getContentPane().setForeground(Color.GRAY);
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 18));
		frame.setBackground(Color.WHITE);
		
		frame.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		frame.setBounds(200,200,951,566);
		frame.getContentPane().setLayout(null);
		
		seatTable1.setBackground(Color.WHITE);
		seatTable1.setBounds(76, 115, 784, 163);
		frame.getContentPane().add(seatTable1);
		seatTable1.setLayout(null);
		
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(0, 0, 784, 163);
		seatTable1.add(scrollPane);
	 
	    bookingBtn.setBackground(Color.WHITE);
	    bookingBtn.setIcon(null);
	    bookingBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    bookingBtn.setBounds(703, 334, 134, 40);
	    frame.getContentPane().add(bookingBtn);
		
	 
	    // ----------------------------------------Decoration------------------------------------------------
	    JPanel seatHeader1 = new JPanel();
	    seatHeader1.setBackground(SystemColor.inactiveCaptionBorder);
	    seatHeader1.setBounds(76, 84, 784, 20);
	    frame.getContentPane().add(seatHeader1);
	    seatHeader1.setLayout(new GridLayout(1, 0, 0, 0));
	    
	    JLabel lblNewLabel_1 = new JLabel("A");
	    lblNewLabel_1.setForeground(Color.GRAY);
	    lblNewLabel_1.setBackground(SystemColor.inactiveCaptionBorder);
	    lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	    seatHeader1.add(lblNewLabel_1);
	    
	    JLabel lblNewLabel_2 = new JLabel("B");
	    lblNewLabel_2.setForeground(Color.GRAY);
	    lblNewLabel_2.setBackground(SystemColor.inactiveCaption);
	    lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
	    seatHeader1.add(lblNewLabel_2);
	    
	    JLabel lblNewLabel = new JLabel("C");
	    lblNewLabel.setForeground(Color.GRAY);
	    lblNewLabel.setBackground(SystemColor.inactiveCaptionBorder);
	    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    seatHeader1.add(lblNewLabel);
	    
	    JLabel lblNewLabel_4 = new JLabel("D");
	    lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_4.setForeground(Color.GRAY);
	    lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
	    seatHeader1.add(lblNewLabel_4);
	    
	    JLabel lblNewLabel_25 = new JLabel("E");
	    lblNewLabel_25.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_25.setForeground(Color.GRAY);
	    lblNewLabel_25.setFont(new Font("Tahoma", Font.BOLD, 16));
	    seatHeader1.add(lblNewLabel_25);
	    
	    JLabel lblNewLabel_26 = new JLabel("F");
	    lblNewLabel_26.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_26.setForeground(Color.GRAY);
	    lblNewLabel_26.setFont(new Font("Tahoma", Font.BOLD, 16));
	    seatHeader1.add(lblNewLabel_26);
	    
	    JLabel lblNewLabel_27 = new JLabel("G");
	    lblNewLabel_27.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_27.setForeground(Color.GRAY);
	    lblNewLabel_27.setFont(new Font("Tahoma", Font.BOLD, 16));
	    seatHeader1.add(lblNewLabel_27);
	    
	    JLabel lblNewLabel_28 = new JLabel("H");
	    lblNewLabel_28.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_28.setForeground(Color.GRAY);
	    lblNewLabel_28.setFont(new Font("Tahoma", Font.BOLD, 16));
	    seatHeader1.add(lblNewLabel_28);
	    
	    JLabel lblNewLabel_29 = new JLabel("I");
	    lblNewLabel_29.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_29.setForeground(Color.GRAY);
	    lblNewLabel_29.setFont(new Font("Tahoma", Font.BOLD, 16));
	    seatHeader1.add(lblNewLabel_29);
	    
	    JLabel lblNewLabel_30 = new JLabel("J");
	    lblNewLabel_30.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_30.setForeground(Color.GRAY);
	    lblNewLabel_30.setFont(new Font("Tahoma", Font.BOLD, 16));
	    seatHeader1.add(lblNewLabel_30);
	    
	    JLabel lblNewLabel_31 = new JLabel("K");
	    lblNewLabel_31.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_31.setForeground(Color.GRAY);
	    lblNewLabel_31.setFont(new Font("Tahoma", Font.BOLD, 16));
	    seatHeader1.add(lblNewLabel_31);
	    
	    JLabel lblNewLabel_32 = new JLabel("L");
	    lblNewLabel_32.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_32.setForeground(Color.GRAY);
	    lblNewLabel_32.setFont(new Font("Tahoma", Font.BOLD, 16));
	    seatHeader1.add(lblNewLabel_32);
	    
	    JLabel lblNewLabel_33 = new JLabel("M");
	    lblNewLabel_33.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_33.setForeground(Color.GRAY);
	    lblNewLabel_33.setFont(new Font("Tahoma", Font.BOLD, 16));
	    seatHeader1.add(lblNewLabel_33);
	    
	    JLabel lblNewLabel_34 = new JLabel("N");
	    lblNewLabel_34.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_34.setForeground(Color.GRAY);
	    lblNewLabel_34.setFont(new Font("Tahoma", Font.BOLD, 16));
	    seatHeader1.add(lblNewLabel_34);
	    
	    JLabel lblNewLabel_35 = new JLabel("O");
	    lblNewLabel_35.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_35.setForeground(Color.GRAY);
	    lblNewLabel_35.setFont(new Font("Tahoma", Font.BOLD, 16));
	    seatHeader1.add(lblNewLabel_35);
	    
	    JLabel lblNewLabel_36 = new JLabel("P");
	    lblNewLabel_36.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_36.setForeground(Color.GRAY);
	    lblNewLabel_36.setFont(new Font("Tahoma", Font.BOLD, 16));
	    seatHeader1.add(lblNewLabel_36);
	    
	    JLabel lblNewLabel_38 = new JLabel("Q");
	    lblNewLabel_38.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_38.setForeground(Color.GRAY);
	    lblNewLabel_38.setFont(new Font("Tahoma", Font.BOLD, 16));
	    seatHeader1.add(lblNewLabel_38);
	    
	    JLabel lblNewLabel_37 = new JLabel("R");
	    lblNewLabel_37.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_37.setForeground(Color.GRAY);
	    lblNewLabel_37.setFont(new Font("Tahoma", Font.BOLD, 16));
	    seatHeader1.add(lblNewLabel_37);
	    
	    JLabel lblNewLabel_40 = new JLabel("S");
	    lblNewLabel_40.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_40.setForeground(Color.GRAY);
	    lblNewLabel_40.setFont(new Font("Tahoma", Font.BOLD, 16));
	    seatHeader1.add(lblNewLabel_40);
	    
	    JLabel lblNewLabel_41 = new JLabel("T");
	    lblNewLabel_41.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_41.setForeground(Color.GRAY);
	    lblNewLabel_41.setFont(new Font("Tahoma", Font.BOLD, 16));
	    seatHeader1.add(lblNewLabel_41);
	    
	    JLabel lblNewLabel_42 = new JLabel("U");
	    lblNewLabel_42.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_42.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_42.setForeground(Color.GRAY);
	    seatHeader1.add(lblNewLabel_42);
	    
	    JLabel lblNewLabel_43 = new JLabel("V");
	    lblNewLabel_43.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_43.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_43.setForeground(Color.GRAY);
	    seatHeader1.add(lblNewLabel_43);
	    
	    JLabel lblNewLabel_44 = new JLabel("W");
	    lblNewLabel_44.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_44.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_44.setForeground(Color.GRAY);
	    seatHeader1.add(lblNewLabel_44);
	    
	    JLabel lblNewLabel_45 = new JLabel("X");
	    lblNewLabel_45.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_45.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_45.setForeground(Color.GRAY);
	    seatHeader1.add(lblNewLabel_45);
	    
	    JLabel lblNewLabel_46 = new JLabel("Y");
	    lblNewLabel_46.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_46.setForeground(Color.GRAY);
	    lblNewLabel_46.setFont(new Font("Tahoma", Font.BOLD, 16));
	    seatHeader1.add(lblNewLabel_46);
	    
	    JPanel seatRow2 = new JPanel();
	    seatRow2.setForeground(Color.GRAY);
	    seatRow2.setBackground(SystemColor.inactiveCaptionBorder);
	    seatRow2.setBounds(870, 115, 27, 160);
	    frame.getContentPane().add(seatRow2);
	    
	    JLabel lblNewLabel_5 = new JLabel("2");
	    lblNewLabel_5.setForeground(Color.GRAY);
	    lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
	    seatRow2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	    
	    JLabel lblNewLabel_3 = new JLabel("1");
	    lblNewLabel_3.setForeground(Color.GRAY);
	    lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
	    lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
	    seatRow2.add(lblNewLabel_3);
	    
	    JLabel lblNewLabel_15 = new JLabel("      ");
	    lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 7));
	    seatRow2.add(lblNewLabel_15);
	    seatRow2.add(lblNewLabel_5);
	    
	    JLabel lblNewLabel_14 = new JLabel("     ");
	    lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 7));
	    seatRow2.add(lblNewLabel_14);
	    
	    JLabel lblNewLabel_6 = new JLabel("3");
	    lblNewLabel_6.setForeground(Color.GRAY);
	    lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
	    seatRow2.add(lblNewLabel_6);
	    
	    JLabel lblNewLabel_17 = new JLabel("     ");
	    lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 7));
	    seatRow2.add(lblNewLabel_17);
	    
	    JLabel lblNewLabel_7 = new JLabel("4");
	    lblNewLabel_7.setForeground(Color.GRAY);
	    lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 18));
	    seatRow2.add(lblNewLabel_7);
	    
	    JLabel lblNewLabel_16 = new JLabel("     ");
	    lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 7));
	    seatRow2.add(lblNewLabel_16);
	    
	    JLabel lblNewLabel_8 = new JLabel("5");
	    lblNewLabel_8.setForeground(Color.GRAY);
	    lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 18));
	    seatRow2.add(lblNewLabel_8);
	    
	    JLabel lblNewLabel_20 = new JLabel("     ");
	    lblNewLabel_20.setFont(new Font("Tahoma", Font.PLAIN, 7));
	    seatRow2.add(lblNewLabel_20);
	    
	    JLabel lblNewLabel_9 = new JLabel("6");
	    lblNewLabel_9.setForeground(Color.GRAY);
	    lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 18));
	    seatRow2.add(lblNewLabel_9);
	    
	    JLabel lblNewLabel_19 = new JLabel("     ");
	    lblNewLabel_19.setFont(new Font("Tahoma", Font.PLAIN, 7));
	    seatRow2.add(lblNewLabel_19);
	    
	    JLabel lblNewLabel_10 = new JLabel("7");
	    lblNewLabel_10.setForeground(Color.GRAY);
	    lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 18));
	    seatRow2.add(lblNewLabel_10);
	    
	    JLabel lblNewLabel_18 = new JLabel("      ");
	    lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 7));
	    seatRow2.add(lblNewLabel_18);
	    
	    JLabel lblNewLabel_12 = new JLabel("8");
	    lblNewLabel_12.setForeground(Color.GRAY);
	    lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 18));
	    seatRow2.add(lblNewLabel_12);
	    
	    JLabel lblNewLabel_22 = new JLabel("     ");
	    lblNewLabel_22.setFont(new Font("Tahoma", Font.PLAIN, 7));
	    seatRow2.add(lblNewLabel_22);
	    
	    JLabel lblNewLabel_13 = new JLabel("9");
	    lblNewLabel_13.setForeground(Color.GRAY);
	    lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 18));
	    seatRow2.add(lblNewLabel_13);
	    
	    JLabel lblNewLabel_21 = new JLabel("     ");
	    lblNewLabel_21.setFont(new Font("Tahoma", Font.PLAIN, 7));
	    seatRow2.add(lblNewLabel_21);
	    
	    JLabel lblNewLabel_11 = new JLabel("10");
	    lblNewLabel_11.setForeground(Color.GRAY);
	    lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 18));
	    seatRow2.add(lblNewLabel_11);
	    
	    JPanel seatRow1 = new JPanel();
	    seatRow1.setBackground(SystemColor.inactiveCaptionBorder);
	    seatRow1.setBounds(39, 115, 27, 160);
	    frame.getContentPane().add(seatRow1);
	    seatRow1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	    
	    JLabel lblNewLabel_3_1 = new JLabel("1");
	    lblNewLabel_3_1.setForeground(Color.GRAY);
	    lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 18));
	    seatRow1.add(lblNewLabel_3_1);
	    
	    JLabel lblNewLabel_15_1 = new JLabel("      ");
	    lblNewLabel_15_1.setFont(new Font("Tahoma", Font.PLAIN, 7));
	    seatRow1.add(lblNewLabel_15_1);
	    
	    JLabel lblNewLabel_5_1 = new JLabel("2");
	    lblNewLabel_5_1.setForeground(Color.GRAY);
	    lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 18));
	    seatRow1.add(lblNewLabel_5_1);
	    
	    JLabel lblNewLabel_14_1 = new JLabel("     ");
	    lblNewLabel_14_1.setFont(new Font("Tahoma", Font.PLAIN, 7));
	    seatRow1.add(lblNewLabel_14_1);
	    
	    JLabel lblNewLabel_6_1 = new JLabel("3");
	    lblNewLabel_6_1.setForeground(Color.GRAY);
	    lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 18));
	    seatRow1.add(lblNewLabel_6_1);
	    
	    JLabel lblNewLabel_17_1 = new JLabel("     ");
	    lblNewLabel_17_1.setFont(new Font("Tahoma", Font.PLAIN, 7));
	    seatRow1.add(lblNewLabel_17_1);
	    
	    JLabel lblNewLabel_7_1 = new JLabel("4");
	    lblNewLabel_7_1.setForeground(Color.GRAY);
	    lblNewLabel_7_1.setFont(new Font("Tahoma", Font.BOLD, 18));
	    seatRow1.add(lblNewLabel_7_1);
	    
	    JLabel lblNewLabel_16_1 = new JLabel("     ");
	    lblNewLabel_16_1.setFont(new Font("Tahoma", Font.PLAIN, 7));
	    seatRow1.add(lblNewLabel_16_1);
	    
	    JLabel lblNewLabel_8_1 = new JLabel("5");
	    lblNewLabel_8_1.setForeground(Color.GRAY);
	    lblNewLabel_8_1.setFont(new Font("Tahoma", Font.BOLD, 18));
	    seatRow1.add(lblNewLabel_8_1);
	    
	    JLabel lblNewLabel_20_1 = new JLabel("     ");
	    lblNewLabel_20_1.setFont(new Font("Tahoma", Font.PLAIN, 7));
	    seatRow1.add(lblNewLabel_20_1);
	    
	    JLabel lblNewLabel_9_1 = new JLabel("6");
	    lblNewLabel_9_1.setForeground(Color.GRAY);
	    lblNewLabel_9_1.setFont(new Font("Tahoma", Font.BOLD, 18));
	    seatRow1.add(lblNewLabel_9_1);
	    
	    JLabel lblNewLabel_19_1 = new JLabel("     ");
	    lblNewLabel_19_1.setFont(new Font("Tahoma", Font.PLAIN, 7));
	    seatRow1.add(lblNewLabel_19_1);
	    
	    JLabel lblNewLabel_10_1 = new JLabel("7");
	    lblNewLabel_10_1.setForeground(Color.GRAY);
	    lblNewLabel_10_1.setFont(new Font("Tahoma", Font.BOLD, 18));
	    seatRow1.add(lblNewLabel_10_1);
	    
	    JLabel lblNewLabel_18_1 = new JLabel("      ");
	    lblNewLabel_18_1.setFont(new Font("Tahoma", Font.PLAIN, 7));
	    seatRow1.add(lblNewLabel_18_1);
	    
	    JLabel lblNewLabel_12_1 = new JLabel("8");
	    lblNewLabel_12_1.setForeground(Color.GRAY);
	    lblNewLabel_12_1.setFont(new Font("Tahoma", Font.BOLD, 18));
	    seatRow1.add(lblNewLabel_12_1);
	    
	    JLabel lblNewLabel_22_1 = new JLabel("     ");
	    lblNewLabel_22_1.setFont(new Font("Tahoma", Font.PLAIN, 7));
	    seatRow1.add(lblNewLabel_22_1);
	    
	    JLabel lblNewLabel_13_1 = new JLabel("9");
	    lblNewLabel_13_1.setForeground(Color.GRAY);
	    lblNewLabel_13_1.setFont(new Font("Tahoma", Font.BOLD, 18));
	    seatRow1.add(lblNewLabel_13_1);
	    
	    JLabel lblNewLabel_21_1 = new JLabel("     ");
	    lblNewLabel_21_1.setFont(new Font("Tahoma", Font.PLAIN, 7));
	    seatRow1.add(lblNewLabel_21_1);
	    
	    JLabel lblNewLabel_11_1 = new JLabel("10");
	    lblNewLabel_11_1.setForeground(Color.GRAY);
	    lblNewLabel_11_1.setFont(new Font("Tahoma", Font.BOLD, 18));
	    seatRow1.add(lblNewLabel_11_1);
	    
	    flightLabel = new JLabel();
	    flightLabel.setForeground(Color.LIGHT_GRAY);
	    flightLabel.setFont(new Font("Tahoma", Font.BOLD, 31));
	    flightLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    flightLabel.setBounds(283, 11, 390, 50);
	    frame.getContentPane().add(flightLabel);
	    
	    textField_1 = new JTextField();
	    textField_1.setBorder(null);
	    textField_1.setBackground(Color.PINK);
	    textField_1.setBounds(102, 434, 43, 28);
	    frame.getContentPane().add(textField_1);
	    textField_1.setColumns(10);
	    
	    txtUnavailable = new JTextField();
	    txtUnavailable.setBorder(null);
	    txtUnavailable.setBackground(SystemColor.inactiveCaptionBorder);
	    txtUnavailable.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    txtUnavailable.setText("UNAVAILABLE");
	    txtUnavailable.setBounds(155, 438, 94, 20);
	    frame.getContentPane().add(txtUnavailable);
	    txtUnavailable.setColumns(10);
	    
	    textField_2 = new JTextField();
	    textField_2.setColumns(10);
	    textField_2.setBorder(null);
	    textField_2.setBackground(Color.WHITE);
	    textField_2.setBounds(102, 384, 43, 28);
	    frame.getContentPane().add(textField_2);
	    
	    //--------------------------------------------------------------------------------------------------
	    
	    
	    //-------------------------Seat's detail-------------------------
	    JPanel seatDetail = new JPanel();
	    seatDetail.setBorder(new LineBorder(Color.PINK, 2));
	    seatDetail.setBackground(Color.WHITE);
	    seatDetail.setBounds(283, 330, 367, 139);
	    frame.getContentPane().add(seatDetail);
	    seatDetail.setLayout(null);
	    
	    selectedSeat = new JTextField();
	    selectedSeat.setFont(new Font("Tahoma", Font.PLAIN, 11));
	    selectedSeat.setHorizontalAlignment(SwingConstants.LEFT);
	    selectedSeat.setBorder(null);
	    selectedSeat.setBounds(120, 11, 123, 20);
	    seatDetail.add(selectedSeat);
	    selectedSeat.setColumns(10);
	    
	    JLabel lblNewLabel_24 = new JLabel("Selected Seat: ");
	    lblNewLabel_24.setFont(new Font("Tahoma", Font.BOLD, 12));
	    lblNewLabel_24.setBounds(15, 14, 91, 14);
	    seatDetail.add(lblNewLabel_24);
	    
	    JLabel lblNewLabel_24_1 = new JLabel("Price: ");
	    lblNewLabel_24_1.setFont(new Font("Tahoma", Font.BOLD, 12));
	    lblNewLabel_24_1.setHorizontalAlignment(SwingConstants.LEFT);
	    lblNewLabel_24_1.setBounds(15, 54, 74, 14);
	    seatDetail.add(lblNewLabel_24_1);
	    
	    seatPrice = new JTextField();
	    seatPrice.setFont(new Font("Tahoma", Font.PLAIN, 11));
	    seatPrice.setHorizontalAlignment(SwingConstants.LEFT);
	    seatPrice.setColumns(10);
	    seatPrice.setBorder(null);
	    seatPrice.setBounds(120, 52, 123, 20);
	    seatDetail.add(seatPrice);
	    
	    JLabel lblNewLabel_24_1_1 = new JLabel("State: ");
	    lblNewLabel_24_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
	    lblNewLabel_24_1_1.setHorizontalAlignment(SwingConstants.LEFT);
	    lblNewLabel_24_1_1.setBounds(15, 94, 74, 14);
	    seatDetail.add(lblNewLabel_24_1_1);
	    
	    seatState = new JTextField();
	    seatState.setFont(new Font("Tahoma", Font.PLAIN, 11));
	    seatState.setHorizontalAlignment(SwingConstants.LEFT);
	    seatState.setColumns(10);
	    seatState.setBorder(null);
	    seatState.setBounds(120, 92, 123, 20);
	    seatDetail.add(seatState);
	    
	    textField = new JTextField();
	    textField.setColumns(10);
	    textField.setBorder(null);
	    textField.setBackground(SystemColor.textHighlight);
	    textField.setBounds(102, 334, 43, 28);
	    frame.getContentPane().add(textField);
	    
	    txtPremium = new JTextField();
	    txtPremium.setText("PREMIUM");
	    txtPremium.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    txtPremium.setColumns(10);
	    txtPremium.setBorder(null);
	    txtPremium.setBackground(SystemColor.inactiveCaptionBorder);
	    txtPremium.setBounds(155, 338, 94, 20);
	    frame.getContentPane().add(txtPremium);
	    
	    backBtn.setBackground(Color.WHITE);
	    backBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    backBtn.setBounds(703, 385, 134, 40);
	    frame.getContentPane().add(backBtn);
	    
	    JLabel label = new JLabel("New label");
	    label.setBounds(782, 90, 22, 2);
	    frame.getContentPane().add(label);
	    
	    txtEconomy = new JTextField();
	    txtEconomy.setText("ECONOMY");
	    txtEconomy.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    txtEconomy.setColumns(10);
	    txtEconomy.setBorder(null);
	    txtEconomy.setBackground(SystemColor.inactiveCaptionBorder);
	    txtEconomy.setBounds(155, 388, 94, 20);
	    frame.getContentPane().add(txtEconomy);
	    //--------------------------------------------------------------

	    
	    frame.setVisible(true);
	    

	}
	
	public JTextField getSeatState() {
		return seatState;
	}


	public void setSeatState(String seatState) {
		this.seatState.setText(seatState);
	}
	
	public void setSelectedSeat(String selectedSeat) {
		this.selectedSeat.setText(selectedSeat);
	}


	public JTable getTable() {
		return table;
	}
	
	
	public void setTable(JTable table) {
		this.table = table;
	}


	public JPanel getSeatTable1() {
		return seatTable1;
	}



	public JButton getBookingBtn() {
		return bookingBtn;
	}



	public void setBookingBtn(JButton bookingBtn) {
		this.bookingBtn = bookingBtn;
	}



	public void setSeatTable1(JPanel seatTable1) {
		this.seatTable1 = seatTable1;
	}



	public JScrollPane getScrollPane() {
		return scrollPane;
	}



	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}



	public JFrame getFrame() {
		return frame;
	}



	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	
	public JButton getBackBtn() {
		return backBtn;
	}

	public void setBackBtn(JButton backBtn) {
		this.backBtn = backBtn;
	}
	

	public void setFlightLabel(String flightLabel) {
		this.flightLabel.setText(flightLabel);
	}


}
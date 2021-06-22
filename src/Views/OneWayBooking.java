package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ConnectDB.BookingDAO;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Thanh Tung Trinh
 *
 */

public class OneWayBooking extends BookingUI{

	public OneWayBooking() {
		super();
		JLabel lbl_titel = new JLabel("ONE WAY");
		lbl_titel.setForeground(new Color(255, 127, 80));
		lbl_titel.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_titel.setFont(new Font("Rockwell", Font.BOLD, 22));
		lbl_titel.setBounds(266, 11, 150, 24);
		getContentPane().add(lbl_titel);
	}
}


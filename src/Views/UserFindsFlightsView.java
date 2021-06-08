package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class UserFindsFlightsView extends JFrame {
	Border default_top_border= BorderFactory.createMatteBorder(2, 0, 0, 0 , new Color(240,240,240));
	Border red_top_border= BorderFactory.createMatteBorder(2, 0, 0, 0 , Color.red);
	
	private JPanel contentPane;
	private JLabel OneWay;
	private JLabel Return;
	private JLabel ow_from_label;
	private JLabel ow_to_label;
	private JTextField ow_traveller_input;
	private JPanel OnewayPanel;
	private JPanel ReturnPanel;
	private JLabel re_from_label;
	private JLabel re_to_label;
	private JLabel re_departure_label;
	private JTextField re_traveller_input;
	private JDateChooser ow_departure_input;
	private JButton ow_confirm;
	private JButton re_confirm;
	private JComboBox comboBox_ow_from_input;
	private JComboBox comboBox_ow_to_input;
	private JComboBox comboBox_return_from_input;
	private JComboBox comboBox_return_to_input;
	private String[] cities = {"Frankfurt","Hamburg","Berlin","Leipzig","M�nchen"};
	private JDateChooser re_departure_input;
	private JDateChooser re_return_input;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserFindsFlightsView frame = new UserFindsFlightsView();
					frame.setVisible(true);
					frame.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void start()
	{
		OneWay.setBorder(red_top_border);
		Return.setBorder(default_top_border);
		ReturnPanel.setVisible(false);
		OnewayPanel.setVisible(true);
	}
	public UserFindsFlightsView() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(320, 180, 805, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 794, 472);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TicketReservation");
		lblNewLabel.setBounds(334, 10, 164, 27);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblNewLabel);
		
		OneWay = new JLabel("One Way");
		OneWay.setBounds(0, 33, 401, 43);
		OneWay.setForeground(new Color(0, 0, 0));
		OneWay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OneWay.setBorder(red_top_border);
				Return.setBorder(default_top_border);
				ReturnPanel.setVisible(false);
				OnewayPanel.setVisible(true);
			}
		});
		OneWay.setOpaque(true);
		OneWay.setHorizontalAlignment(SwingConstants.CENTER);
		OneWay.setBackground(new Color(240, 255, 240));
		OneWay.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(OneWay);
		
		Return = new JLabel("Return");
		Return.setBounds(400, 33, 401, 43);
		Return.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Return.setBorder(red_top_border);
				OneWay.setBorder(default_top_border);
				ReturnPanel.setVisible(true);
				OnewayPanel.setVisible(false);
			}
		});
		Return.setOpaque(true);
		Return.setHorizontalAlignment(SwingConstants.CENTER);
		Return.setFont(new Font("Tahoma", Font.BOLD, 15));
		Return.setBackground(Color.CYAN);
		panel.add(Return);
		
		OnewayPanel = new JPanel();
		OnewayPanel.setBounds(0, 75, 794, 397);
		panel.add(OnewayPanel);
		OnewayPanel.setLayout(null);
		
		ow_from_label = new JLabel("From");
		ow_from_label.setFont(new Font("Tahoma", Font.BOLD, 15));
		ow_from_label.setBounds(210, 66, 110, 28);
		OnewayPanel.add(ow_from_label);
		
		ow_to_label = new JLabel("To");
		ow_to_label.setFont(new Font("Tahoma", Font.BOLD, 15));
		ow_to_label.setBounds(210, 114, 110, 28);
		OnewayPanel.add(ow_to_label);
		
		ow_departure_input = new JDateChooser();
		ow_departure_input.setBounds(330, 163, 169, 31);
		OnewayPanel.add(ow_departure_input);
		
		JLabel ow_departure_label = new JLabel("Departure");
		ow_departure_label.setFont(new Font("Tahoma", Font.BOLD, 15));
		ow_departure_label.setBounds(210, 163, 110, 31);
		OnewayPanel.add(ow_departure_label);
		
		ow_traveller_input = new JTextField();
		ow_traveller_input.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ow_traveller_input.setBounds(330, 214, 169, 31);
		OnewayPanel.add(ow_traveller_input);
		ow_traveller_input.setColumns(10);
		
		JLabel ow_traveller_label = new JLabel("Traveller");
		ow_traveller_label.setFont(new Font("Tahoma", Font.BOLD, 15));
		ow_traveller_label.setBounds(210, 214, 110, 31);
		OnewayPanel.add(ow_traveller_label);
		
		ow_confirm = new JButton("Confirm");
		ow_confirm.setFont(new Font("Tahoma", Font.BOLD, 15));
		ow_confirm.setBounds(350, 311, 132, 37);
		OnewayPanel.add(ow_confirm);
		
		comboBox_ow_from_input = new JComboBox(cities);
		comboBox_ow_from_input.setBounds(330, 65, 169, 31);
		OnewayPanel.add(comboBox_ow_from_input);
		
		comboBox_ow_to_input = new JComboBox(cities);
		comboBox_ow_to_input.setBounds(330, 114, 169, 31);
		OnewayPanel.add(comboBox_ow_to_input);
		
		ReturnPanel = new JPanel();
		ReturnPanel.setBounds(0, 75, 794, 397);
		panel.add(ReturnPanel);
		ReturnPanel.setLayout(null);
		
		re_from_label = new JLabel("From");
		re_from_label.setFont(new Font("Tahoma", Font.BOLD, 15));
		re_from_label.setBounds(210, 66, 110, 28);
		ReturnPanel.add(re_from_label);
		
		comboBox_return_from_input = new JComboBox(cities);
		comboBox_return_from_input.setBounds(330, 65, 169, 31);
		ReturnPanel.add(comboBox_return_from_input);
		
		re_to_label = new JLabel("To");
		re_to_label.setFont(new Font("Tahoma", Font.BOLD, 15));
		re_to_label.setBounds(210, 114, 100, 28);
		ReturnPanel.add(re_to_label);
		
		comboBox_return_to_input = new JComboBox(cities);
		comboBox_return_to_input.setBounds(330, 114, 169, 31);
		ReturnPanel.add(comboBox_return_to_input);
		
		re_departure_label = new JLabel("Departure");
		re_departure_label.setFont(new Font("Tahoma", Font.BOLD, 15));
		re_departure_label.setBounds(210, 163, 110, 31);
		ReturnPanel.add(re_departure_label);
		
		re_departure_input = new JDateChooser();
		re_departure_input.setBounds(330, 163, 169, 31);
		ReturnPanel.add(re_departure_input);
		
		JLabel re_return_label = new JLabel("Return");
		re_return_label.setFont(new Font("Tahoma", Font.BOLD, 15));
		re_return_label.setBounds(210, 214, 110, 31);
		ReturnPanel.add(re_return_label);
		
		re_return_input = new JDateChooser();
		re_return_input.setBounds(330, 214, 169, 31);
		ReturnPanel.add(re_return_input);
		
		JLabel re_traveller_label = new JLabel("Traveller");
		re_traveller_label.setFont(new Font("Tahoma", Font.BOLD, 15));
		re_traveller_label.setBounds(210, 267, 110, 31);
		ReturnPanel.add(re_traveller_label);
		
		re_traveller_input = new JTextField();
		re_traveller_input.setFont(new Font("Tahoma", Font.PLAIN, 15));
		re_traveller_input.setBounds(330, 267, 169, 31);
		ReturnPanel.add(re_traveller_input);
		re_traveller_input.setColumns(10);
		
		re_confirm = new JButton("Confirm");
		re_confirm.setFont(new Font("Tahoma", Font.BOLD, 15));
		re_confirm.setBounds(350, 311, 132, 37);
		ReturnPanel.add(re_confirm);
	}
	
	public Border getDefault_top_border() {
		return default_top_border;
	}

	public Border getRed_top_border() {
		return red_top_border;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JLabel getOneWay() {
		return OneWay;
	}

	public JLabel getReturn() {
		return Return;
	}

	public JLabel getOw_from_label() {
		return ow_from_label;
	}

	public JLabel getOw_to_label() {
		return ow_to_label;
	}

	public JTextField getOw_traveller_input() {
		return ow_traveller_input;
	}

	public JPanel getOnewayPanel() {
		return OnewayPanel;
	}

	public JPanel getReturnPanel() {
		return ReturnPanel;
	}

	public JLabel getRe_from_label() {
		return re_from_label;
	}

	public JLabel getRe_to_label() {
		return re_to_label;
	}

	public JLabel getRe_departure_label() {
		return re_departure_label;
	}

	public JTextField getRe_traveller_input() {
		return re_traveller_input;
	}

	public JDateChooser getOw_departure_input() {
		return ow_departure_input;
	}
	public JDateChooser getRe_away_input()
	{
		return re_departure_input;
	}
	public JDateChooser getRe_back_input()
	{
		return re_return_input;
	}
	public JButton getOw_confirm() {
		return ow_confirm;
	}

	public JButton getRe_confirm() {
		return re_confirm;
	}

	public String getComboBox_ow_from_input() {
		return (String)comboBox_ow_from_input.getSelectedItem();
	}

	public String getComboBox_ow_to_input() {
		return (String)comboBox_ow_to_input.getSelectedItem().toString();
	}

	public String getComboBox_return_from_input() {
		return (String)comboBox_return_from_input.getSelectedItem().toString();
	}

	public String getComboBox_return_to_input() {
		return (String)comboBox_return_to_input.getSelectedItem().toString();
	}

	public JButton getOwBtnConfirm()
	{
		return ow_confirm;
	}
	public JButton getReBtnConfirm()
	{
		return re_confirm;
	}
	public String getOw_departure_date() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String startDateString = dateFormat.format(ow_departure_input.getDate());
		return startDateString;
	}
	public String getRe_away_date()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String startDateString = dateFormat.format(re_departure_input.getDate());
		return startDateString;
	}
	public String getRe_back_date()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String startDateString = dateFormat.format(re_return_input.getDate());
		return startDateString;
	}

}


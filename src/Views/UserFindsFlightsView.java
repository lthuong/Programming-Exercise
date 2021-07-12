package Views;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import com.toedter.calendar.JDateChooser;

import ConnectDB.BookingDAO;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

/**
 * 
 * @author Thanh Tung Trinh
 * @author Thien Huong Le
 */

@SuppressWarnings("serial")
public class UserFindsFlightsView extends JFrame {
	Border default_top_border= BorderFactory.createMatteBorder(2, 0, 0, 0 , new Color(240,240,240));
	Border red_top_border= BorderFactory.createMatteBorder(2, 0, 0, 0 , Color.red);
	
	private JPanel contentPane;
	private JLabel OneWay;
	private JLabel Return;
	private JLabel ow_from_label;
	private JLabel ow_to_label;
	private JPanel OnewayPanel;
	private JPanel ReturnPanel;
	private JLabel re_from_label;
	private JLabel re_to_label;
	private JLabel re_departure_label;
	private JDateChooser ow_departure_input;
	private JButton ow_confirm;
	private JButton re_confirm;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_ow_from_input;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_ow_to_input;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_return_from_input;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_return_to_input;
	private JDateChooser re_departure_input;
	private JDateChooser re_return_input;
	BookingDAO bookingDAO = new BookingDAO();

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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public UserFindsFlightsView() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(320, 180, 805, 458);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBounds(0, 0, 794, 472);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TICKETRESERVATION");
		lblNewLabel.setForeground(new Color(255, 127, 80));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(262, 11, 317, 27);
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 22));
		panel.add(lblNewLabel);
		
		OneWay = new JLabel("One Way");
		OneWay.setBounds(0, 45, 401, 35);
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
		OneWay.setBackground(new Color(175, 238, 238));
		OneWay.setFont(new Font("Rockwell", Font.BOLD, 17));
		panel.add(OneWay);
		
		Return = new JLabel("Return");
		Return.setBounds(400, 45, 394, 35);
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
		Return.setFont(new Font("Rockwell", Font.BOLD, 17));
		Return.setBackground(new Color(152, 251, 152));
		panel.add(Return);
		
		OnewayPanel = new JPanel();
		OnewayPanel.setBackground(SystemColor.inactiveCaptionBorder);
		OnewayPanel.setBounds(0, 81, 794, 338);
		panel.add(OnewayPanel);
		OnewayPanel.setLayout(null);
		
		ow_from_label = new JLabel("From");
		ow_from_label.setForeground(new Color(119, 136, 153));
		ow_from_label.setFont(new Font("Arial Black", Font.PLAIN, 14));
		ow_from_label.setBounds(210, 60, 110, 30);
		OnewayPanel.add(ow_from_label);
		
		ow_to_label = new JLabel("To");
		ow_to_label.setForeground(new Color(119, 136, 153));
		ow_to_label.setFont(new Font("Arial Black", Font.PLAIN, 14));
		ow_to_label.setBounds(210, 114, 110, 30);
		OnewayPanel.add(ow_to_label);
		
		ow_departure_input = new JDateChooser();
		ow_departure_input.getCalendarButton().setFont(new Font("Arial", Font.PLAIN, 12));
		ow_departure_input.setBounds(330, 163, 169, 30);
		OnewayPanel.add(ow_departure_input);
		
		JLabel ow_departure_label = new JLabel("Departure");
		ow_departure_label.setForeground(new Color(119, 136, 153));
		ow_departure_label.setFont(new Font("Arial Black", Font.PLAIN, 14));
		ow_departure_label.setBounds(210, 163, 110, 30);
		OnewayPanel.add(ow_departure_label);
		
		ow_confirm = new JButton("Confirm");
		ow_confirm.setBorder(new LineBorder(new Color(0, 0, 0)));
		ow_confirm.setBackground(new Color(255, 255, 255));
		ow_confirm.setFont(new Font("Arial Black", Font.PLAIN, 14));
		ow_confirm.setBounds(330, 266, 132, 37);
		OnewayPanel.add(ow_confirm);
		
		comboBox_ow_from_input = new JComboBox(bookingDAO.getDEPCities());
		comboBox_ow_from_input.setFont(new Font("Arial", Font.BOLD, 12));
		comboBox_ow_from_input.setBounds(330, 60, 169, 30);
		OnewayPanel.add(comboBox_ow_from_input);
		
		comboBox_ow_to_input = new JComboBox(bookingDAO.getARRCities());
		comboBox_ow_to_input.setFont(new Font("Arial", Font.BOLD, 12));
		comboBox_ow_to_input.setBounds(330, 114, 169, 30);
		OnewayPanel.add(comboBox_ow_to_input);
		
		ReturnPanel = new JPanel();
		ReturnPanel.setBackground(SystemColor.inactiveCaptionBorder);
		ReturnPanel.setBounds(0, 75, 794, 397);
		panel.add(ReturnPanel);
		ReturnPanel.setLayout(null);
		
		re_from_label = new JLabel("From");
		re_from_label.setHorizontalAlignment(SwingConstants.LEFT);
		re_from_label.setForeground(new Color(119, 136, 153));
		re_from_label.setFont(new Font("Arial Black", Font.PLAIN, 14));
		re_from_label.setBounds(210, 50, 110, 30);
		ReturnPanel.add(re_from_label);
		
		comboBox_return_from_input = new JComboBox(bookingDAO.getDEPCities());
		comboBox_return_from_input.setFont(new Font("Arial", Font.BOLD, 12));
		comboBox_return_from_input.setBounds(330, 55, 169, 31);
		ReturnPanel.add(comboBox_return_from_input);
		
		re_to_label = new JLabel("To");
		re_to_label.setHorizontalAlignment(SwingConstants.LEFT);
		re_to_label.setForeground(new Color(119, 136, 153));
		re_to_label.setFont(new Font("Arial Black", Font.PLAIN, 14));
		re_to_label.setBounds(210, 104, 100, 30);
		ReturnPanel.add(re_to_label);
		
		comboBox_return_to_input = new JComboBox(bookingDAO.getARRCities());
		comboBox_return_to_input.setFont(new Font("Arial", Font.BOLD, 12));
		comboBox_return_to_input.setBounds(330, 104, 169, 31);
		ReturnPanel.add(comboBox_return_to_input);
		
		re_departure_label = new JLabel("Departure");
		re_departure_label.setHorizontalAlignment(SwingConstants.LEFT);
		re_departure_label.setForeground(new Color(119, 136, 153));
		re_departure_label.setFont(new Font("Arial Black", Font.PLAIN, 14));
		re_departure_label.setBounds(210, 153, 110, 31);
		ReturnPanel.add(re_departure_label);
		
		re_departure_input = new JDateChooser();
		re_departure_input.getCalendarButton().setFont(new Font("Arial", Font.PLAIN, 12));
		re_departure_input.setBounds(330, 153, 169, 31);
		ReturnPanel.add(re_departure_input);
		
		JLabel re_return_label = new JLabel("Return");
		re_return_label.setHorizontalAlignment(SwingConstants.LEFT);
		re_return_label.setForeground(new Color(119, 136, 153));
		re_return_label.setFont(new Font("Arial Black", Font.PLAIN, 14));
		re_return_label.setBounds(210, 204, 110, 31);
		ReturnPanel.add(re_return_label);
		
		re_return_input = new JDateChooser();
		re_return_input.getCalendarButton().setFont(new Font("Arial", Font.PLAIN, 12));
		re_return_input.setBounds(330, 204, 169, 31);
		ReturnPanel.add(re_return_input);
		
		re_confirm = new JButton("Confirm");
		re_confirm.setBackground(new Color(255, 255, 255));
		re_confirm.setFont(new Font("Arial Black", Font.PLAIN, 14));
		re_confirm.setBounds(330, 270, 132, 37);
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


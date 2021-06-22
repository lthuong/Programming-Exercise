package Views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JButton;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * 
 * @author Tuan Anh Nguyen
 * @author Thien Huong Le
 *
 */
@SuppressWarnings("serial")
public class AirlineInterface extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldFrom;
	private JTextField textFieldTo;
	private JDateChooser dateChooserStartDate;
	private JSpinner spinnerDepTime;
	private JSpinner spinnerArrTime;
	private JSpinner spinnerBasicPrice;
	private JSpinner spinnerPremiumPrice;
	private JSpinner spinnerFlightFreq;
	private JDateChooser dateChooserEndDate;
	private JButton btnSubmit;
	private JButton btnLogout;
	private JLabel warningMsgFrom;
	private JLabel warningMsgTo;
	private JLabel warningMsgStartDate;
	private JLabel warningMsgEndDate;
	
	public AirlineInterface() {
		setBackground(Color.WHITE);
		setTitle("New Flight Line Request");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(320, 180, 800, 490);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setForeground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Request New Flight Line");
		lblNewLabel.setForeground(new Color(255, 99, 71));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(265, 30, 270, 25);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 22));
		
		dateChooserStartDate = new JDateChooser();
		dateChooserStartDate.setBounds(525, 88, 140, 30);
		contentPane.add(dateChooserStartDate);
		
		JLabel lblStartDate = new JLabel("Start-date");
		lblStartDate.setForeground(new Color(47, 79, 79));
		lblStartDate.setFont(new Font("Arial", Font.BOLD, 12));
		lblStartDate.setLabelFor(dateChooserStartDate);
		lblStartDate.setBounds(430, 95, 84, 16);
		contentPane.add(lblStartDate);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setForeground(new Color(47, 79, 79));
		lblFrom.setFont(new Font("Arial", Font.BOLD, 12));
		lblFrom.setBounds(100, 95, 45, 16);
		contentPane.add(lblFrom);
		
		textFieldFrom = new JTextField();
		lblFrom.setLabelFor(textFieldFrom);
		textFieldFrom.setBounds(190, 88, 140, 30);
		contentPane.add(textFieldFrom);
		textFieldFrom.setColumns(10);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setForeground(new Color(47, 79, 79));
		lblTo.setFont(new Font("Arial", Font.BOLD, 12));
		lblTo.setBounds(100, 145, 30, 16);
		contentPane.add(lblTo);
		
		textFieldTo = new JTextField();
		lblTo.setLabelFor(textFieldTo);
		textFieldTo.setBounds(190, 138, 140, 30);
		contentPane.add(textFieldTo);
		textFieldTo.setColumns(10);
		
		Date date = new Date();
		SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
		spinnerDepTime = new JSpinner(sm);
		spinnerDepTime.setBounds(525, 188, 140, 30);
		contentPane.add(spinnerDepTime);
		JSpinner.DateEditor de_spinnerDepTime = new JSpinner.DateEditor(spinnerDepTime, "HH:mm");
		spinnerDepTime.setEditor(de_spinnerDepTime);
		
		JLabel lblDepTime = new JLabel("Departure time");
		lblDepTime.setForeground(new Color(47, 79, 79));
		lblDepTime.setFont(new Font("Arial", Font.BOLD, 12));
		lblDepTime.setLabelFor(spinnerDepTime);
		lblDepTime.setBounds(430, 195, 93, 16);
		contentPane.add(lblDepTime);
		
		JLabel lblArrTime = new JLabel("Arrival time");
		lblArrTime.setForeground(new Color(47, 79, 79));
		lblArrTime.setFont(new Font("Arial", Font.BOLD, 12));
		lblArrTime.setBounds(430, 245, 104, 16);
		contentPane.add(lblArrTime);
		
		Date date1 = new Date();
		SpinnerDateModel sm1 = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
		spinnerArrTime = new JSpinner(sm1);
		lblArrTime.setLabelFor(spinnerArrTime);
		spinnerArrTime.setBounds(525, 238, 140, 30);
		contentPane.add(spinnerArrTime);
		JSpinner.DateEditor de_spinnerArrTime = new JSpinner.DateEditor(spinnerArrTime, "HH:mm");
		spinnerArrTime.setEditor(de_spinnerArrTime);
		
		spinnerBasicPrice = new JSpinner();
		spinnerBasicPrice.setBounds(190, 188, 140, 30);
		spinnerBasicPrice.setValue(100);
		contentPane.add(spinnerBasicPrice);
		
		JLabel lblBasicPrice = new JLabel("Basic price");
		lblBasicPrice.setForeground(new Color(47, 79, 79));
		lblBasicPrice.setFont(new Font("Arial", Font.BOLD, 12));
		lblBasicPrice.setLabelFor(spinnerBasicPrice);
		lblBasicPrice.setBounds(100, 195, 93, 16);
		contentPane.add(lblBasicPrice);
		
		JLabel lblFlightFreq = new JLabel("Flight frequency");
		lblFlightFreq.setForeground(new Color(47, 79, 79));
		lblFlightFreq.setFont(new Font("Arial", Font.BOLD, 12));
		lblFlightFreq.setBounds(265, 318, 95, 16);
		contentPane.add(lblFlightFreq);
		
		JLabel lblPremiumPrice = new JLabel("Premium price");
		lblPremiumPrice.setForeground(new Color(47, 79, 79));
		lblPremiumPrice.setFont(new Font("Arial", Font.BOLD, 12));
		lblPremiumPrice.setBounds(100, 245, 93, 16);
		contentPane.add(lblPremiumPrice);
		
		spinnerPremiumPrice = new JSpinner();
		lblPremiumPrice.setLabelFor(spinnerPremiumPrice);
		spinnerPremiumPrice.setBounds(190, 238, 140, 30);
		spinnerPremiumPrice.setValue(150);
		contentPane.add(spinnerPremiumPrice);
		
		spinnerFlightFreq = new JSpinner();
		lblFlightFreq.setLabelFor(spinnerFlightFreq);
		spinnerFlightFreq.setBounds(405, 311, 60, 30);
		spinnerFlightFreq.setValue(1);
		contentPane.add(spinnerFlightFreq);
		
		dateChooserEndDate = new JDateChooser();
		dateChooserEndDate.setBounds(525, 138, 140, 30);
		contentPane.add(dateChooserEndDate);
		
		JLabel lblEndDate = new JLabel("End-date");
		lblEndDate.setForeground(new Color(47, 79, 79));
		lblEndDate.setFont(new Font("Arial", Font.BOLD, 12));
		lblEndDate.setLabelFor(dateChooserEndDate);
		lblEndDate.setBounds(430, 145, 84, 16);
		contentPane.add(lblEndDate);
		
		JLabel lblEvery = new JLabel("Every");
		lblEvery.setForeground(new Color(47, 79, 79));
		lblEvery.setFont(new Font("Arial", Font.BOLD, 12));
		lblEvery.setBounds(365, 318, 45, 16);
		contentPane.add(lblEvery);
		
		JLabel lblDays = new JLabel("day(s)");
		lblDays.setForeground(new Color(47, 79, 79));
		lblDays.setFont(new Font("Arial", Font.BOLD, 12));
		lblDays.setBounds(472, 318, 45, 16);
		contentPane.add(lblDays);
		
		btnSubmit = new JButton("SEND REQUEST");
		btnSubmit.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnSubmit.setBackground(new Color(255, 99, 71));
		btnSubmit.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnSubmit.setBounds(265, 390, 130, 29);
		contentPane.add(btnSubmit);
		
		warningMsgFrom = new JLabel("");
		warningMsgFrom.setForeground(Color.RED);
		warningMsgFrom.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		warningMsgFrom.setBounds(190, 118, 139, 15);
		contentPane.add(warningMsgFrom);
		
		warningMsgTo = new JLabel("");
		warningMsgTo.setForeground(Color.RED);
		warningMsgTo.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		warningMsgTo.setBounds(190, 168, 139, 15);
		contentPane.add(warningMsgTo);
		
		warningMsgStartDate = new JLabel("");
		warningMsgStartDate.setForeground(Color.RED);
		warningMsgStartDate.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		warningMsgStartDate.setBounds(520, 118, 139, 15);
		contentPane.add(warningMsgStartDate);
		
		warningMsgEndDate = new JLabel("");
		warningMsgEndDate.setForeground(Color.RED);
		warningMsgEndDate.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		warningMsgEndDate.setBounds(520, 168, 139, 15);
		contentPane.add(warningMsgEndDate);
		
		btnLogout = new JButton("LOG OUT");
		btnLogout.setBackground(new Color(255, 255, 255));
		btnLogout.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnLogout.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnLogout.setBounds(465, 390, 130, 29);
		contentPane.add(btnLogout);
	}
	
	public String getTextFieldFrom() {
		return textFieldFrom.getText();
	}
	public String getTextFieldTo() {
		return textFieldTo.getText();
	}
	public String getDateChooserStartDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String startDateString = dateFormat.format(dateChooserStartDate.getDate());
		return startDateString;
	}
	public String getDateChooserEndDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String endDateString = dateFormat.format(dateChooserEndDate.getDate());
		return endDateString;
	}
	public String getSpinnerDepTime() {
		Date date = (Date)spinnerDepTime.getValue();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        String depTime = format.format(date);
//        String[] depTime = format.format(date).split(":");
//        float toFloatTime = Float.parseFloat(depTime[0]) + Float.parseFloat(depTime[1])/60;
		return depTime;
	}
	public String getSpinnerArrTime() {
		Date date = (Date)spinnerArrTime.getValue();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        String arrTime = format.format(date);
		return arrTime;
	}
	public float getSpinnerBasicPrice() {
		return Float.parseFloat(spinnerBasicPrice.getValue().toString());
	}
	public float getSpinnerPremiumPrice() {
		return Float.parseFloat(spinnerPremiumPrice.getValue().toString());
	}
	public int getSpinnerFlightFreq() {
		return Integer.parseInt(spinnerFlightFreq.getValue().toString());
	}
	public JButton getBtnSubmit() {
		return btnSubmit;
	}
	public JButton getBtnLogout() {
		return btnLogout;
	}
	public JLabel getWarningMsgFrom() {
		return warningMsgFrom;
	}
	public JLabel getWarningMsgTo() {
		return warningMsgTo;
	}
	public JLabel getWarningMsgStartDate() {
		return warningMsgFrom;
	}
	public JLabel getWarningMsgEndDate() {
		return warningMsgEndDate;
	}

}

package Views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

/**
 * 
 * @author Tuan Anh Nguyen
 * @author Thien Huong Le
 *
 */
@SuppressWarnings("serial")
public class RegisterView extends JFrame {
	
	private static JPanel contentPane;
	private static JTextField textFieldEmail;
	private static JTextField textFieldFirstName;
	private static JTextField textFieldLastName;
	private static JPasswordField passwordField;
	private static JPasswordField passwordRetypeField;
	private static JButton btnLogin;
	private static JButton btnRegister;
	private static JLabel emailMessage;
	private static JLabel retypePasswordMessage;
	private static JLabel warningMessage;
	private static JLabel passwordMessage;
	private static JLabel lastNameTextWarningMsg;
	private static JLabel firstNameTextWarningMsg;
	private JLabel lblClass;
	private JComboBox comboBox;
	
	/**
	 * Create the frame.
	 */
	public RegisterView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, -28, 531, 545);
		setLocationRelativeTo(null);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnRegister = new JButton("REGISTER");
		btnRegister.setBorder(new LineBorder(Color.LIGHT_GRAY));
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegister.setBackground(Color.WHITE);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegister.setBounds(322, 450, 117, 29);
		contentPane.add(btnRegister);
		
		btnLogin = new JButton("BACK");
		btnLogin.setBorder(new LineBorder(Color.LIGHT_GRAY));
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setBounds(139, 450, 117, 29);
		contentPane.add(btnLogin);
		
		passwordRetypeField = new JPasswordField();
		passwordRetypeField.setBounds(169, 316, 240, 30);
		contentPane.add(passwordRetypeField);
		
		JLabel lblRetypePassword = new JLabel("Retype Password*");
		lblRetypePassword.setBounds(40, 323, 120, 16);
		lblRetypePassword.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		contentPane.add(lblRetypePassword);
		
		JLabel lblPassword = new JLabel("Password*");
		lblPassword.setBounds(86, 266, 74, 16);
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(169, 259, 240, 30);
		contentPane.add(passwordField);
		
		JLabel lblLastName = new JLabel("Last Name*");
		lblLastName.setBounds(78, 209, 82, 16);
		lblLastName.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		contentPane.add(lblLastName);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setBounds(169, 202, 240, 30);
		contentPane.add(textFieldLastName);
		textFieldLastName.setColumns(10);
		lblLastName.setLabelFor(textFieldLastName);
		
		JLabel lblFirstName = new JLabel("First Name*");
		lblFirstName.setBounds(77, 152, 82, 16);
		lblFirstName.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		contentPane.add(lblFirstName);
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setBounds(169, 145, 240, 30);
		contentPane.add(textFieldFirstName);
		textFieldFirstName.setColumns(10);
		lblFirstName.setLabelFor(textFieldFirstName);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(169, 88, 240, 30);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email*");
		lblEmail.setBounds(110, 95, 48, 16);
		lblEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		contentPane.add(lblEmail);
		lblEmail.setLabelFor(textFieldEmail);
		
		JLabel lblRegistration = new JLabel("Registration");
		lblRegistration.setForeground(Color.BLACK);
		lblRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistration.setBounds(169, 28, 205, 36);
		contentPane.add(lblRegistration);
		lblRegistration.setFont(new Font("Segoe Print", Font.BOLD, 29));
		
		warningMessage = new JLabel("");
		warningMessage.setVerticalAlignment(SwingConstants.BOTTOM);
		warningMessage.setBounds(169, 358, 182, 16);
		contentPane.add(warningMessage);
		warningMessage.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		warningMessage.setForeground(Color.PINK);
		
		emailMessage = new JLabel("");
		emailMessage.setBounds(169, 118, 193, 16);
		contentPane.add(emailMessage);
		emailMessage.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		emailMessage.setForeground(Color.PINK);
		
		retypePasswordMessage = new JLabel("");
		retypePasswordMessage.setBounds(169, 346, 193, 16);
		contentPane.add(retypePasswordMessage);
		retypePasswordMessage.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		retypePasswordMessage.setForeground(Color.PINK);
		
		passwordMessage = new JLabel("");
		passwordMessage.setForeground(Color.PINK);
		passwordMessage.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		passwordMessage.setBounds(169, 289, 193, 16);
		contentPane.add(passwordMessage);
		
		lastNameTextWarningMsg = new JLabel("");
		lastNameTextWarningMsg.setForeground(Color.PINK);
		lastNameTextWarningMsg.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lastNameTextWarningMsg.setBounds(169, 232, 193, 16);
		contentPane.add(lastNameTextWarningMsg);
		
		firstNameTextWarningMsg = new JLabel("");
		firstNameTextWarningMsg.setForeground(Color.PINK);
		firstNameTextWarningMsg.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		firstNameTextWarningMsg.setBounds(169, 175, 193, 16);
		contentPane.add(firstNameTextWarningMsg);
		
		lblClass = new JLabel("Class*");
		lblClass.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblClass.setBounds(115, 380, 50, 16);
		contentPane.add(lblClass);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setForeground(Color.BLACK);
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Classic", "Gold", "Plantinum"}));
		comboBox.setBounds(169, 370, 240, 30);
		contentPane.add(comboBox);
	}
	public JComboBox getComboBox() {
		return comboBox;
	}
	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}
	public String getFirstName() {
		return textFieldFirstName.getText();
	}
	public String getLastName() {
		return textFieldLastName.getText();
	}
	public String getEmail() {
		return textFieldEmail.getText();
	}
	public String getPW() {
		return String.copyValueOf(passwordField.getPassword());
	}
	public String getRetypePW() {
		return String.copyValueOf(passwordRetypeField.getPassword());
	}
	public JPanel getContentPane() {
		return contentPane;
	}
	public JLabel getEmailMessage() {
		return emailMessage;
	}
	public JLabel getFirstNameTextWarningMsg() {
		return firstNameTextWarningMsg;
	}
	public JLabel getLastNameTextWarningMsg() {
		return lastNameTextWarningMsg;
	}
	public JLabel getReTypePasswordMessage() {
		return retypePasswordMessage;
	}
	public JLabel getPasswordMessage() {
		return passwordMessage;
	}
	
	public JLabel getWarningMessage() {
		return warningMessage;
	}
	public JButton getBtnLogin(){
		return btnLogin;
	}
	
	public JButton getBtnRegister(){
		return btnRegister;
	}
}

package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConnectDB.UserDAO;
import Models.User;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.Color;

@SuppressWarnings("serial")
public class Registration extends JFrame {

	UserDAO userDAO = new UserDAO();
	
	private JPanel contentPane;
	private static JTextField textFieldEmail;
	private static JTextField textFieldFirstName;
	private static JTextField textFieldLastName;
	private static JPasswordField passwordField;
	private static JPasswordField passwordRetypeField;
	private static JLabel emailMessage;
	private static JLabel passwordMessage;
	private static JLabel warningMessage;
	
	/**
	 * Create the frame.
	 */
	public Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(187, 56, 182, 26);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email*");
		lblEmail.setLabelFor(textFieldEmail);
		lblEmail.setBounds(60, 61, 61, 16);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password*");
		lblPassword.setBounds(60, 145, 71, 16);
		contentPane.add(lblPassword);
		
		JLabel lblRetypePassword = new JLabel("Retype Password*");
		lblRetypePassword.setBounds(60, 173, 117, 21);
		contentPane.add(lblRetypePassword);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean isEmailValid = true;
				boolean isPasswordValid = true;
				boolean isFormBlank = false;
				if (userDAO.checkEmailExisted(getEmail())) {
					emailMessage.setText("Invalid");
					isEmailValid = false;
				} else {
					emailMessage.setText("");
				}
				if (getFirstName().equals("") || getLastName().equals("") || getEmail().equals("") || getPW().equals("") || getRetypePW().equals("")) {
					isFormBlank = true;
					warningMessage.setText("Fields can not be blank");
				} else {
					warningMessage.setText("");
				}
				if (!getPW().equals(getRetypePW())) {
					passwordMessage.setText("Not match");
					isPasswordValid = false;
				} else {
					passwordMessage.setText("");
				}
				if (!isFormBlank && isEmailValid && isPasswordValid) {
					userDAO.insertUserRegistration(new User(getFirstName(), getLastName(), getEmail(), getPW()));
					Login loginFrame = new Login();
					loginFrame.setVisible(true);
					dispose();
				}
			}
		});
		btnRegister.setBounds(80, 219, 117, 29);
		contentPane.add(btnRegister);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Login loginFrame = new Login();
				loginFrame.setVisible(true);
				dispose();
			}
		});
		btnLogin.setBounds(238, 219, 117, 29);
		contentPane.add(btnLogin);
		
		JLabel lblRegistration = new JLabel("Registration");
		lblRegistration.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblRegistration.setBounds(172, 19, 117, 16);
		contentPane.add(lblRegistration);
		
		JLabel lblFirstName = new JLabel("First Name*");
		lblFirstName.setBounds(60, 89, 82, 16);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name*");
		lblLastName.setBounds(60, 117, 82, 16);
		contentPane.add(lblLastName);
		
		textFieldFirstName = new JTextField();
		lblFirstName.setLabelFor(textFieldFirstName);
		textFieldFirstName.setBounds(187, 84, 182, 26);
		contentPane.add(textFieldFirstName);
		textFieldFirstName.setColumns(10);
		
		textFieldLastName = new JTextField();
		lblLastName.setLabelFor(textFieldLastName);
		textFieldLastName.setBounds(187, 112, 182, 26);
		contentPane.add(textFieldLastName);
		textFieldLastName.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(187, 140, 182, 26);
		contentPane.add(passwordField);
		
		passwordRetypeField = new JPasswordField();
		passwordRetypeField.setBounds(187, 170, 182, 26);
		contentPane.add(passwordRetypeField);
		
		emailMessage = new JLabel("");
		emailMessage.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		emailMessage.setForeground(Color.RED);
		emailMessage.setBounds(371, 61, 73, 16);
		contentPane.add(emailMessage);
		
		passwordMessage = new JLabel("");
		passwordMessage.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		passwordMessage.setForeground(Color.RED);
		passwordMessage.setBounds(371, 175, 73, 16);
		contentPane.add(passwordMessage);
		
		warningMessage = new JLabel("");
		warningMessage.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		warningMessage.setForeground(Color.RED);
		warningMessage.setBounds(190, 200, 182, 16);
		contentPane.add(warningMessage);
	}
	public static String getFirstName() {
		return textFieldFirstName.getText();
	}
	public static String getLastName() {
		return textFieldLastName.getText();
	}
	public static String getEmail() {
		return textFieldEmail.getText();
	}
	public static String getPW() {
		return String.copyValueOf(passwordField.getPassword());
	}
	public static String getRetypePW() {
		return String.copyValueOf(passwordRetypeField.getPassword());
	}
}

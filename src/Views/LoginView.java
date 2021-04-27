package Views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.Font;

@SuppressWarnings("serial")
public class LoginView extends JFrame {
	
	private JPanel contentPane;
	private JButton btnLogin;
	private JButton btnRegister;
	private JTextField textFieldUsername;
	private JPasswordField passwordField;
	private JCheckBox showPassword;
	private JLabel warningMessage;
	
	/**
	 * Create the frame.
	 */
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(99, 81, 70, 26);
		lblUsername.setBackground(Color.ORANGE);
		contentPane.add(lblUsername);
		
		textFieldUsername = new JTextField();
		lblUsername.setLabelFor(textFieldUsername);
		textFieldUsername.setBounds(184, 81, 162, 26);
		contentPane.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(99, 119, 61, 16);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		lblPassword.setLabelFor(passwordField);
		passwordField.setBounds(184, 114, 162, 26);
		contentPane.add(passwordField);
		
		showPassword = new JCheckBox("show password");
		showPassword.setBounds(194, 155, 162, 26);
		contentPane.add(showPassword);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(99, 188, 100, 29);
		contentPane.add(btnLogin);
		
		btnRegister = new JButton("Register");
		btnRegister.setBounds(235, 188, 100, 29);
		contentPane.add(btnRegister);
		
		JLabel lblNewLabel = new JLabel("Flight 24h");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblNewLabel.setBounds(184, 38, 86, 16);
		contentPane.add(lblNewLabel);
		
		warningMessage = new JLabel("");
		warningMessage.setForeground(Color.RED);
		warningMessage.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		warningMessage.setBounds(188, 140, 220, 16);
		contentPane.add(warningMessage);
	}
	
	public String getEmail() {
		return textFieldUsername.getText();
	}
	
	public String getPW() {
		return String.copyValueOf(passwordField.getPassword());
	}
	
	public JButton getBtnLogin(){
		return btnLogin;
	}
	
	public JCheckBox getShowPasswordCheckbox(){
		return showPassword;
	}
	
	public JButton getBtnRegister(){
		return btnRegister;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getTextFieldUsername() {
		return textFieldUsername;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public JLabel getWarningMessage() {
		return warningMessage;
	}
}

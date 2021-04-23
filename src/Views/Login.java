package Views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConnectDB.UserDAO;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;

@SuppressWarnings("serial")
public class Login extends JFrame {
	
	UserDAO userDAO = new UserDAO();
	
	private JPanel contentPane;
	private static JTextField textFieldUsername;
	private static JPasswordField passwordField;
	private static JLabel warningMessage;
	
	/**
	 * Create the frame.
	 */
	public Login() {
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
		lblPassword.setBounds(99, 136, 61, 16);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		lblPassword.setLabelFor(passwordField);
		passwordField.setBounds(184, 131, 162, 26);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isFormBlank = false;
				if  (getEmail().equals("") || getPW().equals("")) {
					isFormBlank = true;
					warningMessage.setText("Fields can not be blank");
				} else {
					warningMessage.setText("");
				}
				
				if (!isFormBlank) {
					if (userDAO.checkLogin(getEmail(), getPW())) {
						UserInterface UIFrame = new UserInterface();
						UIFrame.setVisible(true);
						dispose();   
					}
					 else {
						warningMessage.setText("Account not existed! Please register");
					}
				}
			}
			
		});
		btnLogin.setBounds(99, 188, 100, 29);
		contentPane.add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration registerFrame = new Registration();
				registerFrame.setVisible(true);
				dispose();
			}
			
		});
		btnRegister.setBounds(235, 188, 100, 29);
		contentPane.add(btnRegister);
		
		JLabel lblNewLabel = new JLabel("Flight 24h");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblNewLabel.setBounds(184, 38, 86, 16);
		contentPane.add(lblNewLabel);
		
		warningMessage = new JLabel("");
		warningMessage.setForeground(Color.RED);
		warningMessage.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		warningMessage.setBounds(187, 160, 220, 16);
		contentPane.add(warningMessage);
	}
	
	public static String getEmail() {
		return textFieldUsername.getText();
	}
	
	public static String getPW() {
		return String.copyValueOf(passwordField.getPassword());
	}
}

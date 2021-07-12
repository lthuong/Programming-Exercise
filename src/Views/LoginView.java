package Views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Image;

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
public class LoginView extends JFrame {
	
	private JPanel contentPane;
	private JButton btnLogin;
	private JButton btnRegister;
	private JTextField textFieldUsername;
	private JPasswordField passwordField;
	private JCheckBox showPassword;
	private JLabel warningPassword;
	private JLabel warningEmail;

	private Image personLogo = new ImageIcon(this.getClass().getResource("/person_logo.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
	private Image passwordLogo = new ImageIcon(this.getClass().getResource("/password.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
	private Image airplaneLogo = new ImageIcon(this.getClass().getResource("/airplane.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	
	private JLabel airplane;
	private JLabel password;
	private JLabel userName;
	
	/**
	 * Create the frame.
	 */
	public LoginView() {
		setResizable(false);
		setTitle("Flight24H");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 429);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnLogin = new JButton("LOGIN");
		btnLogin.setBorder(new LineBorder(Color.LIGHT_GRAY));
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogin.setBounds(200, 276, 130, 29);
		contentPane.add(btnLogin);
		
		btnRegister = new JButton("SIGN UP");
		btnRegister.setForeground(Color.LIGHT_GRAY);
		btnRegister.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegister.setBorder(null);
		btnRegister.setBackground(SystemColor.inactiveCaptionBorder);
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRegister.setBounds(332, 346, 57, 29);
		contentPane.add(btnRegister);
		
		showPassword = new JCheckBox("Show password");
		showPassword.setBorder(null);
		showPassword.setBackground(SystemColor.inactiveCaptionBorder);
		showPassword.setBounds(207, 306, 108, 26);
		contentPane.add(showPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(115, 200, 319, 35);
		contentPane.add(passwordField);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(115, 132, 319, 35);
		contentPane.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("FLIGHT 24H");
		lblNewLabel.setForeground(SystemColor.activeCaptionBorder);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(142, 49, 201, 38);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Segoe Print", Font.BOLD, 31));
		
		warningPassword = new JLabel("");
		warningPassword.setBounds(115, 235, 165, 25);
		contentPane.add(warningPassword);
		warningPassword.setForeground(Color.PINK);
		warningPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		
		warningEmail = new JLabel("");
		warningEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		warningEmail.setForeground(Color.PINK);
		warningEmail.setBounds(115, 166, 165, 25);
		contentPane.add(warningEmail);
		
		userName = new JLabel("");
		userName.setHorizontalAlignment(SwingConstants.CENTER);
		userName.setBounds(70, 132, 40, 38);
		userName.setIcon(new ImageIcon(personLogo));
		contentPane.add(userName);
		
		airplane = new JLabel("");
		airplane.setBounds(355, 44, 57, 57);
		airplane.setIcon(new ImageIcon(airplaneLogo));
		contentPane.add(airplane);
		
		password = new JLabel("");
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setBounds(73, 197, 35, 38);
		password.setIcon(new ImageIcon(passwordLogo));
		contentPane.add(password);
		
		JLabel lblNewLabel_1 = new JLabel("Haven't had an account yet ?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(165, 354, 165, 14);
		contentPane.add(lblNewLabel_1);
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
	public JLabel getWarningEmail() {
		return warningEmail;
	}
	public JLabel getWarningPassword() {
		return warningPassword;
	}
}

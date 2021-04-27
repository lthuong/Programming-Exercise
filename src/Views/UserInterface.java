package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class UserInterface extends JFrame {

	private JPanel contentPane;
	private static JLabel lblWelcome;

	/**
	 * Create the frame.
	 */
	public UserInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblWelcome = new JLabel("");
		lblWelcome.setBounds(109, 110, 227, 40);
		contentPane.add(lblWelcome);
	}
	
	public JLabel getWelcomeLabel() {
		return lblWelcome;
	}
}

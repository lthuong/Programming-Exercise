package Views;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * 
 * @author Thanh Tung Trinh
 *
 */
@SuppressWarnings("serial")
public class ReturnBookingBack extends BookingUI {
	/**
	 * Create the frame.
	 */
	public ReturnBookingBack() {
		super();
		JLabel lbl_titel = new JLabel("Return");
		lbl_titel.setForeground(new Color(255, 127, 80));
		lbl_titel.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_titel.setFont(new Font("Rockwell", Font.BOLD, 22));
		lbl_titel.setBounds(266, 11, 150, 24);
		getContentPane().add(lbl_titel);
	}
	
}

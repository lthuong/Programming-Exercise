package Views;


import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

/**
 * 
 * @author Thanh Tung Trinh
 *
 */

@SuppressWarnings("serial")
public class OneWayBooking extends BookingUI{

	public OneWayBooking() {
		super();
		JLabel lbl_titel = new JLabel("ONE WAY");
		lbl_titel.setForeground(new Color(255, 127, 80));
		lbl_titel.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_titel.setFont(new Font("Rockwell", Font.BOLD, 22));
		lbl_titel.setBounds(266, 11, 150, 24);
		getContentPane().add(lbl_titel);
	}
}


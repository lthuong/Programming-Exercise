package Views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

/**
 * 
 * @author Thanh Tung Trinh
 * @author Thien Huong Le
 *
 */

public class UserUI extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private JButton btnFind;
	private JScrollPane scrollPane;
	
	private DefaultTableModel tb1Model;
	private List<String[]> tableData = new ArrayList<String[]>();
	
	private JTextField textField_wallet;
	private Image walletLogo = new ImageIcon(this.getClass().getResource("/walletIcon.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("serial")
	public UserUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,200,951,582);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setForeground(Color.DARK_GRAY);
		scrollPane.setFont(new Font("Arial", Font.PLAIN, 11));
		scrollPane.setBounds(44, 125, 858, 375);
		
		table = new JTable();
		table.setForeground(Color.DARK_GRAY);
		table.setFont(new Font("Arial", Font.BOLD, 14));
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Seat_ID","Flight_ID","Seat Number","Day","Departure","Arrival"
				}
			) {
				@SuppressWarnings("rawtypes")
				Class[] columnTypes = new Class[] {
					Object.class,Object.class, Object.class, Object.class, Object.class,Object.class
				};
				@SuppressWarnings({ "unchecked", "rawtypes" })
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				@Override
			    public boolean isCellEditable(int row, int column) {
			       return false;
			    }
			});
		
	    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	    centerRenderer.setHorizontalAlignment( JLabel.CENTER );
	    JTableHeader header = table.getTableHeader();
	    header.setPreferredSize(new Dimension(100, 30));
	    header.setFont(new Font("Arial",Font.PLAIN, 15));
	    header.setBackground(Color.WHITE);
        header.setForeground(SystemColor.textHighlight);
        for(int i = 0; i < 6; ++i) {
        	table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
        }
        
	    table.setRowHeight(25);
	    scrollPane.setViewportView(table);
	    
		contentPane.add(scrollPane);
		
		btnFind = new JButton("Book Now");
		btnFind.setBorder(new LineBorder(Color.LIGHT_GRAY));
		btnFind.setBackground(Color.WHITE);
		btnFind.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFind.setBounds(755, 60, 131, 39);
		contentPane.add(btnFind);
		
		JLabel lblNewLabel = new JLabel("My Flights");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Segoe Script", Font.BOLD, 33));
		lblNewLabel.setBounds(44, 55, 221, 52);
		contentPane.add(lblNewLabel);
		tb1Model = (DefaultTableModel)table.getModel();
		
		textField_wallet = new JTextField();
		textField_wallet.setBorder(null);
		textField_wallet.setForeground(Color.BLACK);
		textField_wallet.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		textField_wallet.setEnabled(false);
		textField_wallet.setEditable(false);
		textField_wallet.setBounds(795, 22, 91, 20);
		textField_wallet.setBackground(SystemColor.inactiveCaptionBorder);
		textField_wallet.setOpaque(true);
		textField_wallet.setColumns(10);
		contentPane.add(textField_wallet);
		
		JLabel walletLabel = new JLabel("");
		walletLabel.setBounds(754, 11, 35, 35);
		walletLabel.setIcon(new ImageIcon(walletLogo));
		contentPane.add(walletLabel);
		tb1Model = (DefaultTableModel)table.getModel();

	}
	
	public JTextField getTextField_wallet() {
		return textField_wallet;
	}

	public void setTextField_wallet(JTextField textField_wallet) {
		this.textField_wallet = textField_wallet;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public void setTb1Model(DefaultTableModel tb1Model) {
		this.tb1Model = tb1Model;
	}

	public JButton getBtnFind() {
		return btnFind;
	}

	public void setBtnFind(JButton btnFind) {
		this.btnFind = btnFind;
	}

	public DefaultTableModel getTb1Model() {
		return tb1Model;
	}
	
	public List<String[]> getTableData() {
		return tableData;
	}

	public void setTableData(List<String[]> tableData) {
		this.tableData = tableData;
	}
}

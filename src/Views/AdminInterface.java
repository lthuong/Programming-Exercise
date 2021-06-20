package Views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import ConnectDB.AdminDAO;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.JViewport;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;

/**
 * 
 * @author Tuan Anh Nguyen
 * @author Thien Huong Le
 *
 */
@SuppressWarnings("serial")
public class AdminInterface extends JFrame {

	AdminDAO adminDAO = new AdminDAO();
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField textFieldAirline;
	private JTextField textFieldFlightLine;
	private JTextField textFieldFlightFreq;
	private JTextField textFieldStartDate;
	private JTextField textFieldEndDate;
	private JTextField textFieldDepTime;
	private JTextField textFieldArrTime;
	private JTextField textFieldBasicPrice;
	private JTextField textFieldPremiumPrice;
	private JButton btnConfirmRequest;
	private JButton btnDeleteRequest;
	private JLabel lblMessage;
	
	private DefaultTableModel tbModel;
	private List<String[]> requests = new ArrayList<>();
	private JButton btnLogout;
	
	public AdminInterface() {
		setResizable(false);
		setTitle("Admin Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(320, 180, 993, 640);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Flight Request");
		lblNewLabel.setForeground(new Color(255, 69, 0));
		lblNewLabel.setBounds(20, 23, 376, 56);
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 34));
		contentPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 90, 940, 291);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setForeground(Color.DARK_GRAY);
		table.setFont(new Font("Arial", Font.BOLD, 14));
		table.setBounds(6, 75, 898, 338);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Airline email","Depature", "Arrival","Dep-time", "Arr-time"
				}
			) {
				@SuppressWarnings("rawtypes")
				Class[] columnTypes = new Class[] {
					Object.class,Object.class, Object.class,Object.class, Object.class, Object.class, Object.class 
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
	    table.setRowHeight(20);
	    JTableHeader header = table.getTableHeader();
	    header.setPreferredSize(new Dimension(100, 30));
	    header.setFont(new Font("Arial", Font.PLAIN, 15));
	    header.setBackground(Color.WHITE);
        header.setForeground(new Color(65, 105, 225));
        for(int i = 0; i < 5; ++i) {
        	table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
        }

		
		JLabel lblAirline = new JLabel("Airline");
		lblAirline.setForeground(new Color(255, 69, 0));
		lblAirline.setFont(new Font("Arial", Font.BOLD, 12));
		lblAirline.setBounds(45, 405, 55, 16);
		contentPane.add(lblAirline);
		
		textFieldAirline = new JTextField();
		textFieldAirline.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldAirline.setBounds(140, 400, 177, 26);
		textFieldAirline.setEditable(false);
		lblAirline.setLabelFor(textFieldAirline);
		contentPane.add(textFieldAirline);
		textFieldAirline.setColumns(10);
		
		JLabel lblFlightLine = new JLabel("Flight line");
		lblFlightLine.setForeground(new Color(255, 69, 0));
		lblFlightLine.setFont(new Font("Arial", Font.BOLD, 12));
		lblFlightLine.setBounds(45, 445, 83, 16);
		contentPane.add(lblFlightLine);
		
		textFieldFlightLine = new JTextField();
		textFieldFlightLine.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldFlightLine.setBounds(140, 440, 177, 26);
		textFieldFlightLine.setEditable(false);
		lblFlightLine.setLabelFor(textFieldFlightLine);
		contentPane.add(textFieldFlightLine);
		textFieldFlightLine.setColumns(10);
		
		JLabel lblFlightFreq = new JLabel("Flight frequency");
		lblFlightFreq.setForeground(new Color(255, 99, 71));
		lblFlightFreq.setFont(new Font("Arial", Font.BOLD, 12));
		lblFlightFreq.setBounds(395, 560, 98, 16);
		contentPane.add(lblFlightFreq);
		
		textFieldFlightFreq = new JTextField();
		textFieldFlightFreq.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldFlightFreq.setBounds(527, 555, 44, 26);
		textFieldFlightFreq.setEditable(false);
		lblFlightFreq.setLabelFor(textFieldFlightFreq);
		contentPane.add(textFieldFlightFreq);
		textFieldFlightFreq.setColumns(10);
		
		JLabel lblStartDate = new JLabel("Start-date");
		lblStartDate.setForeground(new Color(255, 69, 0));
		lblStartDate.setFont(new Font("Arial", Font.BOLD, 12));
		lblStartDate.setBounds(660, 405, 83, 16);
		contentPane.add(lblStartDate);
		
		textFieldStartDate = new JTextField();
		textFieldStartDate.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldStartDate.setBounds(740, 400, 177, 26);
		textFieldStartDate.setEditable(false);
		lblStartDate.setLabelFor(textFieldStartDate);
		contentPane.add(textFieldStartDate);
		textFieldStartDate.setColumns(10);
		
		JLabel lblEndDate = new JLabel("End-date");
		lblEndDate.setForeground(new Color(255, 69, 0));
		lblEndDate.setFont(new Font("Arial", Font.BOLD, 12));
		lblEndDate.setBounds(660, 445, 83, 16);
		contentPane.add(lblEndDate);
		
		textFieldEndDate = new JTextField();
		textFieldEndDate.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldEndDate.setBounds(740, 440, 177, 26);
		textFieldEndDate.setEditable(false);
		lblEndDate.setLabelFor(textFieldEndDate);
		contentPane.add(textFieldEndDate);
		textFieldEndDate.setColumns(10);
		
		JLabel lblDepTime = new JLabel("Dep-time");
		lblDepTime.setForeground(new Color(255, 69, 0));
		lblDepTime.setFont(new Font("Arial", Font.BOLD, 12));
		lblDepTime.setBounds(660, 485, 61, 16);
		contentPane.add(lblDepTime);
		
		textFieldDepTime = new JTextField();
		textFieldDepTime.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldDepTime.setBounds(740, 480, 177, 26);
		textFieldDepTime.setEditable(false);
		lblDepTime.setLabelFor(textFieldDepTime);
		contentPane.add(textFieldDepTime);
		textFieldDepTime.setColumns(10);
		
		textFieldArrTime = new JTextField();
		textFieldArrTime.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldArrTime.setBounds(740, 520, 177, 26);
		textFieldArrTime.setEditable(false);
		contentPane.add(textFieldArrTime);
		textFieldArrTime.setColumns(10);
		
		JLabel lblArrTime = new JLabel("Arr-time");
		lblArrTime.setForeground(new Color(255, 69, 0));
		lblArrTime.setFont(new Font("Arial", Font.BOLD, 12));
		lblArrTime.setBounds(660, 525, 61, 16);
		lblArrTime.setLabelFor(textFieldArrTime);
		contentPane.add(lblArrTime);
		
		JLabel lblBasicPrice = new JLabel("Basic price");
		lblBasicPrice.setForeground(new Color(255, 69, 0));
		lblBasicPrice.setFont(new Font("Arial", Font.BOLD, 12));
		lblBasicPrice.setBounds(45, 485, 83, 16);
		contentPane.add(lblBasicPrice);
		
		JLabel lblPremiumPrice = new JLabel("Premium price");
		lblPremiumPrice.setForeground(new Color(255, 69, 0));
		lblPremiumPrice.setFont(new Font("Arial", Font.BOLD, 12));
		lblPremiumPrice.setBounds(45, 525, 88, 16);
		contentPane.add(lblPremiumPrice);
		
		textFieldBasicPrice = new JTextField();
		textFieldBasicPrice.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldBasicPrice.setBounds(140, 520, 177, 26);
		textFieldBasicPrice.setEditable(false);
		lblBasicPrice.setLabelFor(textFieldBasicPrice);
		contentPane.add(textFieldBasicPrice);
		textFieldBasicPrice.setColumns(10);
		
		textFieldPremiumPrice = new JTextField();
		textFieldPremiumPrice.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldPremiumPrice.setBounds(140, 480, 177, 26);
		textFieldPremiumPrice.setEditable(false);
		lblPremiumPrice.setLabelFor(textFieldPremiumPrice);
		contentPane.add(textFieldPremiumPrice);
		textFieldPremiumPrice.setColumns(10);
		
		JLabel lblEvery = new JLabel("Every");
		lblEvery.setFont(new Font("Arial", Font.PLAIN, 11));
		lblEvery.setBounds(493, 560, 44, 16);
		lblEvery.setLabelFor(textFieldFlightFreq);
		contentPane.add(lblEvery);
		
		JLabel lbldays = new JLabel("day(s)");
		lbldays.setFont(new Font("Arial", Font.PLAIN, 11));
		lbldays.setBounds(575, 560, 44, 16);
		lbldays.setLabelFor(textFieldFlightFreq);
		contentPane.add(lbldays);
		
		btnConfirmRequest = new JButton("CONFIRM ");
		btnConfirmRequest.setBackground(new Color(240, 248, 255));
		btnConfirmRequest.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnConfirmRequest.setBounds(648, 40, 98, 29);
		contentPane.add(btnConfirmRequest);
		
		btnLogout = new JButton("LOG OUT");
		btnLogout.setBackground(new Color(240, 248, 255));
		btnLogout.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnLogout.setBounds(862, 40, 98, 29);
		contentPane.add(btnLogout);
		
		btnDeleteRequest = new JButton("DELETE ");
		btnDeleteRequest.setBackground(new Color(240, 248, 255));
		btnDeleteRequest.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnDeleteRequest.setBounds(756, 40, 96, 29);
		contentPane.add(btnDeleteRequest);
		
		lblMessage = new JLabel("");
		lblMessage.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblMessage.setForeground(Color.RED);
		lblMessage.setBounds(287, 440, 177, 16);
		contentPane.add(lblMessage);
		
		DefaultTableModel tbModel = (DefaultTableModel)table.getModel();
		adminDAO.getRequestFromAirline(tbModel, requests);
	}
	public JTable getTable() {
		return table;
	}
	public JTextField getTextFieldAirline() {
		return textFieldAirline;
	};
	public JTextField getTextFieldFlightLine() {
		return textFieldFlightLine;
	};
	public JTextField getTextFieldFlightFreq() {
		return textFieldFlightFreq;
	};
	public JTextField getTextFieldStartDate() {
		return textFieldStartDate;
	};
	public JTextField getTextFieldEndDate() {
		return textFieldEndDate;
	};
	public JTextField getTextFieldDepTime() {
		return textFieldDepTime;
	};
	public JTextField getTextFieldArrTime() {
		return textFieldArrTime;
	};
	public JTextField getTextFieldBasicPrice() {
		return textFieldBasicPrice;
	};
	public JTextField getTextFieldPremiumPrice() {
		return textFieldPremiumPrice;
	};
	public JButton getBtnConfirmRequest() {
		return btnConfirmRequest;
	};
	public JButton getBtnDeleteRequest() {
		return btnDeleteRequest;
	};
	public JButton getBtnLogout() {
		return btnLogout;
	};
	public DefaultTableModel getTbModel() {
		return tbModel;
	};
	public List<String[]> getRequests() {
		return requests;
	}
	public JLabel getMessage() {
		return lblMessage;
	}
}

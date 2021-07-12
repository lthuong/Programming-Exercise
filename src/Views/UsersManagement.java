package Views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class UsersManagement extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel tbModel;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsersManagement frame = new UsersManagement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UsersManagement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setForeground(Color.DARK_GRAY);
		scrollPane.setFont(new Font("Arial", Font.PLAIN, 11));
		scrollPane.setBounds(0, 0, 717, 257);
		
		table = new JTable();
		table.setForeground(Color.DARK_GRAY);
		table.setFont(new Font("Arial", Font.BOLD, 14));
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"User ID","First Name","Last Name"
				}
			) {
				@SuppressWarnings("rawtypes")
				Class[] columnTypes = new Class[] {
					Object.class,Object.class, Object.class
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
		tbModel = (DefaultTableModel)table.getModel();
	    scrollPane.setViewportView(table);
		contentPane.add(scrollPane);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(628, 281, 89, 23);
		contentPane.add(btnBack);
	}
	public JButton getBtnBack() {
		return btnBack;
	}

	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}

	public void setTbModel(DefaultTableModel tbModel) {
		this.tbModel = tbModel;
	}
	public DefaultTableModel getTbModel() {
		return tbModel;
	};
	public JTable getTable() {
		return table;
	}
}

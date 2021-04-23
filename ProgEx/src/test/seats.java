package test;


import java.awt.EventQueue;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import ConnectDB.ConnectDB;

import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;


public class seats extends JFrame{
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					seats frame = new seats();
					ConnectDB.getInstance().init();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public seats() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPane;
		setBounds(100, 100, 396, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton show = new JButton("show");
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTable();
			}
		});
		show.setBounds(141, 15, 89, 23);
		contentPane.add(show);
		
		JLabel test_label = new JLabel("test");
		test_label.setBounds(39, 414, 254, 14);
		contentPane.add(test_label);
	}
	
	public void showTable()
	{  
		
        String column[]={"A","B","C","D"};    
        
        HashMap<String, Float> seats = new HashMap<String,Float>();
        seats = ConnectDB.getSeatsMap();
        
        JTable jt=new JTable(tableSizeRending(seats),column);    
		jt.setCellSelectionEnabled(true);  
		
		jt.addMouseListener(new java.awt.event.MouseAdapter() {  
		@Override
		 public void mouseClicked(java.awt.event.MouseEvent evt) {  
		   String Data = null;  
		   int[] row = jt.getSelectedRows();  
		   int[] columns = jt.getSelectedColumns();  
		   for (int i = 0; i < row.length; i++) {  
		     for (int j = 0; j < columns.length; j++) {  
		       Data = (String) jt.getValueAt(row[i], columns[j]);  
		     } }  
		   System.out.println("Table element selected is: " + Data);    
		 }       
		});  
		
		
		JScrollPane scrollPane = new JScrollPane(jt);
		scrollPane.setBounds(86, 49, 193, 262);
		getContentPane().add(scrollPane);
	}
	
	public String[][] tableSizeRending(HashMap<String,Float> seats)
	{
		int k=0;
		String[] data = seats.keySet().toArray(new String[0]);
		System.out.println(Arrays.toString(data));
		String[][] map = new String[5][4];
		for(int i=0;i<5;i++)
		{
			for(int j = 0;j<4;j++)
			{
				map[i][j] = data[k];
				k++;
			}
		}
		return map;
	}
}
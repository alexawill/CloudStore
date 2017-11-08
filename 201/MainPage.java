import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import javax.swing.JScrollPane;

import Temp.Test;

import java.awt.Color;
import java.io.RandomAccessFile;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class MainPage extends JFrame{

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	public JTextField textField_1;
	
	/**
	 * Launch the application.
	 */
	public static void mainPage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void close(){
		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
	    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
	
	
	
	

	/**
	 * Create the frame.
	 */
	public MainPage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 100, 892, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Search Bar");
		label.setFont(new Font("宋体", Font.BOLD, 15));
		label.setBounds(202, 17, 98, 18);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(314, 14, 180, 24);
		textField.setText(null);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblCloudStore = new JLabel("Cloud Store");
		lblCloudStore.setBounds(14, -4, 154, 50);
		lblCloudStore.setFont(new Font("MS UI Gothic", Font.BOLD, 26));
		panel.add(lblCloudStore);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setBackground(Color.LIGHT_GRAY);
		btnEnter.setFont(new Font("宋体", Font.BOLD, 15));
		btnEnter.setBounds(519, 13, 113, 27);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			       try{
	                         RandomAccessFile in = new RandomAccessFile("AppsData.txt","rw");
	                         long l = in.length();
	                         System.out.println(" length :" + l);
                             DefaultTableModel model = (DefaultTableModel) table.getModel();
                             System.out.println("Above if!");
				                if(textField.getText().equals("")){
				                	System.out.println("Reach if!");
                                    for(int i = 0; i < l ; i+=8){
                                    	System.out.println("Reach for!");
                                         model.addRow(new Object[]{in.readLine(),in.readLine(),in.readLine(),in.readLine()
                        		           ,in.readLine(),in.readLine(),in.readLine(),in.readLine()});
                                    }
                    
				                }
				                System.out.println("Out if!");
				   }catch(Exception e){}
				
			}
		});
		panel.add(btnEnter);
		
		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
				LoginPage lp = new LoginPage();
				lp.loginPage();
			}
		});
		btnLogOut.setBackground(Color.LIGHT_GRAY);
		btnLogOut.setFont(new Font("宋体", Font.BOLD, 15));
		btnLogOut.setBounds(723, 13, 113, 27);
		panel.add(btnLogOut);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 90, 812, 420);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		table.setFillsViewportHeight(true);
		table.setFont(new Font("宋体", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Name", "Developer", "Description", "Type", "Downloads", "Platform", "Version", "Price"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, false, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		table.getColumnModel().getColumn(2).setMinWidth(300);
		scrollPane.setViewportView(table);
		
		textField_1 = new JTextField();
		textField_1.setBounds(314, 51, 180, 24);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				String temp = textField_1.getText();
				AppPage ap = new AppPage(temp);
				ap.appPage();
				}catch(Exception e){}
				
			}
		});
		btnSearch.setBounds(519, 50, 113, 27);
		panel.add(btnSearch);
	}
}

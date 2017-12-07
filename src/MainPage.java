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

//import Temp.Test;



import java.awt.Color;
import java.io.File;
import java.io.RandomAccessFile;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.JComboBox;


public class MainPage extends JFrame{

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	public JTextField textField_1;
	private static User user;
	private  DefaultTableModel model;
	
	/**
	 * Launch the application.
	 */
	public static void mainPage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage(user);
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
	public MainPage(User user) {
		this.user = user;
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 15));
		comboBox.addItem(new String("All"));
		comboBox.addItem(new String("Name"));
		comboBox.addItem(new String("Developer"));
		comboBox.addItem(new String("Type"));
		comboBox.addItem(new String("Platform"));
		comboBox.addItem(new String("Version"));
		comboBox.addItem(new String("Price"));
		comboBox.setBounds(182, 14, 118, 24);
		panel.add(comboBox);
		
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
		btnEnter.setBackground(UIManager.getColor("Button.background"));
		btnEnter.setFont(new Font("ËÎÌו", Font.BOLD, 15));
		btnEnter.setBounds(519, 13, 113, 27);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RandomAccessFile read;
			       try{
			    	   String name,developer,description,type,download,platform,version,price;
			    	   //------------------------------------------------------------------------------------ALL
			    	   if(comboBox.getSelectedItem().equals(new String("All"))){
			    		   table.setModel(new DefaultTableModel(null,new String[]{"Name", "Developer", "Description", 
			    				   "Type", "Downloads", "Platform", "Version", "Price"}));
			    		   table.setAutoCreateRowSorter(true);
			    		   table.setEnabled(false);
			    		   model = (DefaultTableModel) table.getModel();
					     read = new RandomAccessFile(new File("AppData.txt"),"rw");
					     long l = read.length();
					     read.seek(0);
					     long record = l / 160;
					     for(int j = 0; j < record; j ++){
					    	 name = read.readUTF();
					    	 for(int i= 0;i< 20 - name.length(); i++){
					    		 read.readByte();
					    	 }
					    	 
					    	 developer = read.readUTF();
					    	 for(int i= 0;i< 20 - developer.length(); i++){
					    		 read.readByte();
					    	 }
					    	 
					    	 description = read.readUTF();
					    	 for(int i= 0;i< 20 - description.length(); i++){
					    		 read.readByte();
					    	 }
					    	 
					    	 type = read.readUTF();
					    	 for(int i= 0;i< 20 - type.length(); i++){
					    		 read.readByte();
					    	 }
					    	 
					    	 download = read.readUTF();
					    	 for(int i= 0;i< 20 - download.length(); i++){
					    		 read.readByte();
					    	 }
					    	 
					    	 platform = read.readUTF();
					    	 for(int i= 0;i< 20 - platform.length(); i++){
					    		 read.readByte();
					    	 }
					    	 
					    	 version = read.readUTF();
					    	 for(int i= 0;i< 20 - version.length(); i++){
					    		 read.readByte();
					    	 }
					    	 
					    	 price = read.readUTF();
					    	 for(int i= 0;i< 20 - price.length(); i++){
					    		 read.readByte();
					    	 }
					    	 model.addRow(new Object[]{name,developer,description,type,download,platform,version,
					    			 price});
					     }
					     read.close();
			       }
			    	   else if(comboBox.getSelectedItem().equals(new String("Name"))){
			    		   table.setModel(new DefaultTableModel(null,new String[]{"Name", "Developer", "Description", 
			    				   "Type", "Downloads", "Platform", "Version", "Price"}));
			    		   model = (DefaultTableModel) table.getModel();
			    		   String enter = textField.getText().toLowerCase();
			    		   System.out.println("Test");
						     read = new RandomAccessFile(new File("AppData.txt"),"rw");
						     long l = read.length();
						     read.seek(0);
						     long record = l / 160;
						     for(int j = 0; j < record; j ++){
						    	 if(enter.equals(new String(""))) break;
						    	 name = read.readUTF();
						    	 for(int i= 0;i< 20 - name.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 developer = read.readUTF();
						    	 for(int i= 0;i< 20 - developer.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 description = read.readUTF();
						    	 for(int i= 0;i< 20 - description.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 type = read.readUTF();
						    	 for(int i= 0;i< 20 - type.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 download = read.readUTF();
						    	 for(int i= 0;i< 20 - download.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 platform = read.readUTF();
						    	 for(int i= 0;i< 20 - platform.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 version = read.readUTF();
						    	 for(int i= 0;i< 20 - version.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 price = read.readUTF();
						    	 for(int i= 0;i< 20 - price.length(); i++){
						    		 read.readByte();
						    	 }
						    	 if(name.toLowerCase().contains(enter)){
						    	   model.addRow(new Object[]{name,developer,description,type,download,platform,version,
						    			 price});
						    	 }
						     }
						     read.close();
			    	   }
			    	   else if(comboBox.getSelectedItem().equals(new String("Developer"))){
			    		   table.setModel(new DefaultTableModel(null,new String[]{"Name", "Developer", "Description", 
			    				   "Type", "Downloads", "Platform", "Version", "Price"}));
			    		   model = (DefaultTableModel) table.getModel();
			    		   String enter = textField.getText().toLowerCase();
			    		   System.out.println("Test");
						     read = new RandomAccessFile(new File("AppData.txt"),"rw");
						     long l = read.length();
						     read.seek(0);
						     long record = l / 160;
						     for(int j = 0; j < record; j ++){
						    	 if(enter.equals(new String(""))) break;
						    	 name = read.readUTF();
						    	 for(int i= 0;i< 20 - name.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 developer = read.readUTF();
						    	 for(int i= 0;i< 20 - developer.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 description = read.readUTF();
						    	 for(int i= 0;i< 20 - description.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 type = read.readUTF();
						    	 for(int i= 0;i< 20 - type.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 download = read.readUTF();
						    	 for(int i= 0;i< 20 - download.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 platform = read.readUTF();
						    	 for(int i= 0;i< 20 - platform.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 version = read.readUTF();
						    	 for(int i= 0;i< 20 - version.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 price = read.readUTF();
						    	 for(int i= 0;i< 20 - price.length(); i++){
						    		 read.readByte();
						    	 }
						    	 if(developer.toLowerCase().contains(enter)){
						    	   model.addRow(new Object[]{name,developer,description,type,download,platform,version,
						    			 price});
						    	 }
						     }
						     read.close();
			    	   }
			    	   else if(comboBox.getSelectedItem().equals(new String("Type"))){
			    		   table.setModel(new DefaultTableModel(null,new String[]{"Name", "Developer", "Description", 
			    				   "Type", "Downloads", "Platform", "Version", "Price"}));
			    		   model = (DefaultTableModel) table.getModel();
			    		   String enter = textField.getText().toLowerCase();
			    		   System.out.println("Test");
						     read = new RandomAccessFile(new File("AppData.txt"),"rw");
						     long l = read.length();
						     read.seek(0);
						     long record = l / 160;
						     for(int j = 0; j < record; j ++){
						    	 if(enter.equals(new String(""))) break;
						    	 name = read.readUTF();
						    	 for(int i= 0;i< 20 - name.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 developer = read.readUTF();
						    	 for(int i= 0;i< 20 - developer.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 description = read.readUTF();
						    	 for(int i= 0;i< 20 - description.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 type = read.readUTF();
						    	 for(int i= 0;i< 20 - type.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 download = read.readUTF();
						    	 for(int i= 0;i< 20 - download.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 platform = read.readUTF();
						    	 for(int i= 0;i< 20 - platform.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 version = read.readUTF();
						    	 for(int i= 0;i< 20 - version.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 price = read.readUTF();
						    	 for(int i= 0;i< 20 - price.length(); i++){
						    		 read.readByte();
						    	 }
						    	 if(type.toLowerCase().contains(enter)){
						    	   model.addRow(new Object[]{name,developer,description,type,download,platform,version,
						    			 price});
						    	 }
						     }
						     read.close();
			    	   }
			    	   else if(comboBox.getSelectedItem().equals(new String("Platform"))){
			    		   table.setModel(new DefaultTableModel(null,new String[]{"Name", "Developer", "Description", 
			    				   "Type", "Downloads", "Platform", "Version", "Price"}));
			    		   model = (DefaultTableModel) table.getModel();
			    		   String enter = textField.getText().toLowerCase();
			    		   System.out.println("Test");
						     read = new RandomAccessFile(new File("AppData.txt"),"rw");
						     long l = read.length();
						     read.seek(0);
						     long record = l / 160;
						     for(int j = 0; j < record; j ++){
						    	 if(enter.equals(new String(""))) break;
						    	 name = read.readUTF();
						    	 for(int i= 0;i< 20 - name.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 developer = read.readUTF();
						    	 for(int i= 0;i< 20 - developer.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 description = read.readUTF();
						    	 for(int i= 0;i< 20 - description.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 type = read.readUTF();
						    	 for(int i= 0;i< 20 - type.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 download = read.readUTF();
						    	 for(int i= 0;i< 20 - download.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 platform = read.readUTF();
						    	 for(int i= 0;i< 20 - platform.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 version = read.readUTF();
						    	 for(int i= 0;i< 20 - version.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 price = read.readUTF();
						    	 for(int i= 0;i< 20 - price.length(); i++){
						    		 read.readByte();
						    	 }
						    	 if(platform.toLowerCase().contains(enter)){
						    	   model.addRow(new Object[]{name,developer,description,type,download,platform,version,
						    			 price});
						    	 }
						     }
						     read.close();
			    	   }
			    	   else if(comboBox.getSelectedItem().equals(new String("Version"))){
			    		   table.setModel(new DefaultTableModel(null,new String[]{"Name", "Developer", "Description", 
			    				   "Type", "Downloads", "Platform", "Version", "Price"}));
			    		   model = (DefaultTableModel) table.getModel();
			    		   String enter = textField.getText().toLowerCase();
			    		   System.out.println("Test");
						     read = new RandomAccessFile(new File("AppData.txt"),"rw");
						     long l = read.length();
						     read.seek(0);
						     long record = l / 160;
						     for(int j = 0; j < record; j ++){
						    	 if(enter.equals(new String(""))) break;
						    	 name = read.readUTF();
						    	 for(int i= 0;i< 20 - name.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 developer = read.readUTF();
						    	 for(int i= 0;i< 20 - developer.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 description = read.readUTF();
						    	 for(int i= 0;i< 20 - description.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 type = read.readUTF();
						    	 for(int i= 0;i< 20 - type.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 download = read.readUTF();
						    	 for(int i= 0;i< 20 - download.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 platform = read.readUTF();
						    	 for(int i= 0;i< 20 - platform.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 version = read.readUTF();
						    	 for(int i= 0;i< 20 - version.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 price = read.readUTF();
						    	 for(int i= 0;i< 20 - price.length(); i++){
						    		 read.readByte();
						    	 }
						    	 if(version.toLowerCase().contains(enter)){
						    	   model.addRow(new Object[]{name,developer,description,type,download,platform,version,
						    			 price});
						    	 }
						     }
						     read.close();
			    	   }
			    	   else if(comboBox.getSelectedItem().equals(new String("Pirce"))){
			    		   table.setModel(new DefaultTableModel(null,new String[]{"Name", "Developer", "Description", 
			    				   "Type", "Downloads", "Platform", "Version", "Price"}));
			    		   model = (DefaultTableModel) table.getModel();
			    		   String enter = textField.getText().toLowerCase();
			    		   System.out.println("Test");
						     read = new RandomAccessFile(new File("AppData.txt"),"rw");
						     long l = read.length();
						     read.seek(0);
						     long record = l / 160;
						     for(int j = 0; j < record; j ++){
						    	 if(enter.equals(new String(""))) break;
						    	 name = read.readUTF();
						    	 for(int i= 0;i< 20 - name.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 developer = read.readUTF();
						    	 for(int i= 0;i< 20 - developer.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 description = read.readUTF();
						    	 for(int i= 0;i< 20 - description.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 type = read.readUTF();
						    	 for(int i= 0;i< 20 - type.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 download = read.readUTF();
						    	 for(int i= 0;i< 20 - download.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 platform = read.readUTF();
						    	 for(int i= 0;i< 20 - platform.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 version = read.readUTF();
						    	 for(int i= 0;i< 20 - version.length(); i++){
						    		 read.readByte();
						    	 }
						    	 
						    	 price = read.readUTF();
						    	 for(int i= 0;i< 20 - price.length(); i++){
						    		 read.readByte();
						    	 }
						    	 if(price.toLowerCase().contains(enter)){
						    	   model.addRow(new Object[]{name,developer,description,type,download,platform,version,
						    			 price});
						    	 }
						     }
						     read.close();
			    	   }
			    	 			    	   			    	   
				   }catch(Exception e){
					   System.out.println(e.getMessage());
					   }
			      
				
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
		btnLogOut.setBackground(UIManager.getColor("Button.background"));
		btnLogOut.setFont(new Font("ËÎÌו", Font.BOLD, 15));
		btnLogOut.setBounds(707, 13, 129, 27);
		panel.add(btnLogOut);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 90, 812, 420);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		table.setFillsViewportHeight(true);
		table.setFont(new Font("ËÎÌו", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
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
		table.setAutoCreateRowSorter(true);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		table.getColumnModel().getColumn(2).setMinWidth(300);
		scrollPane.setViewportView(table);
		
		textField_1 = new JTextField();
		textField_1.setBounds(314, 51, 180, 24);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				String temp = textField_1.getText();
				AppPage ap = new AppPage(temp,user);
				ap.appPage();
				}catch(Exception e){}
				
			}
		});
		btnSearch.setBounds(519, 50, 113, 27);
		panel.add(btnSearch);
		
		JButton btnNewRequest = new JButton("New Request");
		btnNewRequest.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RequestPage rp = new RequestPage();
				rp.requestPage();
			}
		});
		btnNewRequest.setBounds(707, 53, 129, 27);
		panel.add(btnNewRequest);
		
		JButton btnCompare = new JButton("Compare");
		btnCompare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				    ComparePage cp = new ComparePage();
				    cp.launchPage();
				}catch(Exception e){}
			}
		});
		btnCompare.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnCompare.setBounds(24, 50, 113, 27);
		panel.add(btnCompare);
		
		
	}
}
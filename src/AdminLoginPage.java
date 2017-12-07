import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.RandomAccessFile;
import javax.swing.JPasswordField;


public class AdminLoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField adminname;
	private static User admin;
	private JPasswordField ps;

	/**
	 * Launch the application.
	 */
	public static void adminLoginPage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLoginPage frame = new AdminLoginPage();
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
	public AdminLoginPage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 575, 489);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdministatorName = new JLabel("Administrator");
		lblAdministatorName.setBounds(58, 144, 104, 18);
		contentPane.add(lblAdministatorName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(58, 200, 72, 18);
		contentPane.add(lblPassword);
		
		adminname = new JTextField();
		adminname.setBounds(251, 141, 231, 24);
		contentPane.add(adminname);
		adminname.setColumns(10);
		
		JButton btnLogIn = new JButton("LOG IN");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					   String name, password;
					   boolean check = false;
					   RandomAccessFile file = new RandomAccessFile("AdminData.txt","rw");
					   long l = file.length();
					   file.seek(0);
					   long record = l / 40;
					
					   for(int j = 0; j < record; j++){
					    	 name = file.readUTF();
					    	 for(int i = 0; i< 20 - name.length(); i++){
					    		 file.readByte();
					    	 }
					    	 password = file.readUTF();
					    	 for(int i = 0; i< 20 - password.length(); i++){
					    		 file.readByte();
					    	 }
					    	 
					    	 if(adminname.getText().equals(name) && ps.getText().equals(password)){
					    		 check = true;
					    	 }
					    	 if(check == true){
					    		 System.out.println(check);
					    		 admin = new Admin();
					    		 admin.setUserName(name);
					    		 admin.setPassword(password);
					    		 record = 0;
					    		 close();
                                 AdminPage ap = new AdminPage(admin);
                                 ap.adminPage();
					    	 }
					   }
					   if(check == false){
						   LoginWrong lw = new LoginWrong();
						   lw.loginWrong();
					   }
					   file.close();
					}catch(Exception e){}
			}
		});
		btnLogIn.setBounds(215, 266, 113, 27);
		contentPane.add(btnLogIn);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				LoginPage lp = new LoginPage();
				lp.loginPage();
			}
		});
		btnBack.setBounds(430, 402, 113, 27);
		contentPane.add(btnBack);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("Times New Roman", Font.BOLD, 80));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(118, 29, 332, 58);
		contentPane.add(lblWelcome);
		
		ps = new JPasswordField();
		ps.setBounds(251, 197, 231, 24);
		contentPane.add(ps);
	}
}

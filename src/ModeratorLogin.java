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


public class ModeratorLogin extends JFrame {

	private JPanel contentPane;
	private JTextField mod;
	private static User moderator;
	private JPasswordField ps;

	/**
	 * Launch the application.
	 */
	public static void moderatorLogin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModeratorLogin frame = new ModeratorLogin();
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
	public ModeratorLogin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 575, 489);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdministatorName = new JLabel("Moderator");
		lblAdministatorName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAdministatorName.setBounds(58, 144, 104, 18);
		contentPane.add(lblAdministatorName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPassword.setBounds(58, 200, 72, 18);
		contentPane.add(lblPassword);
		
		mod = new JTextField();
		mod.setBounds(251, 141, 231, 24);
		contentPane.add(mod);
		mod.setColumns(10);
		
		JButton btnLogIn = new JButton("LOG IN");
		btnLogIn.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					   String name, password;
					   boolean check = false;
					   RandomAccessFile file = new RandomAccessFile("ModeratorData.txt","rw");
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
					    	 
					    	 if(mod.getText().equals(name) && ps.getText().equals(password)){
					    		 check = true;
					    	 }
					    	 if(check == true){
					    		 System.out.println(check);
					    		 moderator = new Moderator();
					    		 moderator.setUserName(name);
					    		 moderator.setPassword(password);
					    		 record = 0;
					    		 close();
					    		 ModeratorPage mp = new ModeratorPage(moderator);
					    		 mp.moderatorPage();
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
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
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

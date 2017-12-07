import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.RandomAccessFile;

import javax.swing.UIManager;
import javax.swing.JPasswordField;


public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private User user;
	private JPasswordField ps;

	/**
	 * Launch the application.
	 */
	public static void loginPage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 575, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 557, 466);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblLogIn = new JLabel("LOG IN");
		lblLogIn.setBounds(161, 48, 229, 42);
		lblLogIn.setFont(new Font("Times New Roman", Font.BOLD, 60));
		lblLogIn.setForeground(Color.WHITE);
		panel.add(lblLogIn);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblUserName.setBounds(92, 143, 127, 18);
		panel.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblPassword.setBounds(92, 193, 127, 18);
		panel.add(lblPassword);
		
		userName = new JTextField();
		userName.setBounds(272, 144, 182, 24);
		panel.add(userName);
		userName.setColumns(10);
		
		ps = new JPasswordField();
		ps.setBounds(272, 194, 182, 24);
		panel.add(ps);
		
		JButton btnLogIn = new JButton("LOG IN");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
				String name, password;
				   boolean check = false;
				   RandomAccessFile file = new RandomAccessFile(new File("UserData.txt"),"rw");
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
				    	 
				    	 if(userName.getText().equals(name) && ps.getText().equals(password)){
				    		 check = true;
				    	 }
				    	 if(check == true){
				    		 user = new User();
				    		 user.setUserName(name);
				    		 user.setPassword(password);
				    		 record = 0;
				    		 close();
				    		 MainPage nw = new MainPage(user);
							nw.mainPage();
				    	 }
				   }
				   if(check == false){
					   LoginWrong lw = new LoginWrong();
					   lw.loginWrong();
				   }
				   file.close();
				}catch(Exception e){}
				
//				user = new User();
//				try{
//					
//				RandomAccessFile in = new RandomAccessFile("UserData.txt","rw");
//					long length = in.length();
//					for(int i = 0; i < length ; i++){
//						if(in.readLine().equals(textField.getText())){
//							if(in.readLine().equals(ps.getText())){
//								break;
//							}
//						}
//					}
//					in.close();
//					close();
//					user.setUserName(textField.getText());
//					user.setPassword(ps.getText());
//					MainPage nw = new MainPage(user);
//					nw.mainPage();
//					
//				}
//				catch(Exception p) {}
//				
//				
//			}
			}});
		btnLogIn.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnLogIn.setBackground(UIManager.getColor("Button.background"));
		btnLogIn.setBounds(148, 266, 113, 27);
		panel.add(btnLogIn);
		
		JButton btnCreateAccoute = new JButton("SIGN UP");
		btnCreateAccoute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				close();
				CreatePage cp = new CreatePage();
				cp.createPage();
				
				
			}
		});
		btnCreateAccoute.setBackground(UIManager.getColor("Button.background"));
		btnCreateAccoute.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnCreateAccoute.setBounds(277, 266, 113, 27);
		panel.add(btnCreateAccoute);
		
		JLabel lblNewLabel_1 = new JLabel("Cloud");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblNewLabel_1.setBounds(14, 333, 173, 48);
		panel.add(lblNewLabel_1);
		
		JLabel lblStore = new JLabel("Store");
		lblStore.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblStore.setBounds(78, 383, 127, 42);
		panel.add(lblStore);
		
		JButton btnAdministor = new JButton("Administrator");
		btnAdministor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
                close();
				AdminLoginPage ap = new AdminLoginPage();
				ap.adminLoginPage();
				
			}
		});
		btnAdministor.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAdministor.setBounds(416, 426, 127, 27);
		panel.add(btnAdministor);
		
		JButton btnNewButton = new JButton("Moderator");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
				ModeratorLogin ml = new ModeratorLogin();
				ml.moderatorLogin();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(416, 383, 127, 27);
		panel.add(btnNewButton);
		
		
		
		
		
//		JLabel lblNewLabel = new JLabel("");
//		Image img = new ImageIcon(this.getClass().getResource("/cloud.jpg")).getImage();
//		lblNewLabel.setIcon(new ImageIcon(img));
//		lblNewLabel.setBounds(0, 0, 557, 466);
//		panel.add(lblNewLabel);
		
		
		
		
	}
}

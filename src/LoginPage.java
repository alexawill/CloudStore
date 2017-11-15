import java.awt.EventQueue;
import java.awt.Toolkit;

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
import java.util.Scanner;


public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField userNameField;
	private JTextField passwordField;

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
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 557, 466);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblLogIn = new JLabel("LOG IN");
		lblLogIn.setBounds(292, 119, 182, 42);
		lblLogIn.setFont(new Font("��������", Font.BOLD, 40));
		lblLogIn.setForeground(Color.BLUE);
		panel.add(lblLogIn);
		
		JLabel infoLogin = new JLabel("");
		infoLogin.setBounds(260, 173, 230, 16);
		panel.add(infoLogin);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("����", Font.BOLD, 15));
		lblUserName.setBounds(260, 204, 87, 18);
		panel.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("����", Font.BOLD, 15));
		lblPassword.setBounds(260, 253, 87, 18);
		panel.add(lblPassword);
		
		userNameField = new JTextField();
		userNameField.setBounds(361, 201, 182, 24);
		panel.add(userNameField);
		userNameField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setBounds(361, 253, 182, 24);
		panel.add(passwordField);
		passwordField.setColumns(10);
		
		JButton btnLogIn = new JButton("LOG IN");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					
				Scanner in = new Scanner(new File("UserData.txt"));
					User user = new User();
					while(in.hasNextLine()){
						String username = in.nextLine();
						String password = in.nextLine();
						String role = in.nextLine();
						if(username.equals(userNameField.getText()) && 
								password.equals(passwordField.getText())){
							if (role.equals("admin")){
								user = new Admin(username, password);
							}
							else if (role.equals("admin")){
								user = new Moderator(username, password);
							}
							else{
								user = new User(username, password);
							}
							MainPage.mainPage(user);
						}
					}
					in.close();
					
					
				}
				catch(Exception p) {
					infoLogin.setText("Wrong username/password");
					infoLogin.setForeground(Color.RED);
				}
				
				
			}
		});
		btnLogIn.setFont(new Font("����", Font.BOLD, 15));
		btnLogIn.setBackground(Color.LIGHT_GRAY);
		btnLogIn.setBounds(361, 308, 113, 27);
		panel.add(btnLogIn);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				close();
				CreatePage cp = new CreatePage();
				cp.createPage();
				
				
			}
		});
		btnCreateAccount.setBackground(Color.LIGHT_GRAY);
		btnCreateAccount.setFont(new Font("����", Font.BOLD, 15));
		btnCreateAccount.setBounds(376, 426, 167, 27);
		panel.add(btnCreateAccount);
		
	}
}

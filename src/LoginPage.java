import java.awt.BorderLayout;
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
import java.io.RandomAccessFile;


public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
		lblLogIn.setBounds(331, 113, 127, 42);
		lblLogIn.setFont(new Font("华文琥珀", Font.BOLD, 40));
		lblLogIn.setForeground(Color.BLUE);
		panel.add(lblLogIn);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("宋体", Font.BOLD, 15));
		lblUserName.setBounds(260, 204, 87, 18);
		panel.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("宋体", Font.BOLD, 15));
		lblPassword.setBounds(260, 253, 87, 18);
		panel.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(361, 201, 182, 24);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(361, 253, 182, 24);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnLogIn = new JButton("LOG IN");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				User user = new User();
				try{
					
				RandomAccessFile in = new RandomAccessFile("UserData.txt","rw");
					long length = in.length();
					for(int i = 0; i < length ; i++){
						if(in.readLine().equals(textField.getText())){
							if(in.readLine().equals(textField_1.getText())){
								break;
							}
						}
					}
					close();
					MainPage nw = new MainPage();
					nw.mainPage();
					
				}
				catch(Exception p) {}
				
				
			}
		});
		btnLogIn.setFont(new Font("宋体", Font.BOLD, 15));
		btnLogIn.setBackground(Color.LIGHT_GRAY);
		btnLogIn.setBounds(361, 308, 113, 27);
		panel.add(btnLogIn);
		
		JButton btnCreateAccoute = new JButton("Create Accoute");
		btnCreateAccoute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				close();
				CreatePage cp = new CreatePage();
				cp.createPage();
				
				
			}
		});
		btnCreateAccoute.setBackground(Color.LIGHT_GRAY);
		btnCreateAccoute.setFont(new Font("宋体", Font.BOLD, 15));
		btnCreateAccoute.setBounds(376, 426, 167, 27);
		panel.add(btnCreateAccoute);
	}
}

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.SwingConstants;


public class LoginPanel {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private RandomAccessFile in;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPanel window = new LoginPanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 592, 453);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.BLACK);
		panel.setBounds(0, 0, 574, 406);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnLogIn = new JButton("LOG IN");
		btnLogIn.setBackground(Color.LIGHT_GRAY);
		btnLogIn.setForeground(Color.BLACK);
		btnLogIn.setFont(new Font("宋体", Font.BOLD, 15));
		btnLogIn.setBounds(362, 276, 113, 27);
		panel.add(btnLogIn);
		
		JButton btnCreateAccout = new JButton("Create Accout");
		btnCreateAccout.setBackground(Color.LIGHT_GRAY);
		btnCreateAccout.setFont(new Font("宋体", Font.BOLD, 15));
		btnCreateAccout.setBounds(404, 366, 156, 27);
		panel.add(btnCreateAccout);
		
		textField_1 = new JTextField();
		textField_1.setBounds(328, 211, 187, 24);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(328, 156, 187, 24);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblUserName = new JLabel("User name");
		lblUserName.setFont(new Font("宋体", Font.BOLD, 15));
		lblUserName.setBounds(222, 159, 92, 18);
		panel.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("宋体", Font.BOLD, 15));
		lblPassword.setBounds(222, 214, 72, 18);
		panel.add(lblPassword);
		
		JLabel lblLogInPage = new JLabel("LOG IN ");
		lblLogInPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogInPage.setForeground(Color.BLUE);
		lblLogInPage.setBounds(335, 74, 158, 51);
		panel.add(lblLogInPage);
		lblLogInPage.setFont(new Font("华文琥珀", Font.BOLD, 40));
		btnCreateAccout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
				User user = new User();
				try{
					in = new RandomAccessFile("UserData.txt","rw");
					long length = in.length();
					for(int i = 0; i < length ; i++){
						if(in.readLine().equals(textField.getText())){
							if(in.readLine().equals(textField_1.getText())){
								break;
							}
						}
					}
					MainPage nw = new MainPage();
					nw.NewScreen();
					
				}
				catch(Exception p) {}
				
				
			
				
				
				
			}
		});
	}
}

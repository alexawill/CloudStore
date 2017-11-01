import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class LoginPanel {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUserName = new JLabel("User name");
		lblUserName.setBounds(34, 80, 72, 18);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(34, 117, 72, 18);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(120, 77, 187, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(120, 114, 187, 24);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnLogIn = new JButton("LOG IN");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
//				User user = new User();
//				ArrayList<String> n = user.getName();
//				ArrayList<String> p = user.getName();
//			 if(n.contains(textField)){
//				 int location = n.indexOf(textField);
//				if(textField_1.equals(p.get(location))){
//					Test nw = new Test();
//					nw.NewScreen();
//				}
//			 }
				
				Test nw = new Test();
				nw.NewScreen();
				
				
			}
		});
		btnLogIn.setBounds(155, 162, 113, 27);
		frame.getContentPane().add(btnLogIn);
		
		JButton btnCreateAccout = new JButton("Create Accout");
		btnCreateAccout.setBounds(281, 213, 137, 27);
		frame.getContentPane().add(btnCreateAccout);
		
		JLabel lblLogInPage = new JLabel("LOG IN ");
		lblLogInPage.setFont(new Font("ËÎÌו", Font.BOLD, 34));
		lblLogInPage.setBounds(137, 13, 137, 51);
		frame.getContentPane().add(lblLogInPage);
	}
}

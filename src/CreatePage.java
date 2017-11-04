import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import java.io.RandomAccessFile;


public class CreatePage extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreatePage frame = new CreatePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CreatePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 433, 367);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewUserName = new JLabel("New User Name");
		lblNewUserName.setFont(new Font("宋体", Font.BOLD, 15));
		lblNewUserName.setBounds(43, 107, 117, 18);
		panel.add(lblNewUserName);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("宋体", Font.BOLD, 15));
		lblNewPassword.setBounds(43, 160, 117, 18);
		panel.add(lblNewPassword);
		
		textField = new JTextField();
		textField.setText(null);
		textField.setBounds(196, 104, 157, 24);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText(null);
		textField_1.setBounds(196, 157, 157, 24);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblSignUp = new JLabel("SIGN UP");
		lblSignUp.setForeground(Color.BLUE);
		lblSignUp.setBackground(Color.BLUE);
		lblSignUp.setFont(new Font("华文琥珀", Font.BOLD, 40));
		lblSignUp.setBounds(135, 13, 157, 71);
		panel.add(lblSignUp);
		
		JButton btnOk = new JButton("Create");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JLabel lblUserNameAlready = new JLabel("user name already taken");
				lblUserNameAlready.setFont(new Font("宋体", Font.BOLD, 15));
				lblUserNameAlready.setForeground(Color.RED);
				lblUserNameAlready.setBounds(196, 126, 207, 18);
				
				System.out.println("Check1");
				try{
					System.out.println("Check2");
					RandomAccessFile out = new RandomAccessFile("UserData.txt","rw");
					RandomAccessFile in = new RandomAccessFile("UserData.txt","rw");
					long length = out.length();
					int check = 0;
					int check2 = 0;
					for(int i = 0; i < length; i++){
						String temp = in.readLine();
						System.out.println("Check3 + length : " + length);
						if(temp.equals(textField.getText())){
//							check = 1;
							panel.add(lblUserNameAlready);
							System.out.println("Check4");
							break;
						}
						in.readLine();
					}
					System.out.println("Check" + check);
					if(check == 0 && textField.getText() != (null)&& textField_1.getText() != (null)){
					    User nuser = new User();
					    nuser.setUserName(textField.getText());
					    nuser.setPassword(textField_1.getText());
					}
					if(length == 0) check = 2;
//					if(check == 1){
//						panel.add(lblUserNameAlready);
//					}
					else if(check == 0){
						lblUserNameAlready = new JLabel("");
						panel.add(lblUserNameAlready);
						CreateDone c = new CreateDone();
						c.createDone();
					}
					
					
					
				}catch(Exception p){}
				
				
			}
		});
		btnOk.setForeground(Color.BLACK);
		btnOk.setBackground(Color.LIGHT_GRAY);
		btnOk.setFont(new Font("宋体", Font.BOLD, 15));
		btnOk.setBounds(153, 233, 113, 27);
		panel.add(btnOk);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("宋体", Font.BOLD, 15));
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.setBounds(306, 327, 113, 27);
		panel.add(btnBack);
		
		
	}
}

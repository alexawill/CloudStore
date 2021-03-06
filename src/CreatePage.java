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
import java.io.File;
import java.io.RandomAccessFile;
import javax.swing.JPasswordField;


public class CreatePage extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField userName;
	private JPasswordField ps;

	/**
	 * Launch the application.
	 */
	public static void createPage() {
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
	
	public void close(){
		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
	    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
	

	/**
	 * Create the frame.
	 */
	public CreatePage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		userName = new JTextField();
		userName.setText(null);
		userName.setBounds(196, 104, 157, 24);
		panel.add(userName);
		userName.setColumns(10);
		
		JLabel lblSignUp = new JLabel("SIGN UP");
		lblSignUp.setForeground(Color.BLUE);
		lblSignUp.setBackground(Color.BLUE);
		lblSignUp.setFont(new Font("华文琥珀", Font.BOLD, 40));
		lblSignUp.setBounds(135, 13, 157, 71);
		panel.add(lblSignUp);
		
		JButton btnOk = new JButton("Create");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
				
					String name , password;
					boolean check = true;
				     RandomAccessFile file = new RandomAccessFile(new File("UserData.txt"),"rw");
				     RandomAccessFile read = new RandomAccessFile(new File("UserData.txt"),"rw");
				     long l = read.length();
				     read.seek(0);
				     long record = l / 40;				 
				     if(userName.getText().length() == 0){
			    		 check = false;
			    	 }
				     for(int i = 0; i < record; i++){								    	
				    	 name = read.readUTF();				    	
				    	 for(int j = 0; j < 20 - name.length(); j++){
				    		read.readByte();
				    	 }
				    	 password = read.readUTF();				    	
				    	 for(int j = 0; j < 20 - password.length(); j++){
				    		 read.readByte();
				    	 }				    					    	
				    	 if(userName.getText().equals(name)){				    	
				    		 check = false;
				    		 LoginWrong1 lw = new LoginWrong1();
				    		 lw.loginWrong1();
				    	 }			    	 
				     }
				     read.close();
				     if(check == true){
				    	 long l1 = file.length();
				    	 file.seek(l1);
				    	 User nuser = new User();
						    nuser.setUserName(userName.getText());
						    nuser.setPassword(ps.getText());
				        file.writeUTF(userName.getText());
				        for(int i = 0; i < 20 - userName.getText().length(); i++){
				    	    file.writeByte(20);
				        }
				        file.writeUTF(ps.getText());
				        for(int i = 0; i < 20 - ps.getText().length(); i++){
				    	    file.writeByte(20);
				        }
				        file.close();
				        close();
				        CreateDone c = new CreateDone();
						c.createDone();
				    }			   		     
				}catch(Exception p){}
				

//				try{
//
//					RandomAccessFile out = new RandomAccessFile("UserData.txt","rw");
//					RandomAccessFile in = new RandomAccessFile("UserData.txt","rw");
//					long length = out.length();
//					int check = 0;
//					int check2 = 0;
//					for(int i = 0; i < length; i++){
//						String temp = in.readLine();
//						if(temp == null)	break;
//						if(temp.equals(userName.getText())){
//							check = 1;
//							break;
//						}
//						in.readLine();
//					}
//					in.close();
//					
//					String x = userName.getText() , y = ps.getText();
//					
//					if(!x.equals("") && !y.equals("")  && check == 0){
//					    User nuser = new User();
//					    nuser.setUserName(userName.getText());
//					    nuser.setPassword(ps.getText());
//					}
//					if(userName.getText().equals("") || ps.getText().equals("") || length == 0) {
//						check2 = 2;
//					}
//					
//					if(check == 0 && check2 == 0){
//						CreateDone c = new CreateDone();
//						c.createDone();
//					}
//					
//					
//					
//				}catch(Exception p){}
				
				
			}
		});
		btnOk.setForeground(Color.BLACK);
		btnOk.setBackground(Color.LIGHT_GRAY);
		btnOk.setFont(new Font("宋体", Font.BOLD, 15));
		btnOk.setBounds(153, 233, 113, 27);
		panel.add(btnOk);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
				LoginPage lp = new LoginPage();
				lp.loginPage();
			}
		});
		btnBack.setFont(new Font("宋体", Font.BOLD, 15));
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.setBounds(306, 327, 113, 27);
		panel.add(btnBack);
		
		ps = new JPasswordField();
		ps.setBounds(196, 157, 157, 24);
		panel.add(ps);
		
		
	}
}

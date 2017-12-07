import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;


public class AdminPage extends JFrame {

	private JPanel contentPane;
	private static User admin;

	/**
	 * Launch the application.
	 */
	public static void adminPage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage frame = new AdminPage(admin);
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
	public AdminPage(User admin) {
		this.admin = admin;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 646, 418);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome Administrator, ");
		lblWelcome.setBounds(14, 13, 193, 18);
		contentPane.add(lblWelcome);
		
		JLabel lblNewLabel = new JLabel(admin.getUserName());
		lblNewLabel.setBounds(202, 13, 72, 18);
		contentPane.add(lblNewLabel);
		
		JButton btnViewStore = new JButton("View Store");
		btnViewStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainPage mp = new MainPage(admin);
				mp.mainPage();
			}
		});
		btnViewStore.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnViewStore.setBounds(376, 100, 183, 27);
		contentPane.add(btnViewStore);
		
		JButton btnManageNewRequest = new JButton("Manage New Request");
		btnManageNewRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RequestList rl = new RequestList();
				rl.requestList();
			}
		});
		btnManageNewRequest.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnManageNewRequest.setBounds(376, 138, 183, 27);
		contentPane.add(btnManageNewRequest);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnChangePassword.setBounds(376, 218, 183, 27);
		contentPane.add(btnChangePassword);
		
		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				LoginPage lp = new LoginPage();
				lp.loginPage();
			}
		});
		btnLogOut.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnLogOut.setBounds(501, 9, 113, 27);
		contentPane.add(btnLogOut);
		
		JButton btnNewButton = new JButton("Manage Comment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					CommentManage cm = new CommentManage();
					cm.commentManage();
				}catch(Exception e){}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(376, 178, 183, 27);
		contentPane.add(btnNewButton);
	}
}

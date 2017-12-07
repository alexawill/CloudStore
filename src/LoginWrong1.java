import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JTextArea;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;


public class LoginWrong1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void loginWrong1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWrong1 frame = new LoginWrong1();
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
	public LoginWrong1() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 323, 213);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrUsernameExist = new JTextArea();
		txtrUsernameExist.setFont(new Font("Times New Roman", Font.BOLD, 25));
		txtrUsernameExist.setText("Username exist!");
		txtrUsernameExist.setBounds(55, 34, 193, 33);
		contentPane.add(txtrUsernameExist);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
			}
		});
		btnOk.setBounds(90, 96, 113, 27);
		contentPane.add(btnOk);
	}
}

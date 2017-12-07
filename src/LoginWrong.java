import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;


public class LoginWrong extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void loginWrong() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWrong frame = new LoginWrong();
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
	public LoginWrong() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 228);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrWrong = new JTextArea();
		txtrWrong.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtrWrong.setLineWrap(true);
		txtrWrong.setText("Incorrect name or password\r\n         Please try again.");
		txtrWrong.setBounds(73, 27, 281, 58);
		contentPane.add(txtrWrong);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
			}
		});
		btnOk.setBounds(152, 117, 113, 27);
		contentPane.add(btnOk);
	}
}

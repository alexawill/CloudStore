import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CreateDone extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void createDone() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateDone frame = new CreateDone();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 */
	public void close(){
		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
	    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
	
	public CreateDone() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 432, 253);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCongradulation = new JLabel("Congradulation!");
		lblCongradulation.setFont(new Font("ËÎÌו", Font.BOLD, 30));
		lblCongradulation.setForeground(Color.BLACK);
		lblCongradulation.setBounds(14, 13, 255, 84);
		panel.add(lblCongradulation);
		
		JLabel lblYourAccoutCreate = new JLabel("Your accout create successfully!");
		lblYourAccoutCreate.setFont(new Font("ËÎÌו", Font.BOLD, 20));
		lblYourAccoutCreate.setBounds(14, 95, 418, 35);
		panel.add(lblYourAccoutCreate);
		
		JButton btnBackToLogin = new JButton("Back to Login Page");
		btnBackToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
			}
		});
		btnBackToLogin.setBackground(Color.LIGHT_GRAY);
		btnBackToLogin.setFont(new Font("ËÎÌו", Font.BOLD, 15));
		btnBackToLogin.setBounds(107, 165, 208, 27);
		panel.add(btnBackToLogin);
	}
}

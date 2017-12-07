import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;


public class PostDone extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void postDone() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostDone frame = new PostDone();
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
	
	public void close(){
		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
	    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
	
	
	public PostDone() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 320, 214);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 302, 167);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblPostDone = new JLabel("Post Done!");
		lblPostDone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPostDone.setBounds(38, 31, 212, 18);
		panel.add(lblPostDone);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
			}
		});
		btnOk.setBounds(85, 91, 113, 27);
		panel.add(btnOk);
	}
}

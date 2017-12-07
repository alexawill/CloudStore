import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;



import java.util.*;
import java.awt.Font;
import java.io.File;
import java.io.RandomAccessFile;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;


public class PostPage extends JFrame {

	private JPanel contentPane;
	private static User user;
	private static String appName;

	/**
	 * Launch the application.
	 */
	public void close(){
		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
	    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
	
	
	public static void postPage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostPage frame = new PostPage(user,appName);
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
	public PostPage(User user,String appName) {
		this.user = user;
		this.appName = appName;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 449, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 431, 276);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 39, 403, 169);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		
		JButton btnPost = new JButton("Post");
		btnPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					RandomAccessFile in = new RandomAccessFile(new File(appName + "Comments.txt"),"rw");
					if(!textArea.getText().equals("")){
						in.seek(in.length());
						in.writeUTF(user.getUserName());
						for(int i = 0;i<20 - user.getUserName().length();i++){
							in.writeByte(20);
						}
						in.writeUTF(textArea.getText());
						for(int i = 0;i<20 - textArea.getText().length();i++){
							in.writeByte(20);
						}
						in.close();
						close();
						PostDone pg= new PostDone();
						pg.postDone();
					}
					else if(textArea.getText().equals("")){
						PostFail pf = new PostFail();
						pf.postFail();
					}
					
				}catch(Exception e){}
				
				
				
			}
		});
		btnPost.setBounds(14, 221, 113, 27);
		panel.add(btnPost);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnBack.setBounds(304, 221, 113, 27);
		panel.add(btnBack);
		
		JLabel lblReview = new JLabel("Review :");
		lblReview.setBounds(14, 13, 72, 18);
		panel.add(lblReview);
		
		
	}
}

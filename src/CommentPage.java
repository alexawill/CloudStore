import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.RandomAccessFile;


public class CommentPage extends JFrame {

	private JPanel contentPane;
	private static User user;
	private static String appName;

	/**
	 * Launch the application.
	 */
	public static void commentPage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CommentPage frame = new CommentPage(user,appName);
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
	public CommentPage(User user,String appName) {
		this.user = user;
		this.appName = appName;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 415, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 397, 425);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 49, 397, 316);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		
		JButton btnPost = new JButton("Post ");
		btnPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PostPage ps = new PostPage(user,appName);
				ps.postPage();
				
			}
		});
		btnPost.setBounds(14, 378, 113, 27);
		panel.add(btnPost);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnBack.setBounds(270, 378, 113, 27);
		panel.add(btnBack);
		
		JLabel lblNewLabel = new JLabel(appName);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(132, 13, 120, 18);
		panel.add(lblNewLabel);
		
		try{
			String temp = "";
			String n,c;
			RandomAccessFile in = new RandomAccessFile(new File(appName + "Comments.txt"),"rw");
			long l = in.length();
			long record = l / 40;
			
			for(int j = 0;j< record; j++){
				n = in.readUTF();
				for(int i = 0;i<20-n.length();i++){
					in.readByte();
				}
				c = in.readUTF();
				for(int i = 0;i<20-c.length();i++){
					in.readByte();
				}
				temp += n + " : \n";
			      temp += "    " + c + "\n";
			}
			in.close();
			textArea.setText(temp);
			
			
//			JButton btnRefresh = new JButton("Refresh");
//			btnRefresh.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent arg0) {
//					close();
//					CommentPage cm = new CommentPage(user,appName);
//					cm.commentPage();
//				}
//			});
//			btnRefresh.setBounds(294, 9, 89, 27);
//			panel.add(btnRefresh);
		}catch(Exception e){}
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
				CommentPage cm = new CommentPage(user,appName);
				cm.commentPage();
			}
		});
		btnRefresh.setBounds(294, 9, 89, 27);
		panel.add(btnRefresh);
		
		
	}
}

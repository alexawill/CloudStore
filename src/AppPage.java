import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;

//import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public class AppPage extends JFrame {

	private JPanel contentPane;
	private static String appname;
	private static User user;
	
	
	/**
	 * Launch the application.
	 */
	public static void appPage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppPage frame = new AppPage(appname,user);
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
	 * @throws IOException 
	 */
	public AppPage(String app,User user) throws IOException {
		this.appname = app;
		this.user = user;
		
		
		
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 476, 471);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbname = new JLabel("Name   :");
		lbname.setBounds(32, 54, 72, 18);
		lbname.setFont(new Font("宋体", Font.BOLD, 15));
		lbname.setForeground(new Color(0, 0, 0));
		lbname.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lbname);
		
		JLabel lbtype = new JLabel("Type   :");
		lbtype.setBounds(32, 85, 72, 18);
		lbtype.setFont(new Font("宋体", Font.BOLD, 15));
		contentPane.add(lbtype);
		
		JLabel lbprice = new JLabel("Price  :");
		lbprice.setBounds(32, 116, 72, 18);
		lbprice.setFont(new Font("宋体", Font.BOLD, 15));
		contentPane.add(lbprice);
		
		JLabel lbdeveloper = new JLabel("Developer  :");
		lbdeveloper.setBounds(221, 54, 108, 18);
		lbdeveloper.setFont(new Font("宋体", Font.BOLD, 15));
		contentPane.add(lbdeveloper);
		
		JLabel lbplatform = new JLabel("Platform   :");
		lbplatform.setBounds(221, 85, 108, 18);
		lbplatform.setFont(new Font("宋体", Font.BOLD, 15));
		contentPane.add(lbplatform);
		
		JLabel lbversion = new JLabel("Version    :");
		lbversion.setBounds(221, 116, 108, 18);
		lbversion.setFont(new Font("宋体", Font.BOLD, 15));
		contentPane.add(lbversion);
		
		JLabel name = new JLabel("New label");
		name.setBounds(135, 54, 72, 18);
		contentPane.add(name);
		
		JLabel developer = new JLabel("New label");
		developer.setBounds(343, 54, 98, 18);
		contentPane.add(developer);
		
		JLabel type = new JLabel("New label");
		type.setBounds(135, 85, 72, 18);
		contentPane.add(type);
		
		JLabel version = new JLabel("New label");
		version.setBounds(343, 116, 72, 18);
		contentPane.add(version);
		
		JLabel download = new JLabel("New label");
		download.setBounds(135, 147, 98, 18);
		contentPane.add(download);
		
		JLabel platform = new JLabel("New label");
		platform.setBounds(343, 85, 98, 18);
		contentPane.add(platform);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(32, 178, 108, 18);
		lblDescription.setFont(new Font("宋体", Font.BOLD, 15));
		contentPane.add(lblDescription);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setBounds(331, 384, 113, 27);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
			}
		});
		contentPane.add(btnBack);
		
		JLabel lbdownload = new JLabel("Download :");
		lbdownload.setBounds(32, 147, 90, 18);
		lbdownload.setFont(new Font("宋体", Font.BOLD, 15));
		contentPane.add(lbdownload);
		
		JLabel price = new JLabel("New label");
		price.setBounds(135, 116, 72, 18);
		contentPane.add(price);
		
		JButton btnViewComment = new JButton("View Comments");
		btnViewComment.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnViewComment.setBounds(24, 384, 140, 27);
		btnViewComment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				CommentPage cp = new CommentPage(user,appname);
				cp.commentPage();
			}
		});
		contentPane.add(btnViewComment);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 209, 387, 140);
		contentPane.add(scrollPane);
		
		JTextArea description = new JTextArea();
		description.setEditable(false);
		description.setForeground(Color.BLACK);
		description.setLineWrap(true);
		description.setFont(new Font("Times New Roman", Font.BOLD, 20));
		scrollPane.setViewportView(description);
		

		
		
		try{
			
			String temp,temp1;
			boolean check = false;
			RandomAccessFile file = new RandomAccessFile(new File("AppData.txt"),"rw");
			long length = file.length();
			file.seek(0);
			long record = length / 160;
			for(int j = 0 ; j < record && check == false ; j++){
				temp = file.readUTF();
				for(int i = 0 ; i < 20 - temp.length(); i++){
					file.readByte();
				}
				if(temp.equals(appname)){
					name.setText(temp);
					
					temp = file.readUTF();
					for(int i = 0 ; i < 20 - temp.length(); i++){
						file.readByte();
					}
					developer.setText(temp);
					
					temp = file.readUTF();
					for(int i = 0 ; i < 20 - temp.length(); i++){
						file.readByte();
					}
					description.setText(temp);
					
					temp = file.readUTF();
					for(int i = 0 ; i < 20 - temp.length(); i++){
						file.readByte();
					}
					type.setText(temp);
					
					temp = file.readUTF();
					for(int i = 0 ; i < 20 - temp.length(); i++){
						file.readByte();
					}
					download.setText(temp);
					
					temp = file.readUTF();
					for(int i = 0 ; i < 20 - temp.length(); i++){
						file.readByte();
					}
					platform.setText(temp);
					
					temp = file.readUTF();
					for(int i = 0 ; i < 20 - temp.length(); i++){
						file.readByte();
					}
					version.setText(temp);
					
					temp = file.readUTF();
					for(int i = 0 ; i < 20 - temp.length(); i++){
						file.readByte();
					}
					price.setText(temp);
					
					check = true;
				}
				
				for(int p = 0 ; p < 7; p ++){
					temp1 = file.readUTF();
					for(int i = 0 ; i < 20 - temp1.length(); i++){
						file.readByte();
					}
				}
			}
			file.close();
			
//			for(int i = 0;i < l;i+=8){
//				String check = in.readLine();
//				if(check.equals(appname)){
//					lblNewLabel.setText(check);
//					lblNewLabel_1.setText(in.readLine());
//					textArea.setText(in.readLine());
//					lblNewLabel_2.setText(in.readLine());
//					lblNewLabel_4.setText(in.readLine());
//					lblNewLabel_5.setText(in.readLine());
//					lblNewLabel_3.setText(in.readLine());
//					lblNewLabel_6.setText(in.readLine());
//					in.close();
//                    break;
//				}
//			}
			
		}catch(Exception e){}
		
		
	
		
	
		
		
		
		
		
		
	}
}

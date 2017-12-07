import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.Color;

import javax.swing.ScrollPaneConstants;
import javax.swing.DropMode;
import javax.swing.JTextArea;

import java.awt.Font;
import java.io.File;
import java.io.RandomAccessFile;

import javax.swing.SwingConstants;


public class RequestPage extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField developer;
	private JTextField type;
	private JTextField download;
	private JTextField platform;
	private JTextField version;
	private JTextField price;
	private JTextArea description;
	private static Application request;
	//requestPage
	public static void requestPage () {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RequestPage frame = new RequestPage();
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
	public RequestPage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 432, 534);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(57, 336, 316, 129);
		panel.add(scrollPane);
		
		description = new JTextArea();
		scrollPane.setViewportView(description);
		description.setFont(new Font("Monospaced", Font.PLAIN, 15));
		description.setLineWrap(true);
		description.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(14, 103, 72, 18);
		panel.add(lblName);
		
		JLabel lblPlatform = new JLabel("Platform");
		lblPlatform.setBounds(205, 157, 72, 18);
		panel.add(lblPlatform);
		
		JLabel lblDownload = new JLabel("Download");
		lblDownload.setBounds(14, 257, 72, 18);
		panel.add(lblDownload);
		
		JLabel lblDeveloper = new JLabel("Developer");
		lblDeveloper.setBounds(205, 103, 72, 18);
		panel.add(lblDeveloper);
		
		JLabel lblVersion = new JLabel("Version");
		lblVersion.setBounds(14, 209, 72, 18);
		panel.add(lblVersion);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(205, 209, 72, 18);
		panel.add(lblPrice);
		
		name = new JTextField();
		name.setBounds(89, 103, 102, 24);
		panel.add(name);
		name.setColumns(10);
		
		developer = new JTextField();
		developer.setBounds(291, 100, 117, 24);
		panel.add(developer);
		developer.setColumns(10);
		
		type = new JTextField();
		type.setBounds(89, 154, 102, 24);
		panel.add(type);
		type.setColumns(10);
		
		download = new JTextField();
		download.setBounds(89, 254, 319, 24);
		panel.add(download);
		download.setColumns(10);
		
		platform = new JTextField();
		platform.setBounds(291, 154, 117, 24);
		panel.add(platform);
		platform.setColumns(10);
		
		version = new JTextField();
		version.setBounds(89, 206, 102, 24);
		panel.add(version);
		version.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(14, 305, 102, 18);
		panel.add(lblDescription);
		
		JButton btnAdd = new JButton("Apply");
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				   
				   RandomAccessFile in = new RandomAccessFile(new File("NewRequest.txt"),"rw");
				   long l = in.length();
				   in.seek(l);
				   in.writeUTF(name.getText());
				   for(int i = 0;i<20-name.getText().length();i++){
					   in.writeByte(20);
				   }
				   in.writeUTF(developer.getText());
				   for(int i = 0;i<20-developer.getText().length();i++){
					   in.writeByte(20);
				   }
				   in.writeUTF(description.getText());
				   for(int i = 0;i<20-description.getText().length();i++){
					   in.writeByte(20);
				   }
				   in.writeUTF(type.getText());
				   for(int i = 0;i<20-type.getText().length();i++){
					   in.writeByte(20);
				   }
				   in.writeUTF(download.getText());
				   for(int i = 0;i<20-download.getText().length();i++){
					   in.writeByte(20);
				   }
				   in.writeUTF(platform.getText());
				   for(int i = 0;i<20-platform.getText().length();i++){
					   in.writeByte(20);
				   }
				   in.writeUTF(version.getText());
				   for(int i = 0;i<20-version.getText().length();i++){
					   in.writeByte(20);
				   }
				   in.writeUTF(price.getText());
				   for(int i = 0;i<20-price.getText().length();i++){
					   in.writeByte(20);
				   }
				   
				   in.close();
				   
				}catch(Exception e){}
				
				close();
			}
		});
		btnAdd.setBounds(14, 494, 113, 27);
		panel.add(btnAdd);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
			}
		});
		btnBack.setBounds(302, 494, 113, 27);
		panel.add(btnBack);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(14, 157, 72, 18);
		panel.add(lblType);
		
		price = new JTextField();
		price.setBounds(290, 206, 118, 24);
		panel.add(price);
		price.setColumns(10);
		
		JLabel lblNewApplicationRequest = new JLabel("New Application Request Form");
		lblNewApplicationRequest.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewApplicationRequest.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewApplicationRequest.setBounds(22, 26, 386, 41);
		panel.add(lblNewApplicationRequest);
	}
}

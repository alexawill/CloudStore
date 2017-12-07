import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Font;
import java.io.File;
import java.io.RandomAccessFile;

import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;


public class RequestForm extends JFrame {

	private JPanel contentPane;
	private static String appName;

	/**
	 * Launch the application.
	 */
	public static void requestForm() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RequestForm frame = new RequestForm(appName);
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
	public RequestForm(String appName) {
		this.appName = appName;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 431, 520);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(32, 80, 72, 18);
		contentPane.add(lblName);
		
		JLabel lblDeveloper = new JLabel("Developer");
		lblDeveloper.setBounds(203, 80, 72, 18);
		contentPane.add(lblDeveloper);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(32, 130, 72, 18);
		contentPane.add(lblType);
		
		JLabel lblPlatform = new JLabel("Platform");
		lblPlatform.setBounds(203, 130, 72, 18);
		contentPane.add(lblPlatform);
		
		JLabel lblVersion = new JLabel("Version");
		lblVersion.setBounds(32, 180, 72, 18);
		contentPane.add(lblVersion);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(203, 180, 72, 18);
		contentPane.add(lblPrice);
		
		JLabel lblDownload = new JLabel("Download");
		lblDownload.setBounds(32, 230, 72, 18);
		contentPane.add(lblDownload);
		
		JLabel lbdescription = new JLabel("Description");
		lbdescription.setBounds(32, 280, 88, 18);
		contentPane.add(lbdescription);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(42, 311, 321, 115);
		contentPane.add(scrollPane);
		
		JTextArea description = new JTextArea();
		description.setEnabled(false);
		description.setFont(new Font("Times New Roman", Font.BOLD, 20));
		description.setLineWrap(true);
		scrollPane.setViewportView(description);
		
		JLabel name = new JLabel("New label");
		name.setBounds(103, 80, 72, 18);
		contentPane.add(name);
		
		JLabel developer = new JLabel("New label");
		developer.setBounds(291, 80, 72, 18);
		contentPane.add(developer);
		
		JLabel type = new JLabel("New label");
		type.setBounds(103, 130, 72, 18);
		contentPane.add(type);
		
		JLabel download = new JLabel("New label");
		download.setBounds(118, 230, 242, 18);
		contentPane.add(download);
		
		JLabel platform = new JLabel("New label");
		platform.setBounds(291, 130, 72, 18);
		contentPane.add(platform);
		
		JLabel version = new JLabel("New label");
		version.setBounds(103, 180, 72, 18);
		contentPane.add(version);
		
		JLabel price = new JLabel("New label");
		price.setBounds(291, 180, 72, 18);
		contentPane.add(price);
		
		JLabel lblRequestForm = new JLabel("Request Form");
		lblRequestForm.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblRequestForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblRequestForm.setBounds(84, 13, 242, 33);
		contentPane.add(lblRequestForm);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
			}
		});
		btnBack.setBounds(286, 433, 113, 27);
		contentPane.add(btnBack);
		
		JButton btnAccess = new JButton("Accept");
		btnAccess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
               try{				
				RandomAccessFile write = new RandomAccessFile(new File("AppData.txt"),"rw");
				RandomAccessFile read = new RandomAccessFile(new File("NewRequest.txt"),"rw");
				long length = write.length();
				write.seek(length);
				
				write.writeUTF(name.getText());
				for(int i = 0; i < 20 - name.getText().length(); i ++){
					write.writeByte(20);
				}
				
				write.writeUTF(developer.getText());
				for(int i = 0; i < 20 - developer.getText().length(); i ++){
					write.writeByte(20);
				}
				
				write.writeUTF(description.getText());
				for(int i = 0; i < 20 - description.getText().length(); i ++){
					write.writeByte(20);
				}
				
				write.writeUTF(type.getText());
				for(int i = 0; i < 20 - type.getText().length(); i ++){
					write.writeByte(20);
				}
				
				write.writeUTF(download.getText());
				for(int i = 0; i < 20 - download.getText().length(); i ++){
					write.writeByte(20);
				}
				
				write.writeUTF(platform.getText());
				for(int i = 0; i < 20 - platform.getText().length(); i ++){
					write.writeByte(20);
				}
				
				write.writeUTF(version.getText());
				for(int i = 0; i < 20 - version.getText().length(); i ++){
					write.writeByte(20);
				}
				
				write.writeUTF(price.getText());
				for(int i = 0; i < 20 - price.getText().length(); i ++){
					write.writeByte(20);
				}
				
				write.close();
				
				length = read.length();
				read.seek(0);
				long record = length / 160;
				String temp,name;
				for(int j = 0; j < record ; j++){
					name = read.readUTF();
					for(int i = 0 ; i < 20 - name.length();i++){
						read.readByte();
					}
					for(int p = 0; p < 7;p++){
						temp = read.readUTF();
						for(int i = 0 ; i < 20 - temp.length();i++){
							read.readByte();
						}
					}
					
					if(name.equals(appName)){
						read.seek(j*160);
						read.setLength(length-176);
					}
				}
				
				
				
				
               }catch(Exception e){}
				
			}
		});
		btnAccess.setBounds(14, 433, 113, 27);
		contentPane.add(btnAccess);
		
		JButton btnDeny = new JButton("Deny");
		btnDeny.setBounds(141, 433, 113, 27);
		contentPane.add(btnDeny);
		
		try{
			String temp,temp1;
			boolean check = false;
			RandomAccessFile file = new RandomAccessFile(new File("NewRequest.txt"),"rw");
			long length = file.length();
			file.seek(0);
			long record = length / 160;
			for(int j = 0 ; j < record && check == false ; j++){
				temp = file.readUTF();
				for(int i = 0 ; i < 20 - temp.length(); i++){
					file.readByte();
				}
				if(temp.equals(appName)){
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
		}catch(Exception e){}
	}
}

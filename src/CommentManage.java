import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class CommentManage extends JFrame {

	private JPanel contentPane;
	ArrayList<Application> apps = getApplications();

	/**
	 * Launch the application.
	 */
	public static void commentManage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CommentManage frame = new CommentManage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private static ArrayList<Application> getApplications() throws FileNotFoundException{
		ArrayList<Application> result = new ArrayList<>();
		String name,developer,description, type,next, platform,version,price;
		try{
			RandomAccessFile read = new RandomAccessFile(new File("AppData.txt"),"rw");
			long filelength = read.length();
			read.seek(0);
			long record = filelength / 160;
			for(int j = 0; j < record ; j++){
				name = read.readUTF();
				for(int i = 0; i < 20 - name.length();i++){
					read.readByte();
				}
				developer = read.readUTF();
				for(int i = 0; i < 20 - developer.length();i++){
					read.readByte();
				}
				description = read.readUTF();
				for(int i = 0; i < 20 - description.length();i++){
					read.readByte();
				}
				type = read.readUTF();
				for(int i = 0; i < 20 - type.length();i++){
					read.readByte();
				}
				next = read.readUTF();
				for(int i = 0; i < 20 - next.length();i++){
					read.readByte();
				}
				platform = read.readUTF();
				for(int i = 0; i < 20 - platform.length();i++){
					read.readByte();
				}
				version = read.readUTF();
				for(int i = 0; i < 20 - version.length();i++){
					read.readByte();
				}
				price = read.readUTF();
				for(int i = 0; i < 20 - price.length();i++){
					read.readByte();
				}
				Application a = new Application(type, name, developer, description, platform, version, price);
	            result.add(a);
			}
		}catch(Exception e){}
		return result;
	}

	/**
	 * Create the frame.
	 */
	public CommentManage() throws FileNotFoundException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 743, 503);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(57, 37, 140, 24);
		for (Application a: apps){
			comboBox.addItem(a.getName());
		}
		contentPane.setLayout(null);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(413, 103, 102, 24);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(413, 157, 239, 24);
		contentPane.add(comboBox_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 103, 334, 340);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(30, 104, 369, 338);
		contentPane.add(textArea);
		textArea.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JButton btnView = new JButton("View");
		btnView.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
				comboBox_1.removeAllItems();
			}
		});
		btnView.setBounds(211, 36, 125, 27);
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					ArrayList<String> check = new ArrayList<String>();
					boolean x = true;
					String temp = "";
					String n,c;
					RandomAccessFile in = new RandomAccessFile(new File(comboBox.getSelectedItem() + "Comments.txt"),"rw");
					long l = in.length();
					long record = l / 40;
					
					for(int j = 0;j< record; j++){
						x = true;
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
					    if(!check.isEmpty()){
					        if(check.contains(n)) {
					        	x = false;
					        }
					    }
					    check.add(n);
					    if(x  == true) comboBox_1.addItem(n);
					      
					}
					in.close();
					textArea.setText(temp);
					
				}catch(Exception e){System.out.println(e.getMessage());}
			}
		});
		btnView.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(btnView);
		
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String n="", c="",tempn="",tempc="";
				try{
					RandomAccessFile file = new RandomAccessFile(new File(comboBox.getSelectedItem()+"Comments.txt"),"rw");
					long l = file.length();
					file.seek(0);
					long record = l / 40;
					for(int j = 0 ;j < record; j++){
						n = file.readUTF();
						for(int i = 0 ; i < 20 - n.length(); i++){
							file.readByte();
						}
						c = file.readUTF();
						for(int i = 0 ; i < 20 - c.length(); i++){
							file.readByte();
						}
						if(n.equals(comboBox_1.getSelectedItem())){
							if(c.equals(comboBox_2.getSelectedItem())){
								file.seek(j*40);
								file.setLength(l - 44);
							}
						}
						
					}
//                   tempn = n;
//                   tempc = c;
//                   file.seek(0);
//                   for(int j = 0 ;j < record; j++){
//						n = file.readUTF();
//						for(int i = 0 ; i < 20 - n.length(); i++){
//							file.readByte();
//						}
//						c = file.readUTF();
//						for(int i = 0 ; i < 20 - c.length(); i++){
//							file.readByte();
//						}
//						if(n.equals(comboBox_1.getSelectedItem())){
//							if(c.equals(comboBox_2.getSelectedItem())){
//								file.seek(40*j+40);
//								file.writeUTF(tempn);
//								for(int i = 0;i<20 - tempn.length();i++){
//									file.writeByte(20);
//								}
//								file.writeUTF(tempc);
//								for(int i = 0; i < 20 - tempc.length();i++){
//									file.writeByte(20);
//								}
//							}
//						}
//						
//					}
                   
                   
                   
                   
					
				}catch(Exception p){System.out.println("HERE"+p.getMessage());}
				
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnDelete.setBounds(413, 223, 113, 27);
		contentPane.add(btnDelete);
		
		JButton btnNewButton = new JButton("View");
		btnNewButton.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				comboBox_2.removeAllItems();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String n,c;
				try{
					RandomAccessFile file = new RandomAccessFile(comboBox.getSelectedItem()+"Comments.txt","rw");
					long l = file.length();
					file.seek(0);
					long record = l / 40;
					for(int j = 0 ; j < record ; j++){
						n = file.readUTF();
						for(int i = 0 ; i < 20 - n.length(); i++){
							file.readByte();
						}
						c = file.readUTF();
						for(int i = 0 ; i < 20 - c.length(); i++){
							file.readByte();
						}
						if(n.equals(comboBox_1.getSelectedItem())){
							comboBox_2.addItem(c);
						}
					}
					file.close();
				}catch(Exception e){}
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(539, 102, 113, 27);
		contentPane.add(btnNewButton);
		
	}
}

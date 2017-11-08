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

import com.jgoodies.forms.factories.DefaultComponentFactory;

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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public class AppPage extends JFrame {

	private JPanel contentPane;
	public static String appname;
	
	
	/**
	 * Launch the application.
	 */
	public static void appPage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppPage frame = new AppPage(appname);
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
	public AppPage(String app) throws IOException {
		this.appname = app;
		
		
		
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 447, 471);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name   :");
		lblName.setFont(new Font("宋体", Font.BOLD, 15));
		lblName.setForeground(new Color(0, 0, 0));
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setBounds(14, 54, 72, 18);
		contentPane.add(lblName);
		
		JLabel lblType = new JLabel("Type   :");
		lblType.setFont(new Font("宋体", Font.BOLD, 15));
		lblType.setBounds(14, 102, 72, 18);
		contentPane.add(lblType);
		
		JLabel lblPrice = new JLabel("Price  :");
		lblPrice.setFont(new Font("宋体", Font.BOLD, 15));
		lblPrice.setBounds(14, 146, 72, 18);
		contentPane.add(lblPrice);
		
		JLabel lblDeveloper = new JLabel("Developer  :");
		lblDeveloper.setFont(new Font("宋体", Font.BOLD, 15));
		lblDeveloper.setBounds(211, 54, 108, 18);
		contentPane.add(lblDeveloper);
		
		JLabel lblPlatform = new JLabel("Platform   :");
		lblPlatform.setFont(new Font("宋体", Font.BOLD, 15));
		lblPlatform.setBounds(211, 102, 108, 18);
		contentPane.add(lblPlatform);
		
		JLabel lblVersion = new JLabel("Version    :");
		lblVersion.setFont(new Font("宋体", Font.BOLD, 15));
		lblVersion.setBounds(211, 146, 108, 18);
		contentPane.add(lblVersion);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(110, 54, 72, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(333, 54, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(110, 102, 72, 18);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(333, 102, 72, 18);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(333, 143, 72, 18);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(110, 146, 72, 18);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("宋体", Font.BOLD, 15));
		lblDescription.setBounds(27, 203, 108, 18);
		contentPane.add(lblDescription);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(56, 234, 310, 114);
		contentPane.add(textPane);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
			}
		});
		
		btnBack.setBounds(292, 384, 113, 27);
		contentPane.add(btnBack);
		

		System.out.println("ky :" + appname);
		RandomAccessFile in = new RandomAccessFile("AppsData.txt","rw");
		long l = in.length();
		
		try{
			
			for(int i = 0;i < l;i+=8){
				String check = in.readLine();
				if(check.equals(appname)){
					lblNewLabel.setText(check);
					lblNewLabel_1.setText(in.readLine());
					textPane.setText(in.readLine());
					lblNewLabel_2.setText(in.readLine());
					lblNewLabel_3.setText(in.readLine());
					lblNewLabel_5.setText(in.readLine());
					lblNewLabel_4.setText(in.readLine());
					in.close();
                    break;
				}
			}
			
		}catch(Exception e){}
		
		
	
		
	
		
		
		
		
		
		
	}
}

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.RandomAccessFile;

import javax.swing.JTextField;
import java.awt.Font;


public class RequestList extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void requestList() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RequestList frame = new RequestList();
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
	public RequestList() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 328, 554);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 126, 282, 308);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"         Name"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnBack.setBounds(103, 467, 113, 27);
		contentPane.add(btnBack);
		
		textField = new JTextField();
		textField.setBounds(55, 27, 177, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RequestForm rf = new RequestForm(textField.getText());
				rf.requestForm();
				
			}
		});
		btnView.setBounds(33, 65, 113, 27);
		contentPane.add(btnView);
		
		JButton btnRefreash = new JButton("Refresh");
		btnRefreash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				RequestList rl = new RequestList();
				rl.requestList();
			}
		});
		btnRefreash.setBounds(160, 65, 113, 27);
		contentPane.add(btnRefreash);
		
		try{
			String name,temp;
			RandomAccessFile file = new RandomAccessFile(new File("NewRequest.txt"),"rw");
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			long length = file.length();
			file.seek(0);
			long record = length / 160;
			for(int j = 0; j < record; j++){
				name = file.readUTF();
				for(int i = 0;i < 20 - name.length();i++){
					file.readByte();
				}
				model.addRow(new Object[]{name});
                for(int p= 0; p< 7;p++){
                	temp = file.readUTF();
    				for(int i = 0;i < 20 - temp.length();i++){
    					file.readByte();
    				}
                }
			}
			
			
			
		}catch(Exception e){}
	}
}

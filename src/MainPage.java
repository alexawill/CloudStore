import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


public class MainPage extends JFrame{

	private JPanel contentPane;
	private JTextField textField;
	private ArrayList<Application> apps = new ArrayList<Application>();

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
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
	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 468, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Search Bar");
		label.setBounds(14, 52, 87, 18);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(115, 49, 180, 24);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblCloudStore = new JLabel("Cloud Store");
		lblCloudStore.setFont(new Font("MS UI Gothic", Font.BOLD, 26));
		lblCloudStore.setBounds(125, 79, 187, 84);
		panel.add(lblCloudStore);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				AppPage nw = new AppPage();
				nw.appPage();
				
			}
		});
		btnEnter.setBounds(308, 48, 113, 27);
		panel.add(btnEnter);
		
		JButton btnCompare = new JButton("Compare");
		btnCompare.setBounds(335, 316, 117, 29);
		panel.add(btnCompare);
	}
}

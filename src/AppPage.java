import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import java.awt.Color;


public class AppPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void appPage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppPage frame = new AppPage();
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
	public AppPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(33, 44, 72, 18);
		contentPane.add(lblType);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(33, 13, 72, 18);
		contentPane.add(lblName);
		
		JLabel lblDeveloper = new JLabel("Developer");
		lblDeveloper.setBounds(33, 75, 72, 18);
		contentPane.add(lblDeveloper);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(205, 13, 72, 18);
		contentPane.add(lblPrice);
		
		JLabel lblVersion = new JLabel("Version");
		lblVersion.setBounds(205, 44, 72, 18);
		contentPane.add(lblVersion);
		
		JLabel lblPlatform = new JLabel("Platform");
		lblPlatform.setBounds(205, 75, 72, 18);
		contentPane.add(lblPlatform);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(119, 13, 72, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(119, 44, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(119, 75, 72, 18);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(291, 75, 72, 18);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(291, 44, 72, 18);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(291, 13, 72, 18);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setBounds(33, 118, 111, 18);
		contentPane.add(lblDescription);
		
		JTextArea txtrText = new JTextArea();
		txtrText.setEditable(false);
		txtrText.setBackground(Color.WHITE);
		txtrText.setForeground(Color.BLACK);
		txtrText.setText("text");
		txtrText.setBounds(67, 149, 258, 118);
		contentPane.add(txtrText);
		
	
		
	
		
		
		
		
		
		
	}
}

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;


public class Test extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Search Bar");
		label.setBounds(30, 13, 72, 18);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(116, 10, 180, 24);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblCloudStore = new JLabel("Cloud Store");
		lblCloudStore.setBounds(158, 47, 97, 37);
		panel.add(lblCloudStore);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setBounds(309, 9, 113, 27);
		panel.add(btnEnter);
	}
}

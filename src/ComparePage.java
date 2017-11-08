import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ComparePage extends JFrame {

	private JPanel contentPane;
	private JButton btnCompare;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	ArrayList<Application> apps = getApplications();

	/**
	 * Launch the application.
	 * @return 
	 * @throws FileNotFoundException 
	 */
	public static void launchPage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComparePage frame = new ComparePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private static ArrayList<Application> getApplications() throws FileNotFoundException{
		ArrayList<Application> result = new ArrayList<>();
		Scanner scanner = new Scanner(new File("fake application data.csv"));
        scanner.useDelimiter(",");
        scanner.nextLine();
        while (scanner.hasNext()){
        	String name = scanner.next();
        	String developer = scanner.next();
        	String description = scanner.next();
        	if (description.charAt(0) == '"'){
        		String next = scanner.next();
            	while (next.charAt(next.length() - 1) != '"'){
            		description += next;
            		next = scanner.next();
            	}
            	description += next;
        	}
        	String type = scanner.next();
        	String platform = scanner.next();
        	String version = scanner.next();
        	String price = scanner.nextLine();
        	price = price.substring(1);
            Application a = new Application(type, name, developer, description, platform, version, price);
            result.add(a);
        }
        scanner.close();
		return result;
	}
	
	private Application getAppByName(String name) {
		for (Application a: apps){
			if (a.getName().equals(name))
				return a;
		}
		return null;
	}

	/**
	 * Create the frame.
	 * @throws FileNotFoundException 
	 */
	public ComparePage() throws FileNotFoundException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 2));
		
		panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		for (Application a: apps){
			comboBox_1.addItem(a.getName());
		}
		panel.add(comboBox_1);
		
		btnCompare = new JButton("Compare");
		
		panel.add(btnCompare);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		for (Application a: apps){
			comboBox.addItem(a.getName());
		}
		panel.add(comboBox);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		panel_3 = new JPanel();
		JLabel name1 = new JLabel("");
		name1.setBounds(110, 5, 0, 0);
		JLabel type1 = new JLabel("");
		JLabel price1 = new JLabel("");
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		panel_3.add(name1);
		panel_3.add(type1);
		panel_3.add(price1);
		panel_1.add(panel_3, BorderLayout.WEST);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.CENTER);
		
		panel_2 = new JPanel();
		JLabel name2 = new JLabel("");
		JLabel type2 = new JLabel("");
		JLabel price2 = new JLabel("");
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		panel_2.add(name2);
		panel_2.add(type2);
		panel_2.add(price2);
		
		panel_1.add(panel_2, BorderLayout.EAST);
		
		btnCompare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String n1 = (String) comboBox_1.getSelectedItem();
				String n2 = (String) comboBox.getSelectedItem();
				Application app1 = getAppByName(n1);
				Application app2 = getAppByName(n2);
				name1.setText(app1.getName());
				name2.setText(app2.getName());
				type1.setText(app1.getType());
				type2.setText(app2.getType());
				price1.setText(app1.getPrice());
				price2.setText(app2.getPrice());
			}

			
		});
	}
}

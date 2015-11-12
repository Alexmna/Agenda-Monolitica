package Iteracion1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.AbstractListModel;
import javax.swing.border.TitledBorder;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel jPanel;
	private JPanel panel1;
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		getContentPane().setLayout(null);
		{
			panel1 = new JPanel();
			panel1.setBounds(0, 0, 434, 261);
			getContentPane().add(panel1);
			panel1.setLayout(null);
			{
				list = new JList();
				list.setModel(new AbstractListModel() {
					String[] values = new String[] {"Abc"};
					public int getSize() {
						return values.length;
					}
					public Object getElementAt(int index) {
						return values[index];
					}
				});
				list.setBounds(24, 187, 72, -135);
				panel1.add(list);
			}
		}
		getContentPane().setLayout(null);
		{
			jPanel = new JPanel();
			jPanel.setBounds(0, 0, 434, 261);
			getContentPane().add(jPanel);
		}
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			DefaultListModel<String> model = new DefaultListModel<String>(); 
			for (int i = 0; i<2; i++){
				String c = "String"+i;
				model.addElement(c);
			}
		}
		{
			panel = new JPanel();
			panel.setBounds(0, 0, 474, 321);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				DefaultListModel <String> model = new DefaultListModel<String>();
				model.addElement("gl");
				
			}
		}
	}
}

package Iteracion2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private static JList list;
	private static List <Contactos> contactos = new ArrayList();
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblTelefono;
	private static JTextField textFieldNombre;
	private static JTextField textFieldApellido;
	private static JTextField textFieldTelefono;
	private JButton btnAadir;
	private static DefaultListModel <Contactos> model = new DefaultListModel<Contactos>();
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		{
			panel = new JPanel();
			contentPane.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				list = new JList();
				list.setBounds(10, 29, 115, 179);
				panel.add(list);
				cargarEnTextField();
				{
					lblNombre = new JLabel("Nombre");
					lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
					lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
					lblNombre.setBounds(186, 59, 64, 14);
					panel.add(lblNombre);
				}
				{
					lblApellido = new JLabel("Apellido");
					lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
					lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
					lblApellido.setBounds(186, 96, 64, 14);
					panel.add(lblApellido);
				}
				{
					lblTelefono = new JLabel("Telefono");
					lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
					lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
					lblTelefono.setBounds(186, 129, 64, 14);
					panel.add(lblTelefono);
				}
				{
					textFieldNombre = new JTextField();
					textFieldNombre.setBounds(295, 57, 119, 20);
					panel.add(textFieldNombre);
					textFieldNombre.setColumns(10);
				}
				{
					textFieldApellido = new JTextField();
					textFieldApellido.setColumns(10);
					textFieldApellido.setBounds(295, 94, 119, 20);
					panel.add(textFieldApellido);
				}
				{
					textFieldTelefono = new JTextField();
					textFieldTelefono.setColumns(10);
					textFieldTelefono.setBounds(295, 127, 119, 20);
					panel.add(textFieldTelefono);
				}
				{
					btnAadir = new JButton("A\u00F1adir");
					btnAadir.addActionListener(new BtnAadirActionListener());
					btnAadir.setBounds(153, 191, 89, 23);
					panel.add(btnAadir);
				}
				rellenarLista();
				
			}
		}
	}

	public static void generarContactos(){
		for (int i = 0; i<3; i++){
			Contactos c = new Contactos("Nombre"+(i+1),"Apellidos"+(i+1), "66666"+i);
			contactos.add(c);
		}
	}
	public static void rellenarLista(){
		generarContactos();
		
		for (int i = 0; i< contactos.size();i++){
			model.addElement(contactos.get(i));
		}
		
		list.setModel(model);
		
	}
	private class BtnAadirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Contactos c = new Contactos(textFieldNombre.getText(), textFieldApellido.getText(), textFieldTelefono.getText());
			contactos.add(c);
			model.addElement(c);
			list.setModel(model);
			
			textFieldNombre.setText("");
			textFieldApellido.setText("");
			textFieldTelefono.setText("");
		}
	}

	private static void cargarEnTextField(){
			
		
	}
}

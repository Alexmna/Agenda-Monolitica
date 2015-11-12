package Iteracion4;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

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
	private JButton btnBorrar;
	private JButton btnModificar;
	private JButton btnBuscar;
	private JButton btnRBusqueda;
	private JTextField textFieldRBusqueda;
	private JLabel lblRBusqueda;
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
		setBounds(100, 100, 450, 287);
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
				list.addListSelectionListener(new ListListSelectionListener());
				list.setBounds(10, 29, 115, 161);
				panel.add(list);
			
				{
					lblNombre = new JLabel("Nombre");
					lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
					lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
					lblNombre.setBounds(151, 50, 64, 14);
					panel.add(lblNombre);
				}
				{
					lblApellido = new JLabel("Apellido");
					lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
					lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
					lblApellido.setBounds(151, 87, 64, 14);
					panel.add(lblApellido);
				}
				{
					lblTelefono = new JLabel("Telefono");
					lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
					lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
					lblTelefono.setBounds(151, 120, 64, 14);
					panel.add(lblTelefono);
				}
				{
					textFieldNombre = new JTextField();
					textFieldNombre.setBounds(260, 48, 119, 20);
					panel.add(textFieldNombre);
					textFieldNombre.setColumns(10);
				}
				{
					textFieldApellido = new JTextField();
					textFieldApellido.setColumns(10);
					textFieldApellido.setBounds(260, 85, 119, 20);
					panel.add(textFieldApellido);
				}
				{
					textFieldTelefono = new JTextField();
					textFieldTelefono.setColumns(10);
					textFieldTelefono.setBounds(260, 118, 119, 20);
					panel.add(textFieldTelefono);
				}
				{
					btnAadir = new JButton("A\u00F1adir");
					btnAadir.addActionListener(new BtnAadirActionListener());
					btnAadir.setBounds(135, 185, 84, 23);
					panel.add(btnAadir);
				}
				{
					btnBorrar = new JButton("Borrar");
					btnBorrar.addActionListener(new BtnBorrarActionListener());
					btnBorrar.setBounds(229, 185, 84, 23);
					panel.add(btnBorrar);
				}
				{
					btnModificar = new JButton("Modificar");
					btnModificar.addActionListener(new ButtonActionListener());
					btnModificar.setBounds(328, 185, 86, 23);
					panel.add(btnModificar);
				}
				{
					btnBuscar = new JButton("BUSCAR");
					btnBuscar.addActionListener(new BtnBuscarActionListener());
					btnBuscar.setBounds(20, 204, 89, 23);
					panel.add(btnBuscar);
				}
				{
					btnRBusqueda = new JButton("BUSCAR");
					btnRBusqueda.addActionListener(new BtnRBusquedaActionListener());
					btnRBusqueda.setVisible(false);
					btnRBusqueda.setBounds(120, 149, 218, 57);
					panel.add(btnRBusqueda);
				}
				{
					textFieldRBusqueda = new JTextField();
					textFieldRBusqueda.setVisible(false);
					textFieldRBusqueda.setBounds(54, 78, 342, 35);
					panel.add(textFieldRBusqueda);
					textFieldRBusqueda.setColumns(10);
				}
				{
					lblRBusqueda = new JLabel("Introduzca nombre a buscar");
					lblRBusqueda.setVisible(false);
					lblRBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 12));
					lblRBusqueda.setHorizontalAlignment(SwingConstants.CENTER);
					lblRBusqueda.setBounds(68, 30, 311, 34);
					panel.add(lblRBusqueda);
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
			DefaultListModel <Contactos> modelAuxiliar = new DefaultListModel <Contactos>();
			for (int i = 0; i<contactos.size(); i++){
				modelAuxiliar.addElement(contactos.get(i));
			}
	
			list.setModel(modelAuxiliar);
			
			textFieldNombre.setText("");
			textFieldApellido.setText("");
			textFieldTelefono.setText("");
		}
	}
	
	private class ListListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			
			Contactos c =contactos.get(list.getSelectedIndex());
			textFieldNombre.setText(c.getNombre());
			textFieldApellido.setText(c.getApellido());
			textFieldTelefono.setText(c.getTelefono());
		}
	}
	
	private class BtnBorrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			int index =list.getSelectedIndex();
			Contactos c = contactos.remove(index);
			try{
			DefaultListModel <Contactos> modelAuxiliar = new DefaultListModel <Contactos>();
			for (int i = 0; i<contactos.size(); i++){
				modelAuxiliar.addElement(contactos.get(i));
			}
			textFieldNombre.setText("");
			textFieldApellido.setText("");
			textFieldTelefono.setText("");
			list.setModel(modelAuxiliar);
			
			}catch(Exception e){}
		}
	}

	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int index =list.getSelectedIndex();
			Contactos c = contactos.get(index);
			c.setNombre(textFieldNombre.getText());
			c.setApellido(textFieldApellido.getText());
			c.setTelefono(textFieldTelefono.getText());
			try{
			DefaultListModel <Contactos> modelAuxiliar = new DefaultListModel <Contactos>();
			for (int i = 0; i<contactos.size(); i++){
				modelAuxiliar.addElement(contactos.get(i));
			}
			textFieldNombre.setText("");
			textFieldApellido.setText("");
			textFieldTelefono.setText("");
			list.setModel(modelAuxiliar);
			
			}catch(Exception e1){}
		}
	}

	private class BtnBuscarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ocultarTodo();
			mostrarBusqueda();
			
		}
	}

	private class BtnRBusquedaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Contactos c = new Contactos();
			boolean encontrado = false;
			for (int i = 0; i<contactos.size(); i++){
				if (contactos.get(i).getNombre().equals(textFieldRBusqueda.getText())){
					c = contactos.get(i);
					encontrado = true;
				}
			}
			
			if (encontrado){
				mostrarTodo();
				ocultarBusqueda();
				textFieldNombre.setText(c.getNombre());
				textFieldApellido.setText(c.getApellido());
				textFieldTelefono.setText(c.getTelefono());
			}
			else{
				textFieldRBusqueda.setText("Nombre no encontrado, introduzca un nombre existente");
				textFieldRBusqueda.setBackground(Color.RED);
			}
		}
	}
	
	
	private void ocultarTodo(){
		btnBuscar.setVisible(false);
		btnAadir.setVisible(false);
		btnBorrar.setVisible(false);
		btnModificar.setVisible(false);
		list.setVisible(false);
		lblNombre.setVisible(false);
		lblApellido.setVisible(false);
		lblTelefono.setVisible(false);
		textFieldNombre.setVisible(false);
		textFieldTelefono.setVisible(false);
		textFieldApellido.setVisible(false);
	}

	private void mostrarTodo(){
		btnBuscar.setVisible(true);
		btnAadir.setVisible(true);
		btnBorrar.setVisible(true);
		btnModificar.setVisible(true);
		list.setVisible(true);
		lblNombre.setVisible(true);
		lblApellido.setVisible(true);
		lblTelefono.setVisible(true);
		textFieldNombre.setVisible(true);
		textFieldTelefono.setVisible(true);
		textFieldApellido.setVisible(true);
	}
	private void mostrarBusqueda(){
		btnRBusqueda.setVisible(true);
		textFieldRBusqueda.setVisible(true);
		lblRBusqueda.setVisible(true);
	}
	private void ocultarBusqueda(){
		btnRBusqueda.setVisible(false);
		textFieldRBusqueda.setVisible(false);
		lblRBusqueda.setVisible(false);
	}

}

package Iteracion1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPasswordField;

public class MenuLogin {

	private JFrame frameLogin;
	private JLabel lblNombreDeUsuario;
	private JLabel lblPassword;
	private JTextField tfNombreDeUsuario;
	private JButton btnEntrar;
	private JButton btnLimpiar;
	private JTextPane txtEstado;
	private String password = "iso";
	private JPasswordField pwdPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuLogin window = new MenuLogin();
					window.frameLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameLogin = new JFrame();
		frameLogin.setResizable(false);
		frameLogin.setBounds(100, 100, 436, 268);
		frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLogin.getContentPane().setLayout(null);
		{
			lblNombreDeUsuario = new JLabel("Nombre de Usuario");
			lblNombreDeUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNombreDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNombreDeUsuario.setBounds(65, 31, 123, 26);
			frameLogin.getContentPane().add(lblNombreDeUsuario);
		}
		{
			lblPassword = new JLabel("Password");
			lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblPassword.setBounds(65, 84, 123, 26);
			frameLogin.getContentPane().add(lblPassword);
		}
		{
			tfNombreDeUsuario = new JTextField();
			tfNombreDeUsuario.setBounds(224, 35, 115, 20);
			frameLogin.getContentPane().add(tfNombreDeUsuario);
			tfNombreDeUsuario.setColumns(10);
			tfNombreDeUsuario.addActionListener(new TfUsuarioActionListener());
		}
		{
			btnEntrar = new JButton("Entrar");
			btnEntrar.setEnabled(false);
			btnEntrar.setBounds(250, 132, 89, 23);
			frameLogin.getContentPane().add(btnEntrar);
			btnEntrar.addActionListener(new BtnEntrarActionListener());
		}
		{
			btnLimpiar = new JButton("Limpiar");
			btnLimpiar.setBounds(109, 132, 89, 23);
			frameLogin.getContentPane().add(btnLimpiar);
		}
		{
			txtEstado = new JTextPane();
			txtEstado.setBackground(Color.WHITE);
			txtEstado.setBounds(0, 219, 430, 20);
			frameLogin.getContentPane().add(txtEstado);
		}
		{
			pwdPassword = new JPasswordField();
			pwdPassword.setEditable(false);
			pwdPassword.setEnabled(false);
			pwdPassword.setBounds(224, 88, 115, 20);
			frameLogin.getContentPane().add(pwdPassword);
			pwdPassword.addActionListener(new PwdfPasswordActionListener());
		}
	}
	
	private class TfUsuarioActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
		txtEstado.setText("Evento de acción: ActionPerformed"+arg0.getActionCommand() );
		//Activamos los de la contraseña
		pwdPassword.setEnabled(true);
		pwdPassword.setEditable(true);
		//Pasamos el foco (el cursor) al campo de la contraseña
		pwdPassword.requestFocus();
		}
		}
	
	private class PwdfPasswordActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (String.valueOf(pwdPassword.getPassword()).toString().equals(password)){
				txtEstado.setText("Contraseña Válida, puede entrar");
				txtEstado.setBackground(Color.GREEN);
				btnEntrar.setEnabled(true);
			}
		}
	}
	
	private class BtnEntrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		//finaliza la ejecución de la aplicación
		//System.exit(0);
			MenuPrincipal int2 = new MenuPrincipal();
			int2.setVisible(true);
			frameLogin.dispose();
		}
		}
}

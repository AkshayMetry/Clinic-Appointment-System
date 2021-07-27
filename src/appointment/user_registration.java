package appointment;
import Database.DB;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class user_registration extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textEmail;
	private JTextField textUsername;
	private JPasswordField passwordField;
	private JLabel lblRegistration;
	private JTextField textMobile;
	private JLabel lblName;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user_registration frame = new user_registration();
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
	Connection con = null;
	private JLabel lblLogin;
	public user_registration() {
		
		con =(Connection) DB.dbconnect();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(320,180,800,500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsername.setBounds(165, 210, 120, 31);
		contentPane.add(lblUsername);
		
		textName = new JTextField();
		textName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textName.setBounds(349, 114, 324, 31);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textEmail.setColumns(10);
		textEmail.setBounds(349, 162, 324, 31);
		contentPane.add(textEmail);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEmail.setBounds(165, 160, 120, 31);
		contentPane.add(lblEmail);
		
		JLabel lblMobileNo = new JLabel("Mobile No");
		lblMobileNo.setForeground(Color.WHITE);
		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMobileNo.setBounds(165, 310, 120, 31);
		contentPane.add(lblMobileNo);
		
		textUsername = new JTextField();
		textUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textUsername.setColumns(10);
		textUsername.setBounds(349, 212, 324, 31);
		contentPane.add(textUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(165, 260, 120, 31);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBounds(349, 262, 324, 31);
		contentPane.add(passwordField);
		
		lblRegistration = new JLabel("Registration");
		lblRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistration.setForeground(Color.WHITE);
		lblRegistration.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblRegistration.setBounds(297, 30, 223, 60);
		contentPane.add(lblRegistration);
		
		textMobile = new JTextField();
		textMobile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textMobile.setColumns(10);
		textMobile.setBounds(349, 312, 324, 31);
		contentPane.add(textMobile);
		
		lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblName.setBounds(165, 112, 120, 31);
		contentPane.add(lblName);
		
		btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name = textName.getText();
					String email = textEmail.getText();
					String username = textUsername.getText(); 
					String password = passwordField.getText();
					String mobile_no = textMobile.getText();
					
					PreparedStatement pst = (PreparedStatement) con.prepareStatement("INSERT INTO users(name,email,username,password,mobile_no) "
							+ "values('"+name+"','"+email+"','"+username+"','"+password+"','"+mobile_no+"')");
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Registred Succesfully");
					
				}
				catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(310, 376, 145, 37);
		contentPane.add(btnNewButton);
		
		
		
		lblLogin = new JLabel("Already have an Account?");
		lblLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login l1 = new login();
				l1.show();
				dispose();
			
			}
		});
		lblLogin.setBounds(310, 424, 194, 31);
		contentPane.add(lblLogin);
//		
//		setUndecorated(true);
	}
}

package doctor;
import Database.DB;
import appointment.Dashboard_User;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class doctor_login extends JFrame {

	private JPanel contentPane;
	private JTextField doc_username;
	private JPasswordField passwordField;
	Connection con = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					doctor_login frame = new doctor_login();
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
	
	public doctor_login() {
		
		con =(Connection) DB.dbconnect();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(320,180,800,500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDoctorLogin = new JLabel("Doctor Login");
		lblDoctorLogin.setBounds(299, 72, 209, 52);
		lblDoctorLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorLogin.setForeground(Color.WHITE);
		lblDoctorLogin.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(lblDoctorLogin);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsername.setBounds(221, 174, 110, 27);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(221, 255, 110, 27);
		contentPane.add(lblPassword);
		
		doc_username = new JTextField();
		doc_username.setBounds(374, 175, 277, 32);
		contentPane.add(doc_username);
		doc_username.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(374, 256, 277, 32);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String doctor_username = doc_username.getText();
				String doctor_password = passwordField.getText();
				
				try {
					String url = "SELECT * FROM doctors WHERE doctor_username = '"+doctor_username+"' and doctor_password = '"+doctor_password+"' ";
					String get_id = "SELECT id FROM doctors WHERE doctor_name = '"+doctor_username+"' ";
					
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(url);
					rs = st.executeQuery(get_id);
					if(rs.next()) {
						String id  = rs.getString("id");
						doctor_dashboard dd = new doctor_dashboard(id);
						dd.show();
						dispose();
					}	
					else
				    {
				      JOptionPane.showInputDialog(null,"Incorrect login or password",
				      "Error",JOptionPane.ERROR_MESSAGE);  
				    }
				}
				catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnLogin.setBackground(new Color(255, 255, 255));
		btnLogin.setForeground(new Color(100, 149, 237));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogin.setBounds(341, 338, 110, 37);
		contentPane.add(btnLogin);
		
		
//		setUndecorated(true);
	}
	
}

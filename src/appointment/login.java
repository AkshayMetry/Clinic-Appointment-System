package appointment;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Database.DB;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JPasswordField;

public class login extends JFrame {

	private JPanel contentPane;
	
	private JTextField getuser;
	private JPasswordField getpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection con = null;
	/**
	 * Create the frame.
	 */
	public login() {
		con =(Connection) DB.dbconnect();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(320,180,800,500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		getuser = new JTextField();
		getuser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getuser.setBounds(353, 136, 272, 32);
		contentPane.add(getuser);
		getuser.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validateUser();
						
			}
		});
		btnLogin.setBounds(332, 309, 130, 41);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(346, 45, 106, 52);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(194, 218, 120, 33);
		contentPane.add(lblPassword);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsername.setBounds(194, 133, 120, 33);
		contentPane.add(lblUsername);
		
	
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user_registration u1 = new user_registration();
				u1.show();
				
				dispose();
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRegister.setBounds(600, 600, 600, 600);
		contentPane.add(btnRegister);
		
		getpassword = new JPasswordField();
		getpassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getpassword.setBounds(353, 220, 272, 33);
		contentPane.add(getpassword);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user_registration ur_1 = new user_registration();
				ur_1.show();
				dispose();
			}
		});
		lblRegister.setForeground(Color.WHITE);
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRegister.setBounds(353, 361, 95, 19);
		contentPane.add(lblRegister);
//		setUndecorated(true); //to remove frame outline
	}
	
	
	public void validateUser() {
		
		String username = getuser.getText();
		String password = getpassword.getText();
		
		try {
			String url = "SELECT * FROM users WHERE username = '"+username+"' and password = '"+password+"'  ";
			String get_id = "SELECT users_id FROM users WHERE username = '"+username+"' ";
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery(url);
			
			if(rs.next()) {
				String id  = rs.getString("users_id");
				Dashboard_User du = new Dashboard_User(id);
				du.setVisible(true);
				dispose();
			}	
			else
		    {
		      JOptionPane.showMessageDialog(this,"Incorrect login or password",
		      "Error",JOptionPane.ERROR_MESSAGE);  
		    }
		}
		catch(Exception e) {
			
		}
	}
}

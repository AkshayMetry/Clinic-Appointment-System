package admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class admin_login extends JFrame {

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
					admin_login frame = new admin_login();
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
	public admin_login() {
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
				validate_admin();
						
			}
		});
		btnLogin.setBounds(332, 309, 130, 41);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("Admin Login");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(274, 45, 178, 52);
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
		
		
		getpassword = new JPasswordField();
		getpassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getpassword.setBounds(353, 220, 272, 33);
		contentPane.add(getpassword);
//		setUndecorated(true); //to remove frame outline
	}
	public void validate_admin() {
		String uname = getuser.getText();
		   String pass = getpassword.getText();
		   if(uname.equals("admin") && pass.equals("admin@123"))
		   {
		      admin_dashboard ad = new admin_dashboard();
		      ad.setVisible(true);
		      dispose();
		    }
		    else
		    {
		      JOptionPane.showMessageDialog(this,"Incorrect login or password",
		      "Error",JOptionPane.ERROR_MESSAGE);  
		    }
		  }
			
		
		
	}



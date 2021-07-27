package appointment;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;


import javax.swing.JLabel;
import java.awt.Panel;

import javax.swing.border.TitledBorder;

import Database.DB;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dashboard_User extends JFrame {

	protected static final String String = null;
	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard_User frame = new Dashboard_User(String);
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
	public Dashboard_User(String id) {
		con =(Connection) DB.dbconnect();
		String name =null ;
		String email = null;
		String mobile_no = null;
		try {
			Statement statement;
			statement = con.createStatement();//crating statement object
	        String query = "select * from users where users_id = '" + id + "'";//Storing MySQL query in A string variable
	        ResultSet resultSet = statement.executeQuery(query);
			
	        while (resultSet.next()) {
	        	
	            name = resultSet.getString("username");
	            email = resultSet.getString("email");
	            mobile_no = resultSet.getString("mobile_no");
	            
//	            System.out.println("Name:"+name+ "Email:"+email+ "Mobile No:" +mobile_no);
	            
	        }
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(320,180,848,532);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(0, 0, 204, 500);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(245, 255, 250));
		panel_1.setBounds(0, 104, 204, 42);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbl_book_appointment = new JLabel("Book Appointment");
		lbl_book_appointment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_book_appointment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String get_id = "SELECT users_id FROM users WHERE users_id = '"+id+"' ";
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(get_id);
					if(rs.next()) {
						String id = rs.getString("users_id");
						appointment_form af = new appointment_form(id);
						af.show();
						dispose();
					}
					
					
				}
				catch(Exception e3) {
					System.out.println(e3);
				}
				
				
				
			}
		});
		lbl_book_appointment.setBounds(28, 11, 151, 19);
		panel_1.add(lbl_book_appointment);
		lbl_book_appointment.setForeground(new Color(100, 149, 237));
		lbl_book_appointment.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_book_appointment.setHorizontalAlignment(SwingConstants.CENTER);
		
		Panel panel_1_1 = new Panel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(245, 255, 250));
		panel_1_1.setBounds(0, 160, 204, 42);
		panel.add(panel_1_1);
		
		JLabel lbl_view_ppointment = new JLabel("View Appointment");	
		lbl_view_ppointment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_view_ppointment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String get_id = "SELECT users_id FROM users WHERE users_id = '"+id+"' ";
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(get_id);
					if(rs.next()) {
						String id = rs.getString("users_id");
						view_appointment va = new view_appointment(id);
						va.show();
						dispose();
					}
					
					
				}
				catch(Exception e3) {
					System.out.println(e3);
				}
			}
		});
		lbl_view_ppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_view_ppointment.setForeground(new Color(100, 149, 237));
		lbl_view_ppointment.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_view_ppointment.setBounds(28, 11, 151, 19);
		panel_1_1.add(lbl_view_ppointment);
		
		Panel panel_1_1_1 = new Panel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBackground(new Color(255, 127, 80));
		panel_1_1_1.setBounds(0, 437, 204, 42);
		panel.add(panel_1_1_1);
		
		JLabel lbl_logout = new JLabel("Logout");
		lbl_logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login l1 = new login();
				l1.show();
				dispose();
			}
		});
		lbl_logout.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_logout.setForeground(Color.WHITE);
		lbl_logout.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_logout.setBounds(28, 11, 151, 19);
		panel_1_1_1.add(lbl_logout);
		
		
		
		JLabel lblWelcome = new JLabel("ID");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(204, 0, 250, 46);
		contentPane.add(lblWelcome);
		
		String getValue = lblWelcome.getText();
		lblWelcome.setText(getValue+":"+id);
		
		lblWelcome.setForeground(new Color(100, 149, 237));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		
		JLabel lbl_details = new JLabel("Personal Details");
		lbl_details.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_details.setForeground(new Color(100, 149, 237));
		lbl_details.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_details.setBounds(210, 89, 168, 25);
		contentPane.add(lbl_details);
		

        JLabel lbl_name = new JLabel("Name");
		String name_value = lbl_name.getText();
		lbl_name.setText(name_value+":"+name);
		
		lbl_name.setForeground(new Color(100, 149, 237));
		lbl_name.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_name.setBounds(220, 125, 204, 19);
		contentPane.add(lbl_name);
		
		JLabel lbl_email = new JLabel("Email");
		String email_value = lbl_email.getText();
		lbl_email.setText(email_value+":"+email);
		
		lbl_email.setForeground(new Color(100, 149, 237));
		lbl_email.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_email.setBounds(220, 160, 204, 19);
		contentPane.add(lbl_email);
		
		JLabel lbl_mobile_no = new JLabel("Mobile No");
		String mobile_no_value = lbl_mobile_no.getText();
		lbl_mobile_no.setText(mobile_no_value+":"+mobile_no);
		
		lbl_mobile_no.setForeground(new Color(100, 149, 237));
		lbl_mobile_no.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_mobile_no.setBounds(220, 200, 204, 19);
		contentPane.add(lbl_mobile_no);

		
//		setUndecorated(true);
	}
	
}

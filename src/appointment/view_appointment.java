package appointment;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Database.DB;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Panel;


public class view_appointment extends JFrame {

	protected static final String String = null;
	private JPanel contentPane;
	Connection con = null;
	
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_appointment frame = new view_appointment(String);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param id 
	 */
	public view_appointment(String id) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				showdata(id);	
			}
		});
		con = DB.dbconnect();
		String name =null ;

		try {
			Statement statement;
			statement = con.createStatement();//crating statement object
	        String query = "select * from users where users_id = '" + id + "'";//Storing MySQL query in A string variable
	        ResultSet resultSet = statement.executeQuery(query);
			
	       if(resultSet.next()) {
	        	
	            name = resultSet.getString("username");
	        }
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(320,180,800,500);
		contentPane =  new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAppointmentDetails = new JLabel("Appointment Details");
		lblAppointmentDetails.setForeground(new Color(100, 149, 237));
		lblAppointmentDetails.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAppointmentDetails.setBounds(10, 22, 199, 28);
		contentPane.add(lblAppointmentDetails);
		
		
		
		JLabel lblId = new JLabel("Name");
		lblId.setForeground(new Color(100, 149, 237));
		lblId.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblId.setBounds(10, 61, 185, 28);
		contentPane.add(lblId);
		
		String getValue = lblId.getText();
		lblId.setText(getValue+":"+name);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 100, 764, 350);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 333, 744, -321);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
//				"ID", "Patient ID", "Doctor", "Date", "Time", "Date Of Booking"
			}
		));
		
		table.setBounds(10, 29, 742, 310);
		panel.add(table);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(100, 149, 237));
		panel_1.setBounds(10, 0, 135, 29);
		panel.add(panel_1);
		
		JLabel lblId_1 = new JLabel("ID");
		lblId_1.setForeground(Color.WHITE);
		lblId_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId_1.setBackground(new Color(100, 149, 237));
		panel_1.add(lblId_1);
		
		Panel panel_1_1 = new Panel();
		panel_1_1.setBackground(new Color(100, 149, 237));
		panel_1_1.setBounds(594, 0, 158, 29);
		panel.add(panel_1_1);
		
		JLabel lblId_1_1 = new JLabel("DateOfBooking");
		lblId_1_1.setForeground(Color.WHITE);
		lblId_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId_1_1.setBackground(new Color(100, 149, 237));
		panel_1_1.add(lblId_1_1);
		
		Panel panel_1_2 = new Panel();
		panel_1_2.setBackground(new Color(100, 149, 237));
		panel_1_2.setBounds(145, 0, 135, 29);
		panel.add(panel_1_2);
		
		JLabel lblId_1_2 = new JLabel("Doctor");
		lblId_1_2.setForeground(Color.WHITE);
		lblId_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId_1_2.setBackground(new Color(100, 149, 237));
		panel_1_2.add(lblId_1_2);
		
		Panel panel_1_3 = new Panel();
		panel_1_3.setBackground(new Color(100, 149, 237));
		panel_1_3.setBounds(279, 0, 152, 29);
		panel.add(panel_1_3);
		
		JLabel lblId_1_3 = new JLabel("Date");
		lblId_1_3.setForeground(Color.WHITE);
		lblId_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId_1_3.setBackground(new Color(100, 149, 237));
		panel_1_3.add(lblId_1_3);
		
		Panel panel_1_4 = new Panel();
		panel_1_4.setBackground(new Color(100, 149, 237));
		panel_1_4.setBounds(431, 0, 164, 29);
		panel.add(panel_1_4);
		
		JLabel lblId_1_4 = new JLabel("Time");
		lblId_1_4.setForeground(Color.WHITE);
		lblId_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId_1_4.setBackground(new Color(100, 149, 237));
		panel_1_4.add(lblId_1_4);
		
		
		JLabel lblGoBack = new JLabel("Go Back");
		lblGoBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblGoBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Dashboard_User du = new Dashboard_User(id);
				du.show();
				dispose();
			}
		});
		lblGoBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblGoBack.setForeground(new Color(100, 149, 237));
		lblGoBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGoBack.setBounds(681, 22, 93, 28);
		contentPane.add(lblGoBack);
		
//		setUndecorated(true);
	}
	
	private void showdata(String id) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
//		model.addColumn("Patient ID");
		model.addColumn("Doctor");
		model.addColumn("Date");
		model.addColumn("Time");
		model.addColumn("Date Of Booking");
//		model.addColumn("Patient Name");
		
		try {
			

			String sql = "SELECT appointments.*,users.name FROM appointments "
					+ "JOIN users ON appointments.patient_id = users.users_id WHERE users.users_id = '"+id+"'";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
//				System.out.println(rs.getString("doctor"));
				
				model.addRow(new Object[] {
				rs.getString("apt_id"), 
//				rs.getString("patient_id"),
				rs.getString("doctor"),
				rs.getString("date"),
				rs.getString("time"),
				rs.getString("dateofbooking"),
//				rs.getString("name"),
				
				});
			}
			
			table.setModel(model);
			
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(10);
			table.getColumnModel().getColumn(1).setPreferredWidth(10);
			table.getColumnModel().getColumn(2).setPreferredWidth(40);
			table.getColumnModel().getColumn(3).setPreferredWidth(40);
			table.getColumnModel().getColumn(4).setPreferredWidth(40);
//			table.getColumnModel().getColumn(5).setPreferredWidth(40);
//			table.getColumnModel().getColumn(6).setPreferredWidth(40);
			
	}
		
		catch(Exception e1) {
			System.out.println(e1);
		}
	}
}

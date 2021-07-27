package doctor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Database.DB;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Panel;

public class doctor_dashboard extends JFrame {

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
					doctor_dashboard frame = new doctor_dashboard(String);
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
	public doctor_dashboard(String id) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				showdata(id);	
			}
		});
		con = DB.dbconnect();
		con =(Connection) DB.dbconnect();
		String name =null ;
		
		try {
			Statement statement;
			statement = con.createStatement();//crating statement object
	        String query = "select * from doctors where id = '" + id + "'";//Storing MySQL query in A string variable
	        ResultSet resultSet = statement.executeQuery(query);
			
	        while (resultSet.next()) {
	        	
	            name = resultSet.getString("doctor_name");
	            
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
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setForeground(new Color(100, 149, 237));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblWelcome.setBounds(10, 61, 313, 28);
		contentPane.add(lblWelcome);
		
		String getValue = lblWelcome.getText();
		lblWelcome.setText(getValue+":"+name);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 93, 764, 357);
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

			}
		));

		table.setBounds(10, 32, 742, 307);
		panel.add(table);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(100, 149, 237));
		panel_1.setBounds(10, 0, 128, 29);
		panel.add(panel_1);
		
		JLabel lblId = new JLabel("ID");
		panel_1.add(lblId);
		lblId.setBackground(new Color(100, 149, 237));
		lblId.setForeground(new Color(255, 255, 255));
		lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(new Color(100, 149, 237));
		panel_2.setBounds(133, 0, 139, 29);
		panel.add(panel_2);
		
		JLabel lblAppointmentDate = new JLabel("Date");
		lblAppointmentDate.setForeground(Color.WHITE);
		lblAppointmentDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAppointmentDate.setBackground(new Color(100, 149, 237));
		panel_2.add(lblAppointmentDate);
		
		Panel panel_2_1 = new Panel();
		panel_2_1.setBackground(new Color(100, 149, 237));
		panel_2_1.setBounds(265, 0, 166, 29);
		panel.add(panel_2_1);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setForeground(Color.WHITE);
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTime.setBackground(new Color(100, 149, 237));
		panel_2_1.add(lblTime);
		
		Panel panel_2_2 = new Panel();
		panel_2_2.setBackground(new Color(100, 149, 237));
		panel_2_2.setBounds(428, 0, 166, 29);
		panel.add(panel_2_2);
		
		JLabel lblDateofbooking = new JLabel("DateOfBooking");
		lblDateofbooking.setForeground(Color.WHITE);
		lblDateofbooking.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDateofbooking.setBackground(new Color(100, 149, 237));
		panel_2_2.add(lblDateofbooking);
		
		Panel panel_2_3 = new Panel();
		panel_2_3.setBackground(new Color(100, 149, 237));
		panel_2_3.setBounds(588, 0, 166, 29);
		panel.add(panel_2_3);
		
		JLabel lblPatientAnme = new JLabel("Patient Name");
		lblPatientAnme.setForeground(Color.WHITE);
		lblPatientAnme.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPatientAnme.setBackground(new Color(100, 149, 237));
		panel_2_3.add(lblPatientAnme);
		
		JLabel lblLogout = new JLabel("Logout");
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				doctor_login dl = new doctor_login();
				dl.show();
				dispose();
			}
		});
		lblLogout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogout.setForeground(new Color(100, 149, 237));
		lblLogout.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLogout.setBounds(693, 22, 81, 28);
		contentPane.add(lblLogout);
		
		
//		setUndecorated(true);
	}
	
	private void showdata(String id) {
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("ID");
		model.addColumn("Date");
		model.addColumn("Time");
		model.addColumn("Date Of Booking");
		model.addColumn("Patient Name");
		
		try {
			
			String sql = "SELECT appointments.*,users.name ,doctors.doctor_name FROM appointments "
					+ "JOIN users ON appointments.patient_id = users.users_id "
					+ "JOIN doctors ON appointments.doctor_id = doctors.id WHERE appointments.doctor_id = '"+id+"'";
			
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
//				System.out.println(rs.getString("doctor"));
				
				model.addRow(new Object[] {
				rs.getString("apt_id"),
				rs.getString("date"),
				rs.getString("time"),
				rs.getString("dateofbooking"),
				rs.getString("name"),
				rs.getString("doctor_name"),
				
				
				});
			}
			table.setModel(model);
	
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(10);
			table.getColumnModel().getColumn(1).setPreferredWidth(10);
			table.getColumnModel().getColumn(2).setPreferredWidth(40);
			table.getColumnModel().getColumn(3).setPreferredWidth(40);
			table.getColumnModel().getColumn(4).setPreferredWidth(40);
		
		
			
	}
		
		catch(Exception e1) {
			System.out.println(e1);
		}
	}

	
}

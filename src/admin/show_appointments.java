package admin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import Database.DB;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Panel;

public class show_appointments extends JFrame {

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
					show_appointments frame = new show_appointments();
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
	public show_appointments() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
			 showdata();	
			}
		});
		con = DB.dbconnect();
		
		
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
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 53, 764, 397);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 333, 744, -321);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				
			}
		));
		table.setBounds(10, 30, 742, 356);
		panel.add(table);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(100, 149, 237));
		panel_1.setBounds(10, 0, 113, 29);
		panel.add(panel_1);
		
		JLabel lblId_1 = new JLabel("ID");
		lblId_1.setForeground(Color.WHITE);
		lblId_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId_1.setBackground(new Color(100, 149, 237));
		panel_1.add(lblId_1);
		
		Panel panel_1_1 = new Panel();
		panel_1_1.setBackground(new Color(100, 149, 237));
		panel_1_1.setBounds(635, 0, 119, 29);
		panel.add(panel_1_1);
		
		JLabel lblId_1_1 = new JLabel("Name");
		lblId_1_1.setForeground(Color.WHITE);
		lblId_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId_1_1.setBackground(new Color(100, 149, 237));
		panel_1_1.add(lblId_1_1);
		
		Panel panel_1_2 = new Panel();
		panel_1_2.setBackground(new Color(100, 149, 237));
		panel_1_2.setBounds(123, 0, 150, 29);
		panel.add(panel_1_2);
		
		JLabel lblId_1_2 = new JLabel("Doctor ");
		lblId_1_2.setForeground(Color.WHITE);
		lblId_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId_1_2.setBackground(new Color(100, 149, 237));
		panel_1_2.add(lblId_1_2);
		
		Panel panel_1_3 = new Panel();
		panel_1_3.setBackground(new Color(100, 149, 237));
		panel_1_3.setBounds(271, 0, 124, 29);
		panel.add(panel_1_3);
		
		JLabel lblId_1_3 = new JLabel("Date");
		lblId_1_3.setForeground(Color.WHITE);
		lblId_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId_1_3.setBackground(new Color(100, 149, 237));
		panel_1_3.add(lblId_1_3);
		
		Panel panel_1_4 = new Panel();
		panel_1_4.setBackground(new Color(100, 149, 237));
		panel_1_4.setBounds(394, 0, 123, 29);
		panel.add(panel_1_4);
		
		JLabel lblId_1_4 = new JLabel("Time");
		lblId_1_4.setForeground(Color.WHITE);
		lblId_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId_1_4.setBackground(new Color(100, 149, 237));
		panel_1_4.add(lblId_1_4);
		
		Panel panel_1_5 = new Panel();
		panel_1_5.setBackground(new Color(100, 149, 237));
		panel_1_5.setBounds(517, 0, 119, 29);
		panel.add(panel_1_5);
		
		JLabel lblId_1_5 = new JLabel("DateOfBooking");
		lblId_1_5.setForeground(Color.WHITE);
		lblId_1_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId_1_5.setBackground(new Color(100, 149, 237));
		panel_1_5.add(lblId_1_5);
		
		JLabel lblGoBack = new JLabel("Go Back");
		lblGoBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				admin_dashboard ad = new admin_dashboard();
				ad.show();
				dispose();
			}
		});
		lblGoBack.setForeground(new Color(100, 149, 237));
		lblGoBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGoBack.setBounds(689, 22, 85, 28);
		contentPane.add(lblGoBack);
		
		
		
		
//		setUndecorated(true);
	}
	
	private void showdata() {
		DefaultTableModel model = new DefaultTableModel();
		model = (DefaultTableModel)table.getModel();
		model.addColumn("ID");
//		model.addColumn("Patient ID");
		model.addColumn("Doctor");
		model.addColumn("Date");
		model.addColumn("Time");
		model.addColumn("Date Of Booking");
		model.addColumn("Patient Name");
		
		try {
			
			String sql = "SELECT appointments.*,users.name FROM appointments JOIN users ON appointments.patient_id = users.users_id";
//			
//			String sql = "SELECT * FROM appointments INNER JOIN users ON appointments.patient_id = users.id";
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
				rs.getString("name"),
				
				});
			}
			
//			table.setModel(model);
//			
			table.setAutoResizeMode(10);
			table.getColumnModel().getColumn(0).setPreferredWidth(5);
			table.getColumnModel().getColumn(1).setPreferredWidth(80);
			table.getColumnModel().getColumn(2).setPreferredWidth(30);
			table.getColumnModel().getColumn(3).setPreferredWidth(30);
			table.getColumnModel().getColumn(4).setPreferredWidth(50);
			table.getColumnModel().getColumn(5).setPreferredWidth(20);
//			
		
//			
		}
		
		catch(Exception e1) {
			System.out.println(e1);
		}
	
	}

}

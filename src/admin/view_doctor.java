package admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Database.DB;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Panel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Component;
import java.awt.Cursor;

public class view_doctor extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable table;
	private Panel panel_1;
	private JLabel lblId;
	private Panel panel_2;
	private JLabel lblAppointmentDate;
	private Panel panel_2_1;
	private JLabel lblTime;
	private Panel panel_2_2;
	private JLabel lblDateofbooking;
	private Panel panel_2_3;
	private JLabel lblPatientAnme;
	Connection con = null;
	private Panel panel_2_4;
	private JLabel lblAddress;
	private Panel panel_2_5;
	private JLabel lblGender;
	private Panel panel_2_6;
	private JLabel lblTime_1;
	private JLabel lblGoBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_doctor frame = new view_doctor();
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
	public view_doctor() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				showdata();	
			}
		});
		
		con = DB.dbconnect();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(320,180,882,546);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDoctorDetails = new JLabel("Doctor Details");
		lblDoctorDetails.setForeground(new Color(100, 149, 237));
		lblDoctorDetails.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDoctorDetails.setBounds(10, 11, 199, 28);
		contentPane.add(lblDoctorDetails);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 67, 846, 429);
		contentPane.add(panel);
		
		scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(10, 333, 744, -321);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBounds(10, 32, 826, 397);
		panel.add(table);
		
		panel_1 = new Panel();
		panel_1.setBackground(new Color(100, 149, 237));
		panel_1.setBounds(10, 0, 83, 29);
		panel.add(panel_1);
		
		lblId = new JLabel("ID");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId.setBackground(new Color(100, 149, 237));
		panel_1.add(lblId);
		
		panel_2_1 = new Panel();
		panel_2_1.setBackground(new Color(100, 149, 237));
		panel_2_1.setBounds(172, 0, 114, 29);
		panel.add(panel_2_1);
		
		lblTime = new JLabel("Email");
		lblTime.setForeground(Color.WHITE);
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTime.setBackground(new Color(100, 149, 237));
		panel_2_1.add(lblTime);
		
		panel_2_2 = new Panel();
		panel_2_2.setBackground(new Color(100, 149, 237));
		panel_2_2.setBounds(381, 0, 114, 29);
		panel.add(panel_2_2);
		
		lblDateofbooking = new JLabel("Age");
		lblDateofbooking.setForeground(Color.WHITE);
		lblDateofbooking.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDateofbooking.setBackground(new Color(100, 149, 237));
		panel_2_2.add(lblDateofbooking);
		
		panel_2_3 = new Panel();
		panel_2_3.setBackground(new Color(100, 149, 237));
		panel_2_3.setBounds(591, 0, 132, 29);
		panel.add(panel_2_3);
		
		lblPatientAnme = new JLabel("Specialization");
		lblPatientAnme.setForeground(Color.WHITE);
		lblPatientAnme.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPatientAnme.setBackground(new Color(100, 149, 237));
		panel_2_3.add(lblPatientAnme);
		
		panel_2 = new Panel();
		panel_2.setBounds(72, 0, 101, 29);
		panel.add(panel_2);
		panel_2.setBackground(new Color(100, 149, 237));
		
		lblAppointmentDate = new JLabel("Name");
		lblAppointmentDate.setForeground(Color.WHITE);
		lblAppointmentDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAppointmentDate.setBackground(new Color(100, 149, 237));
		panel_2.add(lblAppointmentDate);
		
		panel_2_4 = new Panel();
		panel_2_4.setBackground(new Color(100, 149, 237));
		panel_2_4.setBounds(278, 0, 114, 29);
		panel.add(panel_2_4);
		
		lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddress.setBackground(new Color(100, 149, 237));
		panel_2_4.add(lblAddress);
		
		panel_2_5 = new Panel();
		panel_2_5.setBackground(new Color(100, 149, 237));
		panel_2_5.setBounds(487, 0, 107, 29);
		panel.add(panel_2_5);
		
		lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGender.setBackground(new Color(100, 149, 237));
		panel_2_5.add(lblGender);
		
		panel_2_6 = new Panel();
		panel_2_6.setBackground(new Color(100, 149, 237));
		panel_2_6.setBounds(722, 0, 114, 29);
		panel.add(panel_2_6);
		
		lblTime_1 = new JLabel("Experience");
		lblTime_1.setForeground(Color.WHITE);
		lblTime_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTime_1.setBackground(new Color(100, 149, 237));
		panel_2_6.add(lblTime_1);
		
		lblGoBack = new JLabel("Go Back");
		lblGoBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		lblGoBack.setBounds(775, 11, 81, 28);
		contentPane.add(lblGoBack);
	}
	private void showdata() {
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Email");
		model.addColumn("Address");
		model.addColumn("Age");
		model.addColumn("Gender");
		model.addColumn("Specialization");
		model.addColumn("Experirence");
		//model.addColumn("Doctor Name");
		
		try {
			
			String sql = "SELECT * FROM doctors";
				
			
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
//				System.out.println(rs.getString("doctor"));
				
				model.addRow(new Object[] {
				rs.getString("id"),
				rs.getString("doctor_name"),
				rs.getString("doctor_email"),
				rs.getString("doctor_address"),
				rs.getString("doctor_age"),
				rs.getString("doctor_gender"),
				rs.getString("doctor_specialization"),
				rs.getString("doctor_experience"),				
				
				});
			}
			table.setModel(model);
	
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(10);
			table.getColumnModel().getColumn(1).setPreferredWidth(10);
			table.getColumnModel().getColumn(2).setPreferredWidth(40);
			table.getColumnModel().getColumn(3).setPreferredWidth(40);
			table.getColumnModel().getColumn(4).setPreferredWidth(40);
			table.getColumnModel().getColumn(5).setPreferredWidth(40);
			table.getColumnModel().getColumn(6).setPreferredWidth(40);
			table.getColumnModel().getColumn(7).setPreferredWidth(40);
//			table.getColumnModel().getColumn(8).setPreferredWidth(40);
		
			
	}
		
		catch(Exception e1) {
			System.out.println(e1);
		}
	}
}

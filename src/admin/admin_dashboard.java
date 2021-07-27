package admin;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class admin_dashboard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_dashboard frame = new admin_dashboard();
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
	public admin_dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(320,180,800,500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(10, 0, 10, 500);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(100, 149, 237));
		panel_1.setBounds(74, 76, 138, 59);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbl_Add_Doctor = new JLabel("Add Doctor");
		lbl_Add_Doctor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_Add_Doctor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				add_doctor ad1 = new add_doctor();
				ad1.show();
				dispose();
			}
		});
		lbl_Add_Doctor.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Add_Doctor.setForeground(new Color(255, 255, 255));
		lbl_Add_Doctor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_Add_Doctor.setBounds(10, 11, 118, 37);
		panel_1.add(lbl_Add_Doctor);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(100, 149, 237));
		panel_1_1.setBounds(340, 76, 138, 59);
		contentPane.add(panel_1_1);
		
		JLabel lbl_View_Doctor = new JLabel("View Doctor");
		lbl_View_Doctor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				view_doctor vd = new view_doctor();
				vd.show();
				dispose();
			}
		});
		lbl_View_Doctor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_View_Doctor.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_View_Doctor.setForeground(Color.WHITE);
		lbl_View_Doctor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_View_Doctor.setBounds(10, 11, 118, 37);
		panel_1_1.add(lbl_View_Doctor);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBackground(new Color(100, 149, 237));
		panel_1_1_1.setBounds(591, 76, 160, 59);
		contentPane.add(panel_1_1_1);
		
		JLabel lbl_View_Appointment = new JLabel("View Appointment");
		lbl_View_Appointment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_View_Appointment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				show_appointments sa = new show_appointments();
				sa.show();
			
			}
		});
		lbl_View_Appointment.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_View_Appointment.setForeground(Color.WHITE);
		lbl_View_Appointment.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_View_Appointment.setBounds(10, 11, 140, 37);
		panel_1_1_1.add(lbl_View_Appointment);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(new Color(100, 149, 237));
		panel_1_2.setBounds(340, 186, 138, 37);
		contentPane.add(panel_1_2);
		
		JLabel lbl_logout = new JLabel("Logout");
		lbl_logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				admin_login al = new admin_login();
				al.show();
				dispose();
			}
		});
		lbl_logout.setBounds(10, 0, 118, 37);
		panel_1_2.add(lbl_logout);
		lbl_logout.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_logout.setForeground(Color.WHITE);
		lbl_logout.setFont(new Font("Tahoma", Font.BOLD, 15));
//		setUndecorated(true);
		
	}
}

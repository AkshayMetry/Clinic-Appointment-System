package appointment;
import Database.DB;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Panel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.JComboBox;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class appointment_form<TilePane, DatePicker> extends JFrame {

	protected static final String String = null;
	private JPanel contentPane;
	Connection con = null;
	Statement st = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					appointment_form frame = new appointment_form(String);
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
	public appointment_form(String id) {
		
		con = DB.dbconnect();
		String name = null;
		try {
		String query = "SELECT * FROM users WHERE users_id = '"+id+"' ";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		if(rs.next()) {
	           name = rs.getString("username");
	        }
		}
		catch(Exception e1) {
			System.out.println(e1);
		}
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(320,180,800,500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(10, 0, 10, 500);
		contentPane.add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("Book Appointment");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(100, 149, 237));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(51, 9, 173, 28);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(new Color(100, 149, 237));
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDate.setBounds(51, 169, 52, 28);
		contentPane.add(lblDate);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setForeground(new Color(100, 149, 237));
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTime.setBounds(51, 223, 52, 28);
		contentPane.add(lblTime);
		
		JLabel lblDoctor = new JLabel("Doctor");
		lblDoctor.setForeground(new Color(100, 149, 237));
		lblDoctor.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDoctor.setBounds(51, 111, 70, 28);
		contentPane.add(lblDoctor);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(166, 114, 301, 28);
		contentPane.add(comboBox);
		
		
		
		try {
			st = con.createStatement();
			String query = "select * from doctors";
			ResultSet rs = st.executeQuery(query);
		        while(rs.next())
		        {
//		        	
		         comboBox.addItem(rs.getString(1)+ ". " +rs.getString(2)+" -- "+rs.getString(7));
		        }
		        
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR CLOSE");
		}
		
		
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(166, 169, 301, 28);
		contentPane.add(dateChooser);
		
		String time[]={"10:00am - 10:30","10:30 - 11:00","11.00 - 11:30","11.30 - 12:00","12:00 - 12:30","12:30 - 1:00"}; 
		JComboBox comboBoxTime = new JComboBox(time);
		 
		comboBoxTime.setBounds(166, 223, 301, 28);
		contentPane.add(comboBoxTime);
		
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(new Color(100, 149, 237));
		lblId.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblId.setBounds(51, 58, 152, 28);  
		contentPane.add(lblId);
		
		String getValue = lblId.getText();
		lblId.setText(getValue+":"+id);
		
		JLabel lblname = new JLabel("Name");
		lblname.setForeground(new Color(100, 149, 237));
		lblname.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblname.setBounds(243, 58, 152, 28);
		contentPane.add(lblname);
	
		String getname = lblname.getText();
		lblname.setText(getname+":"+name);
		
		JButton btnNewButton = new JButton("Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String doctor = (String) comboBox.getSelectedItem();
					String get_id[] = doctor.split(". ");
//			       
					String time = (String) comboBoxTime.getSelectedItem();
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					String date = sdf.format(dateChooser.getDate());
					
					
					
					PreparedStatement pst = (PreparedStatement) con.prepareStatement("INSERT INTO appointments(patient_id,doctor_id,doctor,date,time)"
							+ " VALUES('"+id+"','"+get_id[0]+"','"+doctor+"','"+date+"','"+time+"') ");
					pst.executeUpdate();
//					
					
					JOptionPane.showMessageDialog(null," Booked Succesfully");
				}
				catch(Exception e2){
					System.out.println(e2);
				}
				
			}
		});
		btnNewButton.setForeground(new Color(100, 149, 237));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(61, 302, 112, 37);
		contentPane.add(btnNewButton);
		
		JLabel lblGo_Back = new JLabel("Go Back");
		lblGo_Back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblGo_Back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Dashboard_User du = new Dashboard_User(id);
				du.show();
				dispose();
				
			}
		});
		lblGo_Back.setHorizontalAlignment(SwingConstants.CENTER);
		lblGo_Back.setForeground(new Color(100, 149, 237));
		lblGo_Back.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGo_Back.setBounds(676, 9, 98, 28);
		contentPane.add(lblGo_Back);
		
		
		
		
//		setUndecorated(true);
		
		
	}
}

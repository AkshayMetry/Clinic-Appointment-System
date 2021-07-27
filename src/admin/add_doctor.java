package admin;
import Database.DB;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class add_doctor extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textEmail;
	private JTextArea textAddress;
	private JTextField textAge;
	private JTextField textExperience;
	private JTextField textUsername;
	private JPasswordField passwordField;
	private JComboBox comboBox;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_doctor frame = new add_doctor();
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
	private JTextField textField;
	public add_doctor() {
		
		con =(Connection) DB.dbconnect();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(320,180,827,542);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdd_Doctor = new JLabel("Add Doctor");
		lblAdd_Doctor.setForeground(new Color(255, 255, 255));
		lblAdd_Doctor.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAdd_Doctor.setBounds(43, 23, 118, 30);
		contentPane.add(lblAdd_Doctor);
		
		JLabel lbl_doctor_name = new JLabel("Name");
		lbl_doctor_name.setForeground(new Color(255, 255, 255));
		lbl_doctor_name.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_doctor_name.setBounds(43, 90, 81, 25);
		contentPane.add(lbl_doctor_name);
		
		JLabel lbl_doctor_email = new JLabel("Email");
		lbl_doctor_email.setForeground(Color.WHITE);
		lbl_doctor_email.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_doctor_email.setBounds(43, 126, 81, 25);
		contentPane.add(lbl_doctor_email);
		
		JLabel lbl_doctor_address = new JLabel("Address");
		lbl_doctor_address.setForeground(Color.WHITE);
		lbl_doctor_address.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_doctor_address.setBounds(43, 162, 81, 25);
		contentPane.add(lbl_doctor_address);
		
		JLabel lbl_doctor_age = new JLabel("Age");
		lbl_doctor_age.setForeground(Color.WHITE);
		lbl_doctor_age.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_doctor_age.setBounds(43, 220, 81, 25);
		contentPane.add(lbl_doctor_age);
		
		JLabel lbl_doctor_specialist = new JLabel("Specialist");
		lbl_doctor_specialist.setForeground(Color.WHITE);
		lbl_doctor_specialist.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_doctor_specialist.setBounds(43, 261, 105, 25);
		contentPane.add(lbl_doctor_specialist);
		
		JLabel lbl_doctor_experience = new JLabel("Experience(Yr)");
		lbl_doctor_experience.setForeground(Color.WHITE);
		lbl_doctor_experience.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_doctor_experience.setBounds(43, 309, 139, 25);
		contentPane.add(lbl_doctor_experience);
		
		JLabel lbl_doctor_username = new JLabel("Username");
		lbl_doctor_username.setForeground(Color.WHITE);
		lbl_doctor_username.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_doctor_username.setBounds(43, 350, 105, 25);
		contentPane.add(lbl_doctor_username);
		
		JLabel lbl_doctor_password = new JLabel("Password");
		lbl_doctor_password.setForeground(Color.WHITE);
		lbl_doctor_password.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_doctor_password.setBounds(43, 386, 105, 25);
		contentPane.add(lbl_doctor_password);
		
		textName = new JTextField();
		textName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textName.setBounds(192, 79, 437, 30);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textEmail.setColumns(10);
		textEmail.setBounds(192, 120, 437, 30);
		contentPane.add(textEmail);
		
		textAge = new JTextField();
		textAge.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textAge.setColumns(10);
		textAge.setBounds(192, 220, 126, 30);
		contentPane.add(textAge);
		
		String doctor_specialist[]={"Select","Dentist","Pediatrician","Dermatologist","Physician"};   
		JComboBox comboBox = new JComboBox(doctor_specialist);
		
		comboBox.setBounds(192, 261, 437, 30);
		contentPane.add(comboBox);
		
		textExperience = new JTextField();
		textExperience.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textExperience.setColumns(10);
		textExperience.setBounds(192, 302, 437, 30);
		contentPane.add(textExperience);
		
		textUsername = new JTextField();
		textUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textUsername.setColumns(10);
		textUsername.setBounds(192, 345, 437, 30);
		contentPane.add(textUsername);
		
		
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBounds(192, 391, 437, 30);
		contentPane.add(passwordField);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setForeground(new Color(100, 149, 237));
		rdbtnMale.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnMale.setBounds(418, 220, 71, 30);
		contentPane.add(rdbtnMale);
		
		JLabel lblNewLabel = new JLabel("Gender");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(348, 222, 59, 28);
		contentPane.add(lblNewLabel);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setForeground(new Color(100, 149, 237));
		rdbtnFemale.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnFemale.setBounds(508, 220, 88, 30);
		contentPane.add(rdbtnFemale);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnFemale);
		bg.add(rdbtnMale);
		
		
		
		
		
		textAddress = new JTextArea();
		textAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textAddress.setBounds(192, 165, 437, 44);
		contentPane.add(textAddress);
		
//		setUndecorated(true);
		
		
		JButton btnAdd_Doctor = new JButton("Add Doctor");
		btnAdd_Doctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String name = textName.getText();
				String email = textEmail.getText();
				String address = textAddress.getText();
				String age = textAge.getText();
				
				String gender;
				if(rdbtnFemale.isSelected()) {
					gender = "Female";
				}
				else {
					gender = "Male";
				}
				
				String specialist = (String) comboBox.getSelectedItem();
				
				
				String experience = textExperience.getText();
				String username = textUsername.getText();
				String password = passwordField.getText();
				
				System.out.printf("Name:"+name+", Email:"+email+", Address:"+address+", age:"+age+"Gender:"+gender+"Specialist:"+specialist+"Experirence:"+experience+"Username:"+username+"Password:"+password);
				PreparedStatement pst = (PreparedStatement) con.prepareStatement("INSERT INTO doctors(doctor_name,doctor_email,doctor_address,doctor_age,doctor_gender,doctor_specialization,doctor_experience,doctor_username,doctor_password) "
					+ "values('"+name+"','"+email+"','"+address+"','"+age+"','"+gender+"','"+specialist+"','"+experience+"','"+username+"','"+password+"')");
				pst.executeUpdate();
				
				JOptionPane.showMessageDialog(null,"Registered Succesfully");

				
			}
			
			catch(Exception e1) {
				System.out.println(e1);
			}
			}
		});
		btnAdd_Doctor.setForeground(new Color(100, 149, 237));
		btnAdd_Doctor.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd_Doctor.setBounds(192, 444, 172, 30);
		contentPane.add(btnAdd_Doctor);
		
		JLabel lblAdd_Doctor_1 = new JLabel("Go Back");
		lblAdd_Doctor_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				admin_dashboard ad = new admin_dashboard();
				ad.show();
				dispose();
			}
		});
		lblAdd_Doctor_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdd_Doctor_1.setForeground(Color.WHITE);
		lblAdd_Doctor_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAdd_Doctor_1.setBounds(683, 23, 118, 30);
		contentPane.add(lblAdd_Doctor_1);
		
		}
	}


//	public void add(){
//		
//		try {
//			
//			
//			 
//			//String specialist =(String) comboBox.getSelectedItem(); 
//			
//			
//			
//			
////			PreparedStatement pst = (PreparedStatement) con.prepareStatement("INSERT INTO doctors(doctor_name,doctor_email,doctor_address,doctor_age,doctor_gender,doctor_specialization,doctor_experience,doctor_username,doctor_password) "
////					+ "values('"+name+"','"+email+"','"+address+"','"+age+"','"+gender+"','"+specialist+"','"+experience+"','"+username+"','"+password+"')");
////			pst.executeUpdate();
//			JOptionPane.showMessageDialog(null,"Doctor Registered Successfully");
//		}
//		catch(Exception e1) {
//			System.out.println(e1);
//		}
//	}
//}

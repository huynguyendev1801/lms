package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Session.Session;
import DAO.EmployeeDAO;
public class LoginGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmployeeId;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
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
	public LoginGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 432, 256);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ĐĂNG NHẬP");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(20, 21, 376, 50);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(30, 71, 356, 86);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 5, 336, 34);
		panel.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Mã nhân viên:");
		lblNewLabel_1.setBounds(23, 10, 99, 13);
		panel_1.add(lblNewLabel_1);
		
		txtEmployeeId = new JTextField();
		txtEmployeeId.setColumns(10);
		txtEmployeeId.setBounds(119, 7, 196, 19);
		panel_1.add(txtEmployeeId);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(10, 49, 336, 34);
		panel.add(panel_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu:");
		lblNewLabel_1_1.setBounds(23, 10, 77, 13);
		panel_1_1.add(lblNewLabel_1_1);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(119, 7, 196, 19);
		panel_1_1.add(txtPassword);
		
		JButton btnLogin = new JButton("Đăng nhập");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnLogin.setBounds(254, 157, 102, 21);
		contentPane.add(btnLogin);
	}
	private void login() {
		 String employeeId = txtEmployeeId.getText();
		 String password = new String(txtPassword.getPassword());
		 if(employeeId.equals("")) {
			 JOptionPane.showMessageDialog(null, "Vui lòng nhập mã nhân viên!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			 return;
		 }
		 if (password.equals("")) {
			 JOptionPane.showMessageDialog(null, "Vui lòng nhập mật khẩu!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			 return;
		 }
		 Session.employeeLog = EmployeeDAO.login(employeeId, password);
		 if(Session.employeeLog != null) {
			 JOptionPane.showMessageDialog(null, "Đăng nhập thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			 MainGUI gui= new MainGUI();
			 this.dispose();
			 gui.setVisible(true);
		 }
		 else {
			 JOptionPane.showMessageDialog(null, "Thông tin đăng nhập không chính xác!", "Thông báo", JOptionPane.WARNING_MESSAGE);
		 }	 
	}
}

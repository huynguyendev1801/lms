package GUI;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import DAO.EmployeeDAO;
import DTO.EmployeeDTO;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EmployeeGUI extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtEmployeeId;
	private JTextField txtPassword;
	private JTextField txtPhoneNumber;
	private JTextField txtEmployeeName;
	private JTable table;
	JDateChooser dateBirthDate;
	JComboBox cboRole;
	/**
	 * Create the panel.
	 */
	public EmployeeGUI() {
		setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(837, 35, 294, 208);
		add(panel_2);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add();
			}
		});
		btnAdd.setBounds(101, 36, 85, 21);
		panel_2.add(btnAdd);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnDelete.setBounds(101, 137, 85, 21);
		panel_2.add(btnDelete);
		
		JButton btnUpdate = new JButton("Sửa");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edit();
			}
		});
		btnUpdate.setBounds(101, 82, 85, 21);
		panel_2.add(btnUpdate);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(64, 35, 753, 208);
		add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(27, 33, 336, 34);
		panel_1.add(panel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Mã nhân viên:");
		lblNewLabel_1.setBounds(23, 10, 99, 13);
		panel_1_1.add(lblNewLabel_1);
		
		txtEmployeeId = new JTextField();
		txtEmployeeId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				  if (txtEmployeeId.getText().length() >= 6) {
	                    e.consume();
	                }
			}
		});
		txtEmployeeId.setColumns(10);
		txtEmployeeId.setBounds(119, 7, 196, 19);
		panel_1_1.add(txtEmployeeId);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBounds(373, 33, 336, 34);
		panel_1.add(panel_1_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu:");
		lblNewLabel_1_1.setBounds(23, 10, 99, 13);
		panel_1_1_1.add(lblNewLabel_1_1);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(119, 7, 196, 19);
		panel_1_1_1.add(txtPassword);
		
		JPanel panel_1_1_2 = new JPanel();
		panel_1_1_2.setLayout(null);
		panel_1_1_2.setBounds(27, 140, 336, 34);
		panel_1.add(panel_1_1_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Số điện thoại:");
		lblNewLabel_1_2.setBounds(23, 10, 99, 13);
		panel_1_1_2.add(lblNewLabel_1_2);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBounds(119, 7, 196, 19);
		panel_1_1_2.add(txtPhoneNumber);
		
		JPanel panel_1_1_3 = new JPanel();
		panel_1_1_3.setLayout(null);
		panel_1_1_3.setBounds(27, 87, 336, 34);
		panel_1.add(panel_1_1_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("Họ tên:");
		lblNewLabel_1_3.setBounds(23, 10, 99, 13);
		panel_1_1_3.add(lblNewLabel_1_3);
		
		txtEmployeeName = new JTextField();
		txtEmployeeName.setColumns(10);
		txtEmployeeName.setBounds(119, 7, 196, 19);
		panel_1_1_3.add(txtEmployeeName);
		
		JPanel panel_1_1_4 = new JPanel();
		panel_1_1_4.setLayout(null);
		panel_1_1_4.setBounds(373, 140, 336, 34);
		panel_1.add(panel_1_1_4);
		
		JLabel lblNewLabel_1_4 = new JLabel("Ngày sinh:");
		lblNewLabel_1_4.setBounds(23, 10, 99, 13);
		panel_1_1_4.add(lblNewLabel_1_4);
		
		dateBirthDate = new JDateChooser();
		dateBirthDate.setDateFormatString("dd/MM/yyyy");
		dateBirthDate.setBounds(116, 10, 194, 19);
		panel_1_1_4.add(dateBirthDate);
		
		JPanel panel_1_1_5 = new JPanel();
		panel_1_1_5.setLayout(null);
		panel_1_1_5.setBounds(373, 87, 336, 34);
		panel_1.add(panel_1_1_5);
		
		JLabel lblNewLabel_1_5 = new JLabel("Chức vụ:");
		lblNewLabel_1_5.setBounds(23, 10, 99, 13);
		panel_1_1_5.add(lblNewLabel_1_5);
		
		cboRole = new JComboBox();
		cboRole.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Nhân viên"}));
		cboRole.setBounds(118, 6, 194, 21);
		panel_1_1_5.add(cboRole);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "B\u1EA3ng danh m\u1EE5c nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(64, 269, 1067, 365);
		add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 46, 955, 277);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				TableMouseClicked();
			}
		});
		scrollPane.setViewportView(table);
		LoadDataToTable();

	}
	private void TableMouseClicked() {
		 int selectedRow = table.getSelectedRow();
	        if (selectedRow >= 0) {
	        	
	      	  String employeeId = table.getValueAt(selectedRow, 0).toString();
		        String employeeName = table.getValueAt(selectedRow, 1).toString();
		        String birthDate = table.getValueAt(selectedRow, 2).toString();
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	            Date date = null;
	            try {
	                date = dateFormat.parse(birthDate);
	            } catch (ParseException e) {
	                e.printStackTrace();
	            }
	            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		       
		        String phoneNumber = table.getValueAt(selectedRow, 3).toString();
		        String role = table.getValueAt(selectedRow, 4).toString();
		        String password = table.getValueAt(selectedRow, 5).toString();
		        txtEmployeeId.setText(employeeId);
	            txtEmployeeName.setText(employeeName);
	            dateBirthDate.setDate(sqlDate);
	            txtPhoneNumber.setText(phoneNumber);
	            cboRole.setSelectedItem(role);
	            txtPassword.setText(password);
	        }
	        
	}
	private void LoadDataToTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        List<EmployeeDTO> lst = EmployeeDAO.getAll();
		   model.setColumnCount(0);
		   model.setRowCount(0);
		   model.addColumn("Mã nhân viên");
		   model.addColumn("Tên nhân viên");
		   model.addColumn("Ngày sinh");
		   model.addColumn("Số điện thoại");
		   model.addColumn("Quyền");
		   model.addColumn("Mật khẩu");
       for (EmployeeDTO item : lst) {
           Object[] rowData = {item.getEmployeeId(), item.getEmployeeName(), item.getBirthDate(), item.getPhoneNumber(), item.getRole(), item.getPassword()};
           model.addRow(rowData);
       }
	}
	private void add() {
		  String employeeId = txtEmployeeId.getText();
	        String employeeName = txtEmployeeName.getText();
	        Date birthDate = dateBirthDate.getDate();
	        String phoneNumber = txtPhoneNumber.getText();
	        String role = cboRole.getSelectedItem().toString();
	        String password = txtPassword.getText();
	        if (employeeId.equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập mã nhân viên!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
                return;
            } else if (employeeName.equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập họ tên!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
                return;
            } else if (birthDate == null) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày sinh!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            else if (phoneNumber.equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            else if (password.equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập mật khẩu!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            EmployeeDTO existingEmployee = EmployeeDAO.getByEmployeeId(employeeId);
            if (existingEmployee != null) {
                JOptionPane.showMessageDialog(this, "Mã nhân viên đã tồn tại!\nVui lòng nhập mã nhân viên khác.", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
                return;
            }
        
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setEmployeeId(employeeId);
            employeeDTO.setEmployeeName(employeeName);
            employeeDTO.setBirthDate(birthDate);
            employeeDTO.setPhoneNumber(phoneNumber);
            employeeDTO.setRole(role);
            employeeDTO.setPassword(password);
            if (EmployeeDAO.insert(employeeDTO)) {
                JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công!", "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
                LoadDataToTable();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm nhân viên không thành công!", "Lỗi!", JOptionPane.ERROR_MESSAGE);
                

            }
         

	}
	private void edit() {
		  String employeeId = txtEmployeeId.getText();
	        String employeeName = txtEmployeeName.getText();
	        Date birthDate = dateBirthDate.getDate();
	        String phoneNumber = txtPhoneNumber.getText();
	        String role = cboRole.getSelectedItem().toString();
	        String password = txtPassword.getText();
	        if (employeeId.equals("")) {
              JOptionPane.showMessageDialog(this, "Vui lòng nhập mã nhân viên!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
              return;
          } else if (employeeName.equals("")) {
              JOptionPane.showMessageDialog(this, "Vui lòng nhập họ tên!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
              return;
          } else if (birthDate == null) {
              JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày sinh!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
              return;
          }
          else if (phoneNumber.equals("")) {
              JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
              return;
          }
          else if (password.equals("")) {
              JOptionPane.showMessageDialog(this, "Vui lòng nhập mật khẩu!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
              return;
          }
          EmployeeDTO existingEmployee = EmployeeDAO.getByEmployeeId(employeeId);
          if (existingEmployee == null) {
              JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên cần sửa!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
              return;
          }
      
          EmployeeDTO employeeDTO = new EmployeeDTO();
          employeeDTO.setEmployeeId(employeeId);
          employeeDTO.setEmployeeName(employeeName);
          employeeDTO.setBirthDate(birthDate);
          employeeDTO.setPhoneNumber(phoneNumber);
          employeeDTO.setRole(role);
          employeeDTO.setPassword(password);
          if (EmployeeDAO.update(employeeDTO)) {
              JOptionPane.showMessageDialog(this, "Sửa nhân viên thành công!", "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
              LoadDataToTable();
          } else {
              JOptionPane.showMessageDialog(this, "Sửa nhân viên không thành công!", "Lỗi!", JOptionPane.ERROR_MESSAGE);
              

          }
       

	}
	private void delete() {
		 int selectedRow = table.getSelectedRow();
	        if (selectedRow >= 0) {
	            String employeeId = table.getValueAt(selectedRow, 0).toString();

	            int option = JOptionPane.showConfirmDialog(this, "Bạn có chắn chắc muốn xóa nhân viên?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
	            if (option == JOptionPane.YES_OPTION) {
	                if (EmployeeDAO.delete(employeeId)) {
	                    JOptionPane.showMessageDialog(this, "Xóa nhân viên thành công!", "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
	                    LoadDataToTable();
	                } else {
	                    JOptionPane.showMessageDialog(this, "Xóa nhân viên không thành công!", "Lỗi!", JOptionPane.ERROR_MESSAGE);
	                }

	            }
	        }
	        else {
	         JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên cần sửa!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
	        }
	}

}

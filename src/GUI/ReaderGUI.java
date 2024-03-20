package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import DAO.ReaderDAO;
import DTO.ReaderDTO;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ReaderGUI extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtReaderId;
	private JTextField txtPhoneNumber;
	private JTextField txtReaderName;
	private JTable table;
	JDateChooser dateBirthDate;
	private JTextField txtAddress;
	/**
	 * Create the panel.
	 */
	public ReaderGUI() {
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
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin \u0111\u1ED9c gi\u1EA3", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(64, 35, 753, 208);
		add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(27, 33, 336, 34);
		panel_1.add(panel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Mã độc giả:");
		lblNewLabel_1.setBounds(23, 10, 99, 13);
		panel_1_1.add(lblNewLabel_1);
		
		txtReaderId = new JTextField();
		txtReaderId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				  if (txtReaderId.getText().length() >= 6) {
	                    e.consume();
	                }
			}
		});
		txtReaderId.setColumns(10);
		txtReaderId.setBounds(119, 7, 196, 19);
		panel_1_1.add(txtReaderId);
		
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
		
		txtReaderName = new JTextField();
		txtReaderName.setColumns(10);
		txtReaderName.setBounds(119, 7, 196, 19);
		panel_1_1_3.add(txtReaderName);
		
		JPanel panel_1_1_4 = new JPanel();
		panel_1_1_4.setLayout(null);
		panel_1_1_4.setBounds(373, 33, 336, 34);
		panel_1.add(panel_1_1_4);
		
		JLabel lblNewLabel_1_4 = new JLabel("Ngày sinh:");
		lblNewLabel_1_4.setBounds(23, 10, 99, 13);
		panel_1_1_4.add(lblNewLabel_1_4);
		
		dateBirthDate = new JDateChooser();
		dateBirthDate.setDateFormatString("dd/MM/yyyy");
		dateBirthDate.setBounds(116, 10, 194, 19);
		panel_1_1_4.add(dateBirthDate);
		
		JPanel panel_1_1_3_1 = new JPanel();
		panel_1_1_3_1.setLayout(null);
		panel_1_1_3_1.setBounds(373, 87, 336, 34);
		panel_1.add(panel_1_1_3_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Địa chỉ:");
		lblNewLabel_1_3_1.setBounds(23, 10, 99, 13);
		panel_1_1_3_1.add(lblNewLabel_1_3_1);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(119, 7, 196, 19);
		panel_1_1_3_1.add(txtAddress);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "B\u1EA3ng danh m\u1EE5c \u0111\u1ED9c gi\u1EA3", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
	        	
	      	  String ReaderId = table.getValueAt(selectedRow, 0).toString();
		        String readerName = table.getValueAt(selectedRow, 1).toString();
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
		        
		        String address = table.getValueAt(selectedRow, 4).toString();
		        txtReaderId.setText(ReaderId);
	            txtReaderName.setText(readerName);
	            dateBirthDate.setDate(sqlDate);
	            txtPhoneNumber.setText(phoneNumber);
	            txtAddress.setText(address);
	        }
	        
	}
	private void LoadDataToTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        List<ReaderDTO> lst = ReaderDAO.getAll();
		   model.setColumnCount(0);
		   model.setRowCount(0);
		   model.addColumn("Mã độc giả");
		   model.addColumn("Tên độc giả");
		   model.addColumn("Ngày sinh");
		   model.addColumn("Số điện thoại");
		   model.addColumn("Địa chỉ");
       for (ReaderDTO item : lst) {
           Object[] rowData = {item.getReaderId(), item.getReaderName(), item.getBirthDate(), item.getPhoneNumber(), item.getAddress()};
           model.addRow(rowData);
       }
	}
	private void add() {
		  String readerId = txtReaderId.getText();
	        String readerName = txtReaderName.getText();
	        Date birthDate = dateBirthDate.getDate();
	        String phoneNumber = txtPhoneNumber.getText();
	        String address = txtAddress.getText();
	        if (readerId.equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập mã độc giả!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
                return;
            } else if (readerName.equals("")) {
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
            else if (address.equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập địa chỉ!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
                return;
            }
        
            ReaderDTO existingreader = ReaderDAO.getByReaderId(readerId);
            if (existingreader != null) {
                JOptionPane.showMessageDialog(this, "Mã độc giả đã tồn tại!\nVui lòng nhập mã độc giả khác.", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
                return;
            }
        
            ReaderDTO readerDTO = new ReaderDTO();
            readerDTO.setReaderId(readerId);
            readerDTO.setReaderName(readerName);
            readerDTO.setBirthDate(birthDate);
            readerDTO.setPhoneNumber(phoneNumber);
            readerDTO.setAddress(address);
            if (ReaderDAO.insert(readerDTO)) {
                JOptionPane.showMessageDialog(this, "Thêm độc giả thành công!", "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
                LoadDataToTable();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm độc giả không thành công!", "Lỗi!", JOptionPane.ERROR_MESSAGE);
                

            }
         

	}
	private void edit() {
		  String readerId = txtReaderId.getText();
	        String readerName = txtReaderName.getText();
	        Date birthDate = dateBirthDate.getDate();
	        String phoneNumber = txtPhoneNumber.getText();
	        String address = txtAddress.getText();
	        if (readerId.equals("")) {
              JOptionPane.showMessageDialog(this, "Vui lòng nhập mã độc giả!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
              return;
          } else if (readerName.equals("")) {
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
          else if (address.equals("")) {
              JOptionPane.showMessageDialog(this, "Vui lòng nhập địa chỉ!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
              return;
          }
      
          ReaderDTO existingreader = ReaderDAO.getByReaderId(readerId);
          if (existingreader == null) {
              JOptionPane.showMessageDialog(this, "Vui lòng chọn độc giả cần sửa!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
              return;
          }
      
          ReaderDTO readerDTO = new ReaderDTO();
          readerDTO.setReaderId(readerId);
          readerDTO.setReaderName(readerName);
          readerDTO.setBirthDate(birthDate);
          readerDTO.setPhoneNumber(phoneNumber);
          readerDTO.setAddress(address);
          if (ReaderDAO.update(readerDTO)) {
              JOptionPane.showMessageDialog(this, "Sửa độc giả thành công!", "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
              LoadDataToTable();
          } else {
              JOptionPane.showMessageDialog(this, "Sửa độc giả không thành công!", "Lỗi!", JOptionPane.ERROR_MESSAGE);
              

          }
       

	}
	private void delete() {
		 int selectedRow = table.getSelectedRow();
	        if (selectedRow >= 0) {
	            String readerId = table.getValueAt(selectedRow, 0).toString();

	            int option = JOptionPane.showConfirmDialog(this, "Bạn có chắn chắc muốn xóa độc giả?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
	            if (option == JOptionPane.YES_OPTION) {
	                if (ReaderDAO.delete(readerId)) {
	                    JOptionPane.showMessageDialog(this, "Xóa độc giả thành công!", "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
	                    LoadDataToTable();
	                } else {
	                    JOptionPane.showMessageDialog(this, "Xóa độc giả không thành công!", "Lỗi!", JOptionPane.ERROR_MESSAGE);
	                }

	            }
	        }
	        else {
	         JOptionPane.showMessageDialog(this, "Vui lòng chọn độc giả cần sửa!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
	        }
	}
}

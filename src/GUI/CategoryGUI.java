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

import javax.swing.JButton;
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

import DAO.CategoryDAO;
import DTO.CategoryDTO;
import javax.swing.JEditorPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CategoryGUI extends JPanel {


	private static final long serialVersionUID = 1L;
	private JTextField txtCategoryId;
	private JTextField txtCategoryName;
	private JTable table;
	JEditorPane txtDescription;
	/**
	 * Create the panel.
	 */
	public CategoryGUI() {
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
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin lo\u1EA1i s\u00E1ch", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(64, 35, 753, 208);
		add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(27, 33, 336, 34);
		panel_1.add(panel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Mã loại sách:");
		lblNewLabel_1.setBounds(23, 10, 99, 13);
		panel_1_1.add(lblNewLabel_1);
		
		txtCategoryId = new JTextField();
		txtCategoryId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				 if (txtCategoryId.getText().length() >= 6) {
	                    e.consume();
	                }
			}
		});
		txtCategoryId.setColumns(10);
		txtCategoryId.setBounds(119, 7, 196, 19);
		panel_1_1.add(txtCategoryId);
		
		JPanel panel_1_1_2 = new JPanel();
		panel_1_1_2.setLayout(null);
		panel_1_1_2.setBounds(27, 77, 682, 110);
		panel_1.add(panel_1_1_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mô tả:");
		lblNewLabel_1_2.setBounds(23, 10, 99, 13);
		panel_1_1_2.add(lblNewLabel_1_2);
		
		 txtDescription = new JEditorPane();
		txtDescription.setBounds(120, 10, 539, 90);
		panel_1_1_2.add(txtDescription);
		
		JPanel panel_1_1_3 = new JPanel();
		panel_1_1_3.setLayout(null);
		panel_1_1_3.setBounds(373, 33, 336, 34);
		panel_1.add(panel_1_1_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("Tên loại sách:");
		lblNewLabel_1_3.setBounds(23, 10, 99, 13);
		panel_1_1_3.add(lblNewLabel_1_3);
		
		txtCategoryName = new JTextField();
		txtCategoryName.setColumns(10);
		txtCategoryName.setBounds(119, 7, 196, 19);
		panel_1_1_3.add(txtCategoryName);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "B\u1EA3ng danh m\u1EE5c lo\u1EA1i s\u00E1ch", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
	        	
	      	  String categoryId = table.getValueAt(selectedRow, 0).toString();
		        String categoryName = table.getValueAt(selectedRow, 1).toString();
		        String description = table.getValueAt(selectedRow, 2).toString();
		        txtCategoryId.setText(categoryId);
	            txtCategoryName.setText(categoryName);
	            txtDescription.setText(description);
	        
	         
	        }
	        
	}
	private void LoadDataToTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        List<CategoryDTO> lst = CategoryDAO.getAll();
		   model.setColumnCount(0);
		   model.setRowCount(0);
		   model.addColumn("Mã loại sách");
		   model.addColumn("Tên loại sách");
		   model.addColumn("Mô tả");
	
       for (CategoryDTO item : lst) {
           Object[] rowData = {item.getCategoryId(), item.getCategoryName(), item.getDescription()};
           model.addRow(rowData);
       }
	}
	private void add() {
		  String categoryId = txtCategoryId.getText();
	        String categoryName = txtCategoryName.getText();
	        String description = txtDescription.getText();
	
	        if (categoryId.equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập mã loại sách", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
                return;
            } else if (categoryName.equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập tên loại sách!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
                return;
            } 
            else if (description.equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
                return;
            }
        
            CategoryDTO existingCategory = CategoryDAO.getByCategoryID(categoryId);
            if (existingCategory != null) {
                JOptionPane.showMessageDialog(this, "Mã loại sách đã tồn tại!\nVui lòng nhập mã loại sách khác.", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            existingCategory = CategoryDAO.getByCategoryName(categoryName);
            if (existingCategory != null) {
                JOptionPane.showMessageDialog(this, "Tên loại sách đã tồn tại!\nVui lòng nhập tên loại sách khác.", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            CategoryDTO CategoryDTO = new CategoryDTO();
            CategoryDTO.setCategoryId(categoryId);
            CategoryDTO.setCategoryName(categoryName);
            CategoryDTO.setDescription(description);
    
            if (CategoryDAO.insert(CategoryDTO)) {
                JOptionPane.showMessageDialog(this, "Thêm loại sách thành công!", "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
                LoadDataToTable();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm loại sách không thành công!", "Lỗi!", JOptionPane.ERROR_MESSAGE);
                

            }
         

	}
	private void edit() {
		String categoryId = txtCategoryId.getText();
        String categoryName = txtCategoryName.getText();
        String description = txtDescription.getText();
	
        if (categoryId.equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã loại sách", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (categoryName.equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên loại sách!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
            return;
        } 
        else if (description.equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
            return;
        }
    
        
        CategoryDTO existingCategory = CategoryDAO.getByCategoryID(categoryId);
          if (existingCategory == null) {
              JOptionPane.showMessageDialog(this, "Vui lòng chọn loại sách cần sửa!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
              return;
          }
      
          CategoryDTO CategoryDTO = new CategoryDTO();
          CategoryDTO.setCategoryId(categoryId);
          CategoryDTO.setCategoryName(categoryName);
          CategoryDTO.setDescription(description);
    
          if (CategoryDAO.update(CategoryDTO)) {
              JOptionPane.showMessageDialog(this, "Sửa loại sách thành công!", "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
              LoadDataToTable();
          } else {
              JOptionPane.showMessageDialog(this, "Sửa loại sách không thành công!", "Lỗi!", JOptionPane.ERROR_MESSAGE);
              

          }
       

	}
	private void delete() {
		 int selectedRow = table.getSelectedRow();
	        if (selectedRow >= 0) {
	            String categoryrId = table.getValueAt(selectedRow, 0).toString();

	            int option = JOptionPane.showConfirmDialog(this, "Bạn có chắn chắc muốn xóa độc giả?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
	            if (option == JOptionPane.YES_OPTION) {
	                if (CategoryDAO.delete(categoryrId)) {
	                    JOptionPane.showMessageDialog(this, "Xóa loại sách thành công!", "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
	                    LoadDataToTable();
	                } else {
	                    JOptionPane.showMessageDialog(this, "Xóa loại sách không thành công!", "Lỗi!", JOptionPane.ERROR_MESSAGE);
	                }

	            }
	        }
	        else {
	         JOptionPane.showMessageDialog(this, "Vui lòng chọn loại sách cần sửa!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
	        }
	}
}

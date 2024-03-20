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

import DAO.BookDAO;
import DAO.CategoryDAO;
import DTO.BookDTO;
import DTO.CategoryDTO;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class BookGUI extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	private JTextField txtBookId;
	private JTextField txtAuthorName;
	private JTextField txtProductionYear;
	private JTextField txtBookName;
	private JTable table;
	JComboBox cboCategory;
	private JTextField txtPublisherName;
	private JTextField txtTimKiem;
	/**
	 * Create the panel.
	 */
	public BookGUI() {
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
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin s\u00E1ch", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(64, 35, 753, 208);
		add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(27, 33, 336, 34);
		panel_1.add(panel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Mã sách:");
		lblNewLabel_1.setBounds(23, 10, 99, 13);
		panel_1_1.add(lblNewLabel_1);
		
		txtBookId = new JTextField();
		txtBookId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				  if (txtBookId.getText().length() >= 6) {
	                    e.consume();
	                }
			}
		});
		txtBookId.setColumns(10);
		txtBookId.setBounds(119, 7, 196, 19);
		panel_1_1.add(txtBookId);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBounds(373, 33, 336, 34);
		panel_1.add(panel_1_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tác giả:");
		lblNewLabel_1_1.setBounds(23, 10, 99, 13);
		panel_1_1_1.add(lblNewLabel_1_1);
		
		txtAuthorName = new JTextField();
		txtAuthorName.setColumns(10);
		txtAuthorName.setBounds(119, 7, 196, 19);
		panel_1_1_1.add(txtAuthorName);
		
		JPanel panel_1_1_2 = new JPanel();
		panel_1_1_2.setLayout(null);
		panel_1_1_2.setBounds(27, 140, 336, 34);
		panel_1.add(panel_1_1_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Năm xuất bản:");
		lblNewLabel_1_2.setBounds(23, 10, 99, 13);
		panel_1_1_2.add(lblNewLabel_1_2);
		
		txtProductionYear = new JTextField();
		txtProductionYear.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				   if (!Character.isDigit(c)) {
	                    e.consume();
	                }
			}
		});
		txtProductionYear.setColumns(10);
		txtProductionYear.setBounds(119, 7, 196, 19);
		panel_1_1_2.add(txtProductionYear);
		
		JPanel panel_1_1_3 = new JPanel();
		panel_1_1_3.setLayout(null);
		panel_1_1_3.setBounds(27, 87, 336, 34);
		panel_1.add(panel_1_1_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("Tên sách:");
		lblNewLabel_1_3.setBounds(23, 10, 99, 13);
		panel_1_1_3.add(lblNewLabel_1_3);
		
		txtBookName = new JTextField();
		txtBookName.setColumns(10);
		txtBookName.setBounds(119, 7, 196, 19);
		panel_1_1_3.add(txtBookName);
		
		JPanel panel_1_1_4 = new JPanel();
		panel_1_1_4.setLayout(null);
		panel_1_1_4.setBounds(373, 140, 336, 34);
		panel_1.add(panel_1_1_4);
		
		JLabel lblNewLabel_1_4 = new JLabel("Nhà xuất bản:");
		lblNewLabel_1_4.setBounds(23, 10, 99, 13);
		panel_1_1_4.add(lblNewLabel_1_4);
		
		txtPublisherName = new JTextField();
		txtPublisherName.setColumns(10);
		txtPublisherName.setBounds(118, 7, 196, 19);
		panel_1_1_4.add(txtPublisherName);
		
		JPanel panel_1_1_5 = new JPanel();
		panel_1_1_5.setLayout(null);
		panel_1_1_5.setBounds(373, 87, 336, 34);
		panel_1.add(panel_1_1_5);
		
		JLabel lblNewLabel_1_5 = new JLabel("Loại sách:");
		lblNewLabel_1_5.setBounds(23, 10, 99, 13);
		panel_1_1_5.add(lblNewLabel_1_5);
		
		cboCategory = new JComboBox();
		cboCategory.setBounds(118, 6, 194, 21);
		panel_1_1_5.add(cboCategory);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "B\u1EA3ng danh m\u1EE5c s\u00E1ch", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(64, 311, 1067, 323);
		add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 36, 955, 277);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				TableMouseClicked();
			}
		});
		scrollPane.setViewportView(table);
		
		JPanel panel_1_1_4_1 = new JPanel();
		panel_1_1_4_1.setLayout(null);
		panel_1_1_4_1.setBounds(795, 253, 336, 34);
		add(panel_1_1_4_1);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Tìm kiếm:");
		lblNewLabel_1_4_1.setBounds(23, 10, 99, 13);
		panel_1_1_4_1.add(lblNewLabel_1_4_1);
		
		txtTimKiem = new JTextField();
		txtTimKiem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				TimKiem();
			}
		});
	
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(118, 7, 196, 19);
		panel_1_1_4_1.add(txtTimKiem);
		LoadDataToTable();
		LoadDataCategoryToComboBox() ;

	}
	private void TableMouseClicked() {
		 int selectedRow = table.getSelectedRow();
	        if (selectedRow >= 0) {
	        	
	      	  String bookyId = table.getValueAt(selectedRow, 0).toString();
		        String bookName = table.getValueAt(selectedRow, 1).toString();
		        String category = table.getValueAt(selectedRow, 2).toString();
		       
		        String productionYear = table.getValueAt(selectedRow, 3).toString();
		        String authorName = table.getValueAt(selectedRow, 4).toString();
		        String publishername = table.getValueAt(selectedRow, 5).toString();
		        txtBookId.setText(bookyId);
	            txtBookName.setText(bookName);
	            cboCategory.setSelectedItem(category);
	            txtProductionYear.setText(productionYear);
	            txtAuthorName.setText(authorName);
	            txtPublisherName.setText(publishername);
	        }
	        
	}
	private void LoadDataToTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        List<BookDTO> lst = BookDAO.getAll();
		   model.setColumnCount(0);
		   model.setRowCount(0);
		   model.addColumn("Mã sách");
		   model.addColumn("Tên sách");
		   model.addColumn("Loại sách");
		   model.addColumn("Năm xuất bản");
		   model.addColumn("Tác giả");
		   model.addColumn("Nhà xuất bản");
       for (BookDTO item : lst) {
           Object[] rowData = {item.getBookId(), item.getBookName(), item.getCategory().getCategoryName(), item.getProductionYear(), item.getAuthorName(), item.getPublisherName()};
           model.addRow(rowData);
       }
	}
	private void TimKiem() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String query = txtTimKiem.getText();
        List<BookDTO> lst = BookDAO.getByBookName(query);
		  
		   model.setRowCount(0);

       for (BookDTO item : lst) {
           Object[] rowData = {item.getBookId(), item.getBookName(), item.getCategory().getCategoryName(), item.getProductionYear(), item.getAuthorName(), item.getPublisherName()};
           model.addRow(rowData);
       }
	}
	  public void LoadDataCategoryToComboBox() {
	       
	                List<CategoryDTO> lst = CategoryDAO.getAll();
	        
	                    cboCategory.removeAllItems();

	                    for (CategoryDTO item : lst) {
	                    	cboCategory.addItem(item.getCategoryName());

	                    }
	             
	  }
	 
	private void add() {
		  String bookId = txtBookId.getText();
	        String bookName = txtBookName.getText();
	        CategoryDTO categoryDTO = CategoryDAO.getByCategoryName(cboCategory.getSelectedItem().toString());
	        String productionYear = txtProductionYear.getText();
	        String authorName = txtAuthorName.getText();
	        String publisherName = txtPublisherName.getText();
	        if (bookId.equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sách!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
                return;
            } else if (bookName.equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập tên sách!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
                return;
            } 
            
            else if (productionYear.equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập năm xuất bản!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            else if (authorName.equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập tác giả!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            else if (publisherName.equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập nhà xuất bản!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            BookDTO existingBook = BookDAO.getByBookId(bookId);
            if (existingBook != null) {
                JOptionPane.showMessageDialog(this, "Mã sách đã tồn tại!\nVui lòng nhập mã sách khác.", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
                return;
            }
        
            BookDTO bookDTO = new BookDTO();
            bookDTO.setBookId(bookId);
            bookDTO.setBookName(bookName);
            bookDTO.setCategory(categoryDTO);
            bookDTO.setProductionYear(Integer.parseInt(productionYear));
            bookDTO.setAuthorName(authorName);
            bookDTO.setPublisherName(publisherName);
            if (BookDAO.insert(bookDTO)) {
                JOptionPane.showMessageDialog(this, "Thêm sách thành công!", "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
                LoadDataToTable();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm sách không thành công!", "Lỗi!", JOptionPane.ERROR_MESSAGE);
                

            }
         

	}
	private void edit() {
		 String bookId = txtBookId.getText();
	        String bookName = txtBookName.getText();
	        CategoryDTO categoryDTO = CategoryDAO.getByCategoryName(cboCategory.getSelectedItem().toString());
	        String productionYear = txtProductionYear.getText();
	        String authorName = txtAuthorName.getText();
	        String publisherName = txtPublisherName.getText();
	        if (bookId.equals("")) {
             JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sách!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
             return;
         } else if (bookName.equals("")) {
             JOptionPane.showMessageDialog(this, "Vui lòng nhập tên sách!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
             return;
         } 
         
         else if (productionYear.equals("")) {
             JOptionPane.showMessageDialog(this, "Vui lòng nhập năm xuất bản!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
             return;
         }
         else if (authorName.equals("")) {
             JOptionPane.showMessageDialog(this, "Vui lòng nhập tác giả!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
             return;
         }
         else if (publisherName.equals("")) {
             JOptionPane.showMessageDialog(this, "Vui lòng nhập nhà xuất bản!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
             return;
         }
         BookDTO existingBook = BookDAO.getByBookId(bookId);
         if (existingBook == null) {
             JOptionPane.showMessageDialog(this, "Vui lòng chọn sách cần sửa", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
             return;
         }
     
         BookDTO bookDTO = new BookDTO();
         bookDTO.setBookId(bookId);
         bookDTO.setBookName(bookName);
         bookDTO.setCategory(categoryDTO);
         bookDTO.setProductionYear(Integer.parseInt(productionYear));
         bookDTO.setAuthorName(authorName);
         bookDTO.setPublisherName(publisherName);
         if (BookDAO.update(bookDTO)) {
             JOptionPane.showMessageDialog(this, "Sửa sách thành công!", "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
             LoadDataToTable();
         } else {
             JOptionPane.showMessageDialog(this, "Sửa sách không thành công!", "Lỗi!", JOptionPane.ERROR_MESSAGE);
             

         }
	}
	private void delete() {
		 int selectedRow = table.getSelectedRow();
	        if (selectedRow >= 0) {
	            String bookId = table.getValueAt(selectedRow, 0).toString();

	            int option = JOptionPane.showConfirmDialog(this, "Bạn có chắn chắc muốn xóa sách?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
	            if (option == JOptionPane.YES_OPTION) {
	                if (BookDAO.delete(bookId)) {
	                    JOptionPane.showMessageDialog(this, "Xóa sách thành công!", "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
	                    LoadDataToTable();
	                } else {
	                    JOptionPane.showMessageDialog(this, "Xóa sách không thành công!", "Lỗi!", JOptionPane.ERROR_MESSAGE);
	                }

	            }
	        }
	        else {
	         JOptionPane.showMessageDialog(this, "Vui lòng chọn sách cần sửa!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
	        }
	}
}

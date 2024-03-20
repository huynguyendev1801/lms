package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

import DAO.BookDAO;
import DAO.BorrowDAO;
import DAO.CategoryDAO;
import DAO.EmployeeDAO;
import DAO.ReaderDAO;
import DTO.BookDTO;
import DTO.BorrowDTO;
import DTO.CategoryDTO;
import DTO.EmployeeDTO;
import DTO.ReaderDTO;

import com.toedter.calendar.JDateChooser;

public class BorrowGUI extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	private JTextField txtBorrowId;
	private JTable table;
	JComboBox cboReader;
	private JTextField txtEmployee;
	JDateChooser dateBorrowDate;
	JComboBox cboBook;
	JDateChooser dateReturnDueDate;
	private JTextField txtReturnDate;
	JButton btnUpdate ;
	/**
	 * Create the panel.
	 */
	public BorrowGUI() {
		setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(837, 35, 294, 262);
		add(panel_2);
		
		JButton btnAdd = new JButton("Mượn sách");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add();
			}
		});
		btnAdd.setBounds(81, 36, 137, 21);
		panel_2.add(btnAdd);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnDelete.setBounds(81, 137, 137, 21);
		panel_2.add(btnDelete);
		
		 btnUpdate = new JButton("Trả sách");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edit();
			}
		});
		btnUpdate.setBounds(81, 82, 137, 21);
		panel_2.add(btnUpdate);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin phi\u1EBFu m\u01B0\u1EE3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(64, 35, 753, 262);
		add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(27, 33, 336, 34);
		panel_1.add(panel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Mã phiếu mượn:");
		lblNewLabel_1.setBounds(23, 10, 99, 13);
		panel_1_1.add(lblNewLabel_1);
		
		txtBorrowId = new JTextField();
		txtBorrowId.setEditable(false);
		txtBorrowId.setColumns(10);
		txtBorrowId.setBounds(119, 7, 196, 19);
		panel_1_1.add(txtBorrowId);
		
		JPanel panel_1_1_5 = new JPanel();
		panel_1_1_5.setLayout(null);
		panel_1_1_5.setBounds(27, 140, 336, 34);
		panel_1.add(panel_1_1_5);
		
		JLabel lblNewLabel_1_5 = new JLabel("Độc giả:");
		lblNewLabel_1_5.setBounds(23, 10, 99, 13);
		panel_1_1_5.add(lblNewLabel_1_5);
		
		cboReader = new JComboBox();
		cboReader.setBounds(118, 6, 194, 21);
		panel_1_1_5.add(cboReader);
		
		JPanel panel_1_1_4_1 = new JPanel();
		panel_1_1_4_1.setLayout(null);
		panel_1_1_4_1.setBounds(373, 33, 336, 34);
		panel_1.add(panel_1_1_4_1);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Ngày mượn:");
		lblNewLabel_1_4_1.setBounds(23, 10, 99, 13);
		panel_1_1_4_1.add(lblNewLabel_1_4_1);
		
		 dateBorrowDate = new JDateChooser();
		dateBorrowDate.setDateFormatString("dd/MM/yyyy");
		dateBorrowDate.setBounds(116, 10, 194, 19);
		panel_1_1_4_1.add(dateBorrowDate);
		
		JPanel panel_1_1_4_1_1 = new JPanel();
		panel_1_1_4_1_1.setLayout(null);
		panel_1_1_4_1_1.setBounds(27, 87, 336, 34);
		panel_1.add(panel_1_1_4_1_1);
		
		JLabel lblNewLabel_1_4_1_1 = new JLabel("Ngày hẹn trả:");
		lblNewLabel_1_4_1_1.setBounds(23, 10, 99, 13);
		panel_1_1_4_1_1.add(lblNewLabel_1_4_1_1);
		
		 dateReturnDueDate = new JDateChooser();
		dateReturnDueDate.setDateFormatString("dd/MM/yyyy");
		dateReturnDueDate.setBounds(120, 10, 194, 19);
		panel_1_1_4_1_1.add(dateReturnDueDate);
		
		JPanel panel_1_1_4_1_1_1 = new JPanel();
		panel_1_1_4_1_1_1.setLayout(null);
		panel_1_1_4_1_1_1.setBounds(373, 87, 336, 34);
		panel_1.add(panel_1_1_4_1_1_1);
		
		JLabel lblNewLabel_1_4_1_1_1 = new JLabel("Ngày trả thực tế:");
		lblNewLabel_1_4_1_1_1.setBounds(23, 10, 99, 13);
		panel_1_1_4_1_1_1.add(lblNewLabel_1_4_1_1_1);
		
		txtReturnDate = new JTextField();
		txtReturnDate.setEditable(false);
		txtReturnDate.setColumns(10);
		txtReturnDate.setBounds(115, 7, 196, 19);
		panel_1_1_4_1_1_1.add(txtReturnDate);
		
		JPanel panel_1_1_5_1 = new JPanel();
		panel_1_1_5_1.setLayout(null);
		panel_1_1_5_1.setBounds(373, 140, 336, 34);
		panel_1.add(panel_1_1_5_1);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("Sách:");
		lblNewLabel_1_5_1.setBounds(23, 10, 99, 13);
		panel_1_1_5_1.add(lblNewLabel_1_5_1);
		
		 cboBook = new JComboBox();
		cboBook.setBounds(118, 6, 194, 21);
		panel_1_1_5_1.add(cboBook);
		
		JPanel panel_1_1_5_2 = new JPanel();
		panel_1_1_5_2.setLayout(null);
		panel_1_1_5_2.setBounds(27, 193, 336, 34);
		panel_1.add(panel_1_1_5_2);
		
		JLabel lblNewLabel_1_5_2 = new JLabel("Nhân viên:");
		lblNewLabel_1_5_2.setBounds(23, 10, 99, 13);
		panel_1_1_5_2.add(lblNewLabel_1_5_2);
		
		txtEmployee = new JTextField();
		txtEmployee.setEditable(false);
		txtEmployee.setColumns(10);
		txtEmployee.setBounds(118, 7, 196, 19);
		panel_1_1_5_2.add(txtEmployee);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "B\u1EA3ng danh m\u1EE5c phi\u1EBFu m\u01B0\u1EE3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(64, 319, 1067, 315);
		add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 35, 955, 246);
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
		LoadDataReaderToComboBox();
		LoadDataBookToComboBox();

	}
	private void TableMouseClicked() {
		 int selectedRow = table.getSelectedRow();
	        if (selectedRow >= 0) {
	        	
	      	  String borrowId = table.getValueAt(selectedRow, 0).toString();
		        String stringBorrowDate = table.getValueAt(selectedRow, 1).toString();
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	            Date borrowDate = null;
	            try {
	            	borrowDate = dateFormat.parse(stringBorrowDate);
	            } catch (ParseException e) {
	                e.printStackTrace();
	            }
	            java.sql.Date sqlDateBorrowDate = new java.sql.Date(borrowDate.getTime());
		        String stringReturnDueDate = table.getValueAt(selectedRow, 2).toString();
		        Date returnDueDate= null;
	            try {
	            	returnDueDate = dateFormat.parse(stringReturnDueDate);
	            } catch (ParseException e) {
	                e.printStackTrace();
	            }
	            java.sql.Date sqlDateReturnDueDate= new java.sql.Date(returnDueDate.getTime());
		        String stringReturnDate = table.getValueAt(selectedRow, 3) == null ? "Chưa trả" :table.getValueAt(selectedRow, 3).toString();
		        if(stringReturnDate.equals("Chưa trả"))
		        {
		        	btnUpdate.setEnabled(true);
		        }
		        else {
		        	btnUpdate.setEnabled(false);
		        }
		        
		        String readerId = table.getValueAt(selectedRow, 4).toString();
		        String readerName = table.getValueAt(selectedRow, 5).toString();
		        String bookId = table.getValueAt(selectedRow, 6).toString();
		        String bookName = table.getValueAt(selectedRow, 7).toString();
		        String employee = table.getValueAt(selectedRow, 8).toString();
		        txtBorrowId.setText(borrowId);
	            dateBorrowDate.setDate(sqlDateReturnDueDate);
	            dateReturnDueDate.setDate(sqlDateReturnDueDate);
	            txtReturnDate.setText(stringReturnDate);
	         
	            cboReader.setSelectedItem(readerId + " - " + readerName);
	            cboBook.setSelectedItem(bookId + " - " + bookName);
	            txtEmployee.setText(employee);
	        }
	        
	}
	private void LoadDataToTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        List<BorrowDTO> lst = BorrowDAO.getAll();
		   model.setColumnCount(0);
		   model.setRowCount(0);
		   model.addColumn("Mã phiếu mượn");
		   model.addColumn("Ngày mượn");
		   model.addColumn("Ngày hẹn trả");
		   model.addColumn("Ngày trả");
		   model.addColumn("Mã độc giả");
		   model.addColumn("Tên độc giả");
		   model.addColumn("Mã sách");
		   model.addColumn("Tên sách");
		   model.addColumn("Nhân viên");
       for (BorrowDTO item : lst) {
           Object[] rowData = {item.getBorrowId(), item.getBorrowDate(), item.getReturnDueDate(), item.getReturnDate() == null ? "Chưa trả": item.getReturnDate(), item.getReader().getReaderId(), item.getReader().getReaderName(), item.getBook().getBookId(), item.getBook().getBookName(), item.getEmployee().getEmployeeName()};
           model.addRow(rowData);
       }
	}
	  public void LoadDataReaderToComboBox() {
	       
	                List<ReaderDTO> lst = ReaderDAO.getAll();
	        
	                    cboReader.removeAllItems();

	                    for (ReaderDTO item : lst) {
	                    	cboReader.addItem(item.getReaderId() + " - " + item.getReaderName());

	                    }
	  }
	  public void LoadDataBookToComboBox() {
	       
          List<BookDTO> lst = BookDAO.getAll();
  
              cboBook.removeAllItems();

              for (BookDTO item : lst) {
            	  cboBook.addItem(item.getBookId() + " - " + item.getBookName());

              }
}
	 
	private void add() {
		  String borrowId = txtBorrowId.getText();
	        Date borrowDate = dateBorrowDate.getDate();
	        Date returnDueDate = dateReturnDueDate.getDate();
	        ReaderDTO reader = ReaderDAO.getByReaderId(cboReader.getSelectedItem().toString().split(" - ")[0]);
	        BookDTO book = BookDAO.getByBookId(cboBook.getSelectedItem().toString().split(" - ")[0]);
	      
	        if (borrowDate == null) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày mượn sách!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
                return;
            } else if (returnDueDate == null) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày hẹn trả!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
                return;
            } 
            
        
            BorrowDTO borrowDTO = new BorrowDTO();
            borrowDTO.setBorrowDate(borrowDate);
            borrowDTO.setReturnDueDate(returnDueDate);
            borrowDTO.setReader(reader);
            borrowDTO.setBook(book);
            borrowDTO.setEmployee(Session.Session.employeeLog);
            if (BorrowDAO.insert(borrowDTO)) {
                JOptionPane.showMessageDialog(this, "Mượn sách thành công!", "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
                LoadDataToTable();
            } else {
                JOptionPane.showMessageDialog(this, "Mượn sách không thành công!", "Lỗi!", JOptionPane.ERROR_MESSAGE);
            }
         

	}
	private void edit() {
		 String borrowId = txtBorrowId.getText();
	       
       
     
		  BorrowDTO borrowDTO = new BorrowDTO();
          borrowDTO.setBorrowId(Integer.parseInt(borrowId));
         if (BorrowDAO.update(borrowDTO)) {
             JOptionPane.showMessageDialog(this, "Trả sách thành công!", "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
             LoadDataToTable();
         } else {
             JOptionPane.showMessageDialog(this, "Trả sách không thành công!", "Lỗi!", JOptionPane.ERROR_MESSAGE);
             

         }
	}
	private void delete() {
		 int selectedRow = table.getSelectedRow();
	        if (selectedRow >= 0) {
	            String borrowId = table.getValueAt(selectedRow, 0).toString();

	            int option = JOptionPane.showConfirmDialog(this, "Bạn có chắn chắc muốn xóa phiếu mượn?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
	            if (option == JOptionPane.YES_OPTION) {
	                if (BorrowDAO.delete(Integer.parseInt(borrowId))) {
	                    JOptionPane.showMessageDialog(this, "Xóa phiếu mượn thành công!", "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
	                    LoadDataToTable();
	                } else {
	                    JOptionPane.showMessageDialog(this, "Xóa phiếu mượn không thành công!", "Lỗi!", JOptionPane.ERROR_MESSAGE);
	                }

	            }
	        }
	        else {
	         JOptionPane.showMessageDialog(this, "Vui lòng chọn phiếu mượn cần sửa!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
	        }
	}
}

package GUI;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

public class MainGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
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
	public MainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 702);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuOption = new JMenu("Tùy chọn");
		menuBar.add(menuOption);
		
		JMenuItem menuItemHome = new JMenuItem("Trang chủ");
		menuItemHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showHomeGUI();
			}
		});
		menuOption.add(menuItemHome);
		
		JMenuItem menuItemExit = new JMenuItem("Thoát");
		menuItemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuOption.add(menuItemExit);
		
		JMenu menuCategory = new JMenu("Danh mục");
		menuBar.add(menuCategory);
		
		JMenuItem menuItemCategory = new JMenuItem("Thể loại");
		menuItemCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showCategoryGUI();
			}
		});
		menuItemCategory.setActionCommand("Thể loại");
		menuCategory.add(menuItemCategory);
		
		JMenuItem menuItemEmployee = new JMenuItem("Nhân viên");
		menuItemEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showEmployeeGUI();   
			}
		});
		menuCategory.add(menuItemEmployee);
		
		JMenuItem menuItemReader = new JMenuItem("Độc giả");
		menuItemReader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showReaderGUI();
			}
		});
		menuCategory.add(menuItemReader);
		
		JMenuItem menuItemBook = new JMenuItem("Sách");
		menuItemBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showBookGUI();
			}
		});
		menuCategory.add(menuItemBook);
		
		JMenu menuBorrowReturn = new JMenu("Mượn trả");
		menuBar.add(menuBorrowReturn);
		
		JMenuItem menuItemBorrow = new JMenuItem("Phiếu mượn");
		menuItemBorrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showBorrowGUI();
			}
		});
		menuBorrowReturn.add(menuItemBorrow);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 1186, 641);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		showHomeGUI();
	
	}
	private void showHomeGUI() {
	
		 panel.setLayout(new BorderLayout(0, 0));
		   this.panel.removeAll();
	        // Load background image
	        ImageIcon backgroundImage = new ImageIcon(getClass().getResource("../Images/Library-Management.jpg"));
	        JLabel backgroundLabel = new JLabel(backgroundImage);
	        panel.add(backgroundLabel, BorderLayout.CENTER);
     
       
        this.panel.updateUI();
        panel.revalidate();
        panel.repaint();
	}
	private void showEmployeeGUI() {
		EmployeeGUI gui = new EmployeeGUI();
        gui.setVisible(true);
        this.panel.setLayout(new BorderLayout());
        this.panel.removeAll();
        this.panel.add(gui, BorderLayout.CENTER);
        this.panel.updateUI();
        panel.revalidate();
        panel.repaint();
	}
	private void showReaderGUI() {
		ReaderGUI gui = new ReaderGUI();
        gui.setVisible(true);
        this.panel.setLayout(new BorderLayout());
        this.panel.removeAll();
        this.panel.add(gui, BorderLayout.CENTER);
        this.panel.updateUI();
        panel.revalidate();
        panel.repaint();
	}
	private void showCategoryGUI() {
		CategoryGUI gui = new CategoryGUI();
        gui.setVisible(true);
        this.panel.setLayout(new BorderLayout());
        this.panel.removeAll();
        this.panel.add(gui, BorderLayout.CENTER);
        this.panel.updateUI();
        panel.revalidate();
        panel.repaint();
	}
	private void showBookGUI() {
		BookGUI gui = new BookGUI();
        gui.setVisible(true);
        this.panel.setLayout(new BorderLayout());
        this.panel.removeAll();
        this.panel.add(gui, BorderLayout.CENTER);
        this.panel.updateUI();
        panel.revalidate();
        panel.repaint();
	}
	private void showBorrowGUI() {
		BorrowGUI gui = new BorrowGUI();
        gui.setVisible(true);
        this.panel.setLayout(new BorderLayout());
        this.panel.removeAll();
        this.panel.add(gui, BorderLayout.CENTER);
        this.panel.updateUI();
        panel.revalidate();
        panel.repaint();
	}
}

package DTO;
import java.util.Date;

public class BorrowDTO {
    private int borrowId;
    private Date borrowDate;
    private Date returnDueDate;
    private Date returnDate;
    private ReaderDTO reader;
    private BookDTO book;
    private EmployeeDTO employee;
	public int getBorrowId() {
		return borrowId;
	}
	public void setBorrowId(int borrowId) {
		this.borrowId = borrowId;
	}
	public Date getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}
	public Date getReturnDueDate() {
		return returnDueDate;
	}
	public void setReturnDueDate(Date returnDueDate) {
		this.returnDueDate = returnDueDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public ReaderDTO getReader() {
		return reader;
	}
	public void setReader(ReaderDTO reader) {
		this.reader = reader;
	}
	public BookDTO getBook() {
		return book;
	}
	public void setBook(BookDTO book) {
		this.book = book;
	}
	public EmployeeDTO getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeDTO employee) {
		this.employee = employee;
	}

    // Getters and setters
    
}

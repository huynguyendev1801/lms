package DAO;

import DTO.BorrowDTO;
import DTO.BookDTO;
import DTO.ReaderDTO;
import DTO.EmployeeDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BorrowDAO {
    public static boolean insert(BorrowDTO borrow) {
        String query = "INSERT INTO Borrows (BorrowDate, ReturnDueDate, ReturnDate, ReaderId, BookId, EmployeeId) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DBConnect.getConnect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDate(1, new java.sql.Date(borrow.getBorrowDate().getTime()));
            statement.setDate(2, new java.sql.Date(borrow.getReturnDueDate().getTime()));
            
            if (borrow.getReturnDate() != null) {
                statement.setDate(3, new java.sql.Date(borrow.getReturnDate().getTime()));
            } else {
                statement.setNull(3, java.sql.Types.DATE);
            }
            
            statement.setString(4, borrow.getReader().getReaderId());
            statement.setString(5, borrow.getBook().getBookId());
            statement.setString(6, borrow.getEmployee().getEmployeeId());
            
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(BorrowDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean update(BorrowDTO borrow) {
        String query = "UPDATE Borrows SET ReturnDate = GETDATE() WHERE BorrowId = ?";
        try (Connection connection = DBConnect.getConnect();
             PreparedStatement statement = connection.prepareStatement(query)) {
    
            statement.setInt(1, borrow.getBorrowId());
            
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(BorrowDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean delete(int borrowId) {
        String query = "DELETE FROM Borrows WHERE BorrowId = ?";
        try (Connection connection = DBConnect.getConnect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, borrowId);
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(BorrowDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static List<BorrowDTO> getAll() {
        List<BorrowDTO> borrows = new ArrayList<>();
        String query = "SELECT * FROM Borrows";
        try (Connection connection = DBConnect.getConnect();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                BorrowDTO borrow = extractBorrowFromResultSet(resultSet);
                borrows.add(borrow);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return borrows;
    }

    public static List<BorrowDTO> getByReader(ReaderDTO reader) {
        List<BorrowDTO> borrows = new ArrayList<>();
        String query = "SELECT * FROM Borrows WHERE ReaderId = ?";
        try (Connection connection = DBConnect.getConnect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, reader.getReaderId());
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    BorrowDTO borrow = extractBorrowFromResultSet(resultSet);
                    borrows.add(borrow);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return borrows;
    }

    private static BorrowDTO extractBorrowFromResultSet(ResultSet resultSet) throws SQLException {
        BorrowDTO borrow = new BorrowDTO();
        borrow.setBorrowId(resultSet.getInt("BorrowId"));
        borrow.setBorrowDate(resultSet.getDate("BorrowDate"));
        borrow.setReturnDueDate(resultSet.getDate("ReturnDueDate"));
        borrow.setReturnDate(resultSet.getDate("ReturnDate"));

        ReaderDTO reader = ReaderDAO.getByReaderId(resultSet.getString("ReaderId"));
       
        borrow.setReader(reader);

        BookDTO book = BookDAO.getByBookId(resultSet.getString("BookId"));
        borrow.setBook(book);

        EmployeeDTO employee = EmployeeDAO.getByEmployeeId(resultSet.getString("EmployeeId"));
        borrow.setEmployee(employee);

        return borrow;
    }
}
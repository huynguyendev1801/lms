package DAO;

import DTO.BookDTO;
import DTO.CategoryDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookDAO {
    public static boolean insert(BookDTO book) {
        String query = "INSERT INTO Books (BookId, BookName, CategoryId, ProductionYear, AuthorName, PublisherName) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DBConnect.getConnect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, book.getBookId());
            statement.setString(2, book.getBookName());
            statement.setString(3, book.getCategory().getCategoryId());
            statement.setInt(4, book.getProductionYear());
            statement.setString(5, book.getAuthorName());
            statement.setString(6, book.getPublisherName());
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean update(BookDTO book) {
        String query = "UPDATE Books SET BookName = ?, CategoryId = ?, ProductionYear = ?, " +
                "AuthorName = ?, PublisherName = ? WHERE BookId = ?";
        try (Connection connection = DBConnect.getConnect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, book.getBookName());
            statement.setString(2, book.getCategory().getCategoryId());
            statement.setInt(3, book.getProductionYear());
            statement.setString(4, book.getAuthorName());
            statement.setString(5, book.getPublisherName());
            statement.setString(6, book.getBookId());
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean delete(String bookId) {
        String query = "DELETE FROM Books WHERE BookId = ?";
        try (Connection connection = DBConnect.getConnect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, bookId);
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static List<BookDTO> getAll() {
        List<BookDTO> books = new ArrayList<>();
        String query = "SELECT * FROM Books";
        try (Connection connection = DBConnect.getConnect();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                BookDTO book = new BookDTO();
                book.setBookId(resultSet.getString("BookId"));
                book.setBookName(resultSet.getString("BookName"));
                CategoryDTO category = getCategoryById(resultSet.getString("CategoryId"));
                book.setCategory(category);
                book.setProductionYear(resultSet.getInt("ProductionYear"));
                book.setAuthorName(resultSet.getString("AuthorName"));
                book.setPublisherName(resultSet.getString("PublisherName"));
                books.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;
    }

    public static List<BookDTO> getByCategory(CategoryDTO category) {
        List<BookDTO> books = new ArrayList<>();
        String query = "SELECT * FROM Books WHERE CategoryId = ?";
        try (Connection connection = DBConnect.getConnect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, category.getCategoryId());
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    BookDTO book = new BookDTO();
                    book.setBookId(resultSet.getString("BookId"));
                    book.setBookName(resultSet.getString("BookName"));
                    book.setCategory(category);
                    book.setProductionYear(resultSet.getInt("ProductionYear"));
                    book.setAuthorName(resultSet.getString("AuthorName"));
                    book.setPublisherName(resultSet.getString("PublisherName"));
                    books.add(book);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;
    }

    public static BookDTO getByBookId(String bookId) {
        String query = "SELECT * FROM Books WHERE BookId = ?";
        try (Connection connection = DBConnect.getConnect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, bookId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    BookDTO book = new BookDTO();
                    book.setBookId(resultSet.getString("BookId"));
                    book.setBookName(resultSet.getString("BookName"));
                    CategoryDTO category = getCategoryById(resultSet.getString("CategoryId"));
                    book.setCategory(category);
                    book.setProductionYear(resultSet.getInt("ProductionYear"));
                    book.setAuthorName(resultSet.getString("AuthorName"));
                    book.setPublisherName(resultSet.getString("PublisherName"));
                    return book;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private static CategoryDTO getCategoryById(String categoryId) {
        String query = "SELECT * FROM Categories WHERE CategoryId = ?";
        try (Connection connection = DBConnect.getConnect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, categoryId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    CategoryDTO category = new CategoryDTO();
                    category.setCategoryId(resultSet.getString("CategoryId"));
                    category.setCategoryName(resultSet.getString("CategoryName"));
                    return category;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static List<BookDTO> getByBookName(String bookName) {
        List<BookDTO> books = new ArrayList<>();
        String query = "SELECT * FROM Books WHERE BookName LIKE ?";
        try (Connection connection = DBConnect.getConnect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, "%" + bookName + "%");
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    BookDTO book = new BookDTO();
                    book.setBookId(resultSet.getString("BookId"));
                    book.setBookName(resultSet.getString("BookName"));
                    CategoryDTO category = getCategoryById(resultSet.getString("CategoryId"));
                    book.setCategory(category);
                    book.setProductionYear(resultSet.getInt("ProductionYear"));
                    book.setAuthorName(resultSet.getString("AuthorName"));
                    book.setPublisherName(resultSet.getString("PublisherName"));
                    books.add(book);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;
    }
}
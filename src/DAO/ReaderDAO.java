package DAO;

import DTO.ReaderDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReaderDAO {
    public static boolean insert(ReaderDTO reader) {
        String query = "INSERT INTO Readers (ReaderId, ReaderName, BirthDate, PhoneNumber, Address) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DBConnect.getConnect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, reader.getReaderId());
            statement.setString(2, reader.getReaderName());
            statement.setDate(3, new java.sql.Date(reader.getBirthDate().getTime()));
            statement.setString(4, reader.getPhoneNumber());
            statement.setString(5, reader.getAddress());
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ReaderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean update(ReaderDTO reader) {
        String query = "UPDATE Readers SET ReaderName = ?, BirthDate = ?, PhoneNumber = ?, Address = ? " +
                "WHERE ReaderId = ?";
        try (Connection connection = DBConnect.getConnect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, reader.getReaderName());
            statement.setDate(2, new java.sql.Date(reader.getBirthDate().getTime()));
            statement.setString(3, reader.getPhoneNumber());
            statement.setString(4, reader.getAddress());
            statement.setString(5, reader.getReaderId());
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ReaderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean delete(String readerId) {
        String query = "DELETE FROM Readers WHERE ReaderId = ?";
        try (Connection connection = DBConnect.getConnect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, readerId);
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ReaderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static ReaderDTO getByReaderId(String readerId) {
        String query = "SELECT * FROM Readers WHERE ReaderId = ?";
        try (Connection connection = DBConnect.getConnect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, readerId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    ReaderDTO reader = new ReaderDTO();
                    reader.setReaderId(resultSet.getString("ReaderId"));
                    reader.setReaderName(resultSet.getString("ReaderName"));
                    reader.setBirthDate(resultSet.getDate("BirthDate"));
                    reader.setPhoneNumber(resultSet.getString("PhoneNumber"));
                    reader.setAddress(resultSet.getString("Address"));
                    return reader;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReaderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static List<ReaderDTO> getAll() {
        List<ReaderDTO> readers = new ArrayList<>();
        String query = "SELECT * FROM Readers";
        try (Connection connection = DBConnect.getConnect();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                ReaderDTO reader = new ReaderDTO();
                reader.setReaderId(resultSet.getString("ReaderId"));
                reader.setReaderName(resultSet.getString("ReaderName"));
                reader.setBirthDate(resultSet.getDate("BirthDate"));
                reader.setPhoneNumber(resultSet.getString("PhoneNumber"));
                reader.setAddress(resultSet.getString("Address"));
                readers.add(reader);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReaderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return readers;
    }
}
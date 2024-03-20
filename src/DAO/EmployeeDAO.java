package DAO;

import DTO.EmployeeDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDAO {
    public static boolean insert(EmployeeDTO employee) {
        String query = "INSERT INTO Employees (EmployeeId, EmployeeName, BirthDate, PhoneNumber, Role, Password) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DBConnect.getConnect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, employee.getEmployeeId());
            statement.setString(2, employee.getEmployeeName());
            statement.setDate(3, new java.sql.Date(employee.getBirthDate().getTime()));
            statement.setString(4, employee.getPhoneNumber());
            statement.setString(5, employee.getRole());
            statement.setString(6, employee.getPassword());
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean update(EmployeeDTO employee) {
        String query = "UPDATE Employees SET EmployeeName = ?, BirthDate = ?, PhoneNumber = ?, Role = ?, Password = ? " +
                "WHERE EmployeeId = ?";
        try (Connection connection = DBConnect.getConnect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, employee.getEmployeeName());
            statement.setDate(2, new java.sql.Date(employee.getBirthDate().getTime()));
            statement.setString(3, employee.getPhoneNumber());
            statement.setString(4, employee.getRole());
            statement.setString(5, employee.getPassword());
            statement.setString(6, employee.getEmployeeId());
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean delete(String employeeId) {
        String query = "DELETE FROM Employees WHERE EmployeeId = ?";
        try (Connection connection = DBConnect.getConnect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, employeeId);
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static EmployeeDTO getByEmployeeId(String employeeId) {
        String query = "SELECT * FROM Employees WHERE EmployeeId = ?";
        try (Connection connection = DBConnect.getConnect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, employeeId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    EmployeeDTO employee = new EmployeeDTO();
                    employee.setEmployeeId(resultSet.getString("EmployeeId"));
                    employee.setEmployeeName(resultSet.getString("EmployeeName"));
                    employee.setBirthDate(resultSet.getDate("BirthDate"));
                    employee.setPhoneNumber(resultSet.getString("PhoneNumber"));
                    employee.setRole(resultSet.getString("Role"));
                    employee.setPassword(resultSet.getString("Password"));
                    return employee;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static EmployeeDTO login(String employeeId, String password) {
        String query = "SELECT * FROM Employees WHERE EmployeeId = ? AND Password = ?";
        try (Connection connection = DBConnect.getConnect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, employeeId);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    EmployeeDTO employee = new EmployeeDTO();
                    employee.setEmployeeId(resultSet.getString("EmployeeId"));
                    employee.setEmployeeName(resultSet.getString("EmployeeName"));
                    employee.setBirthDate(resultSet.getDate("BirthDate"));
                    employee.setPhoneNumber(resultSet.getString("PhoneNumber"));
                    employee.setRole(resultSet.getString("Role"));
                    employee.setPassword(resultSet.getString("Password"));
                    return employee;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static List<EmployeeDTO> getAll() {
        List<EmployeeDTO> employees = new ArrayList<>();
        String query = "SELECT * FROM Employees";
        try (Connection connection = DBConnect.getConnect();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                EmployeeDTO employee = new EmployeeDTO();
                employee.setEmployeeId(resultSet.getString("EmployeeId"));
                employee.setEmployeeName(resultSet.getString("EmployeeName"));
                employee.setBirthDate(resultSet.getDate("BirthDate"));
                employee.setPhoneNumber(resultSet.getString("PhoneNumber"));
                employee.setRole(resultSet.getString("Role"));
                employee.setPassword(resultSet.getString("Password"));
                employees.add(employee);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employees;
    }
}
package DAO;

import DTO.CategoryDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoryDAO {
    public static boolean insert(CategoryDTO category) {
        String query = "INSERT INTO Categories (CategoryId, CategoryName, Description) VALUES (?, ?, ?)";
        try (Connection connection = DBConnect.getConnect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, category.getCategoryId());
            statement.setString(2, category.getCategoryName());
            statement.setString(3, category.getDescription());
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean update(CategoryDTO category) {
        String query = "UPDATE Categories SET CategoryName = ?, Description = ? WHERE CategoryId = ?";
        try (Connection connection = DBConnect.getConnect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, category.getCategoryName());
            statement.setString(2, category.getDescription());
            statement.setString(3, category.getCategoryId());
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean delete(String categoryId) {
        String query = "DELETE FROM Categories WHERE CategoryId = ?";
        try (Connection connection = DBConnect.getConnect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, categoryId);
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static List<CategoryDTO> getAll() {
        List<CategoryDTO> categories = new ArrayList<>();
        String query = "SELECT * FROM Categories";
        try (Connection connection = DBConnect.getConnect();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                CategoryDTO category = new CategoryDTO();
                category.setCategoryId(resultSet.getString("CategoryId"));
                category.setCategoryName(resultSet.getString("CategoryName"));
                category.setDescription(resultSet.getString("Description"));
                categories.add(category);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }

    public static CategoryDTO getByCategoryID(String categoryId) {
        String query = "SELECT * FROM Categories WHERE CategoryId = ?";
        try (Connection connection = DBConnect.getConnect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, categoryId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    CategoryDTO category = new CategoryDTO();
                    category.setCategoryId(resultSet.getString("CategoryId"));
                    category.setCategoryName(resultSet.getString("CategoryName"));
                    category.setDescription(resultSet.getString("Description"));
                    return category;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static CategoryDTO getByCategoryName(String categoryName) {
        String query = "SELECT * FROM Categories WHERE CategoryName = ?";
        try (Connection connection = DBConnect.getConnect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, categoryName);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    CategoryDTO category = new CategoryDTO();
                    category.setCategoryId(resultSet.getString("CategoryId"));
                    category.setCategoryName(resultSet.getString("CategoryName"));
                    category.setDescription(resultSet.getString("Description"));
                    return category;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
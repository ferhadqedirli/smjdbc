package com.company.expenseapp.database.impl;

import com.company.expenseapp.database.dao.CategoryDao;
import com.company.expenseapp.database.dao.Connectable;
import com.company.expenseapp.entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao, Connectable {

    private Category getCategory(ResultSet rs) throws SQLException {
        int categoryId = rs.getInt("ID");
        String categoryName = rs.getString("CATEGORY_NAME");
        return new Category(categoryId, categoryName);
    }

    @Override
    public boolean add(Category category) {
        try (Connection connection = connect()) {
            String query = "INSERT INTO CATEGORY (ID, CATEGORY_NAME) VALUES(category_seq.NEXTVAL, ?)";
            PreparedStatement psmt = connection.prepareStatement(query);
            psmt.setString(1, category.getName());
            psmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(Integer id) {
        Category category = getById(id);
        category.setState(0);
        return update(category);
    }

    @Override
    public boolean update(Category category) {
        try (Connection connection = connect()) {
            String query = "UPDATE CATEGORY SET CATEGORY_NAME = ?, STATE = ? WHERE ID = ?";
            PreparedStatement psmt = connection.prepareStatement(query);
            psmt.setString(1, category.getName());
            psmt.setInt(2, category.getState());
            psmt.setInt(3, category.getId());
            psmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Category getById(Integer id) {
        Category category = null;
        try (Connection connection = connect()) {
            String query = "SELECT * FROM CATEGORY WHERE STATE = 1 AND ID = ?";
            PreparedStatement psmt = connection.prepareStatement(query);
            psmt.setInt(1, id);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                category = getCategory(rs);
            }
            return category;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Category getByName(String categoryName) {
        Category category = null;
        try (Connection connection = connect()) {
            String query = "SELECT * FROM CATEGORY WHERE STATE = 1 AND CATEGORY_NAME = ?";
            PreparedStatement psmt = connection.prepareStatement(query);
            psmt.setString(1, categoryName);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                category = getCategory(rs);
            }
            return category;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();
        try (Connection connection = connect()) {
            String query = "SELECT * FROM CATEGORY WHERE STATE = 1";
            PreparedStatement psmt = connection.prepareStatement(query);
            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {
                categories.add(getCategory(rs));
            }
            return categories;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

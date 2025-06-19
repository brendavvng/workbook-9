package com.pluralsight.NorthwindTradersAPI.dao;

import com.pluralsight.NorthwindTradersAPI.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PutMapping;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

// This is a Spring Component.
// The @Component annotation tells Spring to create an instance of this class and manage it as a Bean.
// This allows us to inject it into other classes
@Component
public class JdbcCategoryDao implements CategoryDao {

    private DataSource dataSource;

    // constructor
    @Autowired
    public JdbcCategoryDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();

        String query = """
                SELECT *
                FROM categories""";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {
                Category category = new Category(
                        resultSet.getInt("CategoryID"),
                        resultSet.getString("CategoryName")
                );
                categories.add(category);
            }

        } catch (SQLException e) {
            // If something goes wrong (SQL error), print the stack trace to help debug.
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category getById(int id) {

        String query = """
            SELECT *
            FROM categories
            WHERE CategoryID = ?""";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                return new Category(
                        resultSet.getInt("CategoryID"),
                        resultSet.getString("CategoryName"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        // return null if product not found
        return null;
    }

    @Override
    public Category insert(Category category) {
        String query = """
            INSERT INTO categories (CategoryName)
            VALUES (?)""";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, category.getCategoryName());

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    category.setCategoryId(generatedKeys.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return category;

    }

    @Override
    public void update(int id, Category category) {

        String query = """
                UPDATE categories
                SET CategoryName = ?
                WHERE CategoryID = ?
                """;
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, category.getCategoryName());
            stmt.setInt(2, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(int id) {

        String query = """
                DELETE FROM categories
                WHERE CategoryID = ?""";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

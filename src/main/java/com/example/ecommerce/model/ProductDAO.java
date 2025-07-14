package com.example.ecommerce.model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ProductDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;

    private static final String SELECT_ALL = "SELECT * FROM products";

    public ProductDAO() {
        loadConfig();
    }

    private void loadConfig() {
        Properties props = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("db.properties")) {
            if (input != null) {
                props.load(input);
                jdbcURL = props.getProperty("jdbc.url");
                jdbcUsername = props.getProperty("jdbc.username");
                jdbcPassword = props.getProperty("jdbc.password");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Product> listAllProducts() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                products.add(new Product(id, name, description, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}

package com.tuempresa.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String url = "jdbc:mysql://localhost:3306/jaxrsdb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "12345";

    public static Connection getConnection() throws SQLException {
        try {
            // Registrar el driver manualmente
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver no encontrado", e);
        }
        return DriverManager.getConnection(url, USER, PASSWORD);
    }
}

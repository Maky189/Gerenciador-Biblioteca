package com.biblioteca.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// This class handles conecting to the table
public class DatabaseUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String USER = "Marcos";
    private static final String PASSWORD = "marcos eh bom";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

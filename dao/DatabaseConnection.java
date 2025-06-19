package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/library?useSSL=false";
    private static final String USER = "root"; // Thay bằng username MySQL của bạn
    private static final String PASSWORD = "2206"; // Thay bằng password MySQL của bạn

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
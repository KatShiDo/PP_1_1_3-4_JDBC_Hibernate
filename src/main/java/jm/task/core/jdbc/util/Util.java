package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String url = "jdbc:mysql://localhost:3306/kata_1.1.4";
    private static final String user = "root";
    private static final String password = "20030117";

    public static Connection getConnection() {
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            return con;
        } catch (SQLException e) {
            System.out.println("Connection failed");
            return null;
        }
    }
}

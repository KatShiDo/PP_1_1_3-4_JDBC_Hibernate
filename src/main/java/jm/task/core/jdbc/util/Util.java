package jm.task.core.jdbc.util;

import com.mysql.cj.log.Log;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Util {
    private static final String url = "jdbc:mysql://localhost:3306/kata_1.1.4";
    private static final String user = "root";
    private static final String password = "20030117";
    private static final Logger logger = Logger.getLogger(Logger.class.getName());

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Connection to MySQL failed: " + e.getMessage());
            return null;
        }
    }
}

package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

public class UserDaoJDBCImpl implements UserDao {
    private final Connection con;
    private final Logger logger;

    public UserDaoJDBCImpl() {
        logger = Logger.getLogger(this.getClass().getName());
        con = Util.getConnection();
        if (con == null) {
            logger.log(Level.SEVERE, "Received null connection from Util");
            System.out.println("Received null connection from Util");
        }
    }

    public void createUsersTable() {
        try (Statement stmt = con.createStatement()){
            stmt.execute("CREATE TABLE users (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(20) NOT NULL," +
                    "lastname VARCHAR(30) NULL," +
                    "age INT NULL);");
        } catch (SQLException e) {
            logger.log(Level.WARNING, "Error while creating users table");
        }
    }

    public void dropUsersTable() {
        try (Statement stmt = con.createStatement()){
            stmt.execute("DROP TABLE users;");
        } catch (SQLException e) {
            logger.log(Level.WARNING, "Error while dropping users table");
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (Statement stmt = con.createStatement()){
            stmt.execute("INSERT INTO users (name, lastname, age) VALUES " +
                    MessageFormat.format("({0}, {1}, {2});", name, lastName, age));
        } catch (SQLException e) {
            logger.log(Level.WARNING, "Error while inserting into users table");
        }
    }

    public void removeUserById(long id) {
        try (Statement stmt = con.createStatement()){
            stmt.execute("DELETE FROM users WHERE id = " + id);
        } catch (SQLException e) {
            logger.log(Level.WARNING, "Error while deleting from users table");
        }
    }

    public List<User> getAllUsers() {
        try (Statement stmt = con.createStatement()){
            stmt.executeQuery("SELECT * FROM users;");
            var rs = stmt.getResultSet();
            var users = new ArrayList<User>();
            while (rs.next()) {
                users.add(new User(rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("lastname"),
                        rs.getByte("age")));
            }
            return users;
        } catch (SQLException e) {
            logger.log(Level.WARNING, "Error while selecting from users table");
            return null;
        }
    }

    public void cleanUsersTable() {
        try (Statement stmt = con.createStatement()){
            stmt.execute("TRUNCATE TABLE users;");
        } catch (SQLException e) {
            logger.log(Level.WARNING, "Error while deleting from users table");
        }
    }
}

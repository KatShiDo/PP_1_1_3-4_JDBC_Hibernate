package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        var userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("name1", "lastname1", (byte) 15);
        System.out.println("User with name name1 added to DB");
        userService.saveUser("name2", "lastname2", (byte) 16);
        System.out.println("User with name name2 added to DB");
        userService.saveUser("name3", "lastname3", (byte) 17);
        System.out.println("User with name name3 added to DB");
        userService.saveUser("name4", "lastname4", (byte) 18);
        System.out.println("User with name name4 added to DB");
        for (var user : userService.getAllUsers()) {
            System.out.println(user);
        }
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}

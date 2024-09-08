package jm.task.core.jdbc;

import java.sql.SQLException;


import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // реализуйте алгоритм здесь
        try {

            UserService userService = new UserServiceImpl();
            userService.createUsersTable();


            userService.saveUser("Bob", "Bob", (byte) 20);
            userService.saveUser("Tom", "Tom", (byte) 25);
            userService.saveUser("Jery", "Jery", (byte) 30);
            userService.saveUser("Mac", "Duck", (byte) 35);

            userService.removeUserById(2);

            userService.getAllUsers().forEach(x -> System.out.println(x.toString()));

            userService.cleanUsersTable();

            userService.dropUsersTable();


        } finally {
            UserDaoHibernateImpl.sessionFactory.close();

        }


    }
}

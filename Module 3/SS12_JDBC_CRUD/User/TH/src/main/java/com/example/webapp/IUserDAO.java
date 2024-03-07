package com.example.webapp;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    void insertUser(User user);
    List<User> search(String COUNTRY);
    List<User> sort();
    List<User> selectAllUsers();

    boolean deleteUser(int id) throws SQLException;

    boolean updateUser(User user) throws SQLException;
    List<User> selectUserID(int id);
    User selectUser(int id);

    void addUserTransaction(User user, int[] permision);

}

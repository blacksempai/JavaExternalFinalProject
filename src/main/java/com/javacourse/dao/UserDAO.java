package com.javacourse.dao;


import com.javacourse.model.entities.User;

public interface UserDAO {

    void addNewUser(User user);

    User getUserByLogin(String login);

    User getUserById(Integer id);

    void updateUser(User user);

    boolean isExists(String login);

}

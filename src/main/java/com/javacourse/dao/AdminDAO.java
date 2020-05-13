package com.javacourse.dao;

import com.javacourse.model.entities.Admin;

public interface AdminDAO {

    Admin getAdminByLogin(String login);

    boolean isExists(String login);

}

package com.javacourse.dao.implementation;

import com.javacourse.dao.AdminDAO;
import com.javacourse.dao.factory.MySqlDBConnection;
import com.javacourse.model.entities.Admin;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAOMySQL implements AdminDAO {
    private static Logger logger = Logger.getLogger(AdminDAOMySQL.class);

    @Override
    public Admin getAdminByLogin(String login) {
        Connection connection = MySqlDBConnection.getConnection();
        String sql ="SELECT * FROM admin WHERE login='"+login+"';";
        Admin admin = new Admin();
        admin.setLogin(login);
        try (connection) {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                admin.setId(rs.getInt("admin_id"));
                admin.setPasswordHash(rs.getString("password_hash"));
                admin.setSalt(rs.getString("salt"));
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return admin;
    }

    @Override
    public boolean isExists(String login) {
        Connection connection = MySqlDBConnection.getConnection();
        String sql ="SELECT * FROM admin WHERE login='"+login+"';";
        try (connection) {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                connection.close();
                return true;
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return false;
    }


}

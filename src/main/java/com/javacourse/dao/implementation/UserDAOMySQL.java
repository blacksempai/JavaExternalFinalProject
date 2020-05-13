package com.javacourse.dao.implementation;

import com.javacourse.dao.factory.MySqlDBConnection;
import com.javacourse.dao.UserDAO;
import com.javacourse.model.entities.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOMySQL implements UserDAO {
    private static Logger logger = Logger.getLogger(UserDAOMySQL.class);

    @Override
    public void addNewUser(User user) {
        Connection connection = MySqlDBConnection.getConnection();
        String sql ="INSERT INTO users VALUE(NULL,?,?,?,?,?,?);";
        try (connection) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,user.getLogin());
            statement.setString(2,user.getPasswordHash());
            statement.setString(3,user.getEmail());
            statement.setString(4,user.getFullName());
            statement.setString(5,user.getCompany());
            statement.setString(6,user.getSalt());
            statement.execute();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public User getUserByLogin(String login) {
        Connection connection = MySqlDBConnection.getConnection();
        String sql ="SELECT * FROM users WHERE login='"+login+"';";
        User user = new User();
        user.setLogin(login);
        try(connection) {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                user.setId(rs.getInt("user_id"));
                user.setPasswordHash(rs.getString("password_hash"));
                user.setSalt(rs.getString("salt"));
                user.setEmail(rs.getString("email"));
                user.setFullName(rs.getString("full_name"));
                user.setCompany(rs.getString("company_name"));
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User getUserById(Integer id) {
        Connection connection = MySqlDBConnection.getConnection();
        String sql ="SELECT * FROM users WHERE user_id='"+id+"';";
        User user = new User();
        user.setId(id);
        try (connection) {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                user.setLogin(rs.getString("login"));
                user.setPasswordHash(rs.getString("password_hash"));
                user.setSalt(rs.getString("salt"));
                user.setEmail(rs.getString("email"));
                user.setFullName(rs.getString("full_name"));
                user.setCompany(rs.getString("company_name"));
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void updateUser(User user) {
        Connection connection = MySqlDBConnection.getConnection();
        String sql = "UPDATE users SET password_hash=?, email=?, full_name=?, company_name=?, salt=? WHERE login='"+user.getLogin()+"';";
        try (connection) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,user.getPasswordHash());
            statement.setString(2,user.getEmail());
            statement.setString(3,user.getFullName());
            statement.setString(4,user.getCompany());
            statement.setString(5,user.getSalt());
            statement.execute();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public boolean isExists(String login) {
        Connection connection = MySqlDBConnection.getConnection();
        String sql ="SELECT * FROM users WHERE login='"+login+"';";
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

package com.javacourse.dao.implementation;

import com.javacourse.dao.factory.MySqlDBConnection;
import com.javacourse.dao.InspectorDAO;
import com.javacourse.model.entities.Inspector;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InspectorDAOMySQL implements InspectorDAO {
    private static Logger logger = Logger.getLogger(InspectorDAOMySQL.class);

    @Override
    public void addNewInspector(Inspector inspector) {
        Connection connection = MySqlDBConnection.getConnection();
        String sql ="INSERT INTO inspectors VALUE(NULL,?,?,?,?,?,?,?);";
        try (connection) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,inspector.getLogin());
            statement.setString(2,inspector.getPasswordHash());
            statement.setString(3,inspector.getEmail());
            statement.setString(4,inspector.getFullName());
            statement.setInt(5,inspector.getComplaintNumber());
            statement.setInt(6,inspector.getReportsInService());
            statement.setString(7,inspector.getSalt());
            statement.execute();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public List<Inspector> getAllInspectors() {
        Connection connection = MySqlDBConnection.getConnection();
        String sql ="SELECT * FROM inspectors;";
        List<Inspector> inspectors = new ArrayList<>();
        try (connection) {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Inspector inspector = new Inspector();
                inspector.setId(rs.getInt("inspector_id"));
                inspector.setLogin(rs.getString("login"));
                inspector.setPasswordHash(rs.getString("password_hash"));
                inspector.setSalt(rs.getString("salt"));
                inspector.setEmail(rs.getString("email"));
                inspector.setFullName(rs.getString("full_name"));
                inspector.setComplaintNumber(rs.getInt("complaint_number"));
                inspector.setReportsInService(rs.getInt("reports_in_service"));
                inspectors.add(inspector);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return inspectors;
    }

    @Override
    public Inspector getInspectorByLogin(String login) {
        Connection connection = MySqlDBConnection.getConnection();
        String sql ="SELECT * FROM inspectors WHERE login='"+login+"';";
        Inspector inspector = new Inspector();
        inspector.setLogin(login);
        try (connection) {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                inspector.setId(rs.getInt("inspector_id"));
                inspector.setPasswordHash(rs.getString("password_hash"));
                inspector.setSalt(rs.getString("salt"));
                inspector.setEmail(rs.getString("email"));
                inspector.setFullName(rs.getString("full_name"));
                inspector.setComplaintNumber(rs.getInt("complaint_number"));
                inspector.setReportsInService(rs.getInt("reports_in_service"));
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return inspector;
    }

    @Override
    public Inspector getInspectorById(Integer id) {
        Connection connection = MySqlDBConnection.getConnection();
        String sql ="SELECT * FROM inspectors WHERE inspector_id='"+id+"';";
        Inspector inspector = new Inspector();
        inspector.setId(id);
        try (connection) {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                inspector.setLogin(rs.getString("login"));
                inspector.setPasswordHash(rs.getString("password_hash"));
                inspector.setSalt(rs.getString("salt"));
                inspector.setEmail(rs.getString("email"));
                inspector.setFullName(rs.getString("full_name"));
                inspector.setComplaintNumber(rs.getInt("complaint_number"));
                inspector.setReportsInService(rs.getInt("reports_in_service"));
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return inspector;
    }

    @Override
    public void updateInspector(Inspector inspector) {
        Connection connection = MySqlDBConnection.getConnection();
        String sql = "UPDATE inspectors SET password_hash=?, email=?, full_name=?, complaint_number=?, reports_in_service=?, salt=? WHERE login='"+inspector.getLogin()+"';";
        try (connection) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,inspector.getPasswordHash());
            statement.setString(2,inspector.getEmail());
            statement.setString(3,inspector.getFullName());
            statement.setInt(4,inspector.getComplaintNumber());
            statement.setInt(5,inspector.getReportsInService());
            statement.setString(6,inspector.getSalt());
            statement.execute();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public boolean isExists(String login) {
        Connection connection = MySqlDBConnection.getConnection();
        String sql ="SELECT * FROM inspectors WHERE login='"+login+"';";
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

    @Override
    public Inspector getInspectorWithLessReportsInService() {
        Connection connection = MySqlDBConnection.getConnection();
        String sql ="SELECT * FROM inspectors WHERE reports_in_service = (SELECT MIN(reports_in_service) FROM inspectors);";
        Inspector inspector = new Inspector();
        try (connection) {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                inspector.setId(rs.getInt("inspector_id"));
                inspector.setLogin(rs.getString("login"));
                inspector.setPasswordHash(rs.getString("password_hash"));
                inspector.setSalt(rs.getString("salt"));
                inspector.setEmail(rs.getString("email"));
                inspector.setFullName(rs.getString("full_name"));
                inspector.setComplaintNumber(rs.getInt("complaint_number"));
                inspector.setReportsInService(rs.getInt("reports_in_service"));
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return inspector;
    }
}

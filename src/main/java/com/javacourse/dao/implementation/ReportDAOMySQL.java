package com.javacourse.dao.implementation;

import com.javacourse.dao.factory.MySqlDBConnection;
import com.javacourse.dao.InspectorDAO;
import com.javacourse.dao.ReportDAO;
import com.javacourse.dao.UserDAO;
import com.javacourse.model.entities.Inspector;
import com.javacourse.model.entities.TaxReport;
import com.javacourse.model.entities.User;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ReportDAOMySQL implements ReportDAO {
    private static Logger logger = Logger.getLogger(ReportDAOMySQL.class);

    @Override
    public void addReport(TaxReport report) {
        Connection connection = MySqlDBConnection.getConnection();
        String sql ="INSERT INTO reports VALUES(NULL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,report.getUser().getId());
            statement.setInt(2,report.getInspector().getId());
            statement.setString(3,getTypeString(report.getType()));
            statement.setString(4,getPeriodString(report.getPeriod()));
            statement.setInt(5,report.getYear());
            statement.setString(6,getPeriodString(report.getSpecifiedPeriod()));
            statement.setInt(7,report.getSpecifiedYear());
            statement.setString(8,report.getAuthorityName());
            statement.setString(9,report.getUserFullName());
            statement.setString(10,report.getUserAddress());
            statement.setString(11,report.getUserPassportInfo());
            statement.setInt(12,report.getEmployeesNumber());
            statement.setString(13,report.getBusinessActivity());
            statement.setString(14,report.getBusinessActivityCode());
            statement.setDouble(15,report.getFirstGroupAdvancePayments().get(1));
            statement.setDouble(16,report.getFirstGroupAdvancePayments().get(2));
            statement.setDouble(17,report.getFirstGroupAdvancePayments().get(3));
            statement.setDouble(18,report.getFirstGroupAdvancePayments().get(4));
            statement.setDouble(19,report.getSecondGroupAdvancePayments().get(1));
            statement.setDouble(20,report.getSecondGroupAdvancePayments().get(2));
            statement.setDouble(21,report.getSecondGroupAdvancePayments().get(3));
            statement.setDouble(22,report.getSecondGroupAdvancePayments().get(4));
            statement.setDouble(23,report.getFirstGroupIncomeVolume01());
            statement.setDouble(24,report.getFirstGroupTaxedIncomeVolume02());
            statement.setDouble(25,report.getSecondGroupIncomeVolume03());
            statement.setDouble(26,report.getSecondGroupTaxedIncomeVolume04());
            statement.setDouble(27,report.getThirdGroup3PercentTaxed05());
            statement.setDouble(28,report.getThirdGroup5PercentTaxed06());
            statement.setDouble(29,report.getThirdGroup15PercentTaxed07());
            statement.setDouble(30,report.getSingleTaxAmount15());
            statement.setDouble(31,report.getSpecifiedTaxAmount16());
            statement.setDouble(32,report.getFinePercent());
            statement.setDouble(33,report.getPennySum20());
            statement.setTimestamp(34, new Timestamp(report.getDeclarationSubmissionDate().getTime()));
            statement.setString(35,getStatusString(report.getStatus()));
            statement.setString(36,report.getReview());
            statement.execute();
            connection.close();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void updateReport(TaxReport report) {
        Connection connection = MySqlDBConnection.getConnection();
        String sql ="UPDATE reports SET user_id=?,inspector_id=?,type=?,period=?,year=?,specified_period=?,specified_year=?,authority_name=?," +
                "user_full_name=?,user_address=?,user_passport=?,employees_number=?,business_activity=?,business_acttivity_code=?," +
                "1group_1q=?,1group_2q=?,1group_3q=?,1group_4q=?,2group_1q=?,2group_2q=?,2group_3q=?,2group_4q=?,1group_income=?," +
                "1group_t_income=?,2group_income=?,2group_t_income=?,3group_3p=?,3group_5p=?,3group_15g=?,single_t_amount=?," +
                "spec_t_amount=?,fine_percent=?,penny_sum=?,date=?,status=?,review=? WHERE report_id='"+report.getId()+"';";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,report.getUser().getId());
            statement.setInt(2,report.getInspector().getId());
            statement.setString(3,getTypeString(report.getType()));
            statement.setString(4,getPeriodString(report.getPeriod()));
            statement.setInt(5,report.getYear());
            statement.setString(6,getPeriodString(report.getSpecifiedPeriod()));
            statement.setInt(7,report.getSpecifiedYear());
            statement.setString(8,report.getAuthorityName());
            statement.setString(9,report.getUserFullName());
            statement.setString(10,report.getUserAddress());
            statement.setString(11,report.getUserPassportInfo());
            statement.setInt(12,report.getEmployeesNumber());
            statement.setString(13,report.getBusinessActivity());
            statement.setString(14,report.getBusinessActivityCode());
            statement.setDouble(15,report.getFirstGroupAdvancePayments().get(1));
            statement.setDouble(16,report.getFirstGroupAdvancePayments().get(2));
            statement.setDouble(17,report.getFirstGroupAdvancePayments().get(3));
            statement.setDouble(18,report.getFirstGroupAdvancePayments().get(4));
            statement.setDouble(19,report.getSecondGroupAdvancePayments().get(1));
            statement.setDouble(20,report.getSecondGroupAdvancePayments().get(2));
            statement.setDouble(21,report.getSecondGroupAdvancePayments().get(3));
            statement.setDouble(22,report.getSecondGroupAdvancePayments().get(4));
            statement.setDouble(23,report.getFirstGroupIncomeVolume01());
            statement.setDouble(24,report.getFirstGroupTaxedIncomeVolume02());
            statement.setDouble(25,report.getSecondGroupIncomeVolume03());
            statement.setDouble(26,report.getSecondGroupTaxedIncomeVolume04());
            statement.setDouble(27,report.getThirdGroup3PercentTaxed05());
            statement.setDouble(28,report.getThirdGroup5PercentTaxed06());
            statement.setDouble(29,report.getThirdGroup15PercentTaxed07());
            statement.setDouble(30,report.getSingleTaxAmount15());
            statement.setDouble(31,report.getSpecifiedTaxAmount16());
            statement.setDouble(32,report.getFinePercent());
            statement.setDouble(33,report.getPennySum20());
            statement.setTimestamp(34, new Timestamp(report.getDeclarationSubmissionDate().getTime()));
            statement.setString(35,getStatusString(report.getStatus()));
            statement.setString(36,report.getReview());
            statement.execute();
            connection.close();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void deleteReport(TaxReport report) {
        Connection connection = MySqlDBConnection.getConnection();
        String sql = "DELETE FROM reports WHERE report_id='"+report.getId()+"';";
        try (connection){
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    private String getPeriodString(TaxReport.Period period){
        switch (period){
            case I_QUARTER:return "I_QUARTER";
            case II_QUARTER:return "II_QUARTER";
            case III_QUARTER:return "III_QUARTER";
            case IV_QUARTER:return "IV_QUARTER";
            default: return null;
        }
    }

    private String getStatusString(TaxReport.Status status){
        switch (status){
            case PENDING:return "PENDING";
            case ACCEPTED:return "ACCEPTED";
            case DECLINED:return "DECLINED";
            default:return null;
        }
    }

    private String getTypeString(TaxReport.Type type){
        switch (type){
            case SIMPLE:return "SIMPLE";
            case SIMPLE_NEW:return "SIMPLE_NEW";
            case SPECIFYING:return "SPECIFYING";
            case REFERENCING:return "REFERENCING";
            default:return null;
        }
    }

    @Override
    public List<TaxReport> getReportsByUser(User user) {
        Connection connection = MySqlDBConnection.getConnection();
        String sql = "SELECT * FROM reports WHERE user_id='"+user.getId()+"';";
        List<TaxReport> reports = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                TaxReport report = new TaxReport();
                report.setId(rs.getInt("report_id"));
                report.setUser(user);
                report.setInspector(getInspector(rs.getInt("inspector_id")));
                report.setType(getTypeEnum(rs.getString("type")));
                report.setPeriod(getPeriodEnum(rs.getString("period")));
                report.setYear((short) rs.getInt("year"));
                report.setSpecifiedPeriod(getPeriodEnum(rs.getString("specified_period")));
                report.setSpecifiedYear((short) rs.getInt("specified_year"));
                report.setAuthorityName(rs.getString("authority_name"));
                report.setUserFullName(rs.getString("user_full_name"));
                report.setUserAddress(rs.getString("user_address"));
                report.setUserPassportInfo(rs.getString("user_passport"));
                report.setEmployeesNumber(rs.getInt("employees_number"));
                report.setBusinessActivity(rs.getString("business_activity"));
                report.setBusinessActivityCode(rs.getString("business_acttivity_code"));
                report.getFirstGroupAdvancePayments().set(1,rs.getDouble("1group_1q"));
                report.getFirstGroupAdvancePayments().set(2,rs.getDouble("1group_2q"));
                report.getFirstGroupAdvancePayments().set(3,rs.getDouble("1group_3q"));
                report.getFirstGroupAdvancePayments().set(4,rs.getDouble("1group_4q"));
                report.getSecondGroupAdvancePayments().set(1,rs.getDouble("2group_1q"));
                report.getSecondGroupAdvancePayments().set(2,rs.getDouble("2group_2q"));
                report.getSecondGroupAdvancePayments().set(3,rs.getDouble("2group_3q"));
                report.getSecondGroupAdvancePayments().set(4,rs.getDouble("2group_4q"));
                report.setFirstGroupIncomeVolume01(rs.getDouble("1group_income"));
                report.setFirstGroupTaxedIncomeVolume02(rs.getDouble("1group_t_income"));
                report.setSecondGroupIncomeVolume03(rs.getDouble("2group_income"));
                report.setSecondGroupTaxedIncomeVolume04(rs.getDouble("2group_t_income"));
                report.setThirdGroup3PercentTaxed05(rs.getDouble("3group_3p"));
                report.setThirdGroup5PercentTaxed06(rs.getDouble("3group_5p"));
                report.setThirdGroup15PercentTaxed07(rs.getDouble("3group_15g"));
                report.setSingleTaxAmount15(rs.getDouble("single_t_amount"));
                report.setSpecifiedTaxAmount16(rs.getDouble("spec_t_amount"));
                report.setFinePercent((short)rs.getInt("fine_percent"));
                report.setPennySum20(rs.getDouble("penny_sum"));
                report.setDeclarationSubmissionDate(rs.getTimestamp("date"));
                report.setStatus(getStatusEnum(rs.getString("status")));
                report.setReview(rs.getString("review"));
                reports.add(report);
            }
            connection.close();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return reports;
    }

    @Override
    public List<TaxReport> getReportsByInspector(Inspector inspector) {
        Connection connection = MySqlDBConnection.getConnection();
        String sql = "SELECT * FROM reports WHERE inspector_id='"+inspector.getId()+"';";
        List<TaxReport> reports = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                TaxReport report = new TaxReport();
                report.setId(rs.getInt("report_id"));
                report.setUser(getUser(rs.getInt("user_id")));
                report.setInspector(inspector);
                report.setType(getTypeEnum(rs.getString("type")));
                report.setPeriod(getPeriodEnum(rs.getString("period")));
                report.setYear((short) rs.getInt("year"));
                report.setSpecifiedPeriod(getPeriodEnum(rs.getString("specified_period")));
                report.setSpecifiedYear((short) rs.getInt("specified_year"));
                report.setAuthorityName(rs.getString("authority_name"));
                report.setUserFullName(rs.getString("user_full_name"));
                report.setUserAddress(rs.getString("user_address"));
                report.setUserPassportInfo(rs.getString("user_passport"));
                report.setEmployeesNumber(rs.getInt("employees_number"));
                report.setBusinessActivity(rs.getString("business_activity"));
                report.setBusinessActivityCode(rs.getString("business_acttivity_code"));
                report.getFirstGroupAdvancePayments().set(1,rs.getDouble("1group_1q"));
                report.getFirstGroupAdvancePayments().set(2,rs.getDouble("1group_2q"));
                report.getFirstGroupAdvancePayments().set(3,rs.getDouble("1group_3q"));
                report.getFirstGroupAdvancePayments().set(4,rs.getDouble("1group_4q"));
                report.getSecondGroupAdvancePayments().set(1,rs.getDouble("2group_1q"));
                report.getSecondGroupAdvancePayments().set(2,rs.getDouble("2group_2q"));
                report.getSecondGroupAdvancePayments().set(3,rs.getDouble("2group_3q"));
                report.getSecondGroupAdvancePayments().set(4,rs.getDouble("2group_4q"));
                report.setFirstGroupIncomeVolume01(rs.getDouble("1group_income"));
                report.setFirstGroupTaxedIncomeVolume02(rs.getDouble("1group_t_income"));
                report.setSecondGroupIncomeVolume03(rs.getDouble("2group_income"));
                report.setSecondGroupTaxedIncomeVolume04(rs.getDouble("2group_t_income"));
                report.setThirdGroup3PercentTaxed05(rs.getDouble("3group_3p"));
                report.setThirdGroup5PercentTaxed06(rs.getDouble("3group_5p"));
                report.setThirdGroup15PercentTaxed07(rs.getDouble("3group_15g"));
                report.setSingleTaxAmount15(rs.getDouble("single_t_amount"));
                report.setSpecifiedTaxAmount16(rs.getDouble("spec_t_amount"));
                report.setFinePercent((short)rs.getInt("fine_percent"));
                report.setPennySum20(rs.getDouble("penny_sum"));
                report.setDeclarationSubmissionDate(rs.getTimestamp("date"));
                report.setStatus(getStatusEnum(rs.getString("status")));
                report.setReview(rs.getString("review"));
                reports.add(report);
            }
            connection.close();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return reports;
    }

    private User getUser(Integer id){
        UserDAO userDAO = new UserDAOMySQL();
        return userDAO.getUserById(id);
    }

    private Inspector getInspector(Integer id){
        InspectorDAO inspectorDAO = new InspectorDAOMySQL();
        return inspectorDAO.getInspectorById(id);
    }

    private TaxReport.Period getPeriodEnum(String s){
        switch (s){
            case "I_QUARTER":return TaxReport.Period.I_QUARTER;
            case "II_QUARTER":return TaxReport.Period.II_QUARTER;
            case "III_QUARTER":return TaxReport.Period.III_QUARTER;
            case "IV_QUARTER":return TaxReport.Period.IV_QUARTER;
            default:return null;
        }
    }

    private TaxReport.Status getStatusEnum(String s){
        switch (s){
            case "PENDING":return TaxReport.Status.PENDING;
            case "ACCEPTED":return TaxReport.Status.ACCEPTED;
            case "DECLINED":return TaxReport.Status.DECLINED;
            default:return null;
        }
    }

    private TaxReport.Type getTypeEnum(String s){
        switch (s){
            case "SIMPLE":return TaxReport.Type.SIMPLE;
            case "SIMPLE_NEW":return TaxReport.Type.SIMPLE_NEW;
            case "SPECIFYING":return TaxReport.Type.SPECIFYING;
            case "REFERENCING":return TaxReport.Type.REFERENCING;
            default:return null;
        }
    }
}

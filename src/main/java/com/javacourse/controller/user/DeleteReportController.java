package com.javacourse.controller.user;

import com.javacourse.annotations.Controller;
import com.javacourse.controller.ControllerCommand;
import com.javacourse.dao.ReportDAO;
import com.javacourse.dao.factory.DAOFactory;
import com.javacourse.model.entities.User;
import com.javacourse.model.entities.report.Report;
import com.javacourse.view.Page;
import com.javacourse.view.PagePath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller(url = "/user/delete-report", method = "GET")
public class DeleteReportController implements ControllerCommand {
    private DisplayAllReportsController reportsController;
    private ReportDAO reportDAO;

    public DeleteReportController(DAOFactory factory) {
        reportsController = new DisplayAllReportsController(factory);
        reportDAO = factory.createReportDAO();
    }

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        List<Report> reports = reportDAO.getReportsByUser(user);
        for (Report report : reports) {
            if (report.getId().equals(Integer.parseInt(request.getParameter("id")))){
                reportDAO.delete(report);
            }
        }
        return reportsController.execute(request, response);
    }

}

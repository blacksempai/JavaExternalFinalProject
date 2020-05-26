package com.javacourse.controller.user;

import com.javacourse.annotations.Controller;
import com.javacourse.controller.ControllerCommand;
import com.javacourse.dao.ReportDAO;
import com.javacourse.dao.factory.DAOFactory;
import com.javacourse.model.entities.TaxReport;
import com.javacourse.model.entities.User;
import com.javacourse.model.entities.report.Report;
import com.javacourse.view.Page;
import com.javacourse.view.PagePath;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller(url = "/user/all-reports", method = "GET")
public class DisplayAllReportsController implements ControllerCommand {
    private ReportDAO reportDAO;

    public DisplayAllReportsController(DAOFactory factory) {
        reportDAO = factory.createReportDAO();
    }

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        List<Report> reports = reportDAO.getReportsByUser(user);
        request.setAttribute("reports", reports);
        return new Page(PagePath.getProperty("page.reports"),Page.DispatchType.FORWARD);
    }
}

package com.javacourse.controller.user;

import com.javacourse.annotations.Controller;
import com.javacourse.controller.ControllerCommand;
import com.javacourse.dao.ReportDAO;
import com.javacourse.dao.factory.DAOFactory;
import com.javacourse.model.TaxReportSummary;
import com.javacourse.model.TaxReportSummaryCalculator;
import com.javacourse.model.entities.User;
import com.javacourse.model.entities.report.Report;
import com.javacourse.view.Page;
import com.javacourse.view.PagePath;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller(url = "/user/report-edit", method = "GET")
public class ReportEditControllerGET implements ControllerCommand {
    private ReportDAO reportDAO;
    private DAOFactory factory;

    public ReportEditControllerGET(DAOFactory factory) {
        this.factory = factory;
        reportDAO = factory.createReportDAO();
    }

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        Integer reportID = Integer.parseInt(request.getParameter("id"));
        List<Report> reports = reportDAO.getReportsByUser(user);
        for (Report report:reports) {
            if (report.getId().equals(reportID)) {
                TaxReportSummary summary = TaxReportSummaryCalculator.calculateSummary(report,factory);
                request.setAttribute("report",report);
                request.setAttribute("summary", summary);
                return new Page(PagePath.getProperty("page.report-edit"),Page.DispatchType.FORWARD);
            }
        }
        return new Page(PagePath.getProperty("page.error"),Page.DispatchType.FORWARD);
    }
}

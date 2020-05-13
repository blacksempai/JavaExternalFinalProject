package com.javacourse.controller.user;

import com.javacourse.annotations.Controller;
import com.javacourse.controller.utils.ControllerCommand;
import com.javacourse.dao.ReportDAO;
import com.javacourse.dao.factory.DAOFactory;
import com.javacourse.model.TaxReportSummary;
import com.javacourse.model.TaxReportSummaryCalculator;
import com.javacourse.model.entities.TaxReport;
import com.javacourse.model.entities.User;
import com.javacourse.view.Page;
import com.javacourse.view.PagePath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller(url = "/user/my-report", method = "GET")
public class DisplayReportController implements ControllerCommand {
    private ReportDAO reportDAO;
    private DAOFactory factory;

    public DisplayReportController(DAOFactory factory) {
        this.factory = factory;
        reportDAO = factory.createReportDAO();
    }

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        List<TaxReport> reports = reportDAO.getReportsByUser(user);
        for (TaxReport report:reports) {
            if (report.getId().equals(Integer.parseInt(request.getParameter("id")))){
                TaxReportSummary summary = TaxReportSummaryCalculator.calculateSummary(report,factory);
                request.setAttribute("report",report);
                request.setAttribute("summary", summary);
                return new Page(PagePath.getProperty("page.report-view"),Page.DispatchType.FORWARD);
            }
        }
        return new Page(PagePath.getProperty("page.error"),Page.DispatchType.FORWARD);
    }
}

package com.javacourse.controller.inspector;

import com.javacourse.annotations.Controller;
import com.javacourse.controller.ControllerCommand;
import com.javacourse.dao.ReportDAO;
import com.javacourse.dao.factory.DAOFactory;
import com.javacourse.model.TaxReportSummary;
import com.javacourse.model.TaxReportSummaryCalculator;
import com.javacourse.model.entities.Inspector;
import com.javacourse.model.entities.TaxReport;
import com.javacourse.model.entities.report.Report;
import com.javacourse.view.Page;
import com.javacourse.view.PagePath;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller(url = "/inspector/review", method = "GET")
public class ReportReviewController implements ControllerCommand {
    private ReportDAO reportDAO;
    private DAOFactory factory;

    public ReportReviewController(DAOFactory factory) {
        this.factory = factory;
        reportDAO = factory.createReportDAO();
    }

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        Inspector inspector = (Inspector) request.getSession().getAttribute("inspector");
        List<Report> reports = reportDAO.getReportsByInspector(inspector);
        for (Report report:reports) {
            if (report.getId().equals(Integer.parseInt(request.getParameter("id")))) {
                TaxReportSummary summary = TaxReportSummaryCalculator.calculateSummary(report,factory);
                request.setAttribute("report",report);
                request.setAttribute("summary", summary);
                return new Page(PagePath.getProperty("page.review"),Page.DispatchType.FORWARD);
            }
        }
        return new Page(PagePath.getProperty("page.error"),Page.DispatchType.FORWARD);
    }
}

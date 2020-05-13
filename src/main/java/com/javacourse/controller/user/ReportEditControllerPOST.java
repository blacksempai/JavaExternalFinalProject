package com.javacourse.controller.user;

import com.javacourse.annotations.Controller;
import com.javacourse.controller.utils.ControllerCommand;
import com.javacourse.dao.ReportDAO;
import com.javacourse.dao.factory.DAOFactory;
import com.javacourse.model.entities.TaxReport;
import com.javacourse.model.entities.User;
import com.javacourse.view.Page;
import com.javacourse.view.PagePath;
import com.javacourse.web.PostReportParser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller(url = "/user/report-edit", method = "POST")
public class ReportEditControllerPOST implements ControllerCommand {
    private ReportDAO reportDAO;

    public ReportEditControllerPOST(DAOFactory factory) {
        reportDAO = factory.createReportDAO();
    }

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        Integer reportId = Integer.parseInt(request.getParameter("id"));
        List<TaxReport> reports = reportDAO.getReportsByUser(user);
        for (TaxReport report : reports) {
            if (report.getId().equals(reportId)){
                updateReport(request,report);
            }
        }
        return new Page(PagePath.getProperty("page.reports"),Page.DispatchType.REDIRECT);
    }

    private void updateReport(HttpServletRequest request, TaxReport report){
        PostReportParser parser = new PostReportParser();
        TaxReport updatedReport = parser.parseRequest(request);
        updatedReport.setDeclarationSubmissionDate(new Timestamp(new Date().getTime()));
        updatedReport.setStatus(TaxReport.Status.PENDING);
        updatedReport.setInspector(report.getInspector());
        updatedReport.setUser((User) request.getSession().getAttribute("user"));
        updatedReport.setReview(report.getReview());
        updatedReport.setId(report.getId());
        reportDAO.updateReport(updatedReport);
    }

}

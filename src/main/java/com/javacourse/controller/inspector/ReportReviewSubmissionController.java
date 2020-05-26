package com.javacourse.controller.inspector;

import com.javacourse.annotations.Controller;
import com.javacourse.controller.ControllerCommand;
import com.javacourse.dao.InspectorDAO;
import com.javacourse.dao.ReportDAO;
import com.javacourse.dao.factory.DAOFactory;
import com.javacourse.model.entities.Inspector;
import com.javacourse.model.entities.report.Report;
import com.javacourse.view.Page;
import com.javacourse.view.PagePath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller(url = "/inspector/review", method = "POST")
public class ReportReviewSubmissionController implements ControllerCommand {
    private ReportDAO reportDAO;
    private InspectorDAO inspectorDAO;

    public ReportReviewSubmissionController(DAOFactory factory) {
        reportDAO = factory.createReportDAO();
        inspectorDAO = factory.createInspectorDAO();
    }

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        Inspector inspector = (Inspector) request.getSession().getAttribute("inspector");
        Integer reportId = Integer.parseInt(request.getParameter("id"));
        List<Report> reports = reportDAO.getReportsByInspector(inspector);
        for (Report report : reports) {
            if (report.getId().equals(reportId)){
                updateReport(request,report);
                updateInspector(inspector);
            }
        }
        return new Page(PagePath.getProperty("page.inspector-reports"),Page.DispatchType.FORWARD);
    }

    private void updateReport(HttpServletRequest request, Report report){
        if(request.getParameter("status").equals("true")) {
            report.setStatus(Report.Status.ACCEPTED);
        }
        if (request.getParameter("status").equals("false")){
            report.setStatus(Report.Status.DECLINED);
            String reviewText = request.getParameter("review_text");
            report.setReview(reviewText);
        }
        reportDAO.update(report);
    }

    private void updateInspector(Inspector inspector){
        inspector.setReportsInService(inspector.getReportsInService()-1);
        inspectorDAO.update(inspector);
    }

}

package com.javacourse.controller.user;

import com.javacourse.annotations.Controller;
import com.javacourse.controller.ControllerCommand;
import com.javacourse.controller.utils.ReportParser;
import com.javacourse.dao.ReportDAO;
import com.javacourse.dao.factory.DAOFactory;
import com.javacourse.model.TaxReportSummaryCalculator;
import com.javacourse.model.entities.User;
import com.javacourse.model.entities.report.Report;
import com.javacourse.view.Messages;
import com.javacourse.view.Page;
import com.javacourse.view.PagePath;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller(url = "/user/report-edit", method = "POST")
public class ReportEditControllerPOST implements ControllerCommand {
    private DAOFactory factory;
    private ReportDAO reportDAO;
    private static Logger logger = Logger.getLogger(ReportEditControllerPOST.class);

    public ReportEditControllerPOST(DAOFactory factory) {
        this.factory = factory;
        reportDAO = factory.createReportDAO();
    }

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        Report oldReport = getReportFromDB(request);
        if (oldReport==null)
            return new Page(PagePath.getProperty("page.error"),Page.DispatchType.FORWARD);
        try {
            Report newReport = parseReportFromRequest(request);
            updateReport(oldReport,newReport);
        }
        catch (NullPointerException | NumberFormatException e){
            logger.error("Error editing report",e);
            request.setAttribute("message", Messages.getProperty("msg.form-error", request));
            request.setAttribute("report", oldReport);
            request.setAttribute("summary", TaxReportSummaryCalculator.calculateSummary(oldReport,factory));
            return new Page(PagePath.getProperty("page.report-edit")+"?id="+request.getParameter("id"),Page.DispatchType.FORWARD);
        }
        return new Page(PagePath.getProperty("page.home"),Page.DispatchType.REDIRECT);
    }

    private Report getReportFromDB(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        Integer reportId = Integer.parseInt(request.getParameter("id"));
        List<Report> reports = reportDAO.getReportsByUser(user);
        for (Report report : reports) {
            if (report.getId().equals(reportId)){
                return report;
            }
        }
        return null;
    }

    private Report parseReportFromRequest(HttpServletRequest request){
        ReportParser parser = new ReportParser();
        return parser.parseRequest(request);
    }

    private void updateReport(Report oldReport, Report newReport){
        newReport.setStatus(Report.Status.PENDING);
        newReport.setInspector(oldReport.getInspector());
        newReport.setUser(oldReport.getUser());
        newReport.setReview(oldReport.getReview());
        newReport.setId(oldReport.getId());
        reportDAO.update(newReport);
    }

}

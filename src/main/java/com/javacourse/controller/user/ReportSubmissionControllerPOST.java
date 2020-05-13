package com.javacourse.controller.user;

import com.javacourse.annotations.Controller;
import com.javacourse.controller.utils.ControllerCommand;
import com.javacourse.dao.InspectorDAO;
import com.javacourse.dao.ReportDAO;
import com.javacourse.dao.factory.DAOFactory;
import com.javacourse.model.entities.Inspector;
import com.javacourse.model.entities.TaxReport;
import com.javacourse.model.entities.User;
import com.javacourse.view.Messages;
import com.javacourse.view.Page;
import com.javacourse.view.PagePath;
import com.javacourse.web.PostReportParser;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.Date;

@Controller(url = "/user/new-report", method = "POST")
public class ReportSubmissionControllerPOST implements ControllerCommand {
    private static Logger logger = Logger.getLogger(ReportSubmissionControllerPOST.class);
    private InspectorDAO inspectorDAO;
    private ReportDAO reportDAO;
    private Page home;
    private Page report;
    private PostReportParser parser;

    public ReportSubmissionControllerPOST(DAOFactory factory) {
        inspectorDAO = factory.createInspectorDAO();
        reportDAO = factory.createReportDAO();
        home = new Page(PagePath.getProperty("page.home"),Page.DispatchType.REDIRECT);
        report = new Page(PagePath.getProperty("page.report-form"),Page.DispatchType.FORWARD);
        parser = new PostReportParser();
    }

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            TaxReport taxReport = buildTaxReportFromRequest(request);
            reportDAO.addReport(taxReport);
        }
        catch (NullPointerException | NumberFormatException e){
            logger.error("Error posting new report",e);
            request.setAttribute("message", Messages.getProperty("msg.form-error"));
            return report;
        }
        return home;
    }

    private TaxReport buildTaxReportFromRequest(HttpServletRequest request)
            throws NumberFormatException, NullPointerException{
        TaxReport taxReport = parser.parseRequest(request);
        taxReport.setDeclarationSubmissionDate(new Timestamp(new Date().getTime()));
        taxReport.setStatus(TaxReport.Status.PENDING);
        taxReport.setInspector(selectInspectorAndUpdate());
        taxReport.setUser((User) request.getSession().getAttribute("user"));
        return taxReport;
    }

    private Inspector selectInspectorAndUpdate(){
        Inspector inspector = inspectorDAO.getInspectorWithLessReportsInService();
        int reportsInService = inspector.getReportsInService();
        inspector.setReportsInService(reportsInService+1);
        inspectorDAO.updateInspector(inspector);
        return inspector;
    }

}

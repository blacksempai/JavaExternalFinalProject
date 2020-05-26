package com.javacourse.controller.user;

import com.javacourse.annotations.Controller;
import com.javacourse.controller.ControllerCommand;
import com.javacourse.controller.utils.ReportParser;
import com.javacourse.dao.InspectorDAO;
import com.javacourse.dao.ReportDAO;
import com.javacourse.dao.factory.DAOFactory;
import com.javacourse.model.entities.Inspector;
import com.javacourse.model.entities.User;
import com.javacourse.model.entities.report.Report;
import com.javacourse.view.Messages;
import com.javacourse.view.Page;
import com.javacourse.view.PagePath;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller(url = "/user/new-report", method = "POST")
public class ReportSubmissionControllerPOST implements ControllerCommand {
    private static Logger logger = Logger.getLogger(ReportSubmissionControllerPOST.class);
    private InspectorDAO inspectorDAO;
    private ReportDAO reportDAO;
    private Page home;
    private Page report;

    public ReportSubmissionControllerPOST(DAOFactory factory) {
        inspectorDAO = factory.createInspectorDAO();
        reportDAO = factory.createReportDAO();
        home = new Page(PagePath.getProperty("page.home"),Page.DispatchType.REDIRECT);
        report = new Page(PagePath.getProperty("page.report-form"),Page.DispatchType.FORWARD);
    }

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            Report report = buildTaxReportFromRequest(request);
            reportDAO.create(report);
        }
        catch (NullPointerException | NumberFormatException e){
            logger.error("Error posting new report",e);
            request.setAttribute("message", Messages.getProperty("msg.form-error", request));
            return report;
        }
        return home;
    }

    private Report buildTaxReportFromRequest(HttpServletRequest request)
            throws NumberFormatException, NullPointerException{
        User user = (User) request.getSession().getAttribute("user");
        ReportParser parser = user.getGroup().getReportParser();
        Report report = parser.parseRequest(request);
        report.setInspector(selectInspectorAndUpdate());
        report.setUser(user);
        return report;
    }

    private Inspector selectInspectorAndUpdate(){
        Inspector inspector = inspectorDAO.getInspectorWithLessReportsInService();
        int reportsInService = inspector.getReportsInService();
        inspector.setReportsInService(reportsInService+1);
        inspectorDAO.update(inspector);
        return inspector;
    }

}

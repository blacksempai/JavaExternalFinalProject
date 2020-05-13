package com.javacourse.controller.user;

import com.javacourse.annotations.Controller;
import com.javacourse.controller.utils.ControllerCommand;
import com.javacourse.dao.InspectorDAO;
import com.javacourse.dao.ReportDAO;
import com.javacourse.dao.factory.DAOFactory;
import com.javacourse.model.entities.Inspector;
import com.javacourse.model.entities.TaxReport;
import com.javacourse.model.entities.User;
import com.javacourse.view.Page;
import com.javacourse.view.PagePath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller(url = "/user/change-inspector", method = "GET")
public class ChangeInspectorController implements ControllerCommand {
    private InspectorDAO inspectorDAO;
    private ReportDAO reportDAO;

    public ChangeInspectorController(DAOFactory factory) {
        inspectorDAO = factory.createInspectorDAO();
        reportDAO = factory.createReportDAO();
    }

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        List<TaxReport> reports = reportDAO.getReportsByUser(user);
        for (TaxReport report : reports) {
            if (report.getId().equals(Integer.parseInt(request.getParameter("id")))){
                changeInspectorInReport(report);
                reportDAO.updateReport(report);
            }
        }
        return new Page(PagePath.getProperty("page.reports"),Page.DispatchType.FORWARD);
    }

    private void changeInspectorInReport(TaxReport report){
        Inspector inspector = report.getInspector();
        inspector.setComplaintNumber(inspector.getComplaintNumber()+1);
        inspector.setReportsInService(inspector.getReportsInService()-1);
        inspectorDAO.updateInspector(inspector);

        inspector = getAnotherInspector(inspector);
        inspector.setReportsInService(inspector.getReportsInService()+1);
        report.setInspector(inspector);
        inspectorDAO.updateInspector(inspector);
    }

    private Inspector getAnotherInspector(Inspector inspector){
        Inspector anotherInspector = null;
        List<Inspector> inspectors = inspectorDAO.getAllInspectors();
        int reportsInService = -1;
        for (Inspector i : inspectors) {
            if (i.getId().equals(inspector.getId()))
                continue;
            if (i.getReportsInService()>reportsInService){
                reportsInService = i.getReportsInService();
                anotherInspector = i;
            }
        }
        return anotherInspector;
    }

}

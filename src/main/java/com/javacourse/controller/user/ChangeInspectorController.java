package com.javacourse.controller.user;

import com.javacourse.annotations.Controller;
import com.javacourse.controller.ControllerCommand;
import com.javacourse.dao.InspectorDAO;
import com.javacourse.dao.ReportDAO;
import com.javacourse.dao.factory.DAOFactory;
import com.javacourse.model.entities.Inspector;
import com.javacourse.model.entities.User;
import com.javacourse.model.entities.report.Report;
import com.javacourse.view.Page;
import com.javacourse.view.PagePath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller(url = "/user/change-inspector", method = "GET")
public class ChangeInspectorController implements ControllerCommand {
    private DisplayAllReportsController reportsController;
    private InspectorDAO inspectorDAO;
    private ReportDAO reportDAO;

    public ChangeInspectorController(DAOFactory factory) {
        reportsController = new DisplayAllReportsController(factory);
        inspectorDAO = factory.createInspectorDAO();
        reportDAO = factory.createReportDAO();
    }

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        List<Report> reports = reportDAO.getReportsByUser(user);
        for (Report report : reports) {
            if (report.getId().equals(Integer.parseInt(request.getParameter("id")))){
                changeInspectorInReport(report);
                reportDAO.update(report);
            }
        }
        return reportsController.execute(request, response);
    }

    private void changeInspectorInReport(Report report){
        Inspector inspector = report.getInspector();
        inspector.setComplaintNumber(inspector.getComplaintNumber()+1);
        inspector.setReportsInService(inspector.getReportsInService()-1);
        inspectorDAO.update(inspector);

        inspector = getAnotherInspector(inspector);
        inspector.setReportsInService(inspector.getReportsInService()+1);
        report.setInspector(inspector);
        inspectorDAO.update(inspector);
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

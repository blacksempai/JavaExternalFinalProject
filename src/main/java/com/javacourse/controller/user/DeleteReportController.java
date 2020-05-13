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

@Controller(url = "/user/delete-report", method = "GET")
public class DeleteReportController implements ControllerCommand {
    private ReportDAO reportDAO;

    public DeleteReportController(DAOFactory factory) {
        reportDAO = factory.createReportDAO();
    }

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        List<TaxReport> reports = reportDAO.getReportsByUser(user);
        for (TaxReport report : reports) {
            if (report.getId().equals(Integer.parseInt(request.getParameter("id")))){
                reportDAO.deleteReport(report);
            }
        }
        return new Page(PagePath.getProperty("page.home"),Page.DispatchType.REDIRECT);
    }

}

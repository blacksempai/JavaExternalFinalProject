package com.javacourse.controller.inspector;

import com.javacourse.annotations.Controller;
import com.javacourse.controller.utils.ControllerCommand;
import com.javacourse.dao.ReportDAO;
import com.javacourse.dao.factory.DAOFactory;
import com.javacourse.model.entities.Inspector;
import com.javacourse.model.entities.TaxReport;
import com.javacourse.view.Page;
import com.javacourse.view.PagePath;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller(url = "/inspector/reports", method = "GET")
public class DisplayPendingReportsController implements ControllerCommand {
    private ReportDAO reportDAO;

    public DisplayPendingReportsController(DAOFactory factory) {
        reportDAO = factory.createReportDAO();
    }

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        Inspector inspector = (Inspector) request.getSession().getAttribute("inspector");
        List<TaxReport> reports = reportDAO.getReportsByInspector(inspector);
        removeAllNonPendingReports(reports);
        request.setAttribute("reports", reports);
        return new Page(PagePath.getProperty("page.inspector-reports"),Page.DispatchType.FORWARD);
    }

    private void removeAllNonPendingReports(List<TaxReport> reports){
        reports.removeIf(report -> !report.getStatus().equals(TaxReport.Status.PENDING));
    }
}

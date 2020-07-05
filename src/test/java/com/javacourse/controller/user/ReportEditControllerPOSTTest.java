package com.javacourse.controller.user;

import com.javacourse.controller.utils.ReportTag;
import com.javacourse.dao.InspectorDAO;
import com.javacourse.dao.ReportDAO;
import com.javacourse.dao.factory.DAOFactory;
import com.javacourse.model.TaxGroup;
import com.javacourse.model.entities.Inspector;
import com.javacourse.model.entities.TaxReport;
import com.javacourse.model.entities.User;
import com.javacourse.model.entities.report.Report;
import com.javacourse.view.Messages;
import com.javacourse.view.PagePath;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReportEditControllerPOSTTest {

    private ReportEditControllerPOST editController;

    @Mock
    private DAOFactory factory;

    @Mock
    private ReportDAO reportDAO;
    @Mock
    private InspectorDAO inspectorDAO;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    @Before
    public void setUp() throws Exception {
        when(factory.createReportDAO()).thenReturn(reportDAO);
        when(factory.createInspectorDAO()).thenReturn(inspectorDAO);
        editController = new ReportEditControllerPOST(factory);
    }

    @After
    public void tearDown() throws Exception {
        reset(factory, request, response, session);
    }

    @Test
    public void givenValidReport_whenReportEditController_thenSuccess() {
        setupValidHttpRequest();
        User user = new User();
        Report report = new Report();
        report.setUser(user);
        report.setId(10);
        List<Report> reports = new ArrayList<>();
        reports.add(report);

        when(request.getSession()).thenReturn(session);
        when(request.getParameter("id")).thenReturn("10");
        when(session.getAttribute("user")).thenReturn(user);
        when(reportDAO.getReportsByUser(user)).thenReturn(reports);
        doNothing().when(inspectorDAO).update(any());

        String pagePath = editController.execute(request,response).getViewLocation();

        verify(reportDAO).update(any());
        verify(request,times(0)).setAttribute("message", Messages.getProperty("msg.form-error", request));
        assertEquals(PagePath.getProperty("page.home"),pagePath);
    }

    @Test
    public void givenInvalidReport_whenReportEditController_thenReturnFailMsg() {
        setupInvalidHttpRequest();
        User user = new User();
        user.setGroup(TaxGroup.FIRST);
        Report report = new Report();
        report.setUser(user);
        report.setId(10);
        List<Report> reports = new ArrayList<>();
        reports.add(report);


        when(request.getSession()).thenReturn(session);
        when(request.getParameter("id")).thenReturn("10");
        when(session.getAttribute("user")).thenReturn(user);
        when(reportDAO.getReportsByUser(user)).thenReturn(reports);
        doNothing().when(inspectorDAO).update(any());

        String pagePath = editController.execute(request,response).getViewLocation();

        verify(reportDAO,times(0)).update(any());
        verify(request).setAttribute("message", Messages.getProperty("msg.form-error", request));
        assertEquals(PagePath.getProperty("page.report-edit")+"?id=10",pagePath);
    }

    private void setupValidHttpRequest(){
        when(request.getParameter(ReportTag.YEAR.getTag())).thenReturn("2020");
        when(request.getParameter(ReportTag.SPECIFIED_YEAR.getTag())).thenReturn("2020");
        when(request.getParameter(ReportTag.FIRST_GROUP_ADVANCED_PAYMENT_I.getTag())).thenReturn("90.50");
        when(request.getParameter(ReportTag.FIRST_GROUP_ADVANCED_PAYMENT_II.getTag())).thenReturn("90.50");
        when(request.getParameter(ReportTag.FIRST_GROUP_ADVANCED_PAYMENT_III.getTag())).thenReturn("90.50");
        when(request.getParameter(ReportTag.FIRST_GROUP_ADVANCED_PAYMENT_IV.getTag())).thenReturn("90.50");
        when(request.getParameter(ReportTag.FIRST_GROUP_INCOME_VOLUME.getTag())).thenReturn("2125.95");
        when(request.getParameter(ReportTag.FIRST_GROUP_TAXED_INCOME_VOLUME.getTag())).thenReturn("2125.95");
        when(request.getParameter(ReportTag.SECOND_GROUP_ADVANCED_PAYMENT_I.getTag())).thenReturn("90.50");
        when(request.getParameter(ReportTag.SECOND_GROUP_ADVANCED_PAYMENT_II.getTag())).thenReturn("90.50");
        when(request.getParameter(ReportTag.SECOND_GROUP_ADVANCED_PAYMENT_III.getTag())).thenReturn("90.50");
        when(request.getParameter(ReportTag.SECOND_GROUP_ADVANCED_PAYMENT_IV.getTag())).thenReturn("90.50");
        when(request.getParameter(ReportTag.SECOND_GROUP_INCOME_VOLUME.getTag())).thenReturn("2125.95");
        when(request.getParameter(ReportTag.SECOND_GROUP_TAXED_INCOME_VOLUME.getTag())).thenReturn("2125.95");
        when(request.getParameter(ReportTag.THIRD_GROUP_3_PERCENT_TAXED.getTag())).thenReturn("0");
        when(request.getParameter(ReportTag.THIRD_GROUP_5_PERCENT_TAXED.getTag())).thenReturn("0");
        when(request.getParameter(ReportTag.THIRD_GROUP_15_PERCENT_TAXED.getTag())).thenReturn("0");
        when(request.getParameter(ReportTag.TYPE.getTag())).thenReturn("01zvitna");
        when(request.getParameter(ReportTag.PERIOD.getTag())).thenReturn("1kvartal");
        when(request.getParameter(ReportTag.SPECIFIED_PERIOD.getTag())).thenReturn("1kvartal");
        when(request.getParameter(ReportTag.AUTHORITY_NAME.getTag())).thenReturn("Полтавська ДПІ");
        when(request.getParameter(ReportTag.SPECIFIED_TAX_AMOUNT.getTag())).thenReturn("10");
        when(request.getParameter(ReportTag.FINE_PERCENT.getTag())).thenReturn("5");
        when(request.getParameter(ReportTag.SINGLE_TAX_AMOUNT.getTag())).thenReturn("10");
        when(request.getParameter(ReportTag.EMPLOYEES_AMOUNT.getTag())).thenReturn("20");
        when(request.getParameter(ReportTag.PENNY_SUM.getTag())).thenReturn("20");
    }

    private void setupInvalidHttpRequest(){
        when(request.getParameter(ReportTag.YEAR.getTag())).thenReturn(null);
        when(request.getParameter(ReportTag.SPECIFIED_YEAR.getTag())).thenReturn("2020");
        when(request.getParameter(ReportTag.FIRST_GROUP_ADVANCED_PAYMENT_I.getTag())).thenReturn("90,50");
        when(request.getParameter(ReportTag.FIRST_GROUP_ADVANCED_PAYMENT_II.getTag())).thenReturn("90,50");
        when(request.getParameter(ReportTag.FIRST_GROUP_ADVANCED_PAYMENT_III.getTag())).thenReturn("90.50");
        when(request.getParameter(ReportTag.FIRST_GROUP_ADVANCED_PAYMENT_IV.getTag())).thenReturn("90.50");
        when(request.getParameter(ReportTag.FIRST_GROUP_INCOME_VOLUME.getTag())).thenReturn("0067.95");
        when(request.getParameter(ReportTag.FIRST_GROUP_TAXED_INCOME_VOLUME.getTag())).thenReturn("tj");
        when(request.getParameter(ReportTag.SECOND_GROUP_ADVANCED_PAYMENT_I.getTag())).thenReturn("90.50");
        when(request.getParameter(ReportTag.SECOND_GROUP_ADVANCED_PAYMENT_II.getTag())).thenReturn("90.50");
        when(request.getParameter(ReportTag.SECOND_GROUP_ADVANCED_PAYMENT_III.getTag())).thenReturn("90.50");
        when(request.getParameter(ReportTag.SECOND_GROUP_ADVANCED_PAYMENT_IV.getTag())).thenReturn("90.50");
        when(request.getParameter(ReportTag.SECOND_GROUP_INCOME_VOLUME.getTag())).thenReturn("2125.95");
        when(request.getParameter(ReportTag.SECOND_GROUP_TAXED_INCOME_VOLUME.getTag())).thenReturn("2125.95");
        when(request.getParameter(ReportTag.THIRD_GROUP_3_PERCENT_TAXED.getTag())).thenReturn("0");
        when(request.getParameter(ReportTag.THIRD_GROUP_5_PERCENT_TAXED.getTag())).thenReturn("0");
        when(request.getParameter(ReportTag.THIRD_GROUP_15_PERCENT_TAXED.getTag())).thenReturn("0");
        when(request.getParameter(ReportTag.TYPE.getTag())).thenReturn("01zvitna");
        when(request.getParameter(ReportTag.PERIOD.getTag())).thenReturn("1kvartal");
        when(request.getParameter(ReportTag.SPECIFIED_PERIOD.getTag())).thenReturn("1kvartal");
        when(request.getParameter(ReportTag.AUTHORITY_NAME.getTag())).thenReturn("Полтавська ДПІ");
        when(request.getParameter(ReportTag.SPECIFIED_TAX_AMOUNT.getTag())).thenReturn("10");
        when(request.getParameter(ReportTag.FINE_PERCENT.getTag())).thenReturn("5");
        when(request.getParameter(ReportTag.SINGLE_TAX_AMOUNT.getTag())).thenReturn("10");
        when(request.getParameter(ReportTag.EMPLOYEES_AMOUNT.getTag())).thenReturn("20");
        when(request.getParameter(ReportTag.PENNY_SUM.getTag())).thenReturn("20");
    }
}
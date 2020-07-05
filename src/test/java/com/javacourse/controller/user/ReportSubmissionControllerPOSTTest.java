package com.javacourse.controller.user;

import com.javacourse.controller.utils.ReportTag;
import com.javacourse.dao.InspectorDAO;
import com.javacourse.dao.ReportDAO;
import com.javacourse.dao.factory.DAOFactory;
import com.javacourse.model.TaxGroup;
import com.javacourse.model.entities.Inspector;
import com.javacourse.model.entities.User;
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

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ReportSubmissionControllerPOSTTest {

    private ReportSubmissionControllerPOST submissionController;

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
        submissionController = new ReportSubmissionControllerPOST(factory);
    }

    @After
    public void tearDown() throws Exception {
        reset(factory, request, response, session);
    }

    @Test
    public void givenValidReport_whenReportSubmissionController_thenSuccess() {
        setupValidHttpRequest();

        User user = new User();
        user.setGroup(TaxGroup.FIRST);
        Inspector inspector = new Inspector();
        Integer expectedReportsInService = 1;
        inspector.setReportsInService(0);


        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("user")).thenReturn(user);
        when(inspectorDAO.getInspectorWithLessReportsInService()).thenReturn(inspector);
        doNothing().when(inspectorDAO).update(any());
        doNothing().when(reportDAO).create(any());

        String pagePath = submissionController.execute(request,response).getViewLocation();

        verify(reportDAO).create(any());
        verify(request,times(0)).setAttribute("message", Messages.getProperty("msg.form-error", request));
        assertEquals(expectedReportsInService,inspector.getReportsInService());
        assertEquals(PagePath.getProperty("page.home"),pagePath);
    }

    @Test
    public void givenInvalidReport_whenReportSubmissionController_thenReturnFailMsg() {
        setupInvalidHttpRequest();
        User user = new User();
        user.setGroup(TaxGroup.FIRST);
        Inspector inspector = new Inspector();
        Integer expectedReportsInService = 0;
        inspector.setReportsInService(0);


        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("user")).thenReturn(user);
        when(inspectorDAO.getInspectorWithLessReportsInService()).thenReturn(inspector);
        doNothing().when(inspectorDAO).update(any());
        doNothing().when(reportDAO).create(any());

        String pagePath = submissionController.execute(request,response).getViewLocation();

        verify(reportDAO,times(0)).create(any());
        verify(request).setAttribute("message", Messages.getProperty("msg.form-error", request));
        assertEquals(expectedReportsInService,inspector.getReportsInService());
        assertEquals(PagePath.getProperty("page.report-form"),pagePath);
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
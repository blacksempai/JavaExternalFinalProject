package com.javacourse.controller.inspector;

import com.javacourse.dao.InspectorDAO;
import com.javacourse.dao.ReportDAO;
import com.javacourse.dao.factory.DAOFactory;
import com.javacourse.model.entities.Inspector;
import com.javacourse.model.entities.report.Report;
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
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ReportReviewSubmissionControllerTest {

    private ReportReviewSubmissionController submissionController;

    @Mock
    private DAOFactory factory;

    @Mock
    private InspectorDAO inspectorDAO;

    @Mock
    private ReportDAO reportDAO;

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
        submissionController = new ReportReviewSubmissionController(factory);
    }

    @After
    public void tearDown() throws Exception {
        reset(factory,request,response,session);
    }

    @Test
    public void givenValidRequest_whenReportReviewSubmissionController_thenUpdateInspectorAndSuccess(){
        Inspector inspector = new Inspector();
        inspector.setReportsInService(2);
        Integer expectedReportsInService = 1;
        Report report = new Report();
        report.setId(10);
        List<Report> reports = new ArrayList<>();
        reports.add(report);

        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("inspector")).thenReturn(inspector);
        when(request.getParameter("id")).thenReturn("10");
        when(request.getParameter("status")).thenReturn("false");
        when(request.getParameter("review_text")).thenReturn("Неправильно вказаний рік");
        when(reportDAO.getReportsByInspector(inspector)).thenReturn(reports);
        doNothing().when(reportDAO).update(report);
        doNothing().when(inspectorDAO).update(inspector);

        String pagePath = submissionController.execute(request,response).getViewLocation();


        verify(reportDAO).getReportsByInspector(inspector);
        verify(reportDAO).update(report);
        verify(inspectorDAO).update(inspector);

        assertEquals(expectedReportsInService,inspector.getReportsInService());
        assertEquals(PagePath.getProperty("page.inspector-reports"),pagePath);
    }
}
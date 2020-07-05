package com.javacourse.controller.user;

import com.javacourse.controller.auth.SignInControllerPOST;
import com.javacourse.dao.AdminDAO;
import com.javacourse.dao.InspectorDAO;
import com.javacourse.dao.ReportDAO;
import com.javacourse.dao.UserDAO;
import com.javacourse.dao.factory.DAOFactory;
import com.javacourse.model.entities.User;
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

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DeleteReportControllerTest {

    private DeleteReportController reportController;

    @Mock
    private DAOFactory factory;

    @Mock
    private ReportDAO reportDAO;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    @Before
    public void setUp() {
        when(factory.createReportDAO()).thenReturn(reportDAO);
        reportController = new DeleteReportController(factory);
    }

    @After
    public void cleanup() {
        reset(factory, request, response, session);
    }

    @Test
    public void givenValidId_whenDeleteReportController_thenSuccess() {
        User user = new User();
        List<Report> reports = new LinkedList<>();
        Report report = new Report();
        report.setId(10);
        reports.add(report);
        when(request.getParameter("id")).thenReturn("10");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("user")).thenReturn(user);
        when(reportDAO.getReportsByUser(user)).thenReturn(reports);
        doNothing().when(reportDAO).delete(any());

        String pagePath = reportController.execute(request,response).getViewLocation();

        verify(request,times(2)).getSession();
        verify(session,times(2)).getAttribute("user");
        verify(request).getParameter("id");
        verify(reportDAO,times(1)).delete(report);

        assertEquals(PagePath.getProperty("page.reports"),pagePath);
    }

    @Test
    public void givenInvalidId_whenDeleteReportController_thenFail() {
        User user = new User();
        List<Report> reports = new LinkedList<>();
        Report report = new Report();
        report.setId(10);
        reports.add(report);
        when(request.getParameter("id")).thenReturn("9");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("user")).thenReturn(user);
        when(reportDAO.getReportsByUser(user)).thenReturn(reports);
        doNothing().when(reportDAO).delete(any());

        String pagePath = reportController.execute(request,response).getViewLocation();

        verify(request,times(2)).getSession();
        verify(session,times(2)).getAttribute("user");
        verify(request).getParameter("id");
        verify(reportDAO,times(0)).delete(report);

        assertEquals(PagePath.getProperty("page.reports"),pagePath);
    }
}
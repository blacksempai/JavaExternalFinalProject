package com.javacourse.controller.user;

import com.javacourse.controller.utils.ReportTag;
import com.javacourse.dao.ReportDAO;
import com.javacourse.dao.factory.DAOFactory;
import com.javacourse.model.entities.User;
import com.javacourse.model.entities.report.*;
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
public class DisplayReportControllerTest {

    private DisplayReportController displayController;

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
    public void setUp(){
        when(factory.createReportDAO()).thenReturn(reportDAO);
        displayController = new DisplayReportController(factory);
    }

    @After
    public void tearDown(){
        reset(factory,request,response,session);
    }

    @Test
    public void givenValidId_whenDisplayReportController_thenSuccess(){
        User user = new User();
        Report report = getValidReport(user);
        List<Report> reports = new ArrayList<>();
        reports.add(report);


        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("user")).thenReturn(user);
        when(request.getParameter("id")).thenReturn("10");
        when(reportDAO.getReportsByUser(user)).thenReturn(reports);

        String pagePath = displayController.execute(request,response).getViewLocation();

        assertEquals(PagePath.getProperty("page.report-view"),pagePath);
    }

    @Test
    public void givenInvalidId_whenDisplayReportController_thenFail(){
        User user = new User();
        Report report = getValidReport(user);
        List<Report> reports = new ArrayList<>();
        reports.add(report);


        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("user")).thenReturn(user);
        when(request.getParameter("id")).thenReturn("11");
        when(reportDAO.getReportsByUser(user)).thenReturn(reports);

        String pagePath = displayController.execute(request,response).getViewLocation();

        assertEquals(PagePath.getProperty("page.error"),pagePath);
    }

    private Report getValidReport(User user){
        Report report = new Report();
        ReportBody body = new ReportBody();
        Info info = new Info();
        FirstGroup firstGroup = new FirstGroup();
        SecondGroup secondGroup = new SecondGroup();
        ThirdGroup thirdGroup = new ThirdGroup();
        General general = new General();
        ErrorReport errorReport = new ErrorReport();
        report.setId(10);
        report.setUser(user);
        report.setReportBody(body);
        body.setInfo(info);
        body.setFirstGroup(firstGroup);
        body.setSecondGroup(secondGroup);
        body.setThirdGroup(thirdGroup);
        body.setGeneral(general);
        body.setErrorReport(errorReport);
        info.setYear((short) 2020);
        info.setSpecifiedYear((short) 2020);
        info.setType(Info.Type.SIMPLE);
        info.setPeriod(Info.Period.I_QUARTER);
        info.setSpecifiedPeriod(Info.Period.I_QUARTER);
        info.setAuthorityName("Полтавська ДПІ");
        firstGroup.setFirstQuarter(90.50);
        firstGroup.setSecondQuarter(90.50);
        firstGroup.setThirdQuarter(90.50);
        firstGroup.setForthQuarter(90.50);
        firstGroup.setIncomeVolume01(2125.95);
        firstGroup.setTaxedIncomeVolume02(2125.95);
        general.setEmployeesNumber(0);
        errorReport.setSingleTax15(0);
        errorReport.setSpecifiedTax16(0);
        errorReport.setPennySum20(0);
        errorReport.setFinePercent((short) 0);
        return report;
    }

}
package com.javacourse.controller.admin;

import com.javacourse.controller.auth.SignUpControllerPOST;
import com.javacourse.dao.AdminDAO;
import com.javacourse.dao.InspectorDAO;
import com.javacourse.dao.UserDAO;
import com.javacourse.dao.factory.DAOFactory;
import com.javacourse.view.PagePath;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class InspectorAddControllerTest {

    private InspectorAddController inspectorAddController;

    @Mock
    private DAOFactory factory;

    @Mock
    private UserDAO userDAO;
    @Mock
    private InspectorDAO inspectorDAO;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Before
    public void setUp() throws Exception {
        when(factory.createUserDAO()).thenReturn(userDAO);
        when(factory.createInspectorDAO()).thenReturn(inspectorDAO);
        inspectorAddController = new InspectorAddController(factory);
    }

    @After
    public void tearDown() throws Exception {
        reset(factory, request, response);
    }

    @Test
    public void givenValidCredentials_whenSignUpCommand_thenSuccess() {
        when(userDAO.isExists(any())).thenReturn(false);
        when(inspectorDAO.isExists(any())).thenReturn(false);
        doNothing().when(inspectorDAO).create(any());
        when(request.getParameter("login")).thenReturn("inspector");
        when(request.getParameter("password")).thenReturn("GoodPass99");
        when(request.getParameter("passwordConfirm")).thenReturn("GoodPass99");
        when(request.getParameter("full_name")).thenReturn("Иван Иванов");
        when(request.getParameter("email")).thenReturn("valid@mail.com");
        when(request.getParameter("complaints")).thenReturn("0");
        when(request.getParameter("service")).thenReturn("0");

        String pagePath = inspectorAddController.execute(request,response).getViewLocation();

        verify(inspectorDAO).create(any());
        assertEquals(PagePath.getProperty("page.admin"),pagePath);
    }

    @Test
    public void givenInvalidCredentials_whenSignUpCommand_thenFail() {
        when(userDAO.isExists(any())).thenReturn(false);
        when(inspectorDAO.isExists(any())).thenReturn(false);
        doNothing().when(inspectorDAO).create(any());
        when(request.getParameter("login")).thenReturn("inspector");
        when(request.getParameter("password")).thenReturn("bad");
        when(request.getParameter("passwordConfirm")).thenReturn("bed");
        when(request.getParameter("full_name")).thenReturn("Иван Иванов");
        when(request.getParameter("email")).thenReturn("invalidmail.om");
        when(request.getParameter("complaints")).thenReturn("0");
        when(request.getParameter("service")).thenReturn("0");

        String pagePath = inspectorAddController.execute(request,response).getViewLocation();

        verify(inspectorDAO,times(0)).create(any());
        assertEquals(PagePath.getProperty("page.admin"),pagePath);
    }
}
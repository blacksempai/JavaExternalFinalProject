package com.javacourse.controller.auth;

import com.javacourse.dao.AdminDAO;
import com.javacourse.dao.InspectorDAO;
import com.javacourse.dao.UserDAO;
import com.javacourse.dao.factory.DAOFactory;
import com.javacourse.model.entities.User;
import com.javacourse.view.PagePath;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SignInControllerPOSTTest {

    private SignInControllerPOST signInController;

    @Mock
    private DAOFactory factory;

    @Mock
    private UserDAO userDAO;
    @Mock
    private InspectorDAO inspectorDAO;
    @Mock
    private AdminDAO adminDAO;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    @Before
    public void setUp() {
        when(factory.createAdminDAO()).thenReturn(adminDAO);
        when(factory.createInspectorDAO()).thenReturn(inspectorDAO);
        when(factory.createUserDAO()).thenReturn(userDAO);
        signInController = new SignInControllerPOST(factory);
    }

    @After
    public void cleanup() {
        reset(factory, request, response, session);
    }

    @Test
    public void givenValidCredentials_whenSignInCommand_thenSuccess() {
        User user = new User();
        user.setPasswordHash("R9eVAMK6l3WAQIlD2iO1TQ==");
        user.setSalt("Ab+X/QLUJu1CfntJIxcchA==");
        when(userDAO.isExists(any())).thenReturn(true);
        when(userDAO.getByLogin(any())).thenReturn(user);
        when(request.getSession()).thenReturn(session);
        when(request.getParameter("login")).thenReturn("user");
        when(request.getParameter("password")).thenReturn("Root2000");
        doNothing().when(session).setAttribute("user", user);

        String pagePath = signInController.execute(request,response).getViewLocation();

        verify(request).getParameter("login");
        verify(request).getParameter("password");
        verify(userDAO).isExists(any());
        verify(userDAO).getByLogin(any());
        verify(request).getSession();
        assertEquals(PagePath.getProperty("page.home"),pagePath);
    }

    @Test
    public void givenInValidCredentials_whenSignInCommand_thenFail() {
        User user = new User();
        user.setPasswordHash("R9eVAMK6l3WAQRHD2iO1TQ==");
        user.setSalt("Ab+X/QLUhR1CfntJIxcchA==");
        when(userDAO.isExists(any())).thenReturn(true);
        when(userDAO.getByLogin(any())).thenReturn(user);
        when(request.getSession()).thenReturn(session);
        when(request.getParameter("login")).thenReturn("user");
        when(request.getParameter("password")).thenReturn("Root2000");
        doNothing().when(session).setAttribute("user", user);

        String pagePath = signInController.execute(request,response).getViewLocation();

        verify(request).getParameter("login");
        verify(request).getParameter("password");
        verify(userDAO).isExists(any());
        verify(userDAO).getByLogin(any());
        verify(request,times(0)).getSession();
        assertEquals(PagePath.getProperty("page.sign-in"),pagePath);
    }
}
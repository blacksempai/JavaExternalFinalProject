package com.javacourse.controller.auth;

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
public class SignUpControllerPOSTTest {
    private SignUpControllerPOST signUpController;

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

    @Before
    public void setUp() throws Exception {
        when(factory.createUserDAO()).thenReturn(userDAO);
        when(factory.createInspectorDAO()).thenReturn(inspectorDAO);
        when(factory.createAdminDAO()).thenReturn(adminDAO);
        signUpController = new SignUpControllerPOST(factory);
    }

    @After
    public void tearDown() throws Exception {
        reset(factory, request, response);
    }

    @Test
    public void givenValidCredentials_whenSignUpCommand_thenSuccess() {
        when(userDAO.isExists(any())).thenReturn(false);
        doNothing().when(userDAO).create(any());
        when(request.getParameter("login")).thenReturn("user");
        when(request.getParameter("password")).thenReturn("GoodPass99");
        when(request.getParameter("passwordConfirm")).thenReturn("GoodPass99");
        when(request.getParameter("full_name")).thenReturn("Иван Иванов");
        when(request.getParameter("email")).thenReturn("valid@mail.com");
        when(request.getParameter("address")).thenReturn("ул. Валидная");
        when(request.getParameter("passport")).thenReturn("ВА112233");
        when(request.getParameter("group")).thenReturn("FIRST");

        String pagePath = signUpController.execute(request,response).getViewLocation();


        verify(userDAO).isExists(any());
        verify(userDAO).create(any());
        assertEquals(PagePath.getProperty("page.home"),pagePath);
    }

    @Test
    public void givenInvalidCredentials_whenSignInCommand_thenFail() {
        when(userDAO.isExists(any())).thenReturn(false);
        doNothing().when(userDAO).create(any());
        when(request.getParameter("login")).thenReturn("user");
        when(request.getParameter("password")).thenReturn("weak");
        when(request.getParameter("passwordConfirm")).thenReturn("weak");
        when(request.getParameter("full_name")).thenReturn("Ивалидов Дмитрий");
        when(request.getParameter("email")).thenReturn("invalid");
        when(request.getParameter("address")).thenReturn("ул. Инвалидная");
        when(request.getParameter("passport")).thenReturn("п345");
        when(request.getParameter("group")).thenReturn("FIRST");

        String pagePath = signUpController.execute(request,response).getViewLocation();

        verify(userDAO,times(0)).create(any());
        assertEquals(PagePath.getProperty("page.sign-up"),pagePath);
    }
}
package com.javacourse.controller.auth;

import com.javacourse.annotations.Controller;
import com.javacourse.controller.utils.ControllerCommand;
import com.javacourse.dao.AdminDAO;
import com.javacourse.dao.InspectorDAO;
import com.javacourse.dao.UserDAO;
import com.javacourse.dao.factory.DAOFactory;
import com.javacourse.model.entities.Admin;
import com.javacourse.model.entities.Inspector;
import com.javacourse.model.entities.User;
import com.javacourse.security.PasswordHashing;
import com.javacourse.view.Messages;
import com.javacourse.view.Page;
import com.javacourse.view.PagePath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller(url = "/auth/sign-in", method = "POST")
public class SignInControllerPOST implements ControllerCommand {
    private UserDAO userDAO;
    private InspectorDAO inspectorDAO;
    private AdminDAO adminDAO;
    private Page homePage;
    private Page signInPage;

    public SignInControllerPOST(DAOFactory factory) {
        userDAO = factory.createUserDAO();
        inspectorDAO = factory.createInspectorDAO();
        adminDAO = factory.createAdminDAO();
        homePage = new Page(PagePath.getProperty("page.home"),Page.DispatchType.REDIRECT);
        signInPage = new Page(PagePath.getProperty("page.sign-in"),Page.DispatchType.FORWARD);
    }

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (userDAO.isExists(login)){
            User user = userDAO.getUserByLogin(login);
            byte[] salt = PasswordHashing.stringToByte(user.getSalt());
            String passHash = PasswordHashing.getSaltedPasswordHash(password,salt);
            if (user.getPasswordHash().equals(passHash)){
                request.getSession().setAttribute("user",user);
                return homePage;
            }
        }
        if (inspectorDAO.isExists(login)){
            Inspector inspector = inspectorDAO.getInspectorByLogin(login);
            byte[] salt = PasswordHashing.stringToByte(inspector.getSalt());
            String passHash = PasswordHashing.getSaltedPasswordHash(password,salt);
            if (inspector.getPasswordHash().equals(passHash)){
                request.getSession().setAttribute("inspector",inspector);
                return homePage;
            }
        }
        if (adminDAO.isExists(login)){
            Admin admin = adminDAO.getAdminByLogin(login);
            byte[] salt = PasswordHashing.stringToByte(admin.getSalt());
            String passHash = PasswordHashing.getSaltedPasswordHash(password,salt);
            if (admin.getPasswordHash().equals(passHash)){
                request.getSession().setAttribute("admin",admin);
                return homePage;
            }
        }
        request.setAttribute("message", Messages.getProperty("msg.sign-in-error"));
        return signInPage;
    }
}

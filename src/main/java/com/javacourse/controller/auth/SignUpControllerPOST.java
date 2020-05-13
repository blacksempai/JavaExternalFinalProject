package com.javacourse.controller.auth;

import com.javacourse.annotations.Controller;
import com.javacourse.controller.utils.ControllerCommand;
import com.javacourse.dao.AdminDAO;
import com.javacourse.dao.InspectorDAO;
import com.javacourse.dao.UserDAO;
import com.javacourse.dao.factory.DAOFactory;
import com.javacourse.model.entities.User;
import com.javacourse.security.PasswordHashing;
import com.javacourse.view.Messages;
import com.javacourse.view.Page;
import com.javacourse.view.PagePath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller(url = "/auth/sign-up", method = "POST")
public class SignUpControllerPOST implements ControllerCommand {
    private UserDAO userDAO;
    private InspectorDAO inspectorDAO;
    private AdminDAO adminDAO;
    private Page successPage;
    private Page signUpPage;

    public SignUpControllerPOST(DAOFactory factory) {
        userDAO = factory.createUserDAO();
        inspectorDAO = factory.createInspectorDAO();
        adminDAO = factory.createAdminDAO();
        successPage = new Page(PagePath.getProperty("page.home"),Page.DispatchType.REDIRECT);
        signUpPage = new Page(PagePath.getProperty("page.sign-up"),Page.DispatchType.FORWARD);
    }

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        if (isValid(request)) {
            User user = buildUser(request);
            userDAO.addNewUser(user);
            return successPage;
        }
        return signUpPage;
    }

    //TODO unit testing if hash is ok; better hashing
    private User buildUser(HttpServletRequest request){
        User user = new User();
        byte[] salt = PasswordHashing.getSalt();
        String passHash = PasswordHashing.getSaltedPasswordHash(request.getParameter("password"),salt);
        String saltStr = PasswordHashing.byteToString(salt);
        user.setLogin(request.getParameter("login"));
        user.setPasswordHash(passHash);
        user.setSalt(saltStr);
        user.setFullName(request.getParameter("full_name"));
        user.setCompany(request.getParameter("company"));
        user.setEmail(request.getParameter("email"));
        return user;
    }

    private boolean isValid(HttpServletRequest request){
        if(request.getParameter("login")==null||(request.getParameter("password")==null||request.getParameter("email")==null)){
            request.setAttribute("message", Messages.getProperty("msg.fields-error"));
            return false;
        }
        if (!loginIsValid(request.getParameter("login"))){
            request.setAttribute("message",Messages.getProperty("msg.login-error"));
            return false;
        }
        if (!passwordIsValid(request.getParameter("password"))){
            request.setAttribute("message",Messages.getProperty("msg.pass-error"));
            return false;
        }
        if (!request.getParameter("password").equals(request.getParameter("passwordConfirm"))){
            request.setAttribute("message",Messages.getProperty("msg.pass-not-equal"));
            return false;
        }
        if (!emailIsValid(request.getParameter("email"))){
            request.setAttribute("message",Messages.getProperty("msg.mail-error"));
            return false;
        }
        if (!loginIsUnique(request.getParameter("login"))){
            request.setAttribute("message",Messages.getProperty("msg.login-exists"));
            return false;
        }
        return true;
    }

    private boolean loginIsValid(String login){
        Pattern pattenObj = Pattern
                .compile("^[0-9a-zA-Z]{3,20}$");
        Matcher matcherObj = pattenObj.matcher(login);
        return matcherObj.matches();
    }

    private boolean passwordIsValid(String password){
        Pattern pattenObj = Pattern
                .compile("^(?=.*[0-9].*)(?=.*[a-z].*)(?=.*[A-Z].*)[0-9a-zA-Z]{8,}$");
        Matcher matcherObj = pattenObj.matcher(password);
        return matcherObj.matches();
    }

    private boolean emailIsValid(String email){
        Pattern pattenObj = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcherObj = pattenObj.matcher(email);
        return matcherObj.matches();
    }

    private boolean loginIsUnique(String login){
        if (userDAO.isExists(login))
            return false;
        if (inspectorDAO.isExists(login))
            return false;
        if (adminDAO.isExists(login))
            return false;
        return true;
    }

}

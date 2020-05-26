package com.javacourse.controller.auth;

import com.javacourse.annotations.Controller;
import com.javacourse.controller.ControllerCommand;
import com.javacourse.view.Page;
import com.javacourse.view.PagePath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller(url = "/auth/sign-out", method = "GET")
public class SignOutController implements ControllerCommand {
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        return new Page(PagePath.getProperty("page.home"),Page.DispatchType.REDIRECT);
    }
}

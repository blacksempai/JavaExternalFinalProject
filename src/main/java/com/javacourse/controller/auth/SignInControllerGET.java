package com.javacourse.controller.auth;

import com.javacourse.annotations.Controller;
import com.javacourse.controller.utils.ControllerCommand;
import com.javacourse.view.Page;
import com.javacourse.view.PagePath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller(url = "/auth/sign-in", method = "GET")
public class SignInControllerGET implements ControllerCommand {
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        return new Page(PagePath.getProperty("page.sign-in"),Page.DispatchType.FORWARD);
    }
}

package com.javacourse.controller.user;

import com.javacourse.annotations.Controller;
import com.javacourse.controller.ControllerCommand;
import com.javacourse.view.Page;
import com.javacourse.view.PagePath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller(url = "/user/new-report", method = "GET")
public class ReportSubmissionControllerGET implements ControllerCommand {
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        return new Page(PagePath.getProperty("page.report-form"),Page.DispatchType.FORWARD);
    }

}

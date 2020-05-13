package com.javacourse.controller.inspector;

import com.javacourse.annotations.Controller;
import com.javacourse.controller.utils.ControllerCommand;
import com.javacourse.view.Page;
import com.javacourse.view.PagePath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller(url = "/inspector/profile", method = "GET")
public class InspectorProfileController implements ControllerCommand {

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        return new Page(PagePath.getProperty("page.inspector-profile"),Page.DispatchType.FORWARD);
    }
}

package com.javacourse.controller.admin;

import com.javacourse.annotations.Controller;
import com.javacourse.controller.utils.ControllerCommand;
import com.javacourse.controller.utils.ControllerMappingHandler;
import com.javacourse.view.Page;
import com.javacourse.view.PagePath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller(url = "/admin/add-controller", method = "GET")
public class ControllerRegisterer implements ControllerCommand {

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            Class cl = Class.forName(request.getParameter("class"));
            ControllerCommand controller = (ControllerCommand) cl.newInstance();
            ControllerMappingHandler holder = ControllerMappingHandler.getInstance();
            holder.addController(controller);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return new Page(PagePath.getProperty("page.home"),Page.DispatchType.REDIRECT);
    }
}

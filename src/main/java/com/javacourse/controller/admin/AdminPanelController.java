package com.javacourse.controller.admin;

import com.javacourse.annotations.Controller;
import com.javacourse.controller.utils.ControllerCommand;
import com.javacourse.dao.InspectorDAO;
import com.javacourse.dao.factory.DAOFactory;
import com.javacourse.view.Page;
import com.javacourse.view.PagePath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller(url = "/admin/panel", method = "GET")
public class AdminPanelController implements ControllerCommand {
    private InspectorDAO inspectorDAO;

    public AdminPanelController(DAOFactory factory) {
        inspectorDAO = factory.createInspectorDAO();
    }

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("inspectors",inspectorDAO.getAllInspectors());
        return new Page(PagePath.getProperty("page.admin"),Page.DispatchType.FORWARD);
    }
}

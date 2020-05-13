package com.javacourse.web;

import com.javacourse.controller.utils.ControllerCommand;
import com.javacourse.controller.utils.ControllerMappingHandler;
import com.javacourse.view.Page;
import com.javacourse.view.PagePath;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "dispatcherServlet", urlPatterns = {"/user/*","/auth/*","/inspector/*","/admin/*"})
public class DispatcherServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(DispatcherServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        dispatchToRequestedPage(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        dispatchToRequestedPage(request,response);
    }

    protected void dispatchToRequestedPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        ControllerMappingHandler mappingHandler = ControllerMappingHandler.getInstance();
        try {
            ControllerCommand controller = mappingHandler.getController(request);
            Page page = controller.execute(request,response);
            if (page.getDispatchType().equals(Page.DispatchType.FORWARD)) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page.getViewLocation());
                dispatcher.forward(request, response);
            }
            else {
                response.sendRedirect(page.getViewLocation());
            }
        } catch (Exception e) {
            logger.error("User tried to reach address:"+request.getRequestURI(),e);
            logger.error(e.getClass());
            e.printStackTrace();
            response.sendRedirect(PagePath.getProperty("page.error"));
        }
    }

}

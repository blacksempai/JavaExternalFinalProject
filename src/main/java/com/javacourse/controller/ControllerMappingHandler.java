package com.javacourse.controller;

import com.javacourse.annotations.Controller;
import com.javacourse.controller.admin.AdminPanelController;
import com.javacourse.controller.admin.InspectorAddController;
import com.javacourse.controller.admin.InspectorChangeController;
import com.javacourse.controller.auth.*;
import com.javacourse.controller.inspector.DisplayPendingReportsController;
import com.javacourse.controller.inspector.InspectorProfileController;
import com.javacourse.controller.inspector.ReportReviewController;
import com.javacourse.controller.inspector.ReportReviewSubmissionController;
import com.javacourse.controller.user.*;
import com.javacourse.dao.factory.DAOFactory;
import com.javacourse.dao.factory.MySqlDAOFactory;
import com.javacourse.exceptions.ControllerNotFound;
import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.util.LinkedList;
import java.util.List;

public class ControllerMappingHandler {
    private DAOFactory factory;
    private List<ControllerCommand> controllers;
    private static ControllerMappingHandler instance;

    private ControllerMappingHandler(){
        factory = new MySqlDAOFactory();
        controllers = new LinkedList<>();
        controllers.add(new SignUpControllerPOST(factory));
        controllers.add(new SignUpControllerGET());
        controllers.add(new SignInControllerPOST(factory));
        controllers.add(new SignInControllerGET());
        controllers.add(new SignOutController());

        controllers.add(new ReportSubmissionControllerGET());
        controllers.add(new ReportSubmissionControllerPOST(factory));
        controllers.add(new DisplayAllReportsController(factory));
        controllers.add(new DisplayReportController(factory));
        controllers.add(new ReportEditControllerGET(factory));
        controllers.add(new ReportEditControllerPOST(factory));
        controllers.add(new ChangeInspectorController(factory));
        controllers.add(new UserProfileController());
        controllers.add(new DeleteReportController(factory));

        controllers.add(new DisplayPendingReportsController(factory));
        controllers.add(new ReportReviewController(factory));
        controllers.add(new ReportReviewSubmissionController(factory));
        controllers.add(new InspectorProfileController());

        controllers.add(new AdminPanelController(factory));
        controllers.add(new InspectorAddController(factory));
        controllers.add(new InspectorChangeController(factory));
    }

    public static ControllerMappingHandler getInstance(){
        ControllerMappingHandler localInstance = instance;
        if (localInstance == null){
            synchronized (ControllerMappingHandler.class){
                localInstance = instance;
                if (localInstance == null){
                    instance = new ControllerMappingHandler();
                }
            }
        }
        return instance;
    }

    public void addController(ControllerCommand controller){
        controllers.add(controller);
    }

    public ControllerCommand getController(HttpServletRequest request) throws Exception {
        String url = getUrlFromRequest(request);
        for (ControllerCommand controller : controllers) {
            for (Annotation annotation : controller.getClass().getAnnotations()) {
                if (annotation instanceof Controller) {
                    if (((Controller) annotation).url().equals(url)&&((Controller) annotation).method().equals(request.getMethod())){
                        return controller;
                    }
                }
            }
        }
        throw new ControllerNotFound();
    }

    private String getUrlFromRequest(HttpServletRequest request){
        String url = request.getRequestURI().replaceFirst(request.getContextPath(), "");
        if (url.contains("?")){
            return chopQuestionMarkOutOfGetUrl(url);
        }
        return url;
    }

    private String chopQuestionMarkOutOfGetUrl(String url){
        int i = url.indexOf('?');
        return url.substring(0,i-1);
    }
}

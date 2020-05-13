package com.javacourse.controller.utils;

import com.javacourse.view.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ControllerCommand {
    Page execute(HttpServletRequest request, HttpServletResponse response);
}

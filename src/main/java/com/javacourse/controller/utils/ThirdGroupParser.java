package com.javacourse.controller.utils;

import com.javacourse.model.entities.report.FirstGroup;
import com.javacourse.model.entities.report.SecondGroup;

import javax.servlet.http.HttpServletRequest;

public class ThirdGroupParser extends ReportParser {
    @Override
    protected FirstGroup parseFirstGroup(HttpServletRequest request) {
        return new FirstGroup();
    }

    @Override
    protected SecondGroup parseSecondGroup(HttpServletRequest request) {
        return new SecondGroup();
    }
}

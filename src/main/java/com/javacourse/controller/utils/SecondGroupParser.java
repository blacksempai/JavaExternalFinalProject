package com.javacourse.controller.utils;

import com.javacourse.model.entities.report.FirstGroup;
import com.javacourse.model.entities.report.SecondGroup;
import com.javacourse.model.entities.report.ThirdGroup;

import javax.servlet.http.HttpServletRequest;

public class SecondGroupParser extends ReportParser {
    @Override
    protected FirstGroup parseFirstGroup(HttpServletRequest request) {
        return new FirstGroup();
    }

    @Override
    protected ThirdGroup parseThirdGroup(HttpServletRequest request) {
        return new ThirdGroup();
    }
}

package com.javacourse.model;

import com.javacourse.controller.utils.FirstGroupParser;
import com.javacourse.controller.utils.ReportParser;
import com.javacourse.controller.utils.SecondGroupParser;
import com.javacourse.controller.utils.ThirdGroupParser;

public enum TaxGroup{
    FIRST(new FirstGroupParser()),
    SECOND(new SecondGroupParser()),
    THIRD(new ThirdGroupParser());

    private ReportParser parser;

    TaxGroup(ReportParser parser){
        this.parser = parser;
    }

    public ReportParser getReportParser(){
        return this.parser;
    }
}

package com.javacourse.model.entities.report;

public class ReportBody {
    private int id;
    private Info info;
    private General general;
    private FirstGroup firstGroup;
    private SecondGroup secondGroup;
    private ThirdGroup thirdGroup;
    private ErrorReport errorReport;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public General getGeneral() {
        return general;
    }

    public void setGeneral(General general) {
        this.general = general;
    }

    public FirstGroup getFirstGroup() {
        return firstGroup;
    }

    public void setFirstGroup(FirstGroup firstGroup) {
        this.firstGroup = firstGroup;
    }

    public SecondGroup getSecondGroup() {
        return secondGroup;
    }

    public void setSecondGroup(SecondGroup secondGroup) {
        this.secondGroup = secondGroup;
    }

    public ThirdGroup getThirdGroup() {
        return thirdGroup;
    }

    public void setThirdGroup(ThirdGroup thirdGroup) {
        this.thirdGroup = thirdGroup;
    }

    public ErrorReport getErrorReport() {
        return errorReport;
    }

    public void setErrorReport(ErrorReport errorReport) {
        this.errorReport = errorReport;
    }
}

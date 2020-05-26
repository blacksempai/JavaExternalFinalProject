package com.javacourse.model.entities;

public class Inspector extends Account {
    private String fullName;
    private Integer complaintNumber;
    private Integer reportsInService;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getComplaintNumber() {
        return complaintNumber;
    }

    public void setComplaintNumber(Integer complaintNumber) {
        this.complaintNumber = complaintNumber;
    }

    public Integer getReportsInService() {
        return reportsInService;
    }

    public void setReportsInService(Integer reportsInService) {
        this.reportsInService = reportsInService;
    }

}

package com.javacourse.model.entities.report;

import java.util.LinkedList;
import java.util.List;

public class General {
    private int id;
    private Integer employeesNumber;
    private List<BusinessActivity> activities;

    public General() {
        activities = new LinkedList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(Integer employeesNumber) {
        this.employeesNumber = employeesNumber;
    }

    public List<BusinessActivity> getActivities() {
        return activities;
    }

    public void setActivities(List<BusinessActivity> activities) {
        this.activities = activities;
    }
}

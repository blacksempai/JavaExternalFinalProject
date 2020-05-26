package com.javacourse.model.entities.report;

import com.javacourse.model.entities.Inspector;
import com.javacourse.model.entities.User;

import java.sql.Timestamp;

public class Report {
    private Integer id;
    private User user;
    private Inspector inspector;
    private Timestamp declarationSubmissionDate;
    private Report.Status status;
    private String review;
    private ReportBody reportBody;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Inspector getInspector() {
        return inspector;
    }

    public void setInspector(Inspector inspector) {
        this.inspector = inspector;
    }

    public Timestamp getDeclarationSubmissionDate() {
        return declarationSubmissionDate;
    }

    public void setDeclarationSubmissionDate(Timestamp declarationSubmissionDate) {
        this.declarationSubmissionDate = declarationSubmissionDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public ReportBody getReportBody() {
        return reportBody;
    }

    public void setReportBody(ReportBody reportBody) {
        this.reportBody = reportBody;
    }

    public enum Status{
        PENDING,
        DECLINED,
        ACCEPTED
    }
}

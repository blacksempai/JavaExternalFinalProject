package com.javacourse.model.entities;

import java.sql.Timestamp;
import java.util.*;

@Deprecated
public class TaxReport {
    private Integer id;
    private User user;
    private Inspector inspector;
    private Type type;
    private Period period;
    private short year;
    private Period specifiedPeriod;
    private short specifiedYear;
    private String authorityName;
    private String userFullName;
    private String userAddress;
    private String userPassportInfo;
    private int employeesNumber;
    private String businessActivity;
    private String businessActivityCode;
    private List<Double> firstGroupAdvancePayments;
    private double firstGroupIncomeVolume01;
    private double firstGroupTaxedIncomeVolume02;
    private List<Double> secondGroupAdvancePayments;
    private double secondGroupIncomeVolume03;
    private double secondGroupTaxedIncomeVolume04;
    private double thirdGroup3PercentTaxed05;
    private double thirdGroup5PercentTaxed06;
    private double thirdGroup15PercentTaxed07;
    private double singleTaxAmount15;
    private double specifiedTaxAmount16;
    private short finePercent;
    private double pennySum20;
    private Timestamp declarationSubmissionDate;
    private Status status;
    private String review;

    public TaxReport() {
        firstGroupAdvancePayments = new ArrayList<>(Arrays.asList(new Double[5]));
        secondGroupAdvancePayments = new ArrayList<>(Arrays.asList(new Double[5]));
    }

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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public Period getSpecifiedPeriod() {
        return specifiedPeriod;
    }

    public void setSpecifiedPeriod(Period specifiedPeriod) {
        this.specifiedPeriod = specifiedPeriod;
    }

    public short getSpecifiedYear() {
        return specifiedYear;
    }

    public void setSpecifiedYear(short specifiedYear) {
        this.specifiedYear = specifiedYear;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPassportInfo() {
        return userPassportInfo;
    }

    public void setUserPassportInfo(String userPassportInfo) {
        this.userPassportInfo = userPassportInfo;
    }

    public int getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(int employeesNumber) {
        this.employeesNumber = employeesNumber;
    }

    public String getBusinessActivity() {
        return businessActivity;
    }

    public void setBusinessActivity(String businessActivity) {
        this.businessActivity = businessActivity;
    }

    public String getBusinessActivityCode() {
        return businessActivityCode;
    }

    public void setBusinessActivityCode(String businessActivityCode) {
        this.businessActivityCode = businessActivityCode;
    }

    public List<Double> getFirstGroupAdvancePayments() {
        return firstGroupAdvancePayments;
    }

    public void setFirstGroupAdvancePayments(List<Double> firstGroupAdvancePayments) {
        this.firstGroupAdvancePayments = firstGroupAdvancePayments;
    }

    public double getFirstGroupIncomeVolume01() {
        return firstGroupIncomeVolume01;
    }

    public void setFirstGroupIncomeVolume01(double firstGroupIncomeVolume01) {
        this.firstGroupIncomeVolume01 = firstGroupIncomeVolume01;
    }

    public double getFirstGroupTaxedIncomeVolume02() {
        return firstGroupTaxedIncomeVolume02;
    }

    public void setFirstGroupTaxedIncomeVolume02(double firstGroupTaxedIncomeVolume02) {
        this.firstGroupTaxedIncomeVolume02 = firstGroupTaxedIncomeVolume02;
    }

    public List<Double> getSecondGroupAdvancePayments() {
        return secondGroupAdvancePayments;
    }

    public void setSecondGroupAdvancePayments(List<Double> secondGroupAdvancePayments) {
        this.secondGroupAdvancePayments = secondGroupAdvancePayments;
    }

    public double getSecondGroupIncomeVolume03() {
        return secondGroupIncomeVolume03;
    }

    public void setSecondGroupIncomeVolume03(double secondGroupIncomeVolume03) {
        this.secondGroupIncomeVolume03 = secondGroupIncomeVolume03;
    }

    public double getSecondGroupTaxedIncomeVolume04() {
        return secondGroupTaxedIncomeVolume04;
    }

    public void setSecondGroupTaxedIncomeVolume04(double secondGroupTaxedIncomeVolume04) {
        this.secondGroupTaxedIncomeVolume04 = secondGroupTaxedIncomeVolume04;
    }

    public double getThirdGroup3PercentTaxed05() {
        return thirdGroup3PercentTaxed05;
    }

    public void setThirdGroup3PercentTaxed05(double thirdGroup3PercentTaxed05) {
        this.thirdGroup3PercentTaxed05 = thirdGroup3PercentTaxed05;
    }

    public double getThirdGroup5PercentTaxed06() {
        return thirdGroup5PercentTaxed06;
    }

    public void setThirdGroup5PercentTaxed06(double thirdGroup5PercentTaxed06) {
        this.thirdGroup5PercentTaxed06 = thirdGroup5PercentTaxed06;
    }

    public double getThirdGroup15PercentTaxed07() {
        return thirdGroup15PercentTaxed07;
    }

    public void setThirdGroup15PercentTaxed07(double thirdGroup15PercentTaxed07) {
        this.thirdGroup15PercentTaxed07 = thirdGroup15PercentTaxed07;
    }

    public double getSingleTaxAmount15() {
        return singleTaxAmount15;
    }

    public void setSingleTaxAmount15(double singleTaxAmount15) {
        this.singleTaxAmount15 = singleTaxAmount15;
    }

    public double getSpecifiedTaxAmount16() {
        return specifiedTaxAmount16;
    }

    public void setSpecifiedTaxAmount16(double specifiedTaxAmount16) {
        this.specifiedTaxAmount16 = specifiedTaxAmount16;
    }

    public short getFinePercent() {
        return finePercent;
    }

    public void setFinePercent(short finePercent) {
        this.finePercent = finePercent;
    }

    public double getPennySum20() {
        return pennySum20;
    }

    public void setPennySum20(double pennySum20) {
        this.pennySum20 = pennySum20;
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

    public enum Period{
        I_QUARTER,
        II_QUARTER,
        III_QUARTER,
        IV_QUARTER
    }

    public enum Type{
        SIMPLE,
        SIMPLE_NEW,
        SPECIFYING,
        REFERENCING
    }

    public enum Status{
        PENDING,
        DECLINED,
        ACCEPTED
    }

    @Override
    public String toString() {
        return "TaxReport{" +
                "id=" + id +
                ", user=" + user +
                ", inspector=" + inspector +
                ", type=" + type +
                ", period=" + period +
                ", year=" + year +
                ", specifiedPeriod=" + specifiedPeriod +
                ", specifiedYear=" + specifiedYear +
                ", authorityName='" + authorityName + '\'' +
                ", userFullName='" + userFullName + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userPassportInfo='" + userPassportInfo + '\'' +
                ", employeesNumber=" + employeesNumber +
                ", businessActivity='" + businessActivity + '\'' +
                ", businessActivityCode='" + businessActivityCode + '\'' +
                ", firstGroupAdvancePayments=" + firstGroupAdvancePayments +
                ", firstGroupIncomeVolume01=" + firstGroupIncomeVolume01 +
                ", firstGroupTaxedIncomeVolume02=" + firstGroupTaxedIncomeVolume02 +
                ", secondGroupAdvancePayments=" + secondGroupAdvancePayments +
                ", secondGroupIncomeVolume03=" + secondGroupIncomeVolume03 +
                ", secondGroupTaxedIncomeVolume04=" + secondGroupTaxedIncomeVolume04 +
                ", thirdGroup3PercentTaxed05=" + thirdGroup3PercentTaxed05 +
                ", thirdGroup5PercentTaxed06=" + thirdGroup5PercentTaxed06 +
                ", thirdGroup15PercentTaxed07=" + thirdGroup15PercentTaxed07 +
                ", singleTaxAmount15=" + singleTaxAmount15 +
                ", specifiedTaxAmount16=" + specifiedTaxAmount16 +
                ", finePercent=" + finePercent +
                ", pennySum20=" + pennySum20 +
                ", declarationSubmissionDate=" + declarationSubmissionDate +
                ", status=" + status +
                ", review='" + review + '\'' +
                '}';
    }
}

package com.javacourse.model.entities.report;

public class Info {
    private int id;
    private Info.Type type;
    private Info.Period period;
    private short year;
    private Info.Period specifiedPeriod;
    private short specifiedYear;
    private String authorityName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}

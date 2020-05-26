package com.javacourse.model.entities.report;

public class ErrorReport {
    private int id;
    private double singleTax15;
    private double specifiedTax16;
    private short finePercent;
    private double pennySum20;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSingleTax15() {
        return singleTax15;
    }

    public void setSingleTax15(double singleTax15) {
        this.singleTax15 = singleTax15;
    }

    public double getSpecifiedTax16() {
        return specifiedTax16;
    }

    public void setSpecifiedTax16(double specifiedTax16) {
        this.specifiedTax16 = specifiedTax16;
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
}

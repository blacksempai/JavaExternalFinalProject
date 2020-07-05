package com.javacourse.model;

import com.javacourse.model.entities.User;
import com.javacourse.model.entities.report.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaxReportSummaryCalculatorTest {

    @Test
    public void calculateTotalIncome() {
        Double expected = 4251.9;
        Double actual = TaxReportSummaryCalculator.calculateTotalIncome(getValidReport().getReportBody());
        assertEquals(expected,actual);
    }

    @Test
    public void calculateSum15() {
        Double expected = 318.8925;
        Double actual = TaxReportSummaryCalculator.calculateSum15(getValidReport().getReportBody());
        assertEquals(expected,actual);
    }

    @Test
    public void calculateSum3() {
        Double expected = 0.0;
        Double actual = TaxReportSummaryCalculator.calculateSum3(getValidReport().getReportBody());
        assertEquals(expected,actual);
    }

    @Test
    public void calculateSum5() {
        Double expected = 0.0;
        Double actual = TaxReportSummaryCalculator.calculateSum5(getValidReport().getReportBody());
        assertEquals(expected,actual);
    }

    @Test
    public void calculateTotalSum() {
        Double expected = 30.00;
        Double actual = TaxReportSummaryCalculator.calculateTotalSum(10.00,10.00,10.00);
        assertEquals(expected,actual);
    }

    @Test
    public void calculateTaxSum() {
        Double expected = 10.00;
        Double actual = TaxReportSummaryCalculator.calculateTaxSum(20.00,10.00);
        assertEquals(expected,actual);
    }

    @Test
    public void calculateAmountIncrease() {
        Double expected = 0.0;
        Double actual = TaxReportSummaryCalculator.calculateAmountIncrease(getValidReport().getReportBody());
        assertEquals(expected,actual);
    }

    private Report getValidReport(){
        Report report = new Report();
        ReportBody body = new ReportBody();
        Info info = new Info();
        FirstGroup firstGroup = new FirstGroup();
        SecondGroup secondGroup = new SecondGroup();
        ThirdGroup thirdGroup = new ThirdGroup();
        General general = new General();
        ErrorReport errorReport = new ErrorReport();
        report.setReportBody(body);
        body.setInfo(info);
        body.setFirstGroup(firstGroup);
        body.setSecondGroup(secondGroup);
        body.setThirdGroup(thirdGroup);
        body.setGeneral(general);
        body.setErrorReport(errorReport);
        info.setYear((short) 2020);
        info.setSpecifiedYear((short) 2020);
        info.setType(Info.Type.SIMPLE);
        info.setPeriod(Info.Period.I_QUARTER);
        info.setSpecifiedPeriod(Info.Period.I_QUARTER);
        info.setAuthorityName("Полтавська ДПІ");
        firstGroup.setFirstQuarter(90.50);
        firstGroup.setSecondQuarter(90.50);
        firstGroup.setThirdQuarter(90.50);
        firstGroup.setForthQuarter(90.50);
        firstGroup.setIncomeVolume01(2125.95);
        firstGroup.setTaxedIncomeVolume02(2125.95);
        general.setEmployeesNumber(0);
        errorReport.setSingleTax15(0);
        errorReport.setSpecifiedTax16(0);
        errorReport.setPennySum20(0);
        errorReport.setFinePercent((short) 0);
        return report;
    }
}
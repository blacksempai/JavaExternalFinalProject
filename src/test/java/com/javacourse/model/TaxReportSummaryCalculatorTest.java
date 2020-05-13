package com.javacourse.model;

import com.javacourse.model.entities.TaxReport;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaxReportSummaryCalculatorTest {
    private TaxReportSummary summary;
    private TaxReport report;

    @Before
    public void setUp() throws Exception {
        report = new TaxReport();
        report.setFirstGroupIncomeVolume01(10.00);
        report.setFirstGroupTaxedIncomeVolume02(10.00);
        report.setSecondGroupIncomeVolume03(10.00);
        report.setSecondGroupTaxedIncomeVolume04(10.00);
        report.setThirdGroup3PercentTaxed05(10.00);
        report.setThirdGroup5PercentTaxed06(10.00);
        report.setThirdGroup15PercentTaxed07(10.00);
    }

    @Test
    public void calculateSummary() {
    }

    @Test
    public void calculateTotalIncome() {
        Double test = TaxReportSummaryCalculator.calculateTotalIncome(report);
        Double expected = 70.00;
        assertEquals(expected,test);
    }

    @Test
    public void calculateSum15() {
        Double test = TaxReportSummaryCalculator.calculateSum15(report);
        Double expected = 4.5;
        assertEquals(expected, test);
    }

    @Test
    public void calculateSum3() {
    }

    @Test
    public void calculateSum5() {
    }

    @Test
    public void calculateTotalSum() {
    }

    @Test
    public void calculatePreviousTotalSum() {
    }

    @Test
    public void getPreviousReport() {
    }

    @Test
    public void calculateTaxSum() {
    }

    @Test
    public void calculateAmountIncrease() {
    }

    @Test
    public void calculateAmountDecrease() {
    }

    @Test
    public void calculateFineAmount() {
    }
}
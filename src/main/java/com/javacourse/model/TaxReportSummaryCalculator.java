package com.javacourse.model;

import com.javacourse.dao.ReportDAO;
import com.javacourse.dao.factory.DAOFactory;
import com.javacourse.model.entities.TaxReport;

import java.util.List;

public class TaxReportSummaryCalculator {
    public static TaxReportSummary calculateSummary(TaxReport report, DAOFactory factory){
        TaxReportSummary summary = new TaxReportSummary();
        double totalIncome = calculateTotalIncome(report);
        double sum3 = calculateSum3(report);
        double sum5 = calculateSum5(report);
        double sum15 = calculateSum15(report);
        double totalSum = calculateTotalSum(sum3,sum5,sum15);
        double previousTotalSum = calculatePreviousTotalSum(report,factory);
        double taxSum = calculateTaxSum(totalSum, previousTotalSum);
        double amountIncrease = calculateAmountIncrease(report);
        double amountDecrease = calculateAmountDecrease(report);
        double fineAmount = calculateFineAmount(report);
        summary.setTotalIncome(totalIncome);
        summary.setSum3(sum3);
        summary.setSum5(sum5);
        summary.setSum15(sum15);
        summary.setTotalSum(totalSum);
        summary.setTaxSum(taxSum);
        summary.setPreviousTotalSum(previousTotalSum);
        summary.setAmountIncrease(amountIncrease);
        summary.setAmountDecrease(amountDecrease);
        summary.setFineAmount(fineAmount);
        return summary;
    }

    public static Double calculateTotalIncome(TaxReport report){
        double a1 = report.getFirstGroupIncomeVolume01();
        double a2 = report.getFirstGroupTaxedIncomeVolume02();
        double a3 = report.getSecondGroupIncomeVolume03();
        double a4 = report.getSecondGroupTaxedIncomeVolume04();
        double a5 = report.getThirdGroup3PercentTaxed05();
        double a6 = report.getThirdGroup5PercentTaxed06();
        double a7 = report.getThirdGroup15PercentTaxed07();
        return a1+a2+a3+a4+a5+a6+a7;
    }

    public static double calculateSum15(TaxReport report){
        double a2 = report.getFirstGroupTaxedIncomeVolume02();
        double a4 = report.getSecondGroupTaxedIncomeVolume04();
        double a7 = report.getThirdGroup15PercentTaxed07();
        return (a2+a4+a7)*0.15;
    }

    public static double calculateSum3(TaxReport report){
        double a5 = report.getThirdGroup3PercentTaxed05();
        return a5*0.03;
    }

    public static double calculateSum5(TaxReport report){
        double a6 = report.getThirdGroup5PercentTaxed06();
        return a6*0.05;
    }

    public static double calculateTotalSum(double sum3, double sum5, double sum15){
        return sum3 + sum5 + sum15;
    }

    public static double calculatePreviousTotalSum(TaxReport report, DAOFactory factory){
        TaxReport previousReport = getPreviousReport(report,factory);
        if (previousReport==null)
            return 0;
        double sum3 = calculateSum3(previousReport);
        double sum5 = calculateSum5(previousReport);
        double sum15 = calculateSum15(previousReport);
        return calculateTotalSum(sum3,sum5,sum15);
    }

    public static TaxReport getPreviousReport(TaxReport report, DAOFactory factory){
        TaxReport previousReport = null;
        ReportDAO reportDAO = factory.createReportDAO();
        List<TaxReport> reports = reportDAO.getReportsByUser(report.getUser());
        long reportDate = 0;
        for (TaxReport r : reports) {
            if (r.getId().equals(report.getId()))
                continue;
            if (r.getDeclarationSubmissionDate().getTime()>reportDate){
                reportDate = r.getDeclarationSubmissionDate().getTime();
                previousReport = r;
            }
        }
        return previousReport;
    }

    public static double calculateTaxSum(double totalSum, double previousTotalSum){
        return totalSum - previousTotalSum;
    }

    public static double calculateAmountIncrease(TaxReport report){
        double amountChange = calculateAmountChange(report);
        if (amountChange>0)
            return amountChange;
        return 0;
    }

    public static double calculateAmountDecrease(TaxReport report){
        double amountChange = calculateAmountChange(report);
        if (amountChange<0)
            return -amountChange;
        return 0;
    }

    private static double calculateAmountChange(TaxReport report){
        double a15 = report.getSingleTaxAmount15();
        double a16 = report.getSpecifiedTaxAmount16();
        return a16 - a15;
    }

    public static double calculateFineAmount(TaxReport report){
        double amountIncrease = calculateAmountIncrease(report);
        short percent = report.getFinePercent();
        return amountIncrease/100*percent;
    }

}

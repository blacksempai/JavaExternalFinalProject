package com.javacourse.web;

import com.javacourse.model.entities.TaxReport;
import com.javacourse.controller.utils.ReportTag;

import javax.servlet.http.HttpServletRequest;

@Deprecated
public class PostReportParser {
    private TaxReport taxReport;

    public TaxReport parseRequest(HttpServletRequest httpServletRequest) throws NumberFormatException, NullPointerException{
        taxReport = new TaxReport();
        for (ReportTag tag : ReportTag.values()){
            String param =  httpServletRequest.getParameter(tag.getTag());
            setTaxReportValue(tag, param);
        }
        return taxReport;
    }

    private void setTaxReportValue(ReportTag tag, String param) throws NumberFormatException, NullPointerException{
        switch (tag){
            case TYPE:taxReport.setType(getType(param));
            break;
            case YEAR:taxReport.setYear(Short.parseShort(param));
            break;
            case THIRD_GROUP_3_PERCENT_TAXED:taxReport.setThirdGroup3PercentTaxed05(Double.parseDouble(param));
            break;
            case PERIOD:taxReport.setPeriod(getPeriod(param));
            break;
            case PENNY_SUM:taxReport.setPennySum20(Double.parseDouble(param));
            break;
            case FINE_PERCENT:taxReport.setFinePercent(Short.parseShort(param));
            break;
            case AUTHORITY_NAME:taxReport.setAuthorityName(param);
            break;
            case SPECIFIED_YEAR:taxReport.setSpecifiedYear(Short.parseShort(param));
            break;
            case EMPLOYEES_AMOUNT:taxReport.setEmployeesNumber(Integer.parseInt(param));
            break;
            case SPECIFIED_PERIOD:taxReport.setSpecifiedPeriod(getPeriod(param));
            break;
            case SINGLE_TAX_AMOUNT:taxReport.setSingleTaxAmount15(Double.parseDouble(param));
            break;
            case SPECIFIED_TAX_AMOUNT:taxReport.setSpecifiedTaxAmount16(Double.parseDouble(param));
            break;
            case THIRD_GROUP_5_PERCENT_TAXED:taxReport.setThirdGroup5PercentTaxed06(Double.parseDouble(param));
            break;
            case FIRST_GROUP_INCOME_VOLUME:taxReport.setFirstGroupIncomeVolume01(Double.parseDouble(param));
            break;
            case SECOND_GROUP_INCOME_VOLUME:taxReport.setSecondGroupIncomeVolume03(Double.parseDouble(param));
            break;
            case THIRD_GROUP_15_PERCENT_TAXED:taxReport.setThirdGroup15PercentTaxed07(Double.parseDouble(param));
            break;
            case FIRST_GROUP_TAXED_INCOME_VOLUME:taxReport.setFirstGroupTaxedIncomeVolume02(Double.parseDouble(param));
            break;
            case SECOND_GROUP_TAXED_INCOME_VOLUME:taxReport.setSecondGroupTaxedIncomeVolume04(Double.parseDouble(param));
            break;
            case BUSINESS_ACTIVITY:taxReport.setBusinessActivity(param);
            break;
            case BUSINESS_ACTIVITY_CODE:taxReport.setBusinessActivityCode(param);
            break;
            case FIRST_GROUP_ADVANCED_PAYMENT_I:taxReport.getFirstGroupAdvancePayments().set(1,Double.parseDouble(param));
            break;
            case FIRST_GROUP_ADVANCED_PAYMENT_II:taxReport.getFirstGroupAdvancePayments().set(2,Double.parseDouble(param));
            break;
            case FIRST_GROUP_ADVANCED_PAYMENT_III:taxReport.getFirstGroupAdvancePayments().set(3,Double.parseDouble(param));
            break;
            case FIRST_GROUP_ADVANCED_PAYMENT_IV:taxReport.getFirstGroupAdvancePayments().set(4,Double.parseDouble(param));
            break;
            case SECOND_GROUP_ADVANCED_PAYMENT_I:taxReport.getSecondGroupAdvancePayments().set(1,Double.parseDouble(param));
            break;
            case SECOND_GROUP_ADVANCED_PAYMENT_II:taxReport.getSecondGroupAdvancePayments().set(2,Double.parseDouble(param));
            break;
            case SECOND_GROUP_ADVANCED_PAYMENT_III:taxReport.getSecondGroupAdvancePayments().set(3,Double.parseDouble(param));
            break;
            case SECOND_GROUP_ADVANCED_PAYMENT_IV:taxReport.getSecondGroupAdvancePayments().set(4,Double.parseDouble(param));
            break;
            default:
        }
    }

    private TaxReport.Type getType(String param){
        switch (param){
            case "01zvitna":
                return TaxReport.Type.SIMPLE;
            case "02zvitnanova":
                return TaxReport.Type.SIMPLE_NEW;
            case "03utochn":
                return TaxReport.Type.SPECIFYING;
            case "04dovidkovo":
                return TaxReport.Type.REFERENCING;
            default:
                return null;
        }
    }

    private TaxReport.Period getPeriod(String param){
        switch (param) {
            case "1kvartal":
                return TaxReport.Period.I_QUARTER;
            case "2kvartal":
                return TaxReport.Period.II_QUARTER;
            case "3kvartal":
                return TaxReport.Period.III_QUARTER;
            case "4kvartal":
                return TaxReport.Period.IV_QUARTER;
            default:
                return null;
        }
    }
}

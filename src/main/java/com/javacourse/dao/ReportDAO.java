package com.javacourse.dao;

import com.javacourse.model.entities.Inspector;
import com.javacourse.model.entities.TaxReport;
import com.javacourse.model.entities.User;

import java.util.List;

public interface ReportDAO {

    void addReport(TaxReport report);

    void updateReport(TaxReport report);

    void deleteReport(TaxReport report);

    List<TaxReport> getReportsByUser(User user);

    List<TaxReport> getReportsByInspector(Inspector inspector);
}

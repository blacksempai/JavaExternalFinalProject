package com.javacourse.dao;

import com.javacourse.model.entities.Inspector;

import java.util.List;

public interface InspectorDAO {

    void addNewInspector(Inspector inspector);

    List<Inspector> getAllInspectors();

    Inspector getInspectorByLogin(String login);

    Inspector getInspectorById(Integer id);

    void updateInspector(Inspector inspector);

    boolean isExists(String login);

    Inspector getInspectorWithLessReportsInService();
}

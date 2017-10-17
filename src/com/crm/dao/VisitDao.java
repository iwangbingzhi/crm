package com.crm.dao;

import com.crm.entity.Visit;

import java.util.List;

public interface VisitDao {
    void add(Visit visit);

    List<Visit> findAll();
}

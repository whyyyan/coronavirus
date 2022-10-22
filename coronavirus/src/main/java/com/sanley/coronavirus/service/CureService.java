package com.sanley.coronavirus.service;

import com.sanley.coronavirus.entity.Cure;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface CureService {

    void add(Cure cure);
    List<Cure> findAll(int page, int size);
    Cure get(int id);
    void update(int baseId,String current);
    int number();
    List<Map<Integer,Date>> group();
    int beforeDay(Date date);
    List<Cure> findByName(String name);

}

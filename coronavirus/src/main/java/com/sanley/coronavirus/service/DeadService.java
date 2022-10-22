package com.sanley.coronavirus.service;

import com.sanley.coronavirus.entity.Dead;
import java.util.List;

public interface DeadService {

    void add(Dead dead);
    List<Dead> findAll(int page, int size);
    Dead get(int id);
    int number();
    List<Dead> findByName(String name);
}

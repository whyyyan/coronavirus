package com.sanley.coronavirus.service;

import com.sanley.coronavirus.entity.Hospital;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HospitalService {
    public List<Hospital> findAll();


    public boolean add(Hospital hospital);


    public List<Hospital> findByName(String name);
    public boolean update(Hospital hospital);
}

package com.sanley.coronavirus.service;

import com.sanley.coronavirus.entity.CheckOut;

import java.util.List;
/**
 * @Author: bonbon
 * @Date: 2021/4/15 14:31
 */
public interface CheckOutService {
    void add(CheckOut checkOut);

    List<CheckOut> findAll(int page, int size);

    List<CheckOut> findByName(String name);
}

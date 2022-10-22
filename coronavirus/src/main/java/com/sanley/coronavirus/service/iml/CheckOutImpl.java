package com.sanley.coronavirus.service.iml;

import com.github.pagehelper.PageHelper;
import com.sanley.coronavirus.dao.CheckOutDao;
import com.sanley.coronavirus.entity.CheckOut;
import com.sanley.coronavirus.service.CheckOutService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: bonbon
 * @Date: 2021/4/15 14:32
 */
@Service
public class CheckOutImpl implements CheckOutService {

    @Autowired
    CheckOutDao dao;

    @Override
    public void add(CheckOut checkOut) {
        dao.add(checkOut);
    }

    @Override
    public List<CheckOut> findAll(int page, int size) {
        PageHelper.startPage(page,size);
        return dao.findAll();
    }

    @Override
    public List<CheckOut> findByName(String name) {
        return dao.findByName(name);
    }
}

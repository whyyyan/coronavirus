package com.sanley.coronavirus;

import com.sanley.coronavirus.dao.BaseDao;
import com.sanley.coronavirus.dao.PatientDao;
import com.sanley.coronavirus.entity.Base;
import com.sanley.coronavirus.entity.CheckOut;
import com.sanley.coronavirus.service.BaseService;
import com.sanley.coronavirus.service.CheckOutService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import java.math.BigInteger;

@SpringBootTest
class CoronavirusApplicationTests {

    @Autowired
    BaseDao dao;

    PatientDao da;

    @Autowired
    BaseService baseService;

    @Autowired
    CheckOutService checkOutService;

    @Test
    void baseInsert() {
        Base base = new Base();
        base.setIdCard("513042198810241233");
        base.setName("安没");
        base.setAge(22);
        base.setGender('男');
        base.setAddress("美国");
        base.setPhone(new BigInteger("123456789"));
        baseService.add(base);
    }

    @Test
    void baseFind() {
        Base base = baseService.findById(78);
        System.out.println(base);
    }

    @Test
    void checkOutInsert() {
        CheckOut checkOut = new CheckOut();
        checkOut.setBaseId(101).
                setCurrentPosition("xx").
                setBodyTemperature(37.0).
                setHealthState("健康").
                setIsToHighArea("yes").
                setIsTouch("true").
                setName("Halo").
                setRemarks("xxx");
        checkOutService.add(checkOut);
    }

    @Test
    void findAll() {
        System.out.println(checkOutService.findAll(1, 25));
    }

}

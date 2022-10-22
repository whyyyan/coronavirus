package com.sanley.coronavirus.service;

import com.sanley.coronavirus.entity.Touch;


import java.util.List;

public interface TouchService {
    //查看所有接触案例
    public List<Touch> findAll(int page,int size);
    //增加接触者
    public void add(Touch touch);
    //根据姓名查找密切接触者
    public List<Touch> findByName(String name);
    //通过id查找密切接触者
    public Touch findById(int baseId);
    //将此接触者隔离状态完成
    public void toSafe(int baseId);

   //查找现存隔离人员数量
    public Integer number();
    //总隔离人数
    public Integer currentNumber();
}

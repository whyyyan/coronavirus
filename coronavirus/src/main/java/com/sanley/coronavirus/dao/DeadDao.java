package com.sanley.coronavirus.dao;

import com.sanley.coronavirus.entity.Base;
import com.sanley.coronavirus.entity.Dead;
import com.sanley.coronavirus.entity.Patient;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeadDao {

    @Select("select baseId,deadTime from dead ")
    @Results({
            @Result(id = true, property = "baseId", column = "baseId"),
            @Result(property = "deadTime", column = "deadTime"),
            @Result(property = "patient",column = "baseId",javaType = Patient.class,one = @One(select = "com.sanley.coronavirus.dao.PatientDao.findById")),
            @Result(property = "base",column = "baseId",javaType = Base.class,one = @One(select = "com.sanley.coronavirus.dao.BaseDao.findById"))
})
    public List<Dead> findAll();

    @Insert("insert into dead(baseId,deadTime)values(#{baseId},#{deadTime})")
    public void add(Dead dead);

    @Select("select baseId,deadTime from dead where baseId = #{baseId}")
    @Results({
            @Result(id = true, property = "baseId", column = "baseId"),
            @Result(property = "deadTime", column = "deadTime"),
            @Result(property = "patient",column = "baseId",javaType = Patient.class,one = @One(select = "com.sanley.coronavirus.dao.PatientDao.findById")),
            @Result(property = "base",column = "baseId",javaType = Base.class,one = @One(select = "com.sanley.coronavirus.dao.BaseDao.findById"))
    })
    public Dead findById(int baseId);
    @Select("select sum(1) from dead")
    public int number();


    @Select("SELECT baseId,deadTime " +
            " FROM dead WHERE baseId in(select id from base where name like #{name})")
    @Results({
            @Result(id = true, property = "baseId", column = "baseId"),
            @Result(property = "deadTime", column = "deadTime"),
            @Result(property = "patient", column = "baseId", javaType = Patient.class,many = @Many(select = "com.sanley.coronavirus.dao.PatientDao.findById")),
            @Result(property = "base", column = "baseId", javaType = Base.class, one = @One(select = "com.sanley.coronavirus.dao.BaseDao.findById"))
    })
    //根据姓名查找死者
    public List<Dead> findByName(String name);
}

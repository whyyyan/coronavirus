package com.sanley.coronavirus.dao;

import com.sanley.coronavirus.entity.Authentication;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AuthenticationDao {
    //通过用户名找到其下的所有授权
    @Select("select * from authentication where authentication.id in(select authentication_id from user_authorities where user_id=#{userId})")
    public List<Authentication> findByUserId(int userId);
}

package com.java.demo.c.c.Mapper;

import com.java.demo.c.c.Model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("insert into github_user (User,User_name,session,Gmt_create,Gmt_change) " +
            "values (#{User},#{User_name},#{session},#{create},#{change})")
    void insert(User user);

    @Select("select User_name from github_user where User = #{user}")
    String select(@Param("user") String user);

    @Select("select * from github_user where session = #{session}")
    User selectsession(@Param("session") String session);


    @Select("select session from github_user where user = #{user}")
    String selecttoken(@Param("user") String user);



}

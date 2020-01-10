package com.java.demo.c.c.Mapper;

import com.java.demo.c.c.Model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    @Insert("insert into github_user (User,User_name,session,Gmt_create,Gmt_change) " +
            "values (#{User},#{User_name},#{session},#{create},#{change})")
    void insert(User user);
}

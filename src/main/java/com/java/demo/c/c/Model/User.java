package com.java.demo.c.c.Model;

import java.util.Date;
//存入数据库专用数据类，连接Javademo库User表。
public class User {

    private String User;
    private String User_name;
    private String Name;
    private String session;
    private Date create;
    private Date change;

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getUser_name() {
        return User_name;
    }

    public void setUser_name(String user_name) {
        User_name = user_name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String sesion) {
        this.session = sesion;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

    public Date getChange() {
        return change;
    }

    public void setChange(Date change) {
        this.change = change;
    }
}

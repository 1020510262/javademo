package com.java.demo.c.c.controller;

import com.java.demo.c.c.Dto.GithubUserDto;
import com.java.demo.c.c.Mapper.UserMapper;
import com.java.demo.c.c.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


@Controller
public class IndexController {
    @Autowired(required = false)
    private UserMapper um;
    @GetMapping("/")
    public String index(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for ( Cookie a : cookies ){
            if (a.getName().equals("token")){
                User user = um.selectsession(a.getValue());
                GithubUserDto githubUserDto = new GithubUserDto();
                githubUserDto.setName(user.getName());
                githubUserDto.setId(user.getUser());
                githubUserDto.setlogin(user.getUser_name());
                request.getSession().setAttribute("user" , githubUserDto);
                break;
            }
        }
        return "index";
    }
}

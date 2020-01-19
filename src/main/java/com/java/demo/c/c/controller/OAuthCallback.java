package com.java.demo.c.c.controller;

import com.java.demo.c.c.Dto.GithubUserDto;
import com.java.demo.c.c.Mapper.UserMapper;
import com.java.demo.c.c.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class OAuthCallback {
    @Autowired(required = false)
    private UserMapper um;


    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           HttpServletRequest request,
                           HttpServletResponse rgs) throws IOException {
        GitHubLog gitHubLog = new GitHubLog();
        gitHubLog.GitHttpPost(code);
        GithubUserDto githubUserDto = gitHubLog.GitHttpGet();
        if (githubUserDto == null){
            return "redirect:/";
        }else {
            request.getSession().setAttribute("user" , githubUserDto);
           if (um.select(githubUserDto.getId()) != null){//检测数据库中User表中是否拥有该用户，避免重复写入数据。
               if (um.select(githubUserDto.getId()).equals(githubUserDto.getlogin())){
                   rgs.addCookie(new Cookie("token" , um.selecttoken(githubUserDto.getId())));//当为系统中存在的用户时读取token，并写入Cookie中。
               }else {
                   System.out.println("错误");
               }
           }else {
               User user = new User();
               String token = UUID.randomUUID().toString();
               rgs.addCookie(new Cookie("token" , token));
               user.setUser_name(githubUserDto.getName());
               user.setUser(githubUserDto.getId());
               user.setUser_name(githubUserDto.getlogin());
               user.setName(githubUserDto.getName());
               user.setChange(new Date());
               user.setCreate(new Date());
               user.setSession(token);
               um.insert(user);
           }
            return "redirect:/";
        }
    }
    @GetMapping("/publish")
    public String problem(){
        return "publish";
    }
}

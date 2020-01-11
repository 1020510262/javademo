package com.java.demo.c.c.controller;

import com.java.demo.c.c.Dto.GithubUserDto;
import com.java.demo.c.c.Mapper.UserMapper;
import com.java.demo.c.c.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class OAuthCallback {
    @Autowired
    private UserMapper um;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           HttpServletRequest request) throws IOException {
        GitHubLog gitHubLog = new GitHubLog();
        gitHubLog.GitHttpPost(code);
        GithubUserDto githubUserDto = gitHubLog.GitHttpGet();
        if (githubUserDto == null){
            return "redirect:/";
        }else {
            request.getSession().setAttribute("user" , githubUserDto);
           if (um.select("36914246") != null){
               if (um.select("36914246").equals(githubUserDto.getlogin())){
                   System.out.println("该用户已存在。");
               }else {
                   System.out.println("错误");
               }
           }else {
               User user = new User();
               user.setUser_name(githubUserDto.getName());
               user.setUser(githubUserDto.getId());
               user.setUser_name(githubUserDto.getlogin());
               user.setName(githubUserDto.getName());
               user.setChange(new Date());
               user.setCreate(new Date());
               user.setSession(UUID.randomUUID().toString());
               um.insert(user);
           }
            return "redirect:/";
        }
    }
}

package com.java.demo.c.c.controller;

import com.java.demo.c.c.Dto.GithubUserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class OAuthCallback {

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           HttpServletRequest request) throws IOException {
        GitHubLog gitHubLog = new GitHubLog();
        gitHubLog.GitHttpPost(code);
        GithubUserDto githubUserDto = gitHubLog.GitHttpGet();
        if (githubUserDto == null){
            System.out.println("未登录");
            return "redirect:/";
        }else {
            System.out.println("登录成功");
            request.getSession().setAttribute("user" , githubUserDto);
            return "redirect:/";
        }
    }
}

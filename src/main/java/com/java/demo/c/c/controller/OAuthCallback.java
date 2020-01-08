package com.java.demo.c.c.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.IOException;

@Controller
public class OAuthCallback {

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code) throws IOException {
        GitHubLog gitHubLog = new GitHubLog();
        gitHubLog.GitHttpPost(code);
        gitHubLog.GitHttpGet();
        return "index";
    }
}

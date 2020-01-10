package com.java.demo.c.c.controller;

import com.alibaba.fastjson.JSON;
import com.java.demo.c.c.Dto.GithubDto;
import com.java.demo.c.c.Dto.GithubUserDto;
import com.java.demo.c.c.ThirdPartySupport.HttpGet;
import com.java.demo.c.c.ThirdPartySupport.HttpPOST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import java.io.IOException;

//用于处理Git登陆过程的值传递
public class GitHubLog{
    private String access_token;

    public void GitHttpPost(String code) throws IOException {
        GithubDto githubDto = new GithubDto();
        githubDto.setClient_id("df63d3b995d374a3221a");
        githubDto.setClient_secret("110346bd3c4ea86e7ea56e6cd5d6ca63937c8608");
        githubDto.setCode(code);
        githubDto.setRedirect_uri("http://localhost:8080/callback");
        githubDto.setState("1");
        access_token = new HttpPOST().post("https://github.com/login/oauth/access_token" , JSON.toJSONString(githubDto));
    }

    public GithubUserDto GitHttpGet() throws IOException {
        access_token =  access_token.split("=")[1].split("&")[0];
        String y = new HttpGet().run("https://api.github.com/user?access_token=" + access_token);
        return JSON.parseObject(y,GithubUserDto.class);
    }

}

package com.java.demo.c.c.controller;

import com.alibaba.fastjson.JSON;
import com.java.demo.c.c.Dto.GithubDto;
import com.java.demo.c.c.Dto.GithubUserDto;
import com.java.demo.c.c.ThirdPartySupport.HttpGet;
import com.java.demo.c.c.ThirdPartySupport.HttpPOST;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Value;

=======
>>>>>>> origin/master
import java.io.IOException;
//用于处理Git登陆过程的值传递
public class GitHubLog{
    private String access_token;

<<<<<<< HEAD
    @Value("${github.Client.id}")
    private String Clientid;
    @Value("${github.Client.secret}")
    private String Clientsecret;
    @Value("${github.url}")
    private String url;

=======
>>>>>>> origin/master
    public void GitHttpPost(String code) throws IOException {
        GithubDto githubDto = new GithubDto();
        githubDto.setClient_id("df63d3b995d374a3221a");
        githubDto.setClient_secret("110346bd3c4ea86e7ea56e6cd5d6ca63937c8608");
        githubDto.setCode(code);
        githubDto.setRedirect_uri("http://localhost:8080/callback");
        githubDto.setState("1");
        access_token = new HttpPOST().post("https://github.com/login/oauth/access_token" , JSON.toJSONString(githubDto));
<<<<<<< HEAD
    }

    public void GitHttpGet() throws IOException {
        access_token =  access_token.split("=")[1].split("&")[0];
        String y = new HttpGet().run("https://api.github.com/user?access_token=" + access_token);
        GithubUserDto githubUserDto = JSON.parseObject(y,GithubUserDto.class);
        System.out.println(githubUserDto.getId());
=======
        System.out.println(access_token);
    }

    public String GitHttpGet() throws IOException {
        GithubUserDto githubUserDto = new GithubUserDto();
        String[] strings1 = access_token.split("=");
        String[] strings2 = strings1[1].split("&");
        access_token =  strings2[0];
        String y = new HttpGet().run("https://api.github.com/user?access_token=" + access_token);
        System.out.println(y);
        return y;
>>>>>>> origin/master
    }

}

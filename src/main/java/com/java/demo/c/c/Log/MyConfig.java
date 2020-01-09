package com.java.demo.c.c.Log;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Component
@ConfigurationProperties(prefix = "author")
public class MyConfig {

    private String Client_id;
    private String Client_secret;
    private String Client_url;

    public String getClient_id() {
        return Client_id;
    }

    public void setClient_id(String client_id) {
        Client_id = client_id;
    }

    public String getClient_secret() {
        return Client_secret;
    }

    public void setClient_secret(String client_secret) {
        Client_secret = client_secret;
    }

    public String getClient_url() {
        return Client_url;
    }

    public void setClient_url(String client_url) {
        Client_url = client_url;
    }
}

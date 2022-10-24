package com.github.l.jackson.web.chat.common;

public class Result {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Result(String str){
        this.token = str;
    }
}

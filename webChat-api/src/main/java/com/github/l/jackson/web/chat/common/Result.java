package com.github.l.jackson.web.chat.common;

public class Result {
    private String userName;

    public Result(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

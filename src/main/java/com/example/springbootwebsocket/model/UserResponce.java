package com.example.springbootwebsocket.model;

public class UserResponce {
    private String content;

    public UserResponce() {
    }

    public UserResponce(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

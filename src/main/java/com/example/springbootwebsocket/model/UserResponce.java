package com.example.springbootwebsocket.model;

public class UserResponce {
    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

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

package com.xyg.learn.spring.pojo;

import java.io.Serializable;

public class MyUser implements Serializable {
    private String userName;
    private String userId;

    public MyUser(String userName, String userId) {
        this.userName = userName;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return userId + " ----- " + userName;
    }
}

package com.tcjbeckett.CodewarsProject.model;

public class CodewarsApiGetResponse {

    private UserData data;

    public UserData getData() {
        return data;
    }

    public void setData(UserData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CodewarsApiGetResponse{" +
                "data=" + data +
                '}';
    }
}


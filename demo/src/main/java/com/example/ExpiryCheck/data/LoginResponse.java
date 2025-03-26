package com.example.ExpiryCheck.data;

import java.util.List;

public class LoginResponse {

    private String fullName;
    private String username;
    private List<Items> items;

    public LoginResponse(String fullName, String username, List<Items> items) {
        this.fullName = fullName;
        this.username = username;
        this.items = items;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
}

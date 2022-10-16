package com.example.myapplication.model;

public class ListUser {
    private String username;
    private String messenger;
    private String date;

    public ListUser(String username, String messenger, String date) {
        this.username = username;
        this.messenger = messenger;
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessenger() {
        return messenger;
    }

    public void setMessenger(String messenger) {
        this.messenger = messenger;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ListUser{" +
                "username='" + username + '\'' +
                ", messenger='" + messenger + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

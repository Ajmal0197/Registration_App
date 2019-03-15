package com.example.phpmysqlintro.model;

public class LoginResponse {

    private boolean error;
    private String message;
    private User user;

    public LoginResponse(boolean error, String message, User user) {
        this.error = error;
        this.message = message;
        this.user = user;
    }

    public boolean isError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }
}

/*
* {
    "error": false,
    "message": "Login Successful",
    "user": {
        "id": 2,
        "email": "a@g.com",
        "name": "Hasan",
        "school": "DAV PS"
    }
} */

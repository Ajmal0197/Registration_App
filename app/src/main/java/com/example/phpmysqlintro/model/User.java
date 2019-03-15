package com.example.phpmysqlintro.model;

public class User {

    private int id;
    private String email, name, school;

    public User(int id, String email, String name, String school) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.school = school;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSchool() {
        return school;
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
}*/
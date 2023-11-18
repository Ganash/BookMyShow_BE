package com.scaler.BookMyShow.service;

import com.scaler.BookMyShow.models.User;

public interface UserService {

    // methods in interface will always be abstract
    User login(String email, String password);

    User signup(String name, String email, String password);
}

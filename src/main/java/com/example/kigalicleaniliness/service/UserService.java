package com.example.kigalicleaniliness.service;

import com.example.kigalicleaniliness.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel saveUser(UserModel user);
    UserModel findUserById(int code);
    UserModel updateUser(UserModel user);
    List<UserModel> listUsers();
    void deleteUser(int code);

    UserModel findUserByUsername(UserModel user);
}

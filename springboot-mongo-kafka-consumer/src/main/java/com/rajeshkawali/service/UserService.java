package com.rajeshkawali.service;

import com.rajeshkawali.entity.User;
import java.util.List;

public interface UserService {
    void consumeUser(User user);
    List<User> getAllUsers();
}
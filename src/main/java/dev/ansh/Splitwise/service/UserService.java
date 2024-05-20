package dev.ansh.Splitwise.service;

import dev.ansh.Splitwise.entity.User;

public interface UserService {
    User signup(String name, String email, String Password);
    User login(String email, String password);
}

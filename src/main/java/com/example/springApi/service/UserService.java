package com.example.springApi.service;

import com.example.springApi.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final List<User> userList;

    // build 20 random users
    public UserService() {
        userList = new ArrayList<>();
        Date date = new Date();

        userList.add(new User(
                1,
                "Artur",
                30,
                "artur@mail.com",
                new User.Address(
                        "123 Main",
                        "Chicago",
                        "60000",
                        "USA"),
                String.valueOf(date.getTime())));

        for (int i = 0; i < 19; i++) {
            userList.add(UserBuilder.buildUser());
        }

    }

    public List<User> getAllUsers() {
        return userList;
    }

    public Optional<User> getUser(Integer id) {
        return userList.stream().filter(user -> id.equals(user.getId())).findFirst();
    }
}
package com.example.corewebmy.service;

import com.example.corewebmy.exception.UserAlreadyExistException;
import com.example.corewebmy.model.User;
import com.example.corewebmy.repository.UserRepository;
import com.example.corewebmy.storage.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserRepository {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserStorage userStorage;

    @Override
    public User save(User user) throws UserAlreadyExistException {
        user.setHashPassword(passwordEncoder.encode(user.getPassword()));
        return userStorage.save(user);
    }

    @Override
    public Map<Long, User> get() {
        return userStorage.getUsersPool();
    }
}

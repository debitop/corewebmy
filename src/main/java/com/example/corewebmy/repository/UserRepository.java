package com.example.corewebmy.repository;

import com.example.corewebmy.exception.UserAlreadyExistException;
import com.example.corewebmy.model.User;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserRepository {

    User save(User user) throws UserAlreadyExistException;

    Map<Long, User> get();
}

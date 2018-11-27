package com.example.corewebmy.storage;

import com.example.corewebmy.exception.UserAlreadyExistException;
import com.example.corewebmy.model.User;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class UserStorage {

    public static final Map<Long, User> USERS_POOL = new ConcurrentHashMap<>();
    public static final AtomicInteger ID_SEQUENCE = new AtomicInteger(1);

    public User save(User user) {
        Optional<User> persistedUser = findUserByUsername(user.getUserName());
        if (persistedUser.isPresent()) {
            throw new UserAlreadyExistException();
        }
        Long userId = generateId();
        user.setId(userId);
        USERS_POOL.put(userId, user);
        return USERS_POOL.get(userId);
    }

    private Optional<User> findUserByUsername(String username) {
        return USERS_POOL.values().stream()
                .filter(user -> user.getUserName().equals(username))
                .findFirst();
    }

    private Long generateId() {
        int id = ID_SEQUENCE.getAndIncrement();
        return (long) id;
    }

    public Map<Long, User> getUsersPool() {
        return USERS_POOL;
    }
}

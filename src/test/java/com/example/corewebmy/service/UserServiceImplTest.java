package com.example.corewebmy.service;

import com.example.corewebmy.exception.UserAlreadyExistException;
import com.example.corewebmy.model.User;
import com.example.corewebmy.storage.UserStorage;
import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    private static final String TEST_NAME = "testName";
    private static final String TEST_LAST_NAME = "testLastName";
    private static final String TEST_USER_NAME = "testUserName";
    private static final String TEST_PASSWORD = "testPassword";

    @Resource
    private UserServiceImpl userService;

    @Test
    public void testCorrectUserPersistingSuccess1() {
        User firstPersistedUser = userService.save(mockUser());
        assertEquals("User persisted error",1L, firstPersistedUser.getId());
        assertNotNull("Hashed password must be provide", firstPersistedUser.getHashPassword());
    }

    @Test
    public void testCorrectUserPersistingSuccess() {
        User firstPersistedUser = userService.save(mockUser());
        assertEquals("User persisted error",1L, firstPersistedUser.getId());
        assertNotNull("Hashed password must be provide", firstPersistedUser.getHashPassword());
    }

    @Test(expected = UserAlreadyExistException.class)
    public void testUserPersistingThrowsUserAlreadyExistExceptionForExistingUsername() {
        User user = mockUser();
        user.setUserName("errorUserName");
        User persistedUser = userService.save(user);
        assertNotNull(persistedUser);
        userService.save(user);
    }

    @After
    public void cleanUp(){
        UserStorage.USERS_POOL = new ConcurrentHashMap<>();
        UserStorage.ID_SEQUENCE = new AtomicInteger(1);
    }

    private User mockUser(){
        return User.of()
                .firstName(TEST_NAME)
                .lastName(TEST_LAST_NAME)
                .userName(TEST_USER_NAME)
                .password(TEST_PASSWORD)
                .create();

    }
}
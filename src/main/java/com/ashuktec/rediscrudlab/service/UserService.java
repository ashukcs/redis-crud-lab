package com.ashuktec.rediscrudlab.service;

import com.ashuktec.rediscrudlab.dao.UserDao;
import com.ashuktec.rediscrudlab.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserDao userDao;

    public User saveUser(User user) {
        User user1 = userDao.saveUser(user);
        log.info("User added successfully!");
        return user1;
    }

    public User getUser(String userId) {
        return userDao.getUser(userId);
    }

    public Map<Object, Object> findAllUsers() {
        return userDao.findAllUser();
    }

    public void deleteUser(String userId) {
        userDao.deleteUser(userId);
    }
}

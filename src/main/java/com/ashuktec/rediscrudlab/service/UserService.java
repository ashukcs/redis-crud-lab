package com.ashuktec.rediscrudlab.service;

import com.ashuktec.rediscrudlab.dao.UserDao;
import com.ashuktec.rediscrudlab.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserDao userDao;

    @CachePut(value="users", key = "#user.getUserId")
    public User saveUser(User user) {
        User user1 = userDao.saveUser(user);
        log.info("User added successfully!");
        return user1;
    }

    @Cacheable(value="users", key = "#userId")
    public User getUser(String userId) {
        log.info("User Service getUser !!");
        return userDao.getUser(userId);
    }

    public Map<Object, Object> findAllUsers() {
        return userDao.findAllUser();
    }

    @CacheEvict(value="users", key = "#userId")
    public void deleteUser(String userId) {
        userDao.deleteUser(userId);
    }
}

package com.ashuktec.rediscrudlab.dao;

import com.ashuktec.rediscrudlab.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserDao {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static final String KEY = "USER";

    //save user
    public User saveUser(User user) {
        redisTemplate.opsForHash().put(KEY, user.getUserId(), user);
        return user;
    }

    //retrieve user
    public User getUser(String userId) {
        return (User) redisTemplate.opsForHash().get(KEY, userId);
    }

    //fetch all users
    public Map<Object, Object> findAllUser() {
        return redisTemplate.opsForHash().entries(KEY);
    }

    //delete user
    public void deleteUser(String userId) {
        redisTemplate.opsForHash().delete(KEY, userId);
    }
}

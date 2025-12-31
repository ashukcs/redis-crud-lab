package com.ashuktec.rediscrudlab.controller;

import com.ashuktec.rediscrudlab.model.User;
import com.ashuktec.rediscrudlab.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        user.setUserId(UUID.randomUUID().toString());
        User user1 = userService.saveUser(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User userToBeUpdated = userService.getUser(user.getUserId());
        if(!ObjectUtils.isEmpty(userToBeUpdated)) {
            User user1 = userService.saveUser(user);
            return new ResponseEntity<>(user1, HttpStatus.CREATED);
        } else {
            log.info("User not found for userId : {}", user.getUserId());
            return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        User user1 = userService.getUser(userId);
        return new ResponseEntity<>(user1, HttpStatus.FOUND);
    }

    @GetMapping
    public Map<Object, Object> findAllUsers() {
        return userService.findAllUsers();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        log.info("User : {} deleted Successfully!", userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

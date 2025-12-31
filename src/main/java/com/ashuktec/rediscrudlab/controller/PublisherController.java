package com.ashuktec.rediscrudlab.controller;

import com.ashuktec.rediscrudlab.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherController {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    ChannelTopic channelTopic;

    @PostMapping("/publish")
    public String publish(@RequestBody User user) {
        redisTemplate.convertAndSend(channelTopic.getTopic(), user.toString());
        return "Event published!!";
    }
}

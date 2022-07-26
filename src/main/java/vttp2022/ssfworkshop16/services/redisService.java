package vttp2022.ssfworkshop16.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import jakarta.json.JsonObject;

@Service
public class redisService implements repo{

    @Autowired
    RedisTemplate <String, Object> redisTemplate;

    @Override
    public void save(JsonObject body) {
        redisTemplate.opsForValue().set("boardgame", body.toString());
        
    }
}

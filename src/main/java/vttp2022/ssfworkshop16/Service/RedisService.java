package vttp2022.ssfworkshop16.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
    private static final Logger logger = LoggerFactory.getLogger(RedisService.class);
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    
}

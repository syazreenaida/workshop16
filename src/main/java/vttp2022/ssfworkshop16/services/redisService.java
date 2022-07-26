package vttp2022.ssfworkshop16.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import jakarta.json.JsonObject;

@Service
public class redisService implements repo{
    private static final Logger logger = LoggerFactory.getLogger(redisService.class);

    @Autowired
    RedisTemplate <String, Object> redisTemplate;

    @Override
    public void save(JsonObject body) {
        redisTemplate.opsForValue().set("boardgame", body.toString());
        
    }

    @Override
    public String BoardGame(String boardGame) {
        String string = (String) redisTemplate.opsForValue().get(boardGame);
        logger.info(">>> " + string + "chosen");
        return string;
    }
}

//Sample Reference from SSFworkshop14
// @Service
// public class ContactsRedis implements ContactsRepo  {
//     private static final Logger logger = LoggerFactory.getLogger(ContactsRedis.class);

//     @Autowired
//     RedisTemplate<String, Object> redisTemplate;

//     @Override
//     public void save(final Contact ctc) {
//         redisTemplate.opsForList().rightPush(ctc.getId(), ctc);
//     }

//     @Override
//     public Contact findById(final String contactId) {
//         Contact result = (Contact) redisTemplate.opsForList().index(contactId,0);
//         logger.info(">>> " + result.getEmail());
//         return result;
//     }
// }
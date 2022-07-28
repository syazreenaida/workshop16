package vttp2022.ssfworkshop16.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import jakarta.json.JsonObject;
import vttp2022.ssfworkshop16.model.Welcome4;

@Service
public class redisService implements repo{
    private static final Logger logger = LoggerFactory.getLogger(redisService.class);

    @Autowired
    RedisTemplate <String, Welcome4> redisTemplate;

    @Override
    public int save(JsonObject body) {
        redisTemplate.opsForValue().set(((Welcome4) body).getId(), (Welcome4) body);
        Welcome4 result = (Welcome4) redisTemplate.opsForValue();
        if (result !=null)
            return 1;
        return 0;
    }

    @Override
    public Welcome4 BoardGame(String boardGame) {
        Welcome4 string = (Welcome4) redisTemplate.opsForValue().get(boardGame);
        logger.info(">>> " + string + "chosen");
        return string;
    }

    @Override
    public int update(JsonObject body) {
        if (((Welcome4) body).isUpsert())
            redisTemplate.opsForValue().setIfAbsent(((Welcome4) body).getId(), (Welcome4) body);
        else
            redisTemplate.opsForValue().setIfPresent(((Welcome4) body).getId(), (Welcome4) body);
        Welcome4 result = (Welcome4) redisTemplate.opsForValue().get(((Welcome4) body).getId());
        if (result != null)
            return 1;
        return 0;
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
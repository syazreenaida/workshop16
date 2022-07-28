package vttp2022.ssfworkshop16.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import vttp2022.ssfworkshop16.model.Welcome4;

@Configuration
public class redisConfig {

    @Value("${spring.redis.host}")
    private String redisHost;
    @Value("${spring.redis.port}")
    private Optional<Integer> redisPort;
    @Value("${spring.redis.password}")
    private String redisPassword;
    @Value("${spring.redis.database}")
    private String redisDatabase;

    @Bean
    @Scope("singleton") // This is the default scope
    public RedisTemplate<String, Welcome4> createRedisTemplate(){

        final RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setPort(redisPort.get());
        config.setHostName(redisHost);
        config.setPassword(redisPassword);

        final JedisClientConfiguration jedisClient = JedisClientConfiguration.builder().build();
        final JedisConnectionFactory jedisFac = new JedisConnectionFactory(config, jedisClient);
        jedisFac.afterPropertiesSet();

        RedisTemplate<String, Welcome4> template = new RedisTemplate<String,Welcome4>();
        template.setConnectionFactory(jedisFac);
        template.setKeySerializer(new StringRedisSerializer());

        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Welcome4.class);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        return template;
        
    }







}

package ru.ruslanator.corelib.repositories;


import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisRepository{

    private HashOperations hashOperations;
    private RedisTemplate<String, String> redisTemplate;
    public RedisRepository(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void saveToken(String token) {
        redisTemplate.opsForValue().set(token, "token");
    }

    public boolean checkToken(String token) {
        if(redisTemplate.hasKey(token)){
            return true;
        }
        return false;
    }

}

package ru.ruslanator.corelib.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("tokens")
@RequiredArgsConstructor
@Data
public class Token {
    @Id String id;
    String token;
}

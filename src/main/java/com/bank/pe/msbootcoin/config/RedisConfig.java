package com.bank.pe.msbootcoin.config;


import com.bank.pe.msbootcoin.entity.BootCoin;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String, BootCoin> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, BootCoin> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(BootCoin.class));

        return template;
    }
}


package com.xyg.learn.spring.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class RedisConfiguration {
    private String host;
    private int port;
}

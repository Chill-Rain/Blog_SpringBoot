package club.chillrainqcna.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

/**
 * @author ChillRain 2023 03 19
 */
@Configuration
public class IOCConfig {
    @Bean
    public JedisPool getJedisPool(){
        return new JedisPool();
    }
}

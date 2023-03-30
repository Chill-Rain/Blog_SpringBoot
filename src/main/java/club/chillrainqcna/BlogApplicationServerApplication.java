package club.chillrainqcna;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("club.chillrainqcna.mapper")
public class BlogApplicationServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogApplicationServerApplication.class, args);
    }

}

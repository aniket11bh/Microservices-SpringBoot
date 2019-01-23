package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
//@EnableEurekaServer
@EnableEurekaClient
public class DBApplication {

    public static void main(String[] args) {
        SpringApplication.run(DBApplication.class, args);
    }

}


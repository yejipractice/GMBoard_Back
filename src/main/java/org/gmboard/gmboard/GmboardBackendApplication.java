package org.gmboard.gmboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class GmboardBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmboardBackendApplication.class, args);
    }

}

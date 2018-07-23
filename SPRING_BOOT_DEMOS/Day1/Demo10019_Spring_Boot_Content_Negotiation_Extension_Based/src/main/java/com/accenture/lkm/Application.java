
package com.accenture.lkm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations="classpath:com/lkm/accenture/resources/spring-servlet.xml")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
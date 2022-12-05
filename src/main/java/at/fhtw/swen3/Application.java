package at.fhtw.swen3;

import com.fasterxml.jackson.databind.Module;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@Slf4j
@ComponentScan(basePackages = {"at.fhtw.swen3.persistence", "at.fhtw.swen3.controller","at.fhtw.swen3.services" , "at.fhtw.swen3.configuration", "at.fhtw.swen3.persistence.repositories"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        log.info("Start of Application");
    }

    @Bean
    public Module jsonNullableModule() {
        return new JsonNullableModule();
    }

}
package dev.csik.cisco.exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "dev.csik.cisco.exercise")
public class App {

    public static void main(final String[] args) {
        SpringApplication.run(App.class, args);
    }
}

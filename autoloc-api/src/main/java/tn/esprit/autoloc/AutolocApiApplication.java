package tn.esprit.autoloc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "tn.esprit.autoloc")

public class AutolocApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutolocApiApplication.class, args);
    }
}
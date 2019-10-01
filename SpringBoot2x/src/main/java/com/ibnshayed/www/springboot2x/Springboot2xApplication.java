package com.ibnshayed.www.springboot2x;

import com.ibnshayed.www.springboot2x.Model.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Springboot2xApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2xApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            Student student = new Student();

        };
    }


}

package com.ibnshayed.www.springrestdemo;

import com.ibnshayed.www.springrestdemo.Model.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringrestdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringrestdemoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            List<Student> studentList = new ArrayList<>();
            studentList = Arrays.asList(
                    new Student(100,"kamal Mukhtar",3.80),
                    new Student(101,"Jalal Uddin",3.44),
                    new Student(102,"Ahmed Sharif",3.34)
            );

            studentList.forEach(System.out::println);
        };

    }

}

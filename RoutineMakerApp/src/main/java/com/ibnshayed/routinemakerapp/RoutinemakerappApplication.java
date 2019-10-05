package com.ibnshayed.routinemakerapp;

import com.ibnshayed.routinemakerapp.Model.Course;
import com.ibnshayed.routinemakerapp.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RoutinemakerappApplication {

    @Autowired
    private CourseRepository courseRepository;

    public static void main(String[] args) {
        SpringApplication.run(RoutinemakerappApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
        /*    Course course1 = new Course("CSE2016","Programming Language II(Java) Lab");
            courseRepository.save(course1);
            System.out.println(course1);*/
            System.out.println("All is Weeeeeeeeeeeeeeeeeeeell!!!!!!!!");

        };
    }

}

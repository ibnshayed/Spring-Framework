package com.ibnshayed.routinemakerapp.Repository;

import com.ibnshayed.routinemakerapp.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,String> {

}

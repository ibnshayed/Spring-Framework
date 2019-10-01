package com.ibnshayed.www.springrestdemo.Controller;

import com.ibnshayed.www.springrestdemo.Model.Student;
import com.ibnshayed.www.springrestdemo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/")
    public String welcome(){
        return "Welcome TO Spring Boot 2.x";
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudent();
    }

    @GetMapping("student/{id}")
    public Student getAStudent(@PathVariable long id){
        return studentService.getAStudent(id);
    }

    @PostMapping("/students")
    public void postAStudet(@RequestBody  Student student){
        studentService.addAStudent(student);
    }

    @PutMapping("/student/{id}")
    public void updateAStudent(@PathVariable long id,@RequestBody Student student){
        studentService.updateAStudent(id,student);
    }

    @DeleteMapping("/student/{id}")
    public void deleteAStudent(@PathVariable long id){
        studentService.deleteAStudent(id);
    }







}

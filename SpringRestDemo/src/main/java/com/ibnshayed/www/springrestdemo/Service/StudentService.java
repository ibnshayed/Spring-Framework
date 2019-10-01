package com.ibnshayed.www.springrestdemo.Service;

import com.ibnshayed.www.springrestdemo.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    List<Student> studentList = new ArrayList<>(Arrays.asList(
            new Student(100,"kamal Mukhtar",3.80),
                new Student(101,"Jalal Uddin",3.44),
                new Student(102,"Ahmed Sharif",3.34)
        ));

    public List<Student> getAllStudent(){
        return studentList;
    }

    public Student getAStudent(long id) {
        for (Student s : studentList){
            if(s.getId() == id)
                return s;
        }
        return null;
    }

    public void addAStudent(Student student) {
        studentList.add(student);
    }

    public void updateAStudent(long id,Student student) {
        for(int i = 0; i<studentList.size(); i++){
            if(studentList.get(i).getId() == id)
                studentList.set(i,student);
            return;
        }

    }

    public void deleteAStudent(long id) {
        for(int i = 0; i<studentList.size(); i++){
            if(studentList.get(i).getId() == id)
                studentList.remove(i);
        }
    }
}

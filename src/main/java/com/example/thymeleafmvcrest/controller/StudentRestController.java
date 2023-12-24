package com.example.thymeleafmvcrest.controller;

import com.example.thymeleafmvcrest.entity.Student;
import com.example.thymeleafmvcrest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentRestController {
    private StudentService studentService;

    @Autowired
    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/findAll")
    public List<Student> findAllStudents(){
        return studentService.findAllStudents();
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable int id){

        Student student = studentService.findStudentById(id);
        if(student == null){
            throw new RuntimeException("Enter A Valid Id " + id);
        }
        return studentService.findStudentById(id);
    }

    @PostMapping("/save")
    public Student saveNewStudent(@RequestBody Student student){
//        student.setId(0);
        Student theNewStudent = studentService.saveStudent(student);
        return theNewStudent;
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id){
        studentService.deleteStudentById(id);
    }

}

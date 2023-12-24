package com.example.thymeleafmvcrest.service;

import com.example.thymeleafmvcrest.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> findAllStudents();

    Student findStudentById(int id);

    Student saveStudent(Student student);

    Student updateStudent(Student student);

    void deleteStudentById(int id);


}

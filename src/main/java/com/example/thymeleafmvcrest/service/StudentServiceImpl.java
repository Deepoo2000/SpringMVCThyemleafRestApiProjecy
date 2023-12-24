package com.example.thymeleafmvcrest.service;

import com.example.thymeleafmvcrest.dao.StudentDAO;
import com.example.thymeleafmvcrest.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public Student findStudentById(int id) {

        Optional<Student> result = studentDAO.findById(id);

        Student student = null;
        if(result.isPresent()) student = result.get();
        else throw new RuntimeException("Student Not Found Write A Valid Id " + id);

        return student;
    }

    @Override
    public List<Student> findAllStudents() {

        List<Student> students = studentDAO.findAll();

        return students;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentDAO.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentDAO.save(student);
    }

    @Override
    public void deleteStudentById(int id) {
        studentDAO.deleteById(id);
    }
}

package com.example.thymeleafmvcrest.controller;

import com.example.thymeleafmvcrest.entity.Student;
import com.example.thymeleafmvcrest.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/showStudents")
    public String showStudents(Model theModel){

        List<Student> students = studentService.findAllStudents();

        theModel.addAttribute("students", students);

        return "show-student";
    }

    @GetMapping("/addStudent")
    public String addNewStudent(Model theModel){
        Student newStudent = new Student();

        theModel.addAttribute("newStudent", newStudent);

        return "add-student";
    }

    @PostMapping("/saveStudent")
    public String saveNewStudent(@Valid @ModelAttribute("newStudent") Student newStudent,
                                 BindingResult bindingResult){
        if(bindingResult.hasErrors())return "add-student";

        studentService.saveStudent(newStudent);
        return "redirect:/students/showStudents";
    }

    @GetMapping("/updateStudent")
    public String updateStudent(@RequestParam("studentId") int studentId, Model theModel){
        Student student = studentService.findStudentById(studentId);
        theModel.addAttribute("newStudent", student);

        return "add-student";
    }

    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("studentId") int studentId){

        studentService.deleteStudentById(studentId);
        return "redirect:/students/showStudents";

    }


}

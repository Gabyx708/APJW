package com.example.student_crud_rest.controllers;

import com.example.student_crud_rest.models.StudentModel;
import com.example.student_crud_rest.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ArrayList<StudentModel> GetAllStudents() {
        return  this.studentService.GetAllStudents();
    }

    @PostMapping
    public StudentModel AddStudent(@RequestBody StudentModel studentModel) {
        return  this.studentService.SaveStudent(studentModel);
    }

    @GetMapping(path="/{id}")
    public Optional<StudentModel> GetStudentById(@PathVariable("id") Long id) {
        return  this.studentService.GetStudentById(id);
    }

}

package com.example.student_crud_rest.Api.controllers;

import com.example.student_crud_rest.Application.Dtos.StudentRequest;
import com.example.student_crud_rest.Application.Dtos.StudentResponse;
import com.example.student_crud_rest.Domain.Models.StudentModel;
import com.example.student_crud_rest.Application.Services.StudentService;
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
    public ArrayList<StudentResponse> GetAllStudents() {
        return  this.studentService.GetAllStudents();
    }

    @PostMapping
    public StudentResponse AddStudent(@RequestBody StudentRequest request) {
        return  this.studentService.SaveStudent(request);
    }

    @GetMapping(path="/{id}")
    public Optional<StudentResponse> GetStudentById(@PathVariable("id") Long id) {
        return  this.studentService.GetStudentById(id);
    }

}

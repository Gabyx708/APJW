package com.example.student_crud_rest.services;

import com.example.student_crud_rest.models.StudentModel;
import com.example.student_crud_rest.repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    IStudentRepository studentRepository;

    public ArrayList<StudentModel> GetAllStudents() {
        return (ArrayList<StudentModel>) studentRepository.findAll();
    }

    public StudentModel SaveStudent(StudentModel studentModel) {
        return studentRepository.save(studentModel);
    }

    public Optional<StudentModel> GetStudentById(Long id) {
        return  studentRepository.findById(id);
    }
}

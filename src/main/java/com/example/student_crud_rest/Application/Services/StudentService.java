package com.example.student_crud_rest.Application.Services;

import com.example.student_crud_rest.Application.Dtos.StudentRequest;
import com.example.student_crud_rest.Application.Dtos.StudentResponse;
import com.example.student_crud_rest.Domain.Models.StudentModel;
import com.example.student_crud_rest.Infraestructure.Repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    IStudentRepository studentRepository;

    public ArrayList<StudentResponse> GetAllStudents() {
        var models = (ArrayList<StudentModel>) studentRepository.findAll();
        var studentResponse = new ArrayList<StudentResponse>();

        //mapping students
        models.forEach(m -> {
            var auxStudent = new StudentResponse(m.getStudentFirstName(),
                                                m.getStudentLastName(),
                                                m.getStudentId().toString());

            studentResponse.add(auxStudent);
        });

        return studentResponse;
    }

    public StudentResponse SaveStudent(StudentRequest StudentRequest) {

        var modelAux = new StudentModel();
        modelAux.setStudentFirstName(StudentRequest.Name);
        modelAux.setStudentLastName(StudentRequest.LastName);

        var model = studentRepository.save(modelAux);

        return new StudentResponse(model.getStudentFirstName(),
                                   model.getStudentLastName(),
                                   model.getStudentId().toString());
    }


    public Optional<StudentResponse> GetStudentById(Long id) {

        Optional<StudentModel> studentOptional = studentRepository.findById(id);

        if (studentOptional.isPresent()) {
            StudentModel student = studentOptional.get();
            StudentResponse response = new StudentResponse(
                    student.getStudentFirstName(),
                    student.getStudentLastName(),
                    student.getStudentId().toString()
            );
            return Optional.of(response);
        } else {
            return Optional.empty();
        }
    }
}

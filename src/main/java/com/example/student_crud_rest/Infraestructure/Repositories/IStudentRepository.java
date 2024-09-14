package com.example.student_crud_rest.Infraestructure.Repositories;

import com.example.student_crud_rest.Domain.Models.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<StudentModel,Long> {
}

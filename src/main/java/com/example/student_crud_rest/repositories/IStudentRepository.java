package com.example.student_crud_rest.repositories;

import com.example.student_crud_rest.models.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<StudentModel,Long> {
}

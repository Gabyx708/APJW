package com.example.student_crud_rest.Application.Dtos;

public class StudentResponse {
    public String Name;
    public String LastName;
    public String Id;

    public  StudentResponse(String Name, String LastName, String Id) {
            this.Name = Name;
            this.LastName = LastName;
            this.Id = Id;
    }
}

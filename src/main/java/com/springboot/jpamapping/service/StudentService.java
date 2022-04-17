package com.springboot.jpamapping.service;

import com.springboot.jpamapping.model.Student;

import java.util.List;

public interface StudentService {
    public  Integer saveStudent(Student Student );

    public List<Student> getAllStudents();

    public  Student getStudentById(Integer id);
    public void  deleteStudent(Integer id);
}

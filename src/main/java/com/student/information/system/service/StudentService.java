package com.student.information.system.service;

import com.student.information.system.model.Student;

import java.util.List;

/**
 * @author regcrix
 */
public interface StudentService {

    List<Student> findAll();

    Student findStudentById(String id);

    Student saveOrUpdateStudent(Student student);

    String deleteStudentById(String id);    

}
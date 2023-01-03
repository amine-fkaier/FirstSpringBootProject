package com.student.information.system.controller;

import com.student.information.system.util.ObjectMapperUtils;
import com.student.information.system.dto.StudentDTO;
import com.student.information.system.model.Student;
import com.student.information.system.service.StudentService;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lombok.AccessLevel.PACKAGE;

/**
 * @author ragcrix
 */

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/students")
    public List<StudentDTO> getAllStudents() {
        return ObjectMapperUtils.mapAll(studentService.findAll(), StudentDTO.class);
    }
    @CrossOrigin(origins = "http://localhost:4200") 
    @GetMapping(value = "student-details/{id}")
    public StudentDTO getStudentDetails(@PathVariable("id") String id) {
        return ObjectMapperUtils.map(studentService.findStudentById(id), StudentDTO.class);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "saveOrUpdateStudent")
    public ResponseEntity<?> saveOrUpdateStudent(@RequestBody StudentDTO studentDTO) {
        studentService.saveOrUpdateStudent(ObjectMapperUtils.map(studentDTO, Student.class));
        return new ResponseEntity<>(new String[]{"Student added successfully"}, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(value = "deleteStudent/{id}")
    public ResponseEntity<?> deleteStudentByStudentId(@PathVariable String id) {
        studentService.deleteStudentById(studentService.deleteStudentById(id));
        return new ResponseEntity(new String[]{"Student deleted successfully"}, HttpStatus.OK);
    }

}
package com.fawry.task.courseregistration.service;

import com.fawry.task.courseregistration.dto.StudentDto;
import com.fawry.task.courseregistration.entity.Student;

import java.util.List;

public interface StudentService {
    StudentDto getStudent(long id);
    List<StudentDto> getStudents();
    StudentDto addStudent(StudentDto student);
    StudentDto updateStudent(long id , StudentDto student);
    void  deleteStudent(long id);
    StudentDto addStudentToCourse(int courseId , long studentId);
    void removeStudentToCourse(int courseId , long studentId);
}

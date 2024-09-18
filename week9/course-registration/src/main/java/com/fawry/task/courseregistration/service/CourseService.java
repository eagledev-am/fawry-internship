package com.fawry.task.courseregistration.service;

import com.fawry.task.courseregistration.dto.CourseDto;
import com.fawry.task.courseregistration.dto.StudentDto;

import java.util.List;

public interface CourseService {
    List<CourseDto> getCourses();
    CourseDto getCourse(int id);
    CourseDto addCourse(CourseDto course);
    CourseDto updateCourse(int id , CourseDto course);
    void deleteCourse(int id);

    CourseDto addProfessor(int courseId , int professorId);

}

package com.fawry.task.courseregistration.controller;

import com.fawry.task.courseregistration.dto.CourseDto;
import com.fawry.task.courseregistration.dto.StudentDto;
import com.fawry.task.courseregistration.entity.Course;
import com.fawry.task.courseregistration.service.CourseService;
import com.fawry.task.courseregistration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping
    ResponseEntity<?> getAllCourse(){
        List<CourseDto> courses = courseService.getCourses();
        if(courses.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(courses , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getCourseById(@PathVariable(name = "id") int id){
        return new ResponseEntity<>(courseService.getCourse(id) , HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<?> addNewCourse(@RequestBody CourseDto courseDto){
        return new ResponseEntity<>(courseService.addCourse(courseDto) , HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateCourseData(@PathVariable("id") int id , @RequestBody CourseDto courseDto){
        return new ResponseEntity<>(courseService.updateCourse(id , courseDto) , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteCourse(@PathVariable("id") int id){
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}/professor/{prof_id}")
    ResponseEntity<?> changeCourseProfessor(@PathVariable("id") int id , @PathVariable("prof_id") int profId){
        return new ResponseEntity<>( courseService.addProfessor(id , profId) , HttpStatus.OK);
    }


}

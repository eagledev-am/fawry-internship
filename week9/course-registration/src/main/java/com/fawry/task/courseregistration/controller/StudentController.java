package com.fawry.task.courseregistration.controller;

import com.fawry.task.courseregistration.dto.CourseDto;
import com.fawry.task.courseregistration.dto.ProfessorDto;
import com.fawry.task.courseregistration.dto.StudentDto;
import com.fawry.task.courseregistration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    StudentService service;

    @GetMapping
    ResponseEntity<?> getAllCourse(){
        List<StudentDto> students = service.getStudents();
        if(students.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(students , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getProfessor(@PathVariable(name = "id") int id){
        return new ResponseEntity<>(service.getStudent(id) , HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<?> addNewProfessor(@RequestBody StudentDto studentDto){
        return new ResponseEntity<>(service.addStudent(studentDto) , HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateProfessor(@PathVariable("id") int id , @RequestBody StudentDto studentDto){
        return new ResponseEntity<>(service.updateStudent(id , studentDto) , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteProfessor(@PathVariable("id") int id){
        service.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}/courses/{c_id}")
    ResponseEntity<?> enrolStudentInCourse(@PathVariable("id") int id , @PathVariable("c_id") int c_id){
        return new ResponseEntity<>(service.addStudentToCourse(c_id , id) , HttpStatus.OK);
    }

    @DeleteMapping("/{id}/courses/{c_id}")
    ResponseEntity<?> removeStudentFromCourse(@PathVariable("id") int id , @PathVariable("c_id") int c_id){
        service.removeStudentToCourse(c_id , id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

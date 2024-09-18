package com.fawry.task.courseregistration.controller;

import com.fawry.task.courseregistration.dto.CourseDto;
import com.fawry.task.courseregistration.dto.ProfessorDto;
import com.fawry.task.courseregistration.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professors")
public class ProfessorController {

    @Autowired
    ProfessorService service;

    @GetMapping
    ResponseEntity<?> getAllCourse(){
        List<ProfessorDto> professors = service.getProfessors();
        if(professors.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(professors , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getProfessor(@PathVariable(name = "id") int id){
        return new ResponseEntity<>(service.getProfessor(id) , HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<?> addNewProfessor(@RequestBody ProfessorDto professorDto){
        return new ResponseEntity<>(service.addProfessor(professorDto) , HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateProfessor(@PathVariable("id") int id , @RequestBody ProfessorDto Professor){
        return new ResponseEntity<>(service.updateProfessor(id , Professor) , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteProfessor(@PathVariable("id") int id){
        service.deleteProfessor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

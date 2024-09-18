package com.fawry.task.courseregistration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fawry.task.courseregistration.entity.Course;
import com.fawry.task.courseregistration.entity.Student;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Setter
@Getter
public class StudentDto {

    @JsonProperty("id")
    Long id;
    @JsonProperty("name")
    String name;
    @JsonProperty("email")
    String email;
    @JsonProperty("courses")
    Set<Course> courses;

    public StudentDto(){}

    public StudentDto(String name , String email){
        this.name = name;
        this.email = email;
    }
}

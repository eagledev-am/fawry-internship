package com.fawry.task.courseregistration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fawry.task.courseregistration.entity.Course;
import com.fawry.task.courseregistration.entity.Professor;
import com.fawry.task.courseregistration.entity.Student;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
public class CourseDto {

    @JsonProperty("id")
    int id;
    @JsonProperty("code")
    String code;
    @JsonProperty("title")
    String title;
    @JsonProperty("professor")
    Professor professor;


    public CourseDto(){

    }

    public CourseDto(String code, String title) {
        this.code = code;
        this.title = title;
    }
}

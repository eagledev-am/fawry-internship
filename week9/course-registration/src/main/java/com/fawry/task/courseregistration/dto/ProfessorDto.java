package com.fawry.task.courseregistration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fawry.task.courseregistration.entity.Course;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class ProfessorDto {
    @JsonProperty("id")
    int id;
    @JsonProperty("name")
    String name;
    @JsonProperty("department")
    String department;
    @JsonProperty("course")
    Course course;

    public ProfessorDto(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public ProfessorDto(){

    }
}

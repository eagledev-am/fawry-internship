package com.fawry.task.courseregistration.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Entity
@Setter
@Getter
@Table(name = "course")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "code")
    String code;

    @Column(name = "title")
    String title;

    @ManyToMany(mappedBy = "courses" , fetch = FetchType.LAZY)
    Set<Student> students = new HashSet<>();


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_id")
    Professor professor;

    public Course(){
    }

    public Course(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public boolean addStudent(Student student){
        return students.add(student);
    }

    public boolean removeStudent(Student student){
        return students.remove(student);
    }

    public void addStudents(Set<Student> students){
        this.students.addAll(students);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course course)) return false;
        return getId() == course.getId() && Objects.equals(getCode(), course.getCode()) && Objects.equals(getTitle(), course.getTitle()) && Objects.equals(getProfessor(), course.getProfessor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCode(), getTitle(), getProfessor());
    }
}

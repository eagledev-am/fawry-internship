package com.fawry.task.courseregistration.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "student")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "email")
    String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "students_courses" ,
            joinColumns = @JoinColumn(name = "student_id") ,
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    Set<Course> courses = new HashSet<>();

    public Student(){

    }

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void addCourse(Course course){
        courses.add(course);
    }

    public void deleteCourse(Course course){
        courses.remove(course);
    }

    public void addCourses(Set<Course> courses){
        this.courses.addAll(courses);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return Objects.equals(getId(), student.getId()) && Objects.equals(getName(), student.getName()) && Objects.equals(getEmail(), student.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail());
    }
}

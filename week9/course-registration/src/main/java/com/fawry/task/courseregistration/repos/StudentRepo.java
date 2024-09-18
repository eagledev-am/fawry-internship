package com.fawry.task.courseregistration.repos;

import com.fawry.task.courseregistration.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student , Integer> {
}

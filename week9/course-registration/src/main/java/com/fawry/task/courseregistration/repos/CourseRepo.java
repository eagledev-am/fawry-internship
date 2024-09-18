package com.fawry.task.courseregistration.repos;

import com.fawry.task.courseregistration.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course , Integer> {
}

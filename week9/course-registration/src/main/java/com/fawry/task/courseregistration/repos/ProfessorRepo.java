package com.fawry.task.courseregistration.repos;

import com.fawry.task.courseregistration.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepo extends JpaRepository<Professor , Integer> {
}

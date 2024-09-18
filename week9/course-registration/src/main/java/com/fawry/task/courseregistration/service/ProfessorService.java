package com.fawry.task.courseregistration.service;

import com.fawry.task.courseregistration.dto.ProfessorDto;

import java.util.List;

public interface ProfessorService {
    List<ProfessorDto> getProfessors();
    ProfessorDto getProfessor(int id);
    ProfessorDto addProfessor(ProfessorDto Professor);
    ProfessorDto updateProfessor(int id , ProfessorDto Professor);
    void deleteProfessor(int id);
}

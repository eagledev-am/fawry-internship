package com.fawry.task.courseregistration.service.serviceimp;

import com.fawry.task.courseregistration.dto.ProfessorDto;
import com.fawry.task.courseregistration.entity.Professor;
import com.fawry.task.courseregistration.entity.Student;
import com.fawry.task.courseregistration.exception.NoSuchEntityException;
import com.fawry.task.courseregistration.repos.ProfessorRepo;
import com.fawry.task.courseregistration.service.ProfessorService;
import com.fawry.task.courseregistration.service.mapper.ProfessorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class ProfessorServiceImp implements ProfessorService {

    @Autowired
    ProfessorRepo repo;

    @Autowired
    ProfessorMapper mapper;

    private final String PROFESSOR_NOT_FOUND = "PROFESSOR_NOT_FOUND";
    @Override
    public List<ProfessorDto> getProfessors() {
        return repo.findAll().stream()
                .map(mapper::toProfessorDto)
                .toList();
    }

    @Override
    public ProfessorDto getProfessor(int id) {
        return mapper.toProfessorDto(repo.findById(id)
                .orElseThrow(()-> new NoSuchEntityException(PROFESSOR_NOT_FOUND)));
    }

    @Override
    public ProfessorDto addProfessor(ProfessorDto professorDto) {
        return mapper.toProfessorDto(repo.save(mapper.toProfessor(professorDto)));
    }

    @Override
    public ProfessorDto updateProfessor(int id, ProfessorDto professorDto) {
        Professor persistedProfessor = repo.findById(id)
                .orElseThrow(()-> new NoSuchEntityException(PROFESSOR_NOT_FOUND));

        persistedProfessor.setName(professorDto.getName());
        persistedProfessor.setDepartment(professorDto.getDepartment());

        return mapper.toProfessorDto(repo.save(persistedProfessor));
    }

    @Override
    public void deleteProfessor(int id) {
        Professor persistedProfessor = repo.findById((int)id)
                .orElseThrow(()-> new NoSuchEntityException(PROFESSOR_NOT_FOUND));
        repo.delete(persistedProfessor);
    }

}

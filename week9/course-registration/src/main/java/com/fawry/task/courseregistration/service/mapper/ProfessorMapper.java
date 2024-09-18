package com.fawry.task.courseregistration.service.mapper;

import com.fawry.task.courseregistration.dto.ProfessorDto;
import com.fawry.task.courseregistration.entity.Professor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProfessorMapper {
    @Mapping(source = "id" , target = "id")
    @Mapping(source = "name" , target = "name")
    @Mapping(source = "department" , target = "department")
    ProfessorDto toProfessorDto(Professor professor);
    @InheritInverseConfiguration(name = "toProfessorDto")
    Professor toProfessor(ProfessorDto professorDto);
}

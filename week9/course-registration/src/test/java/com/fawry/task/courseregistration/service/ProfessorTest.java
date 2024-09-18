package com.fawry.task.courseregistration.service;

import com.fawry.task.courseregistration.dto.ProfessorDto;
import com.fawry.task.courseregistration.entity.Professor;
import com.fawry.task.courseregistration.exception.NoSuchEntityException;
import com.fawry.task.courseregistration.repos.ProfessorRepo;
import com.fawry.task.courseregistration.service.mapper.ProfessorMapper;
import com.fawry.task.courseregistration.service.serviceimp.ProfessorServiceImp;
import org.aspectj.weaver.ast.Var;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.Mapper;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ProfessorTest {

    @Mock
    ProfessorMapper mapper;

    @Mock
    ProfessorRepo repo;

    @InjectMocks
    ProfessorService service = new ProfessorServiceImp();

    private final String PROFESSOR_NOT_FOUND = "PROFESSOR_NOT_FOUND";

    @Test
    void testGetAllProfessors(){
        // arrange
        Professor professor = new Professor("Ahmed" , "cs");
        ProfessorDto professorDto = new ProfessorDto("Ahmed" , "cs");
        when(repo.findAll()).thenReturn(List.of(professor));
        when(mapper.toProfessorDto(professor)).thenReturn(professorDto);
        // act
        List<ProfessorDto> professors =  service.getProfessors();
        // assert
        Assertions.assertThat(professors).isNotNull().hasSize(1);
    }


    @Test
    void testGetProfessorById(){
        // arrange
        Professor professor = new Professor("Ahmed" , "cs");
        ProfessorDto professorDto = new ProfessorDto("Ahmed" , "cs");
        when(repo.findById(1)).thenReturn(Optional.of(professor));
        when(mapper.toProfessorDto(professor)).thenReturn(professorDto);
        // act
        ProfessorDto professorDto1 = service.getProfessor(1);
        // assert
        assertThat(professorDto1).isNotNull().isEqualTo(professorDto);
    }


    @Test
    void testGetProfessorByIdAndProfessorNotFound(){
        // arrange
        when(repo.findById(1)).thenReturn(Optional.empty());
        // act
        // assert
        assertThatThrownBy(() -> service.getProfessor(1))
                .isInstanceOf(NoSuchEntityException.class)
                .hasMessage(PROFESSOR_NOT_FOUND);
    }


    @Test
    void testAddNewProfessor(){
        // arrange
        Professor professor = new Professor("Ahmed" , "cs");
        ProfessorDto professorDto = new ProfessorDto("Ahmed" , "cs");
        when(repo.save(professor)).thenReturn(professor);
        when(mapper.toProfessorDto(professor)).thenReturn(professorDto);
        when(mapper.toProfessor(professorDto)).thenReturn(professor);
        // act
        ProfessorDto professorDto1 = service.addProfessor(professorDto);
        // assert
        assertThat(professorDto1).isNotNull().isEqualTo(professorDto);
    }

    @Test
    void testUpdateProfessorAndProfessorNotFound(){
        // arrange
        when(repo.findById(1)).thenReturn(Optional.empty());
        // act
        // assert
        assertThatThrownBy(() -> service.updateProfessor(1 , any(ProfessorDto.class)))
                .isInstanceOf(NoSuchEntityException.class)
                .hasMessage(PROFESSOR_NOT_FOUND);
    }

    @Test
    void testUpdateProfessor(){
        // arrange
        Professor professor = new Professor("Ahmed" , "cs");
        ProfessorDto professorDto = new ProfessorDto("Mohamed" , "cs");
        when(repo.findById(1)).thenReturn(Optional.ofNullable(professor));
        when(mapper.toProfessorDto(professor)).thenReturn(professorDto);
        when(repo.save(professor)).thenReturn(professor);

        professor.setName(professorDto.getName());
        professor.setDepartment(professorDto.getDepartment());

        // act
        ProfessorDto professorDto1 = service.updateProfessor(1 , professorDto);
        // assert
        assertThat(professorDto1).isNotNull().isEqualTo(professorDto);
    }

    @Test
    void testDeleteProfessorAndNotFound(){
        // arrange
        when(repo.findById(1)).thenReturn(Optional.empty());
        // act
        // assert
        assertThatThrownBy(() -> service.deleteProfessor(1))
                .isInstanceOf(NoSuchEntityException.class)
                .hasMessage(PROFESSOR_NOT_FOUND);
    }

    @Test
    void testDeleteProfessor(){
        // arrange
        Professor professor = new Professor("Ahmed" , "cs");
        when(repo.findById(1)).thenReturn(Optional.of(professor));
        // act
        org.junit.jupiter.api.Assertions.assertAll(() -> service.deleteProfessor(1));
    }


}

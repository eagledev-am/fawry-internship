package com.fawry.task.courseregistration.service;

import com.fawry.task.courseregistration.dto.StudentDto;
import com.fawry.task.courseregistration.entity.Student;
import com.fawry.task.courseregistration.exception.NoSuchEntityException;
import com.fawry.task.courseregistration.repos.CourseRepo;
import com.fawry.task.courseregistration.repos.StudentRepo;
import com.fawry.task.courseregistration.service.StudentService;
import com.fawry.task.courseregistration.service.mapper.StudentMapper;
import com.fawry.task.courseregistration.service.serviceimp.StudentServiceImp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentTest {

    @Mock
    StudentRepo repo;

    @Mock
    StudentMapper mapper;
    
    @InjectMocks
    StudentService service = new StudentServiceImp();


    private final String STUDENT_NOT_FOUND = "STUDENT_NOT_FOUND";

    @Test
    void testGetAllStudents(){
        // arrange
        Student student = new Student("Ahmed" , "ahmed@email");
        StudentDto studentDto = new StudentDto("Ahmed" , "ahmed@email");
        when(repo.findAll()).thenReturn(List.of(student));
        when(mapper.toStudentDto(student)).thenReturn(studentDto);
        // act
        List<StudentDto> students =  service.getStudents();
        // assert
        Assertions.assertThat(students).isNotNull().hasSize(1);
    }


    @Test
    void testGetStudentById(){
        // arrange
        Student student = new Student("Ahmed" , "ahmed@email");
        StudentDto studentDto = new StudentDto("Ahmed" , "ahmed@email");
        when(repo.findById(1)).thenReturn(Optional.of(student));
        when(mapper.toStudentDto(student)).thenReturn(studentDto);
        // act
        StudentDto StudentDto1 = service.getStudent(1);
        // assert
        assertThat(StudentDto1).isNotNull().isEqualTo(studentDto);
    }


    @Test
    void testGetStudentByIdAndStudentNotFound(){
        // arrange
        when(repo.findById(1)).thenReturn(Optional.empty());
        // act
        // assert
        assertThatThrownBy(() -> service.getStudent(1))
                .isInstanceOf(NoSuchEntityException.class)
                .hasMessage(STUDENT_NOT_FOUND);
    }


    @Test
    void testAddNewStudent(){
        // arrange
        Student student = new Student("Ahmed" , "ahmed@email");
        StudentDto studentDto = new StudentDto("Ahmed" , "ahmed@email");
        when(repo.save(student)).thenReturn(student);
        when(mapper.toStudentDto(student)).thenReturn(studentDto);
        when(mapper.toStudent(studentDto)).thenReturn(student);
        // act
        StudentDto StudentDto1 = service.addStudent(studentDto);
        // assert
        assertThat(StudentDto1).isNotNull().isEqualTo(studentDto);
    }

    @Test
    void testUpdateStudentAndStudentNotFound(){
        // arrange
        when(repo.findById(1)).thenReturn(Optional.empty());
        // act
        // assert
        assertThatThrownBy(() -> service.updateStudent(1 , any(StudentDto.class)))
                .isInstanceOf(NoSuchEntityException.class)
                .hasMessage(STUDENT_NOT_FOUND);
    }

    @Test
    void testUpdateStudent(){
        // arrange
        Student student = new Student("Ahmed" , "ahmed@email");
        StudentDto studentDto = new StudentDto("Ahmed" , "ahmed@email");
        when(repo.findById(1)).thenReturn(Optional.ofNullable(student));
        when(mapper.toStudentDto(student)).thenReturn(studentDto);
        when(repo.save(student)).thenReturn(student);

        // act
        StudentDto StudentDto1 = service.updateStudent(1 , studentDto);
        // assert
        assertThat(StudentDto1).isNotNull().isEqualTo(studentDto);
    }

    @Test
    void testDeleteStudentAndNotFound(){
        // arrange
        when(repo.findById(1)).thenReturn(Optional.empty());
        // act
        // assert
        assertThatThrownBy(() -> service.deleteStudent(1))
                .isInstanceOf(NoSuchEntityException.class)
                .hasMessage(STUDENT_NOT_FOUND);
    }

    @Test
    void testDeleteStudent(){
        // arrange
        Student Student = new Student("CS45" , "Operating System");
        when(repo.findById(1)).thenReturn(Optional.of(Student));
        // act
        org.junit.jupiter.api.Assertions.assertAll(() -> service.deleteStudent(1));
    }

}

package com.fawry.task.courseregistration.service;

import com.fawry.task.courseregistration.dto.CourseDto;
import com.fawry.task.courseregistration.entity.Course;
import com.fawry.task.courseregistration.entity.Professor;
import com.fawry.task.courseregistration.exception.NoSuchEntityException;
import com.fawry.task.courseregistration.repos.CourseRepo;
import com.fawry.task.courseregistration.repos.ProfessorRepo;
import com.fawry.task.courseregistration.repos.StudentRepo;
import com.fawry.task.courseregistration.service.mapper.CourseMapper;
import com.fawry.task.courseregistration.service.serviceimp.CourseServiceImp;
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

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CourseTest {
    
    @Mock
    CourseRepo repo;

    @Mock
    ProfessorRepo professorRepo;

    @Mock
    CourseMapper mapper;
    
    @InjectMocks
    CourseService service = new CourseServiceImp();

    private final String COURSE_NOT_FOUND = "COURSE_NOT_FOUND";

    @Test
    void testGetAllCourses(){
        // arrange
        Course Course = new Course("CS34" , "Data Structure");
        CourseDto CourseDto = new CourseDto("CS34" , "Data Structure");
        when(repo.findAll()).thenReturn(List.of(Course));
        when(mapper.toCourseDto(Course)).thenReturn(CourseDto);
        // act
        List<CourseDto> courses =  service.getCourses();
        // assert
        Assertions.assertThat(courses).isNotNull().hasSize(1);
    }


    @Test
    void testGetCourseById(){
        // arrange
        Course course = new Course("CS34" , "Data Structure");
        CourseDto courseDto = new CourseDto("CS34" , "Data Structure");
        when(repo.findById(1)).thenReturn(Optional.of(course));
        when(mapper.toCourseDto(course)).thenReturn(courseDto);
        // act
        CourseDto courseDto1 = service.getCourse(1);
        // assert
        assertThat(courseDto1).isNotNull().isEqualTo(courseDto);
    }


    @Test
    void testGetCourseByIdAndCourseNotFound(){
        // arrange
        when(repo.findById(1)).thenReturn(Optional.empty());
        // act
        // assert
        assertThatThrownBy(() -> service.getCourse(1))
                .isInstanceOf(NoSuchEntityException.class)
                .hasMessage(COURSE_NOT_FOUND);
    }


    @Test
    void testAddNewCourse(){
        // arrange
        Course course = new Course("CS34" , "Data Structure");
        CourseDto courseDto = new CourseDto("CS34" , "Data Structure");
        when(repo.save(course)).thenReturn(course);
        when(mapper.toCourseDto(course)).thenReturn(courseDto);
        when(mapper.toCourse(courseDto)).thenReturn(course);
        // act
        CourseDto courseDto1 = service.addCourse(courseDto);
        // assert
        assertThat(courseDto1).isNotNull().isEqualTo(courseDto);
    }

    @Test
    void testUpdateCourseAndCourseNotFound(){
        // arrange
        when(repo.findById(1)).thenReturn(Optional.empty());
        // act
        // assert
        assertThatThrownBy(() -> service.updateCourse(1 , any(CourseDto.class)))
                .isInstanceOf(NoSuchEntityException.class)
                .hasMessage(COURSE_NOT_FOUND);
    }

    @Test
    void testUpdateCourse(){
        // arrange
        Course course = new Course("CS34" , "Data Structure");
        CourseDto courseDto = new CourseDto("CS34" , "Data Structure");
        when(repo.findById(1)).thenReturn(Optional.ofNullable(course));
        when(mapper.toCourseDto(course)).thenReturn(courseDto);
        when(repo.save(course)).thenReturn(course);

        course.setTitle(courseDto.getTitle());
        course.setCode(courseDto.getCode());
        course.setProfessor(courseDto.getProfessor());

        // act
        CourseDto CourseDto1 = service.updateCourse(1 , courseDto);
        // assert
        assertThat(CourseDto1).isNotNull().isEqualTo(courseDto);
    }

    @Test
    void testDeleteCourseAndNotFound(){
        // arrange
        when(repo.findById(1)).thenReturn(Optional.empty());
        // act
        // assert
        assertThatThrownBy(() -> service.deleteCourse(1))
                .isInstanceOf(NoSuchEntityException.class)
                .hasMessage(COURSE_NOT_FOUND);
    }

    @Test
    void testDeleteCourse(){
        // arrange
        Course Course = new Course("CS45" , "Operating System");
        when(repo.findById(1)).thenReturn(Optional.of(Course));
        // act
        org.junit.jupiter.api.Assertions.assertAll(() -> service.deleteCourse(1));
    }

    @Test
    void testAddProfessorOfCourseAndProfNotFound(){
        when(repo.findById(1)).thenReturn(Optional.of(new Course()));
        when(professorRepo.findById(1)).thenReturn(Optional.empty());
        // act
        // assert
        assertThatThrownBy(() -> service.addProfessor( 1 , 1))
                .isInstanceOf(NoSuchEntityException.class)
                .hasMessage("PROFESSOR_NOT_FOUND");
    }

    @Test
    void testAddProfessorAndCourseNotFound(){
        when(repo.findById(1)).thenReturn(Optional.empty());
        // act
        // assert
        assertThatThrownBy(() -> service.addProfessor( 1 , 1))
                .isInstanceOf(NoSuchEntityException.class)
                .hasMessage(COURSE_NOT_FOUND);
    }

    @Test
    void testAddProfessor(){
        // arrange
        Course c = new Course();
        CourseDto courseDto = new CourseDto();
        when(repo.findById(1)).thenReturn(Optional.of(c));
        when(professorRepo.findById(1)).thenReturn(Optional.of(new Professor()));
        when(mapper.toCourseDto(c)).thenReturn(courseDto);
        when(repo.save(c)).thenReturn(c);

        // act
        CourseDto dto = service.addProfessor(1 , 1);
        // assert
        assertThat(dto).isNotNull().isEqualTo(courseDto);
    }

}

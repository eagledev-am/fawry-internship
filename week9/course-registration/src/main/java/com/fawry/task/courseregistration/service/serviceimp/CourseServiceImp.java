package com.fawry.task.courseregistration.service.serviceimp;

import com.fawry.task.courseregistration.dto.CourseDto;
import com.fawry.task.courseregistration.entity.Course;
import com.fawry.task.courseregistration.entity.Professor;
import com.fawry.task.courseregistration.entity.Student;
import com.fawry.task.courseregistration.exception.NoSuchEntityException;
import com.fawry.task.courseregistration.repos.CourseRepo;
import com.fawry.task.courseregistration.repos.ProfessorRepo;
import com.fawry.task.courseregistration.service.CourseService;
import com.fawry.task.courseregistration.service.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class CourseServiceImp implements CourseService {
    @Autowired
    CourseMapper mapper;

    @Autowired
    CourseRepo repo;

    @Autowired
    ProfessorRepo professorRepo;
    private final String COURSE_NOT_FOUND = "COURSE_NOT_FOUND";


    @Override
    public List<CourseDto> getCourses() {
        return repo.findAll().stream()
                .map((course -> mapper.toCourseDto(course)))
                .toList();
    }

    @Override
    public CourseDto getCourse(int id) {
        return mapper.toCourseDto(repo.findById(id)
                .orElseThrow(()-> new NoSuchEntityException(COURSE_NOT_FOUND)));
    }

    @Override
    public CourseDto addCourse(CourseDto course) {
        return mapper.toCourseDto(repo.save(mapper.toCourse(course)));
    }

    @Override
    public CourseDto updateCourse(int id, CourseDto course) {
        Course persistedCourse = repo.findById((int)id)
                .orElseThrow(()-> new NoSuchEntityException(COURSE_NOT_FOUND));

        persistedCourse.setCode(course.getCode());
        persistedCourse.setTitle(course.getTitle());
        persistedCourse.setProfessor(course.getProfessor());

        return mapper.toCourseDto(repo.save(persistedCourse));
    }

    @Override
    public void deleteCourse(int id) {
        Course persistedCourse = repo.findById((int)id)
                .orElseThrow(()-> new NoSuchEntityException(COURSE_NOT_FOUND));
        repo.delete(persistedCourse);
    }

    @Override
    public CourseDto addProfessor(int courseId, int professorId) {
        Course persistedCourse = repo.findById(courseId)
                .orElseThrow(() -> new NoSuchEntityException(COURSE_NOT_FOUND));

        Professor persistedProfessor = professorRepo.findById(professorId)
                .orElseThrow(()-> new NoSuchEntityException("PROFESSOR_NOT_FOUND"));

        persistedCourse.setProfessor(persistedProfessor);

        repo.save(persistedCourse);

        return mapper.toCourseDto(repo.save(persistedCourse));
    }
}

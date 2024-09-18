package com.fawry.task.courseregistration.service.serviceimp;

import com.fawry.task.courseregistration.dto.StudentDto;
import com.fawry.task.courseregistration.entity.Course;
import com.fawry.task.courseregistration.entity.Student;
import com.fawry.task.courseregistration.exception.NoSuchEntityException;
import com.fawry.task.courseregistration.repos.CourseRepo;
import com.fawry.task.courseregistration.repos.StudentRepo;
import com.fawry.task.courseregistration.service.StudentService;
import com.fawry.task.courseregistration.service.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class StudentServiceImp implements StudentService {

    @Autowired
    StudentMapper mapper;

    @Autowired
    StudentRepo repo;

    @Autowired
    CourseRepo courseRepo;

    private final String STUDENT_NOT_FOUND = "STUDENT_NOT_FOUND";

    @Override
    public StudentDto getStudent(long id) {
        return mapper.toStudentDto(repo.findById((int) id)
                .orElseThrow(()-> new NoSuchEntityException(STUDENT_NOT_FOUND)));
    }

    @Override
    public List<StudentDto> getStudents() {
       return repo.findAll().stream()
               .map((student)->mapper.toStudentDto(student))
               .toList();
    }


    @Override
    public StudentDto addStudent(StudentDto student) {
        return mapper.toStudentDto(repo.save(mapper.toStudent(student)));
    }


    @Override
    public StudentDto updateStudent(long id, StudentDto student) {
        Student persistedStudent = repo.findById((int)id)
                .orElseThrow(()-> new NoSuchEntityException(STUDENT_NOT_FOUND));

        persistedStudent.setName(student.getName());
        persistedStudent.setEmail(student.getEmail());

        return mapper.toStudentDto(repo.save(persistedStudent));
    }



    @Override
    public void deleteStudent(long id) {
        Student persistedStudent = repo.findById((int)id)
                .orElseThrow(()-> new NoSuchEntityException(STUDENT_NOT_FOUND));
        repo.delete(persistedStudent);
    }


    @Override
    public StudentDto addStudentToCourse(int courseId, long studentId) {
        Course persistedCourse = courseRepo.findById(courseId)
                .orElseThrow(() -> new NoSuchEntityException("COURSE_NOT_FOUND"));

        Student persistedStudent = repo.findById((int)studentId)
                .orElseThrow(()-> new NoSuchEntityException(STUDENT_NOT_FOUND));

        persistedStudent.addCourse(persistedCourse);

        return mapper.toStudentDto(repo.save(persistedStudent));
    }

    @Override
    public void removeStudentToCourse(int courseId, long studentId) {
        Course persistedCourse = courseRepo.findById(courseId)
                .orElseThrow(() -> new NoSuchEntityException("COURSE_NOT_FOUND"));

        Student persistedStudent = repo.findById((int)studentId)
                .orElseThrow(()-> new NoSuchEntityException(STUDENT_NOT_FOUND));

        persistedStudent.deleteCourse(persistedCourse);

        repo.save(persistedStudent);
    }
}

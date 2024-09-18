package com.fawry.task.courseregistration.service.mapper;

import com.fawry.task.courseregistration.dto.StudentDto;
import com.fawry.task.courseregistration.entity.Student;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudentMapper {

    @Mapping(source = "id" , target = "id")
    @Mapping(source = "name" , target = "name")
    @Mapping(source = "email" , target = "email")
    @Mapping(source = "courses" , target = "courses")
    Student toStudent(StudentDto studentDto);

    @InheritInverseConfiguration(name = "toStudent")
    StudentDto toStudentDto(Student student);
}

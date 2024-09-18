package com.fawry.task.courseregistration.service.mapper;

import com.fawry.task.courseregistration.dto.CourseDto;
import com.fawry.task.courseregistration.entity.Course;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @Mapping(source = "id" , target = "id")
    @Mapping(source = "code" , target = "code")
    @Mapping(source = "title" , target = "title")
    @Mapping(source = "professor" , target = "professor")
    Course toCourse(CourseDto courseDto);

    @InheritInverseConfiguration(name = "toCourse")
    CourseDto toCourseDto(Course course);
}

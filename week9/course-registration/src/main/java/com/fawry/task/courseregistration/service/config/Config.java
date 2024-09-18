package com.fawry.task.courseregistration.service.config;

import com.fawry.task.courseregistration.service.mapper.CourseMapper;
import com.fawry.task.courseregistration.service.mapper.ProfessorMapper;
import com.fawry.task.courseregistration.service.mapper.StudentMapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {CourseMapper.class , StudentMapper.class , ProfessorMapper.class})
public class Config {
}

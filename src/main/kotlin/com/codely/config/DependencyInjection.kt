package com.codely.config

import com.codely.api.contexts.course.application.createcourse.CourseCreator
import com.codely.api.contexts.course.application.createcourse.CreateCourseHandler
import com.codely.api.contexts.course.domain.CourseRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DependencyInjection {

    @Bean
    fun courseCreator(courseRepository: CourseRepository) = CourseCreator(courseRepository)

    @Bean
    fun createCourseHandler(courseCreator: CourseCreator) = CreateCourseHandler(courseCreator)
}

package com.codely.api.contexts.course.application.createcourse

import com.codely.api.contexts.course.domain.Course
import com.codely.api.contexts.course.domain.CourseRepository

class CourseCreator(
    private val courseRepository: CourseRepository
) {
    fun create(id: String, name: String) {
        Course.from(id, name).let {
            courseRepository.save(it)
        }
    }
}

package com.codely.api.contexts.course.infrastructure

import com.codely.api.contexts.course.domain.Course
import com.codely.api.contexts.course.domain.CourseRepository

class InMemoryCourseRepository : CourseRepository {
    override fun save(course: Course) {
        println(course.name.value)
    }
}

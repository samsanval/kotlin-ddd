package com.codely.api.contexts.course.domain

interface CourseRepository {
    fun save(course: Course)
}

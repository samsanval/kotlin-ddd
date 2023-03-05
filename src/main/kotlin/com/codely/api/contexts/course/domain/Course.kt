package com.codely.api.contexts.course.domain

import java.util.UUID

data class CourseId(val value: UUID) {
    companion object {
        fun fromString(id: String) = try {
            CourseId(UUID.fromString(id))
        } catch (exception: Exception) {
            throw InvalidCourseId(id, exception)
        }
    }
}

data class CourseName(val value: String) {
    init {
        validate()
    }

    private fun validate() {
        if (value.isEmpty() || value.isBlank()) {
            throw InvalidCourseName(value)
        }
    }
}

data class Course(
    val id: CourseId,
    val name: CourseName
) {
    companion object {
        fun from(id: String, name: String) =
                Course(CourseId.fromString(id), CourseName(name))
    }
}

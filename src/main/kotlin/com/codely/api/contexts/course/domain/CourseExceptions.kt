package com.codely.api.contexts.course.domain

sealed class CourseException(override val message: String, override val cause: Throwable? = null):
    RuntimeException(message, cause)

data class InvalidCourseId(val id: String, override val cause: Throwable?)
    : CourseException("The id $id is not valid", cause)

data class InvalidCourseName(val name: String): CourseException("The name $name is not valid")
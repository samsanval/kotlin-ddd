package com.codely.api.contexts.course.application.createcourse

data class CreateCourseHandler
(private val courseCreator: CourseCreator) {
    operator fun invoke(courseCommand: CreateCourseCommand) {
        courseCreator.create(courseCommand.id, courseCommand.name)
    }
}

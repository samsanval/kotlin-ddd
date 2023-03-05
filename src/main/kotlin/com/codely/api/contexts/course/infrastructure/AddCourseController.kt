package com.codely.api.contexts.course.infrastructure

import com.codely.api.contexts.course.application.createcourse.CreateCourseCommand
import com.codely.api.contexts.course.application.createcourse.CreateCourseHandler
import com.codely.api.contexts.course.domain.InvalidCourseId
import com.codely.api.contexts.course.domain.InvalidCourseName
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AddCourseController(private val courseHandler: CreateCourseHandler) {
    @PostMapping("/course")
    fun execute(
        @RequestBody requestBody: CreateCourseRequest
    ): ResponseEntity<String> {
        return try {
            val command = CreateCourseCommand(requestBody.id, requestBody.name)
            courseHandler(command)
            ResponseEntity.ok().body("")
        } catch(exception: Throwable) {
            when (exception) {
                is InvalidCourseName,
                    is InvalidCourseId -> ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(exception.message)
                else -> ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Something went bad")
            }
        }
    }
}

data class CreateCourseRequest(
    val id: String = "",
    val name: String = ""
)
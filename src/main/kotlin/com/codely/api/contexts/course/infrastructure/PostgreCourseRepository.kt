package com.codely.api.contexts.course.infrastructure

import com.codely.api.contexts.course.domain.Course
import com.codely.api.contexts.course.domain.CourseRepository
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate

class PostgreCourseRepository(private val db: NamedParameterJdbcTemplate) : CourseRepository {
    override fun save(course: Course) {
        MapSqlParameterSource()
                .addValue("id", course.id.value.toString())
                .addValue("name", course.name.value)
                .let { params ->
                    db.update(
                            "INSERT INTO course(id, name) VALUES(:id, :name)",
                            params
                    )
                }
    }
}

package com.codely.config

import com.codely.api.contexts.course.infrastructure.PostgreCourseRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate

@Configuration
class DatabaseConfig {
    @Bean
    fun courseRepository(jdbcTemplate: NamedParameterJdbcTemplate) = PostgreCourseRepository(jdbcTemplate)
}

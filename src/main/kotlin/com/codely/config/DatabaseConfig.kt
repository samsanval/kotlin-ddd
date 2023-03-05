package com.codely.config

import com.codely.api.contexts.course.infrastructure.InMemoryCourseRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DatabaseConfig {
	@Bean
	fun courseRepository() = InMemoryCourseRepository()
}
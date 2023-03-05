package course.application

import com.codely.api.contexts.course.application.createcourse.CourseCreator
import com.codely.api.contexts.course.domain.Course
import com.codely.api.contexts.course.domain.CourseId
import com.codely.api.contexts.course.domain.CourseName
import com.codely.api.contexts.course.domain.CourseRepository
import com.codely.api.contexts.course.domain.InvalidCourseId
import com.codely.api.contexts.course.domain.InvalidCourseName
import course.BaseTest
import io.mockk.mockk
import io.mockk.verify
import java.util.UUID
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CourseCreatorTest : BaseTest() {
    private lateinit var courseRepository: CourseRepository
    private lateinit var courseCreator: CourseCreator

    @BeforeEach
    fun setUp() {
        courseRepository = mockk(relaxUnitFun = true)
        courseCreator = CourseCreator(courseRepository)
    }

    @Test
    fun `should create a course successfully`() {

        courseCreator.create(id, name)

        thenTheCourseShouldBeSaved()
    }

    @Test
    fun `should fail with invalid id`() {

        assertThrows<InvalidCourseId> { courseCreator.create("Invalid", name) }
    }

    @Test
    fun `should fail with invalid name`() {

        assertThrows<InvalidCourseName> { courseCreator.create(id, "    ") }
    }

    private fun thenTheCourseShouldBeSaved() {
        verify { courseRepository.save(
                    Course(
                            id = CourseId(UUID.fromString(id)),
                            name = CourseName(name)
                    )
            )
        }
    }

    companion object {
        private const val id = "caebae03-3ee9-4aef-b041-21a400fa1bb7"
        private const val name = "Kotlin Hexagonal Architecture Api Course"
    }
}

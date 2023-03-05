package course

import io.mockk.unmockkAll
import org.junit.jupiter.api.AfterEach

open class BaseTest {

    @AfterEach
    protected fun cleanMock() {
        unmockkAll()
    }
}

package arguments.domain

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class DefaultArgumentsParseUseCaseTest {

    private val argumentsParseUseCase = DefaultArgumentsParseUseCase()

    @Test
    fun `given empty arguments when parse arguments is invoked should return null text file path`() {
        val result = argumentsParseUseCase.parseArguments(emptyArray())
        assertNull(result.textFilePath)
    }

    @Test
    fun `given arguments with text when parse arguments is invoked should return arguments with text file path specified`() {
        val result = argumentsParseUseCase.parseArguments(arrayOf("sometext.txt"))
        assertEquals(result.textFilePath, "sometext.txt")
    }
}
package text.split.domain

import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class CompositeTextSplitUseCaseTest(
    private val text: String,
    private val expectedResult: List<String>
) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: expectedResult({0})={1}")
        fun getParameters() = listOf(
            arrayOf("word", listOf("word")),
            arrayOf("word other", listOf("word", "other")),
            arrayOf("no1-words2", listOf("no1", "words2")),
            arrayOf("two1 --words", listOf("two1", "words"))
        )
    }

    private val textSplitUseCase = CompositeTextSplitUseCase(
        listOf(
            TextByWhitespaceSplitUseCase(),
            TextByDashSplitUseCase()
        )
    )

    @Test
    fun `given text when split is invoked should return tokens split by whitespace and dash`() {
        val result = textSplitUseCase.split(text)
        assertEquals(result, expectedResult)
    }
}
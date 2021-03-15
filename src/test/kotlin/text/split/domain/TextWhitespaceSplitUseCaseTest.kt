package text.split.domain

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import text.split.domain.TextByWhitespaceSplitUseCase

@RunWith(Parameterized::class)
class TextWhitespaceSplitUseCaseTest(
    private val text: String,
    private val expectedResult: List<String>
) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun getParameters() = listOf(
            arrayOf("word", listOf("word")),
            arrayOf("word    other", listOf("word", "other")),
            arrayOf("no1 words2", listOf("no1", "words2")),
            arrayOf("two1    some words", listOf("two1", "some", "words")),
            arrayOf("one, word, only, in,    this example,", listOf("one,", "word,", "only,", "in,", "this", "example,"))
        )
    }

    private val textSplitUseCase = TextByWhitespaceSplitUseCase()

    @Test
    fun `given text when split is invoked should return list of tokens separated by whitespace`() {
        val result = textSplitUseCase.split(text)
        assertEquals(result, expectedResult)
    }
}
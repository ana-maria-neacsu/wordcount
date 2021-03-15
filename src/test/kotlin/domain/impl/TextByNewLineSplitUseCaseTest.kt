package domain.impl

import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TextByNewLineSplitUseCaseTest(
    private val text: String,
    private val expectedResult: List<String>
) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: expectedResult({0})={1}")
        fun getParameters() = listOf(
            arrayOf("word", listOf("word")),
            arrayOf("word\n\n\n\nother", listOf("word", "other")),
            arrayOf("no1\nwords2", listOf("no1", "words2")),
            arrayOf("two1   \nsome\nwords", listOf("two1   ", "some", "words")),
            arrayOf(
                "one,\nword,\nonly,\nin,\n    this\nexample,",
                listOf("one,", "word,", "only,", "in,", "    this", "example,")
            )
        )
    }

    private val textSplitUseCase = TextByNewLineSplitUseCase()

    @Test
    fun `given text when split is invoked should return list of tokens separated by new line`() {
        val result = textSplitUseCase.split(text)
        assertEquals(result, expectedResult)
    }
}
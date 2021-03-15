package domain

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class ValidWordsCountUseCaseTest(
    private val text: String,
    private val expectedResult: Int
) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: expectedResult({0})={1}")
        fun getParameters() = listOf(
            arrayOf("word", 1),
            arrayOf("word other", 2),
            arrayOf("no1 words2", 0),
            arrayOf("two1 some words", 2),
            arrayOf("one, word, only, in, this example,", 1)
        )
    }

    private val wordsCountUseCase = ValidWordsCountUseCase()

    @Test
    fun `given text when count words is invoked should return correct count`() {
        println(text + expectedResult)
        val result = wordsCountUseCase.countWords(text)
        assertEquals(result, expectedResult)
    }
}
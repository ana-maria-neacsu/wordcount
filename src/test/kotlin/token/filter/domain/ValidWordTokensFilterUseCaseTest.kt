package token.filter.domain

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class ValidWordTokensFilterUseCaseTest(
    private val tokens: List<String>,
    private val expectedResult: List<String>
) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: expectedResult({0})={1}")
        fun getParameters() = listOf(
            arrayOf(listOf("word"), listOf("word")),
            arrayOf(listOf("word", "other"), listOf("word", "other")),
            arrayOf(listOf("no1", "words2"), listOf()),
            arrayOf(listOf("two1", "some", "words"), listOf("some", "words")),
            arrayOf(listOf("one,", "word,", "only,", "in,", "this", "example,"), listOf("this"))
        )
    }

    private val tokensFilterUseCase = ValidWordTokensFilterUseCase()

    @Test
    fun `given token list when filter is invoked should return only valid word tokens`() {
        val result = tokensFilterUseCase.filter(tokens)
        assertEquals(result, expectedResult)
    }
}
package token.filter.domain

import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class UniqueTokensFilterUseCaseTest(
    private val tokens: List<String>,
    private val expectedResult: List<String>
) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: expectedResult({0})={1}")
        fun getParameters() = listOf(
            arrayOf(listOf("word"), listOf("word")),
            arrayOf(listOf("word", "other"), listOf("word", "other")),
            arrayOf(listOf("word", "word", "other"), listOf("word", "other")),
            arrayOf(listOf("two1", "some", "words"), listOf("two1", "some", "words")),
            arrayOf(listOf("one", "one", "one"), listOf("one"))
        )
    }

    private val tokensFilterUseCase = UniqueTokensFilterUseCase()

    @Test
    fun `given token list when filter is invoked should return only unique tokens`() {
        val result = tokensFilterUseCase.filter(tokens)
        assertEquals(result, expectedResult)
    }
}
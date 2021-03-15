package token.count.domain

import token.count.domain.AllTokensCountUseCase
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class AllTokensCountUseCaseTest(
    private val tokens: List<String>,
    private val expectedResult: Int
) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: expectedResult({0})={1}")
        fun getParameters() = listOf(
            arrayOf(listOf("word"), 1),
            arrayOf(listOf("word", "other"), 2),
            arrayOf(listOf("no1", "words2"), 2),
            arrayOf(listOf("two1", "some", "words"), 3),
            arrayOf(listOf("one,", "word,", "only,", "in,", "this", "example,"), 6)
        )
    }

    private val tokensCountUseCase = AllTokensCountUseCase()

    @Test
    fun `given list of tokens when count tokens is invoked should return all tokens count`() {
        val result = tokensCountUseCase.countTokens(tokens)
        assertEquals(result, expectedResult)
    }
}
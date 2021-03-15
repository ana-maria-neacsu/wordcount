package token.filter.domain

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TokensByRegexFilterUseCaseTest(
    regex: Regex,
    private val tokens: List<String>,
    private val expectedResult: List<String>
) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: expectedResult({0})={1}")
        fun getParameters() = listOf(
            arrayOf("[a-zA-Z.]+".toRegex(), listOf("word"), listOf("word")),
            arrayOf("[a-zA-Z.]+".toRegex(), listOf("word", "other"), listOf("word", "other")),
            arrayOf("[a-zA-Z.]+".toRegex(), listOf("no1", "words2"), listOf<String>()),
            arrayOf("[a-zA-Z.]+".toRegex(), listOf("two1", "some", "words"), listOf("some", "words")),
            arrayOf(
                "[a-zA-Z.]+".toRegex(),
                listOf("one,", "word,", "only,", "in,", "this", "example,"),
                listOf("this")
            ),
            arrayOf("[1-9]+".toRegex(), listOf("abc", "123", "1a2"), listOf("123"))
        )
    }

    private val tokensFilterUseCase = TokensByRegexFilterUseCase(regex)

    @Test
    fun `given token list when filter is invoked should return only valid word tokens`() {
        val result = tokensFilterUseCase.filter(tokens)
        assertEquals(result, expectedResult)
    }
}
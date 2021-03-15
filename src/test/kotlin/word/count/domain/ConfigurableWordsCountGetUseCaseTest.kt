package word.count.domain

import text.split.api.TextSplitUseCase
import token.count.api.TokensCountUseCase
import token.filter.api.TokensFilterUseCase
import junit.framework.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class ConfigurableWordsCountGetUseCaseTest {

    private val mockTextSplitUseCase = object : TextSplitUseCase {

        var wasSplitCalled = false

        override fun split(text: String): List<String> {
            wasSplitCalled = true;
            return text.lines()
        }
    }

    private val mockTokensFilterUseCase = object : TokensFilterUseCase {

        var wasFilterCalled = false

        override fun filter(tokens: List<String>): List<String> {
            wasFilterCalled = true
            return tokens
        }
    }

    private val mockTokensCountUseCase = object : TokensCountUseCase {

        var wasCountTokensCalled = false

        override fun countTokens(tokens: List<String>): Int {
            wasCountTokensCalled = true
            return tokens.count()
        }
    }

    private val wordsCountUseCase = ConfigurableWordsCountGetUseCase(
        textSplitUseCase = mockTextSplitUseCase,
        tokensFilterUseCase = mockTokensFilterUseCase,
        tokensCountUseCase = mockTokensCountUseCase
    )

    @Before
    fun setUp() {
        mockTextSplitUseCase.wasSplitCalled = false
        mockTokensFilterUseCase.wasFilterCalled = false
    }

    @Test
    fun `given text when get word count is invoked should call text split use case`() {
        wordsCountUseCase.getWordCount("")
        assertTrue(mockTextSplitUseCase.wasSplitCalled)
    }

    @Test
    fun `given text when get word count is invoked should call tokens filter use case`() {
        wordsCountUseCase.getWordCount("")
        assertTrue(mockTokensFilterUseCase.wasFilterCalled)
    }

    @Test
    fun `given text when get word count is invoked should call tokens count use case`() {
        wordsCountUseCase.getWordCount("")
        assertTrue(mockTokensCountUseCase.wasCountTokensCalled)
    }

    @Test
    fun `given text when get word count is invoked should return correct token count`() {
        val result = wordsCountUseCase.getWordCount("test\ntokens")
        assertEquals(result, 2)
    }
}
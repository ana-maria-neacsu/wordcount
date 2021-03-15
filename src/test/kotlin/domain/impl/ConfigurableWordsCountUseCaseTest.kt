package domain.impl

import domain.TextSplitUseCase
import domain.TokensCountUseCase
import domain.TokensFilterUseCase
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ConfigurableWordsCountUseCaseTest {

    private val mockTextSplitUseCase = object : TextSplitUseCase {

        var wasSplitCalled = false

        override fun split(text: String): List<String> {
            wasSplitCalled = true;
            return emptyList()
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

    private val wordsCountUseCase = ConfigurableWordsCountUseCase(
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
    fun `given text when count words is invoked should call text split use case`() {
        wordsCountUseCase.countWords("")
        Assert.assertTrue(mockTextSplitUseCase.wasSplitCalled)
    }

    @Test
    fun `given text when count words is invoked should call tokens filter use case`() {
        wordsCountUseCase.countWords("")
        Assert.assertTrue(mockTokensFilterUseCase.wasFilterCalled)
    }

    @Test
    fun `given text when count words is invoked should call tokens count use case`() {
        wordsCountUseCase.countWords("")
        Assert.assertTrue(mockTokensCountUseCase.wasCountTokensCalled)
    }
}
package domain.impl

import domain.TokensFilterUseCase
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class CompositeTokensFilterUseCaseTest(
    private val tokens: List<String>,
    private val expectedResult: List<String>
) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: expectedResult({0})={1}")
        fun getParameters() = listOf(
            arrayOf(listOf("word"), listOf()),
            arrayOf(listOf("word", "11"), listOf()),
            arrayOf(listOf("11", "254", "9999"), listOf("254", "9999")),
            arrayOf(listOf("two1", "11111", "12"), listOf("11111"))
        )
    }

    private val numbersTokensFilterUseCase = object: TokensFilterUseCase {
        override fun filter(tokens: List<String>) = tokens.filter { it.matches("[0-9]+".toRegex()) }
    }

    private val lengthAboveThreeTokensFilterUseCase = object: TokensFilterUseCase {
        override fun filter(tokens: List<String>) = tokens.filter { it.length >= 3 }
    }

    private val compositeTokensFilterUseCase = CompositeTokensFilterUseCase(
        filters = listOf(numbersTokensFilterUseCase, lengthAboveThreeTokensFilterUseCase)
    )

    @Test
    fun `given list of tokens when filter is invoked should return only numbers with length above three`() {
        val result = compositeTokensFilterUseCase.filter(tokens)
        assertEquals(result, expectedResult)
    }
}
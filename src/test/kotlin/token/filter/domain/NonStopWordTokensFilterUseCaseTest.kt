package token.filter.domain

import stopwords.api.StopWordsGetUseCase
import token.filter.domain.NonStopWordTokensFilterUseCase
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class NonStopWordTokensFilterUseCaseTest(
    private val tokens: List<String>,
    private val expectedResult: List<String>
) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun getParameters() = listOf(
            arrayOf(listOf("word"), listOf()),
            arrayOf(listOf("word", "11"), listOf("11")),
            arrayOf(listOf("11", "stop", "9999"), listOf("11", "9999")),
            arrayOf(listOf("two1", "stop", "word", "other"), listOf("two1", "other"))
        )
    }

    private val mockStopWordsGetUseCase = object : StopWordsGetUseCase {
        override fun getStopWords() = listOf("stop", "word")
    }

    private val nonStopWordTokensFilterUseCase = NonStopWordTokensFilterUseCase(
        stopWordsGetUseCase = mockStopWordsGetUseCase
    )

    @Test
    fun `given tokens when filter is invoked should return only non stop word tokens`() {
        val result = nonStopWordTokensFilterUseCase.filter(tokens)
        assertEquals(result, expectedResult)
    }
}
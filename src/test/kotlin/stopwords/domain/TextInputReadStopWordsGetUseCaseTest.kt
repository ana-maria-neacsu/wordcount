package stopwords.domain

import text.split.api.TextSplitUseCase
import text.input.api.TextInputReadUseCase
import junit.framework.Assert.assertEquals
import org.junit.Test

class TextInputReadStopWordsGetUseCaseTest {

    private val mockTextInput = object : TextInputReadUseCase {
        override fun getText(): String = "some\ntext"
    }

    private val mockTextSplitUseCase = object : TextSplitUseCase {
        override fun split(text: String) = text.lines()
    }

    private val stopWordsGetUseCase = TextInputReadStopWordsGetUseCase(
        textInputReadUseCase = mockTextInput,
        textSplitUseCase = mockTextSplitUseCase
    )

    @Test
    fun `when get stop words is invoked should return tokens from text input split by line`() {
        val result = stopWordsGetUseCase.getStopWords()
        assertEquals(result, listOf("some", "text"))
    }
}
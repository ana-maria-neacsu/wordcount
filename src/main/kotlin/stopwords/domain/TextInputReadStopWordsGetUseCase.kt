package stopwords.domain

import stopwords.api.StopWordsGetUseCase
import text.split.api.TextSplitUseCase
import text.input.api.TextInputReadUseCase

class TextInputReadStopWordsGetUseCase(
    private val textInputReadUseCase: TextInputReadUseCase,
    private val textSplitUseCase: TextSplitUseCase
) : StopWordsGetUseCase {

    override fun getStopWords() = textSplitUseCase.split(
        textInputReadUseCase.getText()
    )
}
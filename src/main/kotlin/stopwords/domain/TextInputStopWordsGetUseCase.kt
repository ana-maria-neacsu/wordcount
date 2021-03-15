package stopwords.domain

import stopwords.api.StopWordsGetUseCase
import text.split.api.TextSplitUseCase
import text.input.api.TextInput

class TextInputStopWordsGetUseCase(
    private val textInput: TextInput,
    private val textSplitUseCase: TextSplitUseCase
) : StopWordsGetUseCase {

    override fun getStopWords() = textSplitUseCase.split(
        textInput.getText()
    )
}
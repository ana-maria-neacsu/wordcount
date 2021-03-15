package domain.impl

import domain.StopWordsGetUseCase
import domain.TextSplitUseCase
import input.TextInput

class TextInputStopWordsGetUseCase(
    private val textInput: TextInput,
    private val textSplitUseCase: TextSplitUseCase
) : StopWordsGetUseCase {

    override fun getStopWords() = textSplitUseCase.split(
        textInput.getText()
    )
}
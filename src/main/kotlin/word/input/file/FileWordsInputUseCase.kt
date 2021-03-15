package word.input.file

import text.input.file.FileTextInputReadUseCase
import word.input.api.WordsInputUseCase

class FileWordsInputUseCase(
    private val textInputReadUseCase: FileTextInputReadUseCase
): WordsInputUseCase {

    override fun getInput() = textInputReadUseCase.getText()
}
package word.input.domain

import text.input.commandline.CommandLineTextInputReadUseCase
import text.output.api.TextOutputWriteUseCase
import word.input.api.WordsInputUseCase

class CommandLineWordsInputUseCase(
    private val textInputReadUseCase: CommandLineTextInputReadUseCase,
    private val textOutputWriteUseCase: TextOutputWriteUseCase
) : WordsInputUseCase {

    override fun getInput(): String {
        textOutputWriteUseCase.writeText("Enter text: ")
        return textInputReadUseCase.getText()
    }
}
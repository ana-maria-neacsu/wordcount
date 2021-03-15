import domain.ValidWordsCountUseCase
import domain.WordsCountUseCase
import input.TextInput
import input.commandline.CommandLineTextInput
import output.TextOutput
import output.commandline.CommandLineTextOutput

fun main() {
    val input: TextInput = CommandLineTextInput()
    val output: TextOutput = CommandLineTextOutput()
    val wordsCountUseCase: WordsCountUseCase = ValidWordsCountUseCase()

    output.showText("Enter text: ")

    val result = wordsCountUseCase.countWords(input.getText())
    output.showText("Number of words: $result\n")
}
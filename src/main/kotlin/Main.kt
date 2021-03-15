import domain.WordsCountUseCase
import domain.impl.AllTokensCountUseCase
import domain.impl.ConfigurableWordsCountUseCase
import domain.impl.TextByWhitespaceSplitUseCase
import domain.impl.ValidWordTokensFilterUseCase
import input.TextInput
import input.commandline.CommandLineTextInput
import output.TextOutput
import output.commandline.CommandLineTextOutput

fun main() {
    val input: TextInput = CommandLineTextInput()
    val output: TextOutput = CommandLineTextOutput()
    val wordsCountUseCase: WordsCountUseCase = ConfigurableWordsCountUseCase(
        textSplitUseCase = TextByWhitespaceSplitUseCase(),
        tokensFilterUseCase = ValidWordTokensFilterUseCase(),
        tokensCountUseCase = AllTokensCountUseCase()
    )

    output.showText("Enter text: ")

    val result = wordsCountUseCase.countWords(input.getText())
    output.showText("Number of words: $result\n")
}
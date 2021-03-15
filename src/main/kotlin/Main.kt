import domain.WordsCountGetUseCase
import domain.impl.*
import input.TextInput
import input.commandline.CommandLineTextInput
import input.file.FileTextInput
import output.TextOutput
import output.commandline.CommandLineTextOutput

fun main() {
    val input: TextInput = CommandLineTextInput()
    val output: TextOutput = CommandLineTextOutput()

    val wordsCountGetUseCase: WordsCountGetUseCase = ConfigurableWordsCountGetUseCase(
        textSplitUseCase = TextByWhitespaceSplitUseCase(),
        tokensFilterUseCase = CompositeTokensFilterUseCase(
            listOf(
                ValidWordTokensFilterUseCase(),
                NonStopWordTokensFilterUseCase(
                    stopWordsGetUseCase = TextInputStopWordsGetUseCase(
                        textInput = FileTextInput("stopwords.txt"),
                        textSplitUseCase = TextByNewLineSplitUseCase()
                    )
                )
            )
        ),
        tokensCountUseCase = AllTokensCountUseCase()
    )

    output.showText("Enter text: ")

    val result = wordsCountGetUseCase.getWordCount(input.getText())
    output.showText("Number of words: $result\n")
}
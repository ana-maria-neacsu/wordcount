import stopwords.domain.TextInputStopWordsGetUseCase
import text.input.api.TextInput
import text.input.commandline.CommandLineTextInput
import text.input.file.FileTextInput
import text.output.api.TextOutput
import text.output.commandline.CommandLineTextOutput
import text.split.domain.TextByNewLineSplitUseCase
import text.split.domain.TextByWhitespaceSplitUseCase
import token.count.domain.AllTokensCountUseCase
import token.filter.domain.CompositeTokensFilterUseCase
import token.filter.domain.NonStopWordTokensFilterUseCase
import token.filter.domain.ValidWordTokensFilterUseCase
import word.count.api.WordsCountGetUseCase
import word.count.domain.ConfigurableWordsCountGetUseCase

fun main(args: Array<String>) {
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
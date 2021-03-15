import token.count.domain.AllTokensCountUseCase
import word.count.api.WordsCountGetUseCase
import token.filter.domain.CompositeTokensFilterUseCase
import token.filter.domain.NonStopWordTokensFilterUseCase
import token.filter.domain.ValidWordTokensFilterUseCase
import text.input.api.TextInput
import text.input.commandline.CommandLineTextInput
import text.input.file.FileTextInput
import text.output.api.TextOutput
import text.output.commandline.CommandLineTextOutput
import stopwords.domain.TextInputStopWordsGetUseCase
import text.split.domain.TextByNewLineSplitUseCase
import text.split.domain.TextByWhitespaceSplitUseCase
import word.count.domain.ConfigurableWordsCountGetUseCase

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
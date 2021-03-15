import arguments.domain.ArgumentsParseUseCaseImpl
import stopwords.domain.TextInputReadStopWordsGetUseCase
import text.input.api.InvalidInputException
import text.input.commandline.CommandLineTextInputReadUseCase
import text.input.file.FileTextInputReadUseCase
import text.output.api.TextOutputWriteUseCase
import text.output.commandline.CommandLineTextOutputWriteUseCase
import text.split.domain.TextByNewLineSplitUseCase
import text.split.domain.TextByWhitespaceSplitUseCase
import token.count.domain.AllTokensCountUseCase
import token.filter.domain.CompositeTokensFilterUseCase
import token.filter.domain.NonStopWordTokensFilterUseCase
import token.filter.domain.ValidWordTokensFilterUseCase
import word.count.api.WordsCountGetUseCase
import word.count.domain.ConfigurableWordsCountGetUseCase
import word.input.api.WordsInputUseCase
import word.input.domain.CommandLineWordsInputUseCase
import word.input.domain.FileWordsInputUseCase

fun main(args: Array<String>) {

    val argumentsParseUseCase = ArgumentsParseUseCaseImpl()
    val arguments = argumentsParseUseCase.parseArguments(args)

    val outputWriteUseCase: TextOutputWriteUseCase = CommandLineTextOutputWriteUseCase()

    val wordsInputUseCase: WordsInputUseCase = arguments.textFilePath?.let { path ->
        FileWordsInputUseCase(FileTextInputReadUseCase(path))
    } ?: CommandLineWordsInputUseCase(
        textInputReadUseCase = CommandLineTextInputReadUseCase(),
        textOutputWriteUseCase = outputWriteUseCase
    )

    val wordsCountGetUseCase: WordsCountGetUseCase = ConfigurableWordsCountGetUseCase(
        textSplitUseCase = TextByWhitespaceSplitUseCase(),
        tokensFilterUseCase = CompositeTokensFilterUseCase(
            listOf(
                ValidWordTokensFilterUseCase(),
                NonStopWordTokensFilterUseCase(
                    stopWordsGetUseCase = TextInputReadStopWordsGetUseCase(
                        textInputReadUseCase = FileTextInputReadUseCase("stopwords.txt"),
                        textSplitUseCase = TextByNewLineSplitUseCase()
                    )
                )
            )
        ),
        tokensCountUseCase = AllTokensCountUseCase()
    )

    try {
        val result = wordsCountGetUseCase.getWordCount(
            wordsInputUseCase.getInput()
        )

        outputWriteUseCase.writeText("Number of words: $result\n")
    } catch (e: InvalidInputException) {
        outputWriteUseCase.writeText(e.message ?: "Unknown error")
    }
}
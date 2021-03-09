package application

import LatinWordCounter
import ResourceFileStopWordsProvider
import java.io.File
import java.io.InputStream
import java.io.PrintStream

class Application(
        private val inputStream: InputStream = System.`in`,
        private val printStream: PrintStream = System.out,
) {
    fun run(vararg args: String) {
        val arguments = parseInputArguments(*args)

        val inputText = if (arguments.textFilePath == null) {
            print("Enter text: ")

            inputStream.bufferedReader().let { it.readLine() ?: it.readText() }
        }
        else
        {
            File(arguments.textFilePath).readLines().joinToString(" ")
        }

        val dictionaryFile = arguments.dictionaryFilePath?.let { File(it) }
        val dictionary = if (dictionaryFile?.exists() == true) dictionaryFile.readLines().toSet() else emptySet()

        val stopWordsProvider = ResourceFileStopWordsProvider(STOPWORDS_FILE_PATH)
        val latinWordCounter = LatinWordCounter(stopWordsProvider)

        val wordsCount = latinWordCounter.count(inputText, dictionary)
        val unknownWordCounter = wordsCount.index.count { it.unknown }

        printStream.println("Number of words: ${wordsCount.total}, unique: ${wordsCount.unique}; average word length: ${String.format("%.2f", wordsCount.avgLength)} characters")
        if (arguments.withIndex) {
            printStream.println("Index (unknown $unknownWordCounter):")
            wordsCount.index.forEach { printStream.println(it) }
        }
    }

    // Needs to be extracted to argument parser and tested or used a third-party library
    private fun parseInputArguments(vararg args: String): Arguments {
        val withIndex = args.any { it == INDEX_ARGUMENT }
        val dictionaryFilePath: String? = args.find { it.startsWith(DICTIONARY_ARGUMENT) }?.let {
            val path = it.drop(DICTIONARY_ARGUMENT.length).trim()
            if (path.startsWith("\"") && path.endsWith("\""))
                path.drop(1).dropLast(1)
            else
                path
        }
        var textFilePath: String? = null
        if (args.isNotEmpty()) {
            val possibleFilePathArgument = args[args.size - 1]
            val inputFile = File(args[args.size - 1])
            if (!possibleFilePathArgument.startsWith('-') && inputFile.exists()) {
                textFilePath = possibleFilePathArgument
            }
        }

        return Arguments(
                withIndex = withIndex,
                dictionaryFilePath = dictionaryFilePath,
                textFilePath = textFilePath
        )
    }

    companion object {
        private const val INDEX_ARGUMENT = "-index"
        private const val DICTIONARY_ARGUMENT = "-dictionary="
    }
}

data class Arguments(
        val withIndex: Boolean = false,
        val dictionaryFilePath: String? = null,
        val textFilePath: String? = null
)

private const val STOPWORDS_FILE_PATH = "\\stopwords.txt"
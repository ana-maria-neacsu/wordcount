package at.george.wordcount

import java.io.File

const val STOPWORDS_FILE_PATH = "stopwords.txt"

fun main(args: Array<String>) {

    val console = ConsoleImpl()
    val wordReader = WordReader()

    Application(
            console = console,
            stopWordsFile = File(STOPWORDS_FILE_PATH),
            wordReader = wordReader,
            wordCounter = WordCounter(),
            indexReporterFactory = IndexReporterFactory(
                    wordReader = wordReader,
                    console = console
            )
    ).run(args)
}


class Application(
        private val console: Console,
        private val stopWordsFile: File,
        private val wordReader: WordReader,
        private val wordCounter: WordCounter,
        private val indexReporterFactory: IndexReporter.Factory
) {

    fun run(args: Array<String>) {
        val parsedArgs = Args.from(args)
        val exceptionWords = wordReader.readFromFile(stopWordsFile)

        val indexReporter = indexReporterFactory.create(parsedArgs)

        if (parsedArgs.file != null) {
            printResult(wordReader.readFromFile(parsedArgs.file), exceptionWords, indexReporter)
            return
        }

        var userInput = console.prompt("Enter text: ")
        while (!userInput.isNullOrBlank()) {
            printResult(wordReader.readFromLine(userInput), exceptionWords, indexReporter)
            userInput = console.prompt("Enter text: ")
        }
    }

    private fun printResult(words: List<String>, exceptionWords: List<String>, indexReporter: IndexReporter) {
        val countResult = wordCounter.count(words, exceptionWords)

        console.println("Number of words: ${countResult.numberOfWords}, " +
                "unique: ${countResult.uniqueWords.size}; " +
                "average word length: ${countResult.avgWordLength} characters")

        indexReporter.report(countResult.uniqueWords)

        println()
    }
}
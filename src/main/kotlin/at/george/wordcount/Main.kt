package at.george.wordcount

import java.io.File

const val STOPWORDS_FILE_PATH = "stopwords.txt"

fun main(args: Array<String>) {

    Application(
            console = ConsoleImpl(),
            stopWordsFile = File(STOPWORDS_FILE_PATH),
            wordReader = WordReader(),
            wordCounter = WordCounter(),
            indexer = Indexer()
    ).run(args)
}


class Application(
        private val console: Console,
        private val stopWordsFile: File,
        private val wordReader: WordReader,
        private val wordCounter: WordCounter,
        private val indexer: Indexer
) {

    fun run(args: Array<String>) {
        val parsedArgs = Args.from(args)
        val exceptionWords = wordReader.readFromFile(stopWordsFile)

        if (parsedArgs.file == null) {
            var userInput = console.prompt("Enter text: ")
            while (!userInput.isNullOrEmpty()) {
                printResult(wordReader.readFromLine(userInput), exceptionWords, parsedArgs)
                userInput = console.prompt("Enter text: ")
            }
        } else {
            printResult(wordReader.readFromFile(parsedArgs.file), exceptionWords, parsedArgs)
        }
    }

    private fun printResult(words: List<String>, exceptionWords: List<String>, parsedArgs: Args ) {
        val countResult = wordCounter.count(words, exceptionWords)

        console.println("Number of words: ${countResult.numberOfWords}, " +
                "unique: ${countResult.uniqueWords.size}; " +
                "average word length: ${countResult.avgWordLength} characters")

        if (parsedArgs.printIndex) {
            if (parsedArgs.dict == null) {
                console.println("Index:\n" +
                        countResult.uniqueWords.joinToString(separator = "\n"))
            } else {
                val dictionaryWords = wordReader.readFromFile(parsedArgs.dict)
                val indexerWords = indexer.index(countResult.uniqueWords, dictionaryWords)
                val unknownCount = indexerWords.count { !it.isKnown }

                console.println("Index (unknown: $unknownCount):")
                indexerWords.forEach {
                    if (!it.isKnown) console.println("${it.word}*") else console.println(it.word)
                }
            }
        }

        println()
    }
}
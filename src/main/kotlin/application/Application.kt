package application

import LatinWordCounter
import ResourceFileStopWordsProvider
import java.io.File
import java.io.InputStream
import java.io.PrintStream
import java.lang.NullPointerException

class Application(
        private val inputStream: InputStream = System.`in`,
        private val printStream: PrintStream = System.out,
) {
    fun run(vararg args: String) {
        var inputText = ""
        var fileExists = false
        var withIndex = false
        if (args.isNotEmpty()) {
            withIndex = args[0].compareTo("-index") == 0

            val possibleFilePathArgument = args[args.size - 1]
            val inputFile = File(args[args.size - 1])
            if (!possibleFilePathArgument.startsWith('-') && inputFile.exists()) {
                fileExists = true
                inputText = inputFile.readLines().joinToString(" ")
            }
        }

        if (!fileExists) {
            print("Enter text: ")

            try {
                inputText = inputStream.bufferedReader().readLine()
            } catch (e: NullPointerException)
            {
                printStream.println("Please, do not interrupt a line feed with EOF symbol...")
                return
            }
        }

        val stopWordsProvider = ResourceFileStopWordsProvider(STOPWORDS_FILE_PATH)
        val latinWordCounter = LatinWordCounter(stopWordsProvider)

        val wordsCount = latinWordCounter.count(inputText)

        printStream.println("Number of words: ${wordsCount.total}, unique: ${wordsCount.unique}; average word length: ${String.format("%.2f", wordsCount.avgLength)} characters")
        if (withIndex)
        {
            printStream.println("Index:")
            wordsCount.index.forEach { printStream.println(it) }
        }
    }
}

private const val STOPWORDS_FILE_PATH = "\\stopwords.txt"
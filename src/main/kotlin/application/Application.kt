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
        var inputText = ""
        var fileExists = false
        if (args.isNotEmpty())
        {
            val inputFile = File(args[0])
            if (inputFile.exists())
            {
                fileExists = true
                inputText = inputFile.readLines().joinToString(" ")
            }
        }

        if (!fileExists)
        {
            print("Enter text: ")
            inputText = inputStream.bufferedReader().readLine()
        }

        val stopWordsProvider = ResourceFileStopWordsProvider(STOPWORDS_FILE_PATH)
        val latinWordCounter = LatinWordCounter(stopWordsProvider)

        val wordsCount = latinWordCounter.count(inputText)

        printStream.println("Number of words: $wordsCount")
    }
}

private const val STOPWORDS_FILE_PATH = "\\stopwords.txt"